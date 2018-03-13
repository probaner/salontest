package SpringMy.Maven.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.db.enities.FileDetail;
import SpringMy.Maven.db.enities.PayStatus;
import SpringMy.Maven.model.DisplayFileDTO;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.Login;
import SpringMy.Maven.model.PaymentDTO;
import SpringMy.Maven.model.UserDTO;



@Controller 
@Scope("session")
@EnableWebMvc
public class UserLoginController {
	
	@Autowired
	CommonServices 	commonServices;
	@Autowired
	private DbServices dbServices;
	@Autowired
	private UserDTO userDTO;
	
	public void setUser(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	@RequestMapping("/getloginForm")
		public String viewLogin(Map<String, Object> model) throws IOException {
			Login loginForm = new Login();
			model.put("loginForm", loginForm);	
			return "login";		
		  }
		
	@RequestMapping(value = "/loginSucess", method = RequestMethod.POST)
	public String executeLogin(Model model, @ModelAttribute("loginForm") Login loginBean, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		System.out.println("GELO");

		if (loginBean != null && loginBean.getUsername() != null && loginBean.getPassword() != null) {
			if (dbServices.getUserData(loginBean).size() == 1) {
				userDTO = commonServices.createCurrentUserDTO(dbServices.getUserData(loginBean).get(0), userDTO);
				
				if ((dbServices.getUserData(loginBean).get(0).getRole()).equals("participate")) {
					if (commonServices.getExpairStatus()) {// check expairy date
						dbServices.updateCurrentTimeStamp(dbServices.getUserData(loginBean));// update current time stamp																								 																								 																								 
						model.addAttribute("sucessMagssage", "WELCOME " + userDTO.getLastname().toUpperCase() + " "+ userDTO.getFirstname().toUpperCase());
						model.addAttribute("product", new FileDTO());
						model.addAttribute("paymentDetail", new PaymentDTO());
												
						HashMap<String, LinkedList<DisplayFileDTO>> displayFileDTOMap = dbServices.getDisplayFileData(userDTO);

						if (displayFileDTOMap.size() > 0) {
							for (Map.Entry<String, LinkedList<DisplayFileDTO>> entry : displayFileDTOMap.entrySet()) {
                                 String k = entry.getKey();
                                 LinkedList<DisplayFileDTO> v = entry.getValue();                  
                                 for(DisplayFileDTO dfdto : v){
                                	 byte[] encoded=Base64.encodeBase64( dfdto.getItemImage());
                                	 String encodedString = new String(encoded);
                                	 model.addAttribute("image_"+dfdto.getPosition(), encodedString);
                                	 model.addAttribute("titel_"+dfdto.getPosition(), dfdto.getTitel());
                                	 System.out.println("image_"+dfdto.getPosition()+ "    "+"titel_"+dfdto.getPosition()+"  "+dfdto.getTitel());                               	     
                                    }                                
							     }							
							model.addAttribute("size",displayFileDTOMap.size());
							
							//check user status paid or not
							/*List<PayStatus> ufd = dbServices.getPayStatusOfAUser(userDTO);
							if(!(ufd.get(0).getPayingStatus()).equals("Being Check")){
								model.addAttribute("statue", "lock");
							   }
							else{*/
								  model.addAttribute("statue", "open");
							   // }
							
							
						}else{
							   model.addAttribute("size", "0");
					         }
					} else {
						model.addAttribute("error", "Last Login Date is Over");
						return "login";
					}
						
					return "registrationsuccess";
				} else if ((dbServices.getUserData(loginBean).get(0).getRole()).equals("admin")) {
					dbServices.updateCurrentTimeStamp(dbServices.getUserData(loginBean));
					return "admin";// need to create admin page
				} else {
					return "registrationsuccess";// need to create judge page
				}

			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		
		/*List<PayStatus> ufd = dbServices.getPayStatusOfAUser(userDTO);
		if((ufd.get(0).getPayingStatus()).equals("Being Check")){
		   System.out.println("CHANDAN="+ufd.size());
		   dbServices.savePayStatus(userDTO);
		  }*/
		
		model.clear();
		session.invalidate();
		return "login";
	}
		
}

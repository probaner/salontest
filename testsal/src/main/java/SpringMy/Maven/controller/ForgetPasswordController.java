

package SpringMy.Maven.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.model.GetPassword;

@Controller
@EnableWebMvc
public class ForgetPasswordController {
	
	@Autowired
	DbServices dbServices;
	
	
	@RequestMapping("/getForgetPasswordForm") 
	public String viewForgetPasswordForm(Map<String, Object> model) throws IOException {
		          GetPassword getPassword = new GetPassword();
		           model.put("getPassword", getPassword);
		           return "forgetpassword";
                 }
	
	
	 @RequestMapping(value="/processForgetPassword", method = RequestMethod.POST)
	 public String processForgetPassWord(@ModelAttribute("getPassword") GetPassword getPassword,  Model model) throws IOException{
		 List<String> usersEmailList=dbServices.getListOfAColumn("email");
		 if(usersEmailList.contains(getPassword.getEmail())){
		    String s = dbServices.getPassword(getPassword);
		    model.addAttribute("massage","Password Send to Mail Address");
		    System.out.println("pass="+s);
		   }else{
			      model.addAttribute("getPassword", getPassword);
			      model.addAttribute("massage","Mailid not found !");
		        }
		 
		 return "forgetpassword";		 
	 }
	
	
}

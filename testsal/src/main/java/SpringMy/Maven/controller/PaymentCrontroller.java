package SpringMy.Maven.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.model.PaymentDTO;
import SpringMy.Maven.model.UserDTO;

@Controller
@Scope("session")
@EnableWebMvc

public class PaymentCrontroller {
	
	@Autowired
	private CommonServices commonServices;	
	@Autowired
	private UserDTO userDTO;
	
	public void setCommonService(CommonServices commonService) {
		this.commonServices = commonService;
	}
	
	 @RequestMapping(value = "/payment")
     public void uploadResources(@RequestParam String action, HttpServletRequest servletRequest, 
    		                       HttpServletResponse response, @ModelAttribute("payment") PaymentDTO PaymentDTO, Model model) 
    		                       throws IOException{
		 
		                            System.out.println("I am in payment");
		                            
		                            
		                            
		                			if(commonServices.userIsNative(userDTO))
		                				java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.google.co.in"));
		                			   //model.addAttribute("payurl","https://www.google.co.in");
		                			 else
		                				 java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://in.yahoo.com/"));
		                				 //model.addAttribute("payurl","https://in.yahoo.com/");
		 
									//return "registrationsuccess";
		 
	 }

}

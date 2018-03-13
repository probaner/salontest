package SpringMy.Maven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.model.MailRecipientDTO;

@Controller
@EnableWebMvc
public class SendEmailController {
	
	@Autowired
	private CommonServices commonServices;
	
	public void setCommonServices(CommonServices commonServices) {
		this.commonServices = commonServices;
	}

	@RequestMapping("/contuctUs" )
    public String fetchEmailForm() {	
	   return "emailForm";		
	}
	
	@RequestMapping(value="processmail", method = RequestMethod.POST)
    public String doSendEmail(@ModelAttribute("sendEmailForm") MailRecipientDTO mailRecipientDTO,Model model) {
		   mailRecipientDTO.setRecipient("salonechnchy@gmail.com");			
		   commonServices.sendQueryEmail(mailRecipientDTO);
	       return "mailSendSuccess";
	    }		
}

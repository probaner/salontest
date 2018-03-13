package SpringMy.Maven.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import SpringMy.Maven.Services.CommonServices;
import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.db.enities.FileDetail;
import SpringMy.Maven.model.DisplayFileDTO;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.PaymentDTO;
import SpringMy.Maven.model.UserDTO;
import SpringMy.Maven.property.enities.ConfigProperty;

@Controller
@Scope("session")
@EnableWebMvc


public class FileUploadController {
	
	@Autowired
	DbServices dbServices;
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private CommonServices commonServices;
	@Autowired
	private ConfigProperty configProperty;
		
	public void setUser(UserDTO userDTO) {
		   this.userDTO = userDTO;
	    }
	
	public void setCommonService(CommonServices commonService) {
		this.commonServices = commonService;
	}
	
	 @RequestMapping(value = "/saveimage")
     public String uploadResources(@RequestParam String action, HttpServletRequest servletRequest, HttpServletResponse response, @ModelAttribute("product") FileDTO fileDTO, Model model) throws IOException{
		 
		if (action.equals("save")) {
			CommonsMultipartFile imagecm = fileDTO.getImages();
			byte[] encoded = Base64.encodeBase64(imagecm.getBytes());
			// if(!imagecm.isEmpty() && imagecm.getSize()>0 ){//check the
			// multipart data

			// if(imagecm.getSize()<configProperty.getMaxSize()){//check the
			// maximum file size

			if (dbServices.saveFileData(fileDTO, userDTO)) { // check for same
																// titel in same
																// catagory
				commonServices.saveFile(userDTO.getUserid() + File.separator + fileDTO.getCatagoryName(), imagecm);

				String encodedString = new String(encoded);
				model.addAttribute("image", encodedString);

				model.addAttribute("sucessMagssage",
						"WELCOME " + userDTO.getLastname().toUpperCase() + " " + userDTO.getFirstname().toUpperCase());
				model.addAttribute("fileDTO", fileDTO);
			} else
				model.addAttribute("fileSizeError", "title should not be same on same catagory");

			/*
			 * } else model.addAttribute("fileSizeError","File size more then "
			 * +(configProperty.getMaxSize().toString()).substring(0, 1) +"MB");
			 */

			/*
			 * }else model.addAttribute("fileSizeError",
			 * "Before upload choose a file");
			 */

		} else if (action.equals("delete")) {
			System.out.println("CatagoryName="+fileDTO.getCatagoryName()+" ,PositionName="+fileDTO.getPositionName());
			
			FileDetail totalFileData = dbServices.deleteFileData(fileDTO, userDTO);//delete file 
			/*System.out.println("totalFileData=" + totalFileData.toString());
			if (totalFileData.getFile() != null) {
				commonServices.deleteFileFromDirectory(userDTO.getUserid() + File.separator + fileDTO.getCatagoryName()
						+ File.separator + totalFileData.getOriginalFileName());//delete file from directory.
				model.addAttribute("deleteMassage", "delete sucess");
			} else
				model.addAttribute("deleteMassage", "nothing to delete");*/
		}
		
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
                	 //System.out.println("image_"+dfdto.getPosition()+ "    "+"titel_"+dfdto.getPosition()+"  "+dfdto.getTitel());
               	     
                    }
			}
						
			model.addAttribute("size", "");
			     
		}else{
			   model.addAttribute("size", "0");
		     }
         
		 return "registrationsuccess";
		 
	     }
	
	
	 
}


//http://stackoverflow.com/questions/20193138/very-simple-spring-mvc-button-click
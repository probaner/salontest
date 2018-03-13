package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringMy.Maven.Services.DbServices;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.UserDTO;

public class TestDBService {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
		DbServices dbServices = (DbServices) context.getBean("dbServices");
		try {
			
			  FileDTO fileDTO = new FileDTO();
			  UserDTO userDTO = new UserDTO();
			  fileDTO.setCatagoryName("momocrom");
			  dbServices.saveFileData(fileDTO, userDTO);
			
		    }catch (Exception e) {
				                   // TODO Auto-generated catch block
				                   e.printStackTrace();
			                      }
		
		
	 }

}

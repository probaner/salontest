package SpringMy.Maven.Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import SpringMy.Maven.model.MailRecipientDTO;
import SpringMy.Maven.property.enities.ConfigProperty;
import SpringMy.Maven.property.enities.LastIdProperty;


public class CommonUtil {
	
	
	 @Autowired
	 private MailSender mailSender;
	 
	 @Autowired
	 private LastIdProperty lastIdProperty;
	 
	 @Autowired
	 private ConfigProperty configProperty;
	 	 
	 private static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 
	 
	 public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	   }
	 public void setLastIdProperty(LastIdProperty lastIdProperty) {
			this.lastIdProperty = lastIdProperty;
		}
	
	
	
	 public static String getDateTime(){
		 Date date = new Date();
		 //System.out.println(sdf.format(date)); 
		 return  sdf.format(date);		
	 }
	 
	 public  Timestamp sqlDateTime(){
		 long time = System.currentTimeMillis();
		 return(new java.sql.Timestamp(time));	 
	 }
	
	 public  int getUserId() throws IOException{
		String temp = CommonUtil.getDateTime();
		String temp_part1=(temp.substring(9,10)).replace("/", "");
		String temp_part2=(temp.substring(13,temp.length())).replace(":", "");
		
		int temp1 = Integer.parseInt(lastIdProperty.getLastId()) +1;
		
		lastIdProperty.setLastId(String.valueOf(temp1));
		if(temp1<10)
		return Integer.parseInt(temp_part1+"000"+temp1+ temp_part2);
		else if(temp1<100 && temp1>=10)
			return Integer.parseInt(temp_part1+"00"+temp1+ temp_part2);
		else if(temp1<1000 && temp1>=100)
			return Integer.parseInt(temp_part1+"0"+temp1+ temp_part2);  
		
		return 0;		
	 }
	
	 
	 
	 
	
	//http://www.codejava.net/frameworks/spring/sending-e-mail-with-spring-mvc
	 public String doSendEmail(MailRecipientDTO mailRecipientDTO) {		 
		 SimpleMailMessage email = new SimpleMailMessage();
		 email.setFrom(mailRecipientDTO.getSender());
		 email.setTo(mailRecipientDTO.getRecipient());
		 email.setSubject(mailRecipientDTO.getSubject());
		 email.setText(mailRecipientDTO.getMessage());		 
		 mailSender.send(email);		 
		 return "success";		 
	 }


	 
	 public String directoryCheck(String directoryName){		 
		 String dir=configProperty.getBasePath()+File.separator+directoryName;
		 File file = new File(dir);		  
		 if(!file.exists()){
			 file.mkdirs();
			 return dir; 
		   }
		 else
		     return dir;		 
	 }
	 
	 
	 public boolean checkFileSize(File file){
		 
		 Double size = (double) (file.length()/1024);
		 System.out.println("size="+size);
		 if(size> configProperty.getMaxSize())
		    return false;
		 else   		
		      return true;		 
	 }
	 
	 
	 public long findNumberofDaysBetweenTwoDate(String inputString1, String inputString2 ){
		 
		 inputString2 = inputString2.replace("/", "-");
		     System.out.println(inputString1 +"        "+inputString2 );
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");	
			try {
			    Date date1 = simpleDateFormat.parse(inputString1);
			    Date date2 = simpleDateFormat.parse(inputString2);
			    long diff = date1.getTime() - date2.getTime();
			    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			return 0;
		}
	 
	/*public static void main(String args[]){
		calculatePersentValue(20,20);
	}*/
	  
	 
	 public int calculatePersentValue(int amount, int persent){
		 
		 float finalv = amount - (amount*persent)/100;
		  return (Math.round(finalv));
		 
	 }
	
  }

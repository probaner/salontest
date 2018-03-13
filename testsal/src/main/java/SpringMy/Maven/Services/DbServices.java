package SpringMy.Maven.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import SpringMy.Maven.Utility.CommonUtil;
import SpringMy.Maven.db.dao.CategoryDAO;
import SpringMy.Maven.db.dao.DiscountDataDAO;
import SpringMy.Maven.db.dao.FileDetailDAO;
import SpringMy.Maven.db.dao.PayStatusDAO;
import SpringMy.Maven.db.dao.UsersDAO;
import SpringMy.Maven.db.enities.Category;
import SpringMy.Maven.db.enities.DiscountData;
import SpringMy.Maven.db.enities.FileDetail;
import SpringMy.Maven.db.enities.PayStatus;
import SpringMy.Maven.db.enities.Users;
import SpringMy.Maven.model.DisplayFileDTO;
import SpringMy.Maven.model.FileDTO;
import SpringMy.Maven.model.GetPassword;
import SpringMy.Maven.model.Login;
import SpringMy.Maven.model.UserDTO;
import SpringMy.Maven.model.UserStatusDisplayDTO;
import SpringMy.Maven.property.enities.ConfigProperty;

public class DbServices {
	
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private CommonServices commonService;
	@Autowired
	private FileDetailDAO fileDetailDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ConfigProperty configProperty;
	@Autowired
	private PayStatusDAO payStatusDAO;
	@Autowired
	private DiscountDataDAO discountDataDAO;
	
	
	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	public void setCommonUtil(CommonUtil commonUtil) {
		this.commonUtil = commonUtil;
	}
	
	public void setCommonService(CommonServices commonService) {
		this.commonService = commonService;
	}
		
	public void setFileDetailDAO(FileDetailDAO fileDetailDAO) {
		this.fileDetailDAO = fileDetailDAO;
	}
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
		
	public void setPayStatusDAO(PayStatusDAO payStatusDAO) {
		this.payStatusDAO = payStatusDAO;
	}	
	public void setDiscountDataDAO(DiscountDataDAO discountDataDAO) {
		this.discountDataDAO = discountDataDAO;
	}

	
	
	public void saveUserData(UserDTO userDTO) throws IOException{		
		Users users = new Users();
		users.setUser_id(commonUtil.getUserId());
		users.setFirst_name(userDTO.getFirstname());
		users.setLast_name(userDTO.getLastname());
		users.setGender(userDTO.getGender());
		users.setAddress(userDTO.getAddress());
		users.setCity(userDTO.getCity());
		users.setState(userDTO.getPin());
		users.setCountry(userDTO.getCountry());
		users.setClub(userDTO.getClub());
		users.setHoner(userDTO.getHoner());
		users.setEmail(userDTO.getEmail());
		users.setPassword(userDTO.getPassword());
		users.setCreated_on(commonUtil.sqlDateTime());
		users.setLast_loggin(commonUtil.sqlDateTime());
		users.setRole("participate");
		usersDAO.persist(users);
		//commonService.sendRegistrationConfirmMail(users);
		System.out.println(users.toString());
	}
	
	
	
	public List<Users> getUserData(Login login) throws IOException{
		Users users = new Users();
		users.setEmail(login.getUsername());
		users.setPassword(login.getPassword());
		@SuppressWarnings("unchecked")
		List<Users> userData= usersDAO.findByExample(users);
		return userData;
		
	}
	
	public List<String> getListOfAColumn(String columnName) throws IOException{
		List<Users> usersList= usersDAO.findAColumn(columnName);
		List<String> emailList= new ArrayList<String>();
		//System.out.println(usersList.toString());
		if(usersList.size()>0){
		   for (Users users : usersList){
			   emailList.add(users.getEmail());
		       }
		  }
		System.out.println(emailList);
		return emailList;
		//return null;
		
	}
  
	 public void updateCurrentTimeStamp(List<Users> user){
		 Users users = new Users();
		 users.setUser_id(user.get(0).getUser_id());		 
		 users.setFirst_name(user.get(0).getFirst_name());
		 users.setLast_name(user.get(0).getLast_name());
		 users.setGender(user.get(0).getGender());
		 users.setAddress(user.get(0).getAddress());
		 users.setCity(user.get(0).getCity());
		 users.setState(user.get(0).getState());
		 users.setCountry(user.get(0).getCountry());
		 users.setClub(user.get(0).getClub());
		 users.setHoner(user.get(0).getHoner());
		 users.setEmail(user.get(0).getEmail());
		 users.setPassword(user.get(0).getPassword());
		 users.setCreated_on(user.get(0).getCreated_on());
		 users.setLast_loggin(commonUtil.sqlDateTime());
		 users.setRole(user.get(0).getRole());
		 usersDAO.attachDirty(users);  
		 
	   }

	
	 public boolean saveFileData(FileDTO fileDTO, UserDTO userDTO) throws IOException{
		 		      
		      FileDetail fileDetail = new FileDetail();
		      
		      Users user = new Users();
		      user.setUser_id(userDTO.getUserid());
		      
		      Category catagory = new Category();		      		      
		      catagory.setCategoryId(getCategoryIDfromCategoryName(fileDTO));
		      
		      fileDetail.setUsers(user);
		      fileDetail.setTitel(fileDTO.getTitel());
		      fileDetail.setFile(fileDTO.getImages().getBytes());
		      fileDetail.setOriginalFileName(fileDTO.getPositionName()+"_"+fileDTO.getImages().getOriginalFilename());
		      fileDetail.setUpload_time(commonUtil.sqlDateTime());
		      fileDetail.setCategory(catagory);
		      //save file
		      List<String> listOfTitel = fileDetailDAO.findTitelListOfaCatagory(fileDetail);
		      //System.out.println("listOfTitel=================================="+listOfTitel);
		      if(listOfTitel.size()==0){
		    	  fileDetailDAO.persist(fileDetail);
		    	  return true;
		      }
		      else if (listOfTitel.contains(fileDetail.getTitel())){
		    	       return false;
		              }
		      else{
		    	    fileDetailDAO.persist(fileDetail);
		    	    return true;		    	    
		          }		     	   		 
	 }
	 
	 public FileDetail deleteFileData(FileDTO fileDTO, UserDTO userDTO){
		 
		 FileDetail fileDetail = new FileDetail();		 
		 Users user = new Users();
		 Category catagory = new Category();
		 
		 user.setUser_id(userDTO.getUserid());
		 catagory.setCategoryId(getCategoryIDfromCategoryName(fileDTO));
		 
		 // Create file object from file DTO
		 fileDetail.setUsers(user);		 
		 fileDetail.setCategory(catagory);
		 fileDetail.setOriginalFileName(fileDTO.getPositionName()+"%");
		
		 FileDetail file1 = fileDetailDAO.findFile(fileDetail);
		 if(file1!=null){			 			 
		     fileDetailDAO.delete(file1);
		     return file1;
		    }
		 else
			 return (new FileDetail());
	 }
	 
	 public Integer getCategoryIDfromCategoryName(FileDTO fileDTO){
		 
	      return categoryDAO.getCategoryID(fileDTO.getCatagoryName());		      
	 }
	 
	 public HashMap<String, LinkedList<DisplayFileDTO>> getDisplayFileData(UserDTO userDTO){		 		  
		    //List<DisplayFileDTO> listOfDisplayFileDTO = new ArrayList<DisplayFileDTO>();		      
		    List<FileDetail> fileDetailList = getUpLoadedFileDetailOfAUser(userDTO);
		    HashMap<String, LinkedList<DisplayFileDTO>> hm = new HashMap<>();
		   
		    
		    if(fileDetailList.size()>0){
		    	for(FileDetail f : fileDetailList){
		    	if(hm.containsKey(f.getCategory().getCategoryName())){
		    		DisplayFileDTO displayFileDTO = new DisplayFileDTO();
		    		displayFileDTO.setItemImage(f.getFile());
		    		displayFileDTO.setTime(f.getUpload_time().toString());
		    		displayFileDTO.setTitel(f.getTitel());	
		    		displayFileDTO.setPosition(f.getOriginalFileName().substring(0, f.getOriginalFileName().indexOf("_")));
		    		LinkedList<DisplayFileDTO>  l =hm.get(f.getCategory().getCategoryName());
		    		l.add(displayFileDTO);
		    		hm.put(f.getCategory().getCategoryName(), l);
		    	}
		    	else{
		    		  DisplayFileDTO displayFileDTO = new DisplayFileDTO();
		    		  LinkedList<DisplayFileDTO>  l = new LinkedList<>();
		    		  displayFileDTO.setItemImage(f.getFile());
		    		  displayFileDTO.setTime(f.getUpload_time().toString());
		    		  displayFileDTO.setTitel(f.getTitel());
		    		  displayFileDTO.setPosition(f.getOriginalFileName().substring(0, f.getOriginalFileName().indexOf("_")));
		    		  l.add(displayFileDTO);
		    		  hm.put(f.getCategory().getCategoryName(), l);
		    	    }
		    	}
		    	
		      }
		    //System.out.println(hm);
		    return hm;     	      
	 }
	 
	 /*public List<FileDetail>getUpLoadedFileDetailOfAUser(UserDTO userDTO){
		String sql = "select ca.category_name categoryname, f.titel titel, f.upload_time time, f.file file "+ 
				"from salontest.category ca, salontest.file f "+
				"where ca.category_id=f.category_id "+ 
				"and f.user_id="+userDTO.getUserid() +" ORDER BY f.upload_time";
		
		  List
		 
		return null;
		 
	 }*/
	 
   public List<FileDetail>getUpLoadedFileDetailOfAUser(UserDTO userDTO){
		
	    FileDetail fileDetail = new FileDetail();	    
	    Users user = new Users();		   
	    user.setUser_id(userDTO.getUserid());
	    fileDetail.setUsers(user);		  
	    List<FileDetail> fileDetailList = fileDetailDAO.findByExample(fileDetail);		    
	    return fileDetailList;	   
	}
   
   public List<PayStatus> getPayStatusOfAUser(UserDTO userDTO){
		
	   PayStatus payStatus = new PayStatus();	    
	    Users user = new Users();		   
	    user.setUser_id(userDTO.getUserid());
	    payStatus.setUsers(user);		  
	    List<PayStatus> payStatusList = payStatusDAO.findByExample(payStatus);		    
	    return payStatusList;	   
	}
	 
  public void savePayStatus(UserDTO userDTO){
	PayStatus payStatus = new PayStatus();  
	List<PayStatus> payStatusList=getPayStatusOfAUser(userDTO);
	List<FileDetail> fileDetailList = getUpLoadedFileDetailOfAUser(userDTO);
	
	Users user = new Users();
	//System.out.println();
	user.setUser_id(userDTO.getUserid());
	payStatus.setUsers(user);
	 
	if(fileDetailList.size()>0 ){
		
	   payStatus.setTotalEntry(fileDetailList.size());
	   //String country =userDTO.getCountry();		
	   Set<Integer> uniqueCategory = new HashSet<Integer>();
	   for(FileDetail fd : fileDetailList ){
			uniqueCategory.add(fd.getCategory().getCategoryId());
		   }
	   payStatus.setAttemptSection(uniqueCategory.size());
	   	   
	  // List<String> netiveCountryList = Arrays.asList(configProperty.getNetiveCountry().split(","));
	    //System.out.println("netiveCountryList="+netiveCountryList);
	    
	   //if(netiveCountryList.contains(userDTO.getCountry().toUpperCase())){
	     if(commonService.userIsNative(userDTO)){// check native country of a user....
		  if(configProperty.getChargeingTypeCategoryWiseNetive().equals("yes")){ // for netive entry		  
			  if(uniqueCategory.size()==0)
				  payStatus.setTotalAmount(0);
			  if(uniqueCategory.size()==1)
				  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryOneNetive()));
			  if(uniqueCategory.size()==2)
				  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryTwoNetive()));
			  if(uniqueCategory.size()==3)
				  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryThreeNetive()));
			  if(uniqueCategory.size()==4)
				  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryFourNetive()));
			}
		else if(configProperty.getChargeingTypeOverallNetive().equals("yes")){
			     payStatus.setTotalAmount(Integer.parseInt(configProperty.getOverallNetive()));  
		       }
		else if(configProperty.getChargeingTypeIndivisualPhotoWiseNetive().equals("yes")){
			
		       }
		
		   payStatus.setCourencyType(configProperty.getNetiveCurrencyName());
	      }
		else{   // for forgen entry
			 if(configProperty.getChargeingTypeCategoryWiseForeign().equals("yes")){
				  if(uniqueCategory.size()==0)
					  payStatus.setTotalAmount(0);
				  if(uniqueCategory.size()==1)
					  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryOne()));
				  if(uniqueCategory.size()==2)
					  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryTwo()));
				  if(uniqueCategory.size()==3)
					  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryThree()));
				  if(uniqueCategory.size()==4)
					  payStatus.setTotalAmount(Integer.parseInt(configProperty.getCategoryFour()));
			   }
	        else if(configProperty.getChargeingTypeOverallForeign().equals("yes")){
			     payStatus.setTotalAmount(Integer.parseInt(configProperty.getOverall()));  
		       }
		    else if(configProperty.getChargeingTypeIndivisualPhotoWiseForeign().equals("yes")){
			         
		           }
			
			 payStatus.setCourencyType(configProperty.getForeignCurrencyName());  
		    }			
		  
	        //claculate Discount amount for a user
	       int discountPersent = getDiscountPersent(userDTO);
	       if(discountPersent > 0){
	          int value = commonUtil.calculatePersentValue(payStatus.getTotalAmount(),discountPersent);
	          payStatus.setDiscountAmount(value);
	          }else{
	        	     payStatus.setDiscountAmount(payStatus.getTotalAmount());
	               }
	     
	        		    
	        payStatus.setPayingStatus("Being Check");
		if(payStatusList.isEmpty()){
			System.out.println("  IN CREATE ");
			payStatus.setEntryCreatedTime(commonUtil.sqlDateTime());
			payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
			payStatusDAO.persist(payStatus);			
		  }else{			  
			     System.out.println("  IN UPDATE ");
			     payStatus.setPayId(payStatusList.get(0).getPayId());
			     payStatus.setEntryCreatedTime(payStatusList.get(0).getEntryCreatedTime());
			     payStatus.setLastUpdateTime(commonUtil.sqlDateTime());
			     payStatusDAO.attachDirty(payStatus);
		       }
		
	  }else if(fileDetailList.size()==0  && payStatusList.size()>0){		       
		       payStatusDAO.delete(payStatus);	  
	          }
	
}
	 
	
  public List<UserStatusDisplayDTO> getUserDateForStatusTable(){
	  
	  String sql ="SELECT ps.user_id, usr.first_name, usr.last_name, usr.club, usr.country,ps.attempt_section, ps.total_entry, ps.paying_status "+
	              "FROM salontest.pay_status ps, salontest.users usr "+ 
			       "where ps.user_id=usr.user_id"; 
	  
	  List<UserStatusDisplayDTO> userStatusDisplayDTOList = payStatusDAO.fetchSql(sql);
	  
	  return userStatusDisplayDTOList;
	  
  }
  
  
  public int getDiscountPersent(UserDTO userDTO){
	  
	  DiscountData discountData =new DiscountData();
      discountData.setUsrID(userDTO.getUserid()); 
      @SuppressWarnings("unchecked")
	  List<DiscountData> discountDataList = discountDataDAO.findByExample(discountData);
      if(discountDataList.size()>0){
    	  return discountDataList.get(0).getDiscountPersent();
        } 
      
	  return 0;
	  
  }

  public String getPassword(GetPassword getPassword){	  
	String password = usersDAO.findPassword(getPassword.getEmail()); 
	return password;	  
  }
  
}

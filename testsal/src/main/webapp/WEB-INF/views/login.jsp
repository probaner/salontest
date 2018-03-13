<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Salon</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/css/bootstrap-formhelpers.min.css" >
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-formhelpers/2.3.0/js/bootstrap-formhelpers.min.js"></script>
  <script src="<c:url value="/resources/javaScript/utility.js" />"></script>
  <script src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>
 
 <style> 
div.redplaceholder ::-webkit-input-placeholder {
color: red !important;
}
 
div.redplaceholder :-moz-placeholder { /* Firefox 18- */
color: red !important;  
}
 
div.redplaceholder ::-moz-placeholder {  /* Firefox 19+ */
color: red !important;  
}
 
div.redplaceholder :-ms-input-placeholder {  
color: red !important;  
}
</style>

</head>
<body>

<div class="container">
  <div class="page-header">
    <h2>Example Page Header</h2>      
  </div>
  <p></p>      
  <p></p>      
</div>

 <div class="container">
  <h4></h4>
  <ul class="nav nav-tabs">
    <li class="active"><a href="home">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Rules & Regulations <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#"> RULES & REGULATIONS 2017 </a></li>
        <li><a href="#"> FIAP DEFINITIONS OF DIVISIONS </a></li>                       
      </ul>
    </li>
	<li><a href="getloginForm">Perticipate/Login</a></li>
	<li><a href="getUserTable">Entry Status</a></li>
	<li><a href="#">Download</a></li>   
    <li><a href="final-contactus.html">Contuct Us</a></li>
  </ul>
</div> 
  
  <div>
  <p class="big"></p>
  <p class="big"></p>
  <p class="big"></p>
  </div>
 
  
        
    	<div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="getForgetPasswordForm"><strong>Forgot password?</strong></a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                     <!--   <form id="loginform" class="form-horizontal" role="form"> -->
					 <form:form  action="loginSucess" method="post" commandName="loginForm">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email" required autofocus>                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                                    </div>
                                    

                                
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
                                    </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->
                                    <div style="color: red"> ${error} </div>
                                    <div class="col-sm-12 controls">
                                     <input type="submit" class="btn btn-default btn-primary submit" value="Submit" onclick="buttonSubmitClickedLogin(event);" data-login-id="login-username,login-password"/>
                                   
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                         <strong>   Don't have an account! </strong>
                                        <a href="getRegistrationForm" > <!-- onClick="$('#loginbox').hide(); $('#signupbox').show()"> -->
                                           <strong> Sign Up Here </strong>
                                        </a>
                                        </div>
                                    </div>
                                </div>  
							</form:form>	
                           <!-- </form> --> 



                        </div>                     
                    </div>  
        </div>
        </div>
       </body>
</html> 
        
       <%--  <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">
                                 <form:form action="processRegistration" method="post" commandName="userForm">    
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                  
                                   <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <input id="email" type="text" class="form-control" name="email" value="" placeholder="* Email Address" required autofocus />                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                        <input id="password" type="password" class="form-control" name="password" value="" placeholder="* Password" />                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                        <input id="confirm_password" type="password" class="form-control" name="confirm_password" value="" onkeyup="myFunction();" placeholder="* Confirm Password" />                                        
                                    </div>  
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <input id="firstname" type="text" class="form-control" name="firstname" value="" placeholder="* First Name" />                                        
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <input id="lastname" type="text" class="form-control" name="lastname" value="" placeholder="* Last Name" />                                        
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="col-sm-12">
                                    <form:select class="form-control" path="gender" items="${professionList}" >
                                    <!-- <select class="form-control" id="gender">
                                    <option>Sex</option>
                                    <option>Male</option>
                                    <option>Female</option>-->  
                                    </select>                   
                                    </div>
                                 
                                   <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <input id="address" type="text" class="form-control" name="address" value="" placeholder="* Address with PIN code" />                                        
                                   </div>
                                   
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                    <select class="form-control" id="country">
                                    <option> * Country.... </option>
                                    <option>India</option>
                                    <option>Nepal</option>
                                    </select>                    
                                    </div>
                                   
                                    <div style="margin-bottom: 25px" class="col-md-12"> 
                                        <input id="club" type="text" class="form-control" name="club" value="" placeholder=" Club" />                                        
                                   </div>
                                   
                                    <div style="margin-bottom: 25px" class="col-md-12" > 
                                        <input id="honer" type="text" class="form-control" name="honer" value="" placeholder=" Honer" />                                        
                                   </div>
                                   
                                   <div style="margin-top:10px" class="form-group">
                                    <div class="col-md-offset-5 col-md-12">
                                     <input class="btn btn-default btn-primary submit" type="submit" value="Submit" onclick="" data-login-id="login-username,login-password"/>
                                    </div>
                                    </div>    --%> 
                                    
                                    
                                    
                                    
                                    <!-- <div class="form-group">
                                    Button                                        
                                    <div class="col-md-offset-5 col-md-12">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                       <span style="margin-left:8px;">or</span>   
                                    </div>
                                </div> -->
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                               
                                <!-- <div class="form-group">
                                   <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-12 redplaceholder" >
                                        <input type="test" path="email1" class="form-control" name="email"  placeholder="* Email Address" required autofocus >
                                    </div>
                                </div>
                                  
								  <div class="form-group">
                                   <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-12 redplaceholder">
                                        <input type="password" path="password" class="form-control" name="passwd" placeholder="* Password" >
                                    </div>
                                </div>
                                  <div class="form-group">
                                   <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-12 redplaceholder">
                                        <input type="password" path="password" class="form-control" name="confpasswd" placeholder="* Confirm Password" >
                                    </div>
                                </div>
								  
                                <div class="form-group">
                                     <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-12 redplaceholder">
                                        <input type="text" path="firstname" class="form-control" name="firstname" placeholder="* First Name" >
                                    </div>
                                </div>
                                <div class="form-group">
                                   <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-12 redplaceholder">
                                        <input type="text" path="lastname" class="form-control" name="lastname" placeholder="* Last Name" >
                                    </div>
                                </div> -->
                              								
							<%-- 	<div class="form-group">
                                <!-- <label for="gender1" class="col-sm-2 control-label">With Bootstrap:</label> -->
                                <div class="col-sm-12">
                                <select class="form-control" id="gender1">
                                <option>Male</option>
                                <option>Female</option>
                                </select>                    
                                </div>
                                 </div>
								
								  <div class="form-group">
                                  <!--  <label for="password" class="col-md-3 control-label">Password</label> -->
                                    <div class="col-md-12">
                                        <form:input type="text" path="clubname" class="form-control" name="clubname" placeholder="Club Name" />
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                   <!-- <label for="icode" class="col-md-3 control-label">Invitation Code</label> -->
                                    <div class="col-md-12 redplaceholder">
                                        <form:input type="text" path="address" class="form-control" name="icode" placeholder="* Address" />
                                    </div>
                                </div>
								
								  <div class="form-group ">
                                   <!-- <label for="icode" class="col-md-3 control-label">Invitation Code</label> -->
                                    <div class="col-md-12">
                                        <form:input type="text" path="address" class="form-control" name="icode" placeholder="* City" />
                                    </div>
                                </div>
                                
                                <div class="form-group ">
                                   <!-- <label for="icode" class="col-md-3 control-label">Invitation Code</label> -->
                                    <div class="col-md-12">
                                        <form:input type="text" class="form-control" name="icode" placeholder="* ZIP" />
                                    </div>
                                </div>
							
								<div class="form-group">
                                <!-- <label>Select Country</label><br> -->
								<div class="col-md-12">
                                <select class="form-control bfh-countries" data-country="US"> </select>																
								</div>
                                </div>
							
								
								
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-5 col-md-12">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                       <!-- <span style="margin-left:8px;">or</span> -->   
                                    </div>
                                </div> --%>
						
							
                              <!--  <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i> Â  Sign Up with Facebook</button>
                                    </div>                                           
                                        
                                </div> --> 
                       <%--          </form:form>    --%>
                      <%--       </form>
                         </div>
                         </div>
                         </div>




</body>
</html> --%>



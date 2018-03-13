<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>User Registration</title>
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
    <h2>Login</h2>      
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
  
<div class="container" > 

 

<div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="getloginForm" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                         </div> 
                         <div class="panel-body">
                         <form:form action="processRegistration" method="post" commandName="userForm">
                         
                          <style>
                          .foo{
                                display: none;
                              }
                         </style>
                         <div style="margin-bottom: 25px" class="alert-danger" >${error} 
                         <a href="getForgetPasswordForm" class="alert-link"><strong>  Click hear to get password</strong></a>
                         <span></span>                                              
                         </div>
                         <script type="text/javascript">
                         var username = "${error}";
                         $(document).ready(function () {
                         if (username  == "") {                       	
                              $(".alert-danger").addClass("foo");                             
                           }                        
                          });
                         </script>
                         
                         
                         <!--  <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div> -->
                        
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="email" id="email" type="text" class="form-control" name="email" value="" placeholder="* Email Address" required="autofocus" />                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                        <form:input path="password" id="password" type="password" class="form-control" name="password" value="" placeholder="* Password" />                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
                                        <input  id="confirm_password" type="password" class="form-control" name="confirm_password" value="" onblur="myFunction();" placeholder="* Confirm Password" />                                        
                                    </div>  
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="firstname" id="firstname" type="text" class="form-control" name="firstname" value="" placeholder="* First Name" />                                        
                                    </div>
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="lastname" id="lastname" type="text" class="form-control" name="lastname" value="" placeholder="* Last Name" />                                        
                                    </div> 
                                      
                                    <div style="margin-bottom: 25px" class="col-sm-12">
                                     <form:select class="form-control" path="gender" items="${genderList}" />
                                    </div> 
                                    
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="address" id="address" type="text" class="form-control" name="address" value="" placeholder="* Address with PIN code" />                                        
                                   </div>
                                   
                                   <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="city" id="city" type="text" class="form-control" name="city" value="" placeholder="* City" />                                        
                                   </div>
                                   
                                    <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
                                        <form:input path="pin" id="pin" type="text" class="form-control" name="pin" value="" placeholder="* ZIP/PIN Code" />                                        
                                   </div>
                                   
                                   <div style="margin-bottom: 25px" class="col-sm-12">
                                     <form:select class="form-control" path="country" items="${countryList}" />
                                    </div>
                                   
                                    <div style="margin-bottom: 25px" class="col-md-12"> 
                                        <form:input path="club" id="club" type="text" class="form-control" name="club" value="" placeholder=" Club" />                                        
                                   </div>
                                   
                                    <div style="margin-bottom: 25px" class="col-md-12" > 
                                        <form:input path="honer" id="honer" type="text" class="form-control" name="honer" value="" placeholder=" Honer" />                                        
                                   </div>
                                   
                                   <div style="margin-top:10px" class="form-group">
                                   <div class="col-md-offset-5 col-md-12">
                                   <input class="btn btn-default btn-primary submit" type="submit" value="Submit" />
                                   </div>
                                   </div>
                            
                         </form:form>                         
                         </div>
                         

</div> 
</div> 
</div> 
                        
                         
</body>
</html>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>
<title>Registration/Login  Success</title>
</head>

<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="" >  
<div align="right"><a href="<%=request.getContextPath()%>/logout"> Log Out </a></div>
<tr><tr><tr><tr><tr></tr></tr></tr></tr></tr>
   
 <div align="center">
 <table border="0">
            <tr>
            <td colspan="2" align="center"><h2> <c:out value="${sucessMagssage}" /> </h2></td>
            </tr>           
 </table>
 </div>
 
 <tr><tr><tr><tr><tr></tr></tr></tr></tr></tr>
 <div id="global">
 
 
         <form commandName="product" action="<c:url value="/saveimage" />" method="post" enctype="multipart/form-data">
        <fieldset>
                <legend>Add a product</legend>
                                
               <p>
                 <label for="image">Product Images: </label> 
                 <input type="file" name="images" multiple="multiple"/>
                 </p>
                 <p>
                 <input name="catagoryName" type="hidden" value="color"/>                 
                 </p>
                 <!-- <img  style="float:right;width:42px;height:42px;" src="{fileDTO.images}"/> -->
                 <img style="float:right;width:80px;height:80px;" src="data:image/jpg;base64,<c:out value='${image}'/>" />
                  <tr>
                  <table border="0">
                  <td colspan="2" align="center"><h4> <c:out value="${fileSizeError}" /> </h4></td>
                  <td colspan="2" align="center"><h4> <c:out value="${deleteMassage}" /> </h4></td>
                  </tr> 
                  </table>  
                   
                 <p id="buttons">                   
                    <input id="submit" type="submit" name="action"  tabindex="5" value="save">
                 </p>
				 
				 <p id="buttons">                   
                    <input id="delete" type="submit" name="action" tabindex="5" value="delete">
                 </p>
                
        </fieldset>
        </form>
 
 
        <%-- <form:form commandName="product" action="saveimage" method="post" enctype="multipart/form-data">
        <fieldset>
                <legend>Add a product</legend>
                                
               <p>
                 <label for="image">Product Images: </label> 
                 <input type="file" name="images" multiple="multiple"/>
                 </p>
                 
                 <img  style="float:right;width:42px;height:42px;" src="{fileDTO.images}"/>
                  <tr>
                  <table border="0">
                  <td colspan="2" align="center"><h4> <c:out value="${fileSizeError}" /> </h4></td>
                  </tr> 
                  </table>   
                 <p id="buttons">                   
                    <input id="submit" type="submit" tabindex="5" value="Upload">
                 </p>
                
        </fieldset>
        </form:form> --%>
 </div>
    
</body>
</html>
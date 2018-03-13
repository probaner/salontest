<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email with Spring MVC</title>
</head>
<body>
    <center>
        <h1>Sending e-mail with Spring MVC</h1>
        <h2><c:out value="${message}"/></h2>
        <form:form action="processmail" method="post" commandName="sendEmailForm">
            <table border="0" width="80%">
                <tr>
                    <td>From your mailId:</td>
                    <td><input type="text" name="sender" size="65" /></td>
                </tr>                
                <tr>
                    <td>Subject:</td>
                    <td><input type="text" name="subject" size="65" /></td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td><textarea cols="50" rows="10" name="message"></textarea></td>
                </tr>               
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="SendEmail" />
                    </td>
                </tr>
            </table>
       </form:form>
    </center>
</body>
</html>
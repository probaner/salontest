<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
       <%--  <form:form action="processRegistration" method="post" commandName="userForm"> --%>
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Spring MVC Form Demo - Registration</h2></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstname" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastname" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Gender:</td>
                    <td><form:select path="gender" items="${genderList}" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Address:</td>
                    <td><form:input path="address" /></td>
                </tr>
                <tr>
                <tr>
                    <td>State:</td>
                    <td><form:input path="state" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Country:</td>
                    <td><form:input path="country" /></td>
                </tr>
                <tr>
                <tr>
                    <td>City:</td>
                    <td><form:input path="city" /></td>
                </tr>
                 <tr>
                <tr>
                    <td>Club:</td>
                    <td><form:input path="club" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Honer:</td>
                    <td><form:input path="honer" /></td>
                </tr>
                <tr>
                 <tr>
                    <td>E-mail:</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                    
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        <%-- </form:form> --%>
    </div>
</body>
</html>
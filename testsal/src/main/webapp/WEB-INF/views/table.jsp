<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
  <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
  
<style>
div.ex1 {
    padding: 50px 100px 0px 100px;
}

div.ex2 {
    padding: 0px 100px 10px 100px;
}

div.ex3 {
    padding: 50px 0px 0px 0px;
}
</style>
  
  
  
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>

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
	<li><a href="gettableForm">Entry Status</a></li>
	<li><a href="#">Download</a></li>   
    <li><a href="final-contactus.html">Contuct Us</a></li>
  </ul>
</div>
   
 <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2"> 
 
 <form:form method="post" action="save.html" modelAttribute="contactForm">
 <div class="table-responsive">
 <table id="myTable" class="display table" width="100%" >
 
 <thead>  
          <tr>
            <th>ID</th> 
            <th>  Name  </th>  
            <th>Country</th>  
            <th>Attempt Section</th>  
            <th>Total Entry</th>
			<th>Pay Status</th>
          </tr>  
        </thead>  
        <tbody> 
        <c:forEach var="item" items="${tableData}"> 
          <tr>              
             <td><c:out value="${item.user_id}"/></td> 
             <td><c:out value="${item.last_name} ${item.first_name}"/></td> 
             <td><c:out value="${item.country}"/></td> 
             <td><c:out value="${item.attempt_section}"/></td> 
             <td><c:out value="${item.total_entry}"/></td> 
             <td><c:out value="${item.paying_status}"/></td>             	
          </tr> 
          </c:forEach>         
        </tbody>  
     
  </table>
  </div> 
  </form:form>
  
  </div>


</body>
</html>
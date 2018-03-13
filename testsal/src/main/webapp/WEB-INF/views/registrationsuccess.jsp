<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/javaScript/utility.js" />"></script>
<script
	src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>
<style>
div.ex1 {
	padding: 50px 100px 0px 100px;
}

div.ex2 {
	padding: 0px 100px 10px 100px;
}

div.ex3 {
	padding: 50px 10px 0px 115px;
}

div.ex4 {
	padding: 0px 100px 10px 700px;
}

div.ex5 {
	padding: 0px 100px 10px 100px;
}
</style>




</head>
<body onload="dissableField(); dissablePayField();dissableImageArea();lockPage(); ">

	<div class="container">
		<div class="page-header">
			<h2>Example Page Header</h2>
		</div>
		<p></p>
		<p></p>
	</div>

	<!-- <div class="container">
  <h4></h4>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Submenu 1-1</a></li>
        <li><a href="#">Submenu 1-2</a></li>                       
      </ul>
    </li>
	<li><a href="#">Perticipate/Login</a></li>
	<li><a href="#">Entry Status</a></li>
	<li><a href="#">Download</a></li>   
    <li><a href="#">Contuct Us</a></li>
  </ul>
</div> -->

<script type="text/javascript">
		var isDisabledAll = "${statue}";
</script>


	<div class="ex1">
		<div class="well">
			<h4>
				<c:out value="${sucessMagssage}" />
			</h4>
			<div
				style="float: right; font-size: 120%; position: relative; top: -10px">
				<a href="<%=request.getContextPath()%>/logout"> Log Out </a>
			</div>
		</div>
	</div>

	<!-- Start of row colour -->

	<div class="ex2">
		 <div class="page-header">
			  <h4>Colour</h4>
		 </div>
	</div>
	
	<div class="row">

		 <form:form id="my_form" action="saveimage" method="post" enctype="multipart/form-data" commandName="product">
		 <div class="col-sm-4">
			  <div class="ex2">
				   <div class="col-sm-12" required autofocus>
						<form:input path="titel" id="titelcolour1" class="form-control" placeholder="Enter Titel" value="${titel_color1}" />
							  <script type="text/javascript"> var titelColor1 = "${titel_color1}";</script>
				   </div>
			  </div>
			   <form:input path="catagoryName" type="hidden" value="color" />
			   <form:input path="positionName" type="hidden" value="color1" />

			   <div class="ex3">
					<label class="btn btn-default btn-file">Browse..<form:input type="file" path="images" style="display: none;" multiple="multiple" id="browsecol1" /></label> 
				    <label class="btn btn btn-success">Upload<input type="submit" style="display: none;" name="action" value="save" id="uploadcol1" onclick="buttonSubmitClickedFileupload(event);" data-input-id="browsecol1,titelcolour1" /></label> 
				    <label class="btn btn-danger">Delete<input type="submit" id="deletecol1" style="display: none;" name="action" value="delete" onclick="deleteJob(event);" /></label>
					<!-- <button type="button" class="btn btn-danger"> Delete </button> -->
			   </div>
		 </div>

		 <div class="col-sm-2">
				               <!-- space for pto -->
              <img alt="abc" id="col1img" style="float: left; width: 80px; height: 80px;" src="data:image/jpg;base64,<c:out value='${image_color1}'/>" />
	     </div>
	    </form:form>


		
		<form:form id="my_form" action="saveimage" method="post" enctype="multipart/form-data" commandName="product">
		<div class="col-sm-4">
		     <div class="ex2">
				  <div class="col-sm-12" required autofocus>
					   <form:input path="titel" id="titelcolour2" class="form-control" placeholder="Enter Titel" value="${titel_color2}" />
							 <script type="text/javascript"> var titelColor2 = "${titel_color2}"; </script>
				  </div>
			 </div> 
		     <form:input path="catagoryName" type="hidden" value="color" />
			 <form:input path="positionName" type="hidden" value="color2" />
				
			 <div class="ex3">
				  <label class="btn btn-default btn-file">Browse..<form:input type="file" path="images" style="display: none;" multiple="multiple" id="browsecol2" /></label> 
				  <label class="btn btn btn-success">Upload<input type="submit" style="display: none;" name="action" value="save" id="uploadcol2" onclick="buttonSubmitClickedFileupload(event);" data-input-id="browsecol2,titelcolour2" /></label> 
				  <label class="btn btn-danger">Delete<input type="submit" id="deletecol2" style="display: none;" name="action" value="delete" onclick="deleteJob(event);" /></label>
			 </div>
		</div>
		                               <!-- space for pto -->
		<div class="col-sm-2">
			 <img alt=" " id="col2img" style="float: left; width: 80px; height: 80px;" src="data:image/jpg;base64,<c:out value='${image_color2}'/>" />
		</div>
		</form:form>
	</div>	
				
	<!-- End of row one of colour -->
	
	<!-- Start of row tow of colour -->

	<div class="ex2">
		 <div class="page-header">
			  <h4></h4>
		 </div>
	</div>

	<div class="row">

		 <form:form id="my_form" action="saveimage" method="post" enctype="multipart/form-data" commandName="product">
		 <div class="col-sm-4">
			  <div class="ex2">
				   <div class="col-sm-12" required autofocus>
						<form:input path="titel" id="titelcolour3" class="form-control" placeholder="Enter Titel" value="${titel_color3}" />
							  <script type="text/javascript"> var titelColor3 = "${titel_color3}";</script>
				   </div>
			  </div>
			   <form:input path="catagoryName" type="hidden" value="color" />
			   <form:input path="positionName" type="hidden" value="color3" />

			   <div class="ex3">
					<label class="btn btn-default btn-file">Browse..<form:input type="file" path="images" style="display: none;" multiple="multiple" id="browsecol3" /></label> 
				    <label class="btn btn btn-success">Upload<input type="submit" style="display: none;" name="action" value="save" id="uploadcol3" onclick="buttonSubmitClickedFileupload(event);" data-input-id="browsecol3,titelcolour3" /></label> 
				    <label class="btn btn-danger">Delete<input type="submit" id="deletecol3" style="display: none;" name="action" value="delete" onclick="deleteJob(event);" /></label>
					<!-- <button type="button" class="btn btn-danger"> Delete </button> -->
			   </div>
		 </div>

		 <div class="col-sm-2">
				               <!-- space for pto -->
              <img alt="" id="col3img" style="float: left; width: 80px; height: 80px;" src="data:image/jpg;base64,<c:out value='${image_color3}'/>" />
	     </div>
	    </form:form>


		
		<form:form id="my_form" action="saveimage" method="post" enctype="multipart/form-data" commandName="product">
		<div class="col-sm-4">
		     <div class="ex2">
				  <div class="col-sm-12" required autofocus>
					   <form:input path="titel" id="titelcolour4" class="form-control" placeholder="Enter Titel" value="${titel_color4}" />
							 <script type="text/javascript"> var titelColor4 = "${titel_color4}"; </script>
				  </div>
			 </div> 
		     <form:input path="catagoryName" type="hidden" value="color" />
			 <form:input path="positionName" type="hidden" value="color4" />
				
			 <div class="ex3">
				  <label class="btn btn-default btn-file">Browse..<form:input type="file" path="images" style="display: none;" multiple="multiple" id="browsecol4" /></label> 
				  <label class="btn btn btn-success">Upload<input type="submit" style="display: none;" name="action" value="save" id="uploadcol4" onclick="buttonSubmitClickedFileupload(event);" data-input-id="browsecol4,titelcolour4" /></label> 
				  <label class="btn btn-danger">Delete<input type="submit" id="deletecol4" style="display: none;" name="action" value="delete" onclick="deleteJob(event);" /></label>
			 </div>
		</div>
		                               <!-- space for pto -->
		<div class="col-sm-2">
			 <img alt=" " id="col4img" style="float: left; width: 80px; height: 80px;" src="data:image/jpg;base64,<c:out value='${image_color4}'/>" />
		</div>
		</form:form>
	</div>	
	
	<!-- End of row tow -->
	<!-- End of row colour -->


	<!-- Start of row moncrome -->
	
	
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	
	
	<div class="ex2">
		<div class="page-header">
			<h4>Monocrome</h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row one -->

	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row tow -->
	<!-- End of row moncrome -->


	<!-- Start of row Nature -->
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex2">
		<div class="page-header">
			<h4>Nature</h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row one -->

	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row tow -->
	<!-- End of row Nature -->



	<!-- Start of row Travel -->
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex2">
		<div class="page-header">
			<h4>Travel</h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row one -->

	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row tow -->
	<!-- End of row Travel -->

	<!--<div class="ex2"><div class="page-header"><h4></h4> </div></div> -->

	<script type="text/javascript">
		var isDisabledPayment = "${size}";
	</script>


	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex5">
		<div class="page-header">
			<h4>Payment Area</h4>
		</div>
	</div>

	<form:form id="mypayment_form" action="payment" method="post"
		commandName="paymentDetail">
		<div class="col-sm-2"></div>
		<div class="col-sm-6">
			<div class="ex5">
				<div class="col-sm-12" required autofocus>
					<form:input path="couponCode" id="couponCodeId"
						class="form-control" placeholder="Enter coupon code if available" />
				</div>
			</div>
			<div class="ex5">
				<div class="col-sm-12">
					<input type="image" id="paySubmit" name="action" value="payment"
						src="<c:url value="/resources/image/pay.jpg" />" width="400"
						height="80" border="0" />
				</div>
			</div>
			<div class="ex3">
				<div class="page-header">
					<h4></h4>
				</div>
			</div>
		</div>
	</form:form>


</body>
</html>
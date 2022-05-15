<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/payment.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/payment.js"></script>
<title>Payment Management</title>
</head>
<body onload='getData()'>

<br>
<h1 class="companiName">Electro Gird (PVT)Ltd</h1>
<h2 class="companiName">Payment Management</h2><br><br>

<div id="alertSuccess" class="container alert alert-success"></div><br>
		<div id="alertError" class="container alert alert-danger"></div>


<div class="aCalculatBillForm">		
<form id="calbillForm">
  
	    <div class="mb-3">
	      <label for="disabledTextInput" class="form-label">Full Name :</label>
	      <input type="text" id="Name" name="Name" class="Name form-control">
	      <input type="hidden" id="Name1" name="Name1" class="Name1 form-control">
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Card No :</label>
	      <input type="text" id="CardNo" name="CardNo" class="CardNo form-control">
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Holder Name :</label>
	      <input type="text" id="HlderName" name="HlderName" class="HlderName form-control">
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">CVV :</label>
	      <input type="text" id="CVV" name="CVV" class="CVV form-control">
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Ex Date :</label>
	      <input type="text" id="Exdate" name="Exdate" class="Exdate form-control">
	    </div>

	    <input type="button" id="pay" name="pay" value="Pay" class="pay btn btn-primary BilBut">

</form><br>
</div>
<br>
<h2 class="companiName">All Payment Details</h2><br><br>
<div id='gettable'>
</div>
<br><br>
</body>
</html>
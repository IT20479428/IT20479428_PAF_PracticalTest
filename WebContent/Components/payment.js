$(document).ready(function()
{
		if ($("#alertSuccess").text().trim() == "")
		{
 				$("#alertSuccess").hide();
 		}
 		$("#alertError").hide();
});

$(document).on("click", "#pay", function(event) { 
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
	
	 if($("#Name1").val() == ""){
		var type = "POST"; 
		 $.ajax( { 
			 url : "http://localhost:8080/IT20479428/ElectroG/Payment/Add", 
			 type : type, 
			 data : $("#calbillForm").serialize(), 
			 dataType : "text", 
			 complete : function(response, status) { 
			 	onSaveComplete(response.responseText, status); 
			 }
		 });
	}else{
		var type = "PUT"; 
		 $.ajax( { 
			 url : "http://localhost:8080/IT20479428/ElectroG/Payment/Update", 
			 type : type, 
			 contentType: "application/json", 
			 data : "{'Name':'"+$("#Name").val()+"','CardNo':'"+$("#CardNo").val()+"','HlderName':'"+$("#HlderName").val()+"','CVV':'"+$("#CVV").val()+"','Exdate':'"+$("#Exdate").val()+"'}", 
			 dataType : "text", 
			 complete : function(response, status) { 
			 	onSaveComplete(response.responseText, status); 
			 }
		 });
	}
	
	$("#Name1").val("");
}); 

function onSaveComplete(response, status) { 

	$("#alertSuccess").text(response); 
	$("#alertSuccess").show(); 
}

function getData(){
	var type = "GET"; 
	 $.ajax( { 
		 url : "http://localhost:8080/IT20479428/ElectroG/Payment/", 
		 type : type, 
		 dataType : "text", 
		 complete : function(response, status) { 
		 	onGetComplete(response.responseText, status); 
		 }
	 });
}

function onGetComplete(response, status) { 

	$("#gettable").html(response); 

}


$(document).on("click", "#btnUpdate", function(event) { 
	 $("#Name1").val($(this).closest("tr").find('td:eq(1)').text()); 
	 $("#Name").val($(this).closest("tr").find('td:eq(1)').text()); 
	 $("#CardNo").val($(this).closest("tr").find('td:eq(2)').text()); 
	 $("#HlderName").val($(this).closest("tr").find('td:eq(3)').text()); 
	 $("#CVV").val($(this).closest("tr").find('td:eq(4)').text());
	 $("#Exdate").val($(this).closest("tr").find('td:eq(5)').text()); 
});

$(document).on("click", "#btnRemovee", function(event) { 
	
	$.ajax( { 
		 url : "http://localhost:8080/IT20479428/ElectroG/Payment/Delete", 
		 type : "DELETE", 
		 contentType: "application/xml", 
		 data : "<PaymentData><id>"+$(this).closest("tr").find('td:eq(0)').text()+"</id></PaymentData>",
		 dataType : "text", 
		 complete : function(response, status) { 
		 	onSaveComplete(response.responseText, status); 
		 }
	 });
});
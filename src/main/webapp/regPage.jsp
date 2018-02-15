<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration page</title>

 <!-- <link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 -->

<link rel="stylesheet"	
href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"> </script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!--datePicker  style -->
<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
  
  <!-- <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>  
   <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>  -->
  
  <script type="text/javascript">
  function validateform()
  {   
	 // alert("hhhhhhhhh");
//	  var s=document.myform.uaCheck.value;
	var s=document.getElementById("uaCheck").innerHTML;
	//alert(s);
	  if(s=="name not available")
	  {
		  return false;
	  } 
	  return true;
	  //document.getElementById("uaCheck").
	  
  }
  </script>
  
</head>
<body>

 <h1>Registration Page</h1>



<form:form method="post" action="SignUpToController" name="myform" onsubmit="return validateform()" >
<table>
<tr>
<td>Id : </td>
<td><form:input path="id" name="id" value="0" placeholder="Auto-Genarator"/></td>
</tr>
<tr>
<td>Age : </td>
<td> <form:input path="age" value="0"  name="age" /></td>
</tr>
<tr>
<td>Date : </td>
<td> <form:input path="date" type="text" name="date" id="datepicker" /></td>
</tr>


<!-- <tr>
<td>Country :</td>
<td> <input type="text" name="country" /></td>
</tr>

<tr>
<td>State :</td>
<td> <input type="text" name="state" /></td>
</tr> -->

<!-- Country And State AJAX  -->
 <tr>
				<td>Select Country</td>
				<td><select path="country" name="country" id="select1" onchange="sendAjax()">
						<option value="0">country</option>
						<c:forEach items="${model}" var="oneModel">
							<option value="${oneModel.cid}" > ${oneModel.country}</option>
							<div id="sel" ></div>
						</c:forEach>
				    </select>
				 </td>
				 <!-- <td><a href="vieww">viewcountrylist</a></td> -->
			    </tr>
			
			<tr>
				<td>Select State</td>
				<td><select id="select2" path="state" name="state">
						<option value="0">State</option>
				</select></td>
			</tr>
		<!--ENd AJAX  -->	
		
		<!--NAme Ajax  -->
<tr>
<td>Name :</td>
<td><form:input type="text" path="name" name="name" id="nameSelect" />

<td><span id="uaCheck" name="uaCheck" ></span></td>
</td>    <!--byDefault onkey up taken  -->
<!-- <td><input type="button" onkeyup="nameAjax()" value="check" ></td> -->
</tr>

<!--NAme ajax end  -->
<!-- <tr>
<td>Name :</td>
<td><input type="text" name="name" /></td>
</tr> -->

<tr>
<td>Password :</td>
<td><form:input path="password" type="text" name="password" /></td>
</tr>
<tr>
<td>
	<input type="submit" value="Save" />
	<input type="reset" /></td>
	</tr>
	</table>
</form:form> 
<!-- AJAX Code For COUNTRY AND STATE  -->
<script>
	function sendAjax(){
		//alert("hiiiiiiiiiiii");

		var cid=$("#select1").val();
		//alert(country);
		 
		$.ajax({

			type : "GET",
			url : "getCountryData",
			data : "cid=" + cid,
			dataType: "html",
			
			//---------dropdown for state-------//
			success : function(response) 
			{
				
				 //alert(response);

				var js = JSON.parse(response);
				//alert(js.length);
				
				var jsn = "";
				for (var i = 0; i < js.length; i++) 
				{
					jsn += "<option value='" + js[i].state + "'>"
							+ js[i].state + "</option>";
				}
				$("#select2").html(jsn);

			},

		});

	}
	<!-- End Ajax  -->
	</script>
    <!--   ===============DAte picker===================== -->
	
     <script>
     
         $( function()
        		  {
        	 $( "#datepicker" ).datepicker( { dateFormat: 'dd-M-yy' }).val();        	 

               } 
         ); 
         
         
         </script>
	

<!--ajax nameSearch  -->
<script>
<!--byDefault onkey up taken  -->
$(document).ready(function()
{
    $("#nameSelect").keyup(function()
    {
    	//alert("hjhj");
    	var name=$("#nameSelect").val();
		//alert(name);
		
		$.ajax(
				{

			type : "GET",
			url : "nameSearchfromDb",
			data : "name=" + name,
			dataType: "html",
			
			success : function(response) 
			{
				
				 //alert(response);

				
				$("#uaCheck").html(response);

			},
			
    });
   });
});

</script>



</body>
</html>
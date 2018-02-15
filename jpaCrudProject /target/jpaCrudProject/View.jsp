<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>


<!--------------------SEARCH !----------------->
<h5>SEARCH byNAME:<input type="text" >
	<input type="button" value="search" onclick="window.location.href='searchRequestToControllerFromViewPge'" /></h5>
		
		
		
<table cellpadding="2" border="2px"  bordercolor="red" width="570px" style="border-collapse: collapse; background-color: cyan;"  >
<tr>
<th>ID:</th>
<th>NAME:</th>
<th>AGE:</th>
<th>COUNTRY:</th>
<th>PASSWORD:</th>
<th>EDIT:</th>
<th>DELETE:</th>

</tr>
   <c:forEach var="EmployeePojo" items="${viewKey.list}">
   <tr>
      <td>${EmployeePojo.id}</td>
      <td>${EmployeePojo.name}</td>
      <td>${EmployeePojo.age}</td>
      <td>${EmployeePojo.country}</td>
       <td>${EmployeePojo.password}</td>
       
   
      <td> <input type="button" value=Edit onclick="window.location.href='editEmpRequestFromViewPage/${EmployeePojo.id}'" /></td> 
      <td> <input type="button" value=Delete onclick="window.location.href='deleteEmpRecord/${EmployeePojo.id}'" /></td> 
       
   </tr>
   </c:forEach>




</table>
</body>
</html>
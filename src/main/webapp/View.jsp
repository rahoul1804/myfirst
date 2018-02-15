<%@page import="jpa.controllerModelPojo.EmployeePojo"%>
<%@page import="org.apache.poi.ss.formula.functions.Count"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.List"%>
    <%@page    import="jpa.controller.EmployeeController"%>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>


<!--------------------SEARCH !----------------->
<form action="/jpaCrudProject/searchByName">
		<table >
			<tr>
				<td><font >SEARCH ByName</font></td>
				<td><input type="text" name="name"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
		
		<form action="/jpaCrudProject/searchById">
		<table >
			<tr>
				<td><font >SEARCH ByID</font></td>
				<td><input type="text" name="id" value=0></td>
				
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	
	<!--  search ID NAme  -->
	<h1>--------------------------</h1>
	<form action="/jpaCrudProject/searchByIdAndName">
		<table >
			<tr>
				<td><font >SEARCH ByID</font></td>
				<td><input type="text" name="id"></td>
				<td><font >& ByName</font></td>
				<td><input type="text" name="name"></td></tr>
			<tr>	<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
		<!-- Search Id And Name MErge  -->
		
		<%-- <form action="searchByIdAndNameMerge">
		<table >
			<tr>
				<td><font >SEARCH ByID</font></td>
				<td><input type="text" name="id"></td></tr>
				<tr><td><font >SEARCH ByName</font></td>
				<td><input type="text" name="name"></td></tr>
			<tr>	<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form> --%>
		
		
		
		<!-- ======================== -->
<table cellpadding="2" border="2px"  bordercolor="red" width="570px" style="border-collapse: collapse; background-color: cyan;"  >
<tr>
<th>ID:</th>
<th>NAME:</th>
<th>AGE:</th>
<th>COUNTRY:</th>
<th>STATE:</th>
<th>DATE</th>
<th>PASSWORD:</th>
<th>EDIT:</th>
<th>DELETE:</th>

</tr>
   <c:forEach var="EmployeePojo" items="${list}">
   <tr>
      <td>${EmployeePojo.id}</td>
      <td>${EmployeePojo.name}</td>
      <td>${EmployeePojo.age}</td>
      <td>${EmployeePojo.country}</td>
      <td>${EmployeePojo.state}</td>
      <td>${EmployeePojo.date}</td>
       <td>${EmployeePojo.password}</td>
       
   
      <td> <input type="button" value=Edit onclick="window.location.href='/jpaCrudProject/editEmpRequestFromViewPage/${EmployeePojo.id}'" /></td> 
      <td> <input type="button" value=Delete onclick="window.location.href='/jpaCrudProject/deleteEmpRecord/${EmployeePojo.id}'" /></td> 
   </tr>
   </c:forEach>

  
    
  

</table>

<%-- Full View COunt=== ${cont}

View With Page Id === ${cnt} --%>
<!-- for pagination  -->

<c:forEach begin="0" end="${cont}" step="1" varStatus="loop">
        <a href="/jpaCrudProject/viewToController/<c:out value="${loop.count}"/>"><c:out value="${loop.count}"/></a> 
        <%-- <c:if test="${list.size()/3}">
        <c:out value="${clientName}"></c:out>
        
		</c:if>    --%>     
</c:forEach>


<%-- <c:forEach begin="0" end="${list.size()/3}" step="1" varStatus="loop">

<a href="/jpaCrudProject/viewToController/<c:out value="${loop.count}"/>"><c:out value="${loop.count}"/></a> 
   
</c:forEach> --%>


<br/><br/><br/>
 <!--  <a href="/jpaCrudProject/viewToController/1">1</a>   
  
 <a href="/jpaCrudProject/viewToController/1">1</a>   
   <a href="/jpaCrudProject/viewToController/2">2</a>   
   <a href="/jpaCrudProject/viewToController/3">3</a> 
   <a href="/jpaCrudProject/viewToController/4">4</a>
   <a href="/jpaCrudProject/viewToController/5">5</a> 
   <a href="/jpaCrudProject/viewToController/6">6</a> -->
    <input type="button" value="FullView" onclick="window.location.href='/jpaCrudProject/viewToController'" />
</body>
</html>
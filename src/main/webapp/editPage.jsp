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
${ editkey}

<form:form method="POST" action="editedDetailsrequest" modelAttribute="editkey" >
	
	<h1>enter edit details</h1>
			<table>
			<tr>
				<td><label >Employee ID :  </label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><label>Employee Age : </label></td>
				<td><form:input path="age" /></td>
			</tr>
			
			<tr>
				<td><label>Your Name : </label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><label>Date : </label></td>
				<td><form:input path="date" /></td>
			</tr>
			<tr>
				<td><label>Country : </label></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td><label>State : </label></td>
				<td><form:input path="state" /></td>
			</tr>
			
			
			<%-- <!-- Country And State AJAX  -->
              <tr>
				<td>Select Country</td>
				<td><select path="country" name="country" id="select1" onchange="doAjaxGet()">
						<option value="0">country</option>
						<c:forEach items="${model}" var="oneModel">
							<option value="${oneModel.countryName}">${oneModel.countryName}</option>
							
						</c:forEach>
				    </select>
				<!-- </td><td><a href="vieww">viewcountrylist</a></td> -->
			    </tr>
			
			<tr>
				<td>Select State</td>
				<td><select id="select2" path="state" name="state">
						<option value="0">State</option>
				</select></td>
			</tr>
		<!--ENd AJAX  -->	 --%>
			
			<tr>
				<td><label>Password : </label></td>
				<td><form:input path="password" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form:form>



</body>
</html>
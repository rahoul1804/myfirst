<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>Registartin Page</h1>



<form method="post" action="SignUpToController">
<table>
<tr>
<td>Id : </td>
<td><input name="id"  placeholder="Auto-Genarator"/></td>
</tr>
<tr>
<td>Age : </td>
<td> <input type="text" name="age" /></td>
</tr>
<tr>
<td>Country :</td>
<td> <input type="text" name="country" /></td>
</tr>
<tr>
<td>Name :</td>
<td><input type="text" name="name" /></td>
</tr>
<tr>
<td>Password :</td>
<td><input type="text" name="password" /></td>
</tr>
<tr>
<td>
	<input type="submit" value="Save" />
	<input type="reset" /></td>
	</tr>
	</table>
</form> 


</body>
</html>
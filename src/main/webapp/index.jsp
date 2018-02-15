<html>
<body>

<h2>Hello World!</h2>

<%-- <%         // New location to be redirected     
		String site = new String("http://localhost:8080/jpaCrudProject/regPage.jsp");    
		response.setStatus(response.SC_MOVED_TEMPORARILY);  
		response.setHeader("Location", site);       %>
 --%>
 
 
    <!-- login page -->
    ${error}
 ${key}
 <h1>enter your login details</h1>
 <form method="post" action="loginToController">
<table>
<tr>
<td>name : </td>
<td><input name="name"  placeholder="enter id"/></td>
</tr>
<tr>
<td>password : </td>
<td> <input type="text" name="password" placeholder="enter password" /></td>

<td><input type="submit" value="LogIn"></td></tr>
</table>
</form>

<a href="downloadExcelSheet">Download to Excel</a>
<!-- <input type="button" value="reg" onclick="window.location.href='regPage.jsp'" /> -->
   <input type="button" value="reg" onclick="window.location.href='regPageRequst'" />

<input type="button" value="FullView" onclick="window.location.href='viewToController'" />

</body>
</html>

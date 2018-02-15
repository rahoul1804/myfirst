<html>
<body>

<h2>Hello World!</h2>

<%-- <%         // New location to be redirected     
		String site = new String("http://localhost:8080/jpaCrudProject/regPage.jsp");    
		response.setStatus(response.SC_MOVED_TEMPORARILY);  
		response.setHeader("Location", site);       %>
 --%>
 
 
    <!-- login page -->
 
 <h1>enter your login details</h1>
 <form method="post" action="SignUpToController">
<table>
<tr>
<td>name : </td>
<td><input name="name"  placeholder="enter id"/></td>
</tr>
<tr>
<td>password : </td>
<td> <input type="text" name="paswd" placeholder="enter password" /></td>
</tr>
</table>
</form>


<input type="button" value="reg" onclick="window.location.href='regPage.jsp'" />

<input type="button" value="View" onclick="window.location.href='viewToController'" />

</body>
</html>

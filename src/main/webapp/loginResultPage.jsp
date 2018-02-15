<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <table cellpadding="2" border="2px"  bordercolor="red" width="570px" style="border-collapse: collapse; background-color: cyan;">
    <thead>
      <tr> <h2>Employee Details :</h2></tr><tr>
      <tr><th>  ID </th><td>       ${model.id}</td></tr>
      <tr><th>  NAME</th><td>	   ${model.name}</td></tr>
      <tr><th>  PASSWORD</th><td>  ${model.password}</td>	</tr>
      <tr><th>  AGE	 </th><td>     ${model.age}</td>	</tr>
      <tr><th>  COUNTRY	</th><td>  ${model.country}</td></tr>
       <tr><th>  STATE	</th><td>  ${model.state}</td></tr>
      </tr>
    </thead>
    </table> 
</body>
</html>
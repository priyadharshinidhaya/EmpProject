<%@ page language="java" import= " com.emp.bean.* , java.util.*  " contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<table border ="5" cellspacing="5" cellpadding="5">
<%

List<Employee> list = (List<Employee>) request.getAttribute("emplist");

out.println("<h1><b>The employees above the given age are : </b></h1>"+"<br><br>");

out.println("<tr><td> <h2><em> Name </em></h2> </td> <td> <h2><em> Address </em> </td></tr> <h2>");

for(Employee emp : list){
	out.println("<tr><td>"+emp.getName()+"</td>"+"<td>"+emp.getAddress()+"</td></tr>");
}

%>
</table>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER SUCCESS</title>
</head>
<body>
<marquee width="40%">
     <h1>REGISTER SUCCESSFUL</h1><br><br>
     </marquee>

<%

PrintWriter pw=response.getWriter();
session=request.getSession();
pw.println("Master."+" "+session.getAttribute("fname")+" "+session.getAttribute("mname")+" "+session.getAttribute("lname")
+" "+"is successfully enrolled to"+" "+"class"+" "+session.getAttribute("standard")+" "+"and Roll. no is"+" "+"SID"+session.getAttribute("year")+session.getAttribute("rollno"));

%>

</body>
</html>
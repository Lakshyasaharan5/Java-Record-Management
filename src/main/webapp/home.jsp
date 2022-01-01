<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="navbar.jsp" %>
<% if(session.getAttribute("currentUser")==null){ %>
<% response.sendRedirect("login.jsp");}
else{%>
<h1>HOME PAGE</h1>
<% 

out.println(session.getAttribute("currentUser")); %>
<%} %>
</body>
</html>
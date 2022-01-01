<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.studentrecord.helper.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Login/SignUp</title>
</head>
<body>
<%
Connection con = ConnectionProvider.getConnection(); 
out.println(con);
%>

<h1>WELCOME SIR !</h1>

<a href="login.jsp">LOGIN</a>
<a href="signup.jsp">SIGNUP</a>
	
</body>
</html>
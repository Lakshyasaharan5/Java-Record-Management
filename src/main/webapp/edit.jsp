<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.studentrecord.entities.*" %>
<%@ page import="com.studentrecord.dao.*" %>
<%@ page import="com.studentrecord.helper.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>

<% int userID =  Integer.parseInt(request.getParameter("userID"));
out.println(userID);
%>

<%
UserDao ud = new UserDao(ConnectionProvider.getConnection());
Users u = ud.getUserDetailsByID(userID);
out.println(u.getUserName());
%>

<form action="edit" method="post">
	<input type="hidden" value="<%= u.getUserId() %>" name="id">
	<br>
	<label>Name: <input type="text" value="<%= u.getUserName() %>" name="name">
	</label><br>
	<label>Phone: <input type="text" value="<%= u.getUserPhone() %>" name="phone">
	</label><br>
	<label>Email: <input type="text" value="<%= u.getUserEmail() %>" name="email">
	</label><br>
	<label>Password: <input type="text" value="<%= u.getUserPass() %>" name="password">
	</label><br>
	<button type="submit">EDIT</button>
</form>

</body>
</html>
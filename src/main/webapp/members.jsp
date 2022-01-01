<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.studentrecord.helper.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
  border:1px solid black;
}
</style>
</head>
<body>

<%@ include file="navbar.jsp" %>

<% if(session.getAttribute("currentUser")==null){ %>
<% response.sendRedirect("login.jsp");}
else{%>
	
<% Connection con = ConnectionProvider.getConnection(); 
   String query = "select * from memberlist";
   Statement stmt = con.createStatement();
   ResultSet rs = stmt.executeQuery(query);
%>

<h1>MEMBERS LIST</h1>
<% 
out.println(session.getAttribute("currentUser")); %>

<table>
  <tr>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th colspan=2>Action</th>
  </tr>
  <% while(rs.next()){ %>
  <tr>
    <td><%= rs.getString("memberName") %></td>
    <td><%= rs.getString("memberPhone") %></td>
    <td><%= rs.getString("memberEmail") %></td>
    <td><a href="edit.jsp?userID=<%= rs.getInt("memberID")%>">Edit</a></td>
    <td><a href="delete?userID=<%= rs.getInt("memberID")%>">Delete</a></td>
  </tr>
  <%} %>
</table>

<%} %>

</body>
</html>
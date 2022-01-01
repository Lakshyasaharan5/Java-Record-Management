package com.studentrecord.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentrecord.dao.UserDao;
import com.studentrecord.entities.Users;
import com.studentrecord.helper.ConnectionProvider;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteServlet extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter out = response.getWriter();
		
		
		int userID = Integer.parseInt(request.getParameter("userID"));
		
		UserDao ud = new UserDao(ConnectionProvider.getConnection());
		ud.deleteUser(userID);
		
		response.sendRedirect("members.jsp");
		
		response.setContentType("text/html");
}
}

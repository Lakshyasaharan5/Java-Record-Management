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

public class EditServlet extends HttpServlet{

public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter out = response.getWriter();
		
		
		int userID = Integer.parseInt(request.getParameter("id"));
		
		String userName = request.getParameter("name");
		String userPhone = request.getParameter("phone");
		String userEmail = request.getParameter("email");
		String userPass = request.getParameter("password");
		
		Users u = new Users(userID, userName, userPhone, userEmail, userPass);
		
		UserDao ud = new UserDao(ConnectionProvider.getConnection());
		ud.editUser(u);
		
		response.sendRedirect("members.jsp");
		
		response.setContentType("text/html");
}
}

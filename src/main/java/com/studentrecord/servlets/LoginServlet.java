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

public class LoginServlet extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		UserDao ud = new UserDao(ConnectionProvider.getConnection());
		Users u = ud.getUserDetails(email, password);
		
		if(u==null) {
			
			response.sendRedirect("index.jsp");
			out.println("Sorry not found!");
		}
		else {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("currentUser", u.getUserName());
			
			response.sendRedirect("home.jsp");
			out.println("LOGIN SUCCESSFULLY");
			out.println(email);
			out.println(password);
			out.println(u.getUserPhone());
		}
		
		out.println(email);
		out.println(password);
		
	}
}

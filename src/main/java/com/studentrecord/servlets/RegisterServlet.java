package com.studentrecord.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentrecord.dao.UserDao;
import com.studentrecord.entities.Users;
import com.studentrecord.helper.ConnectionProvider;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		Users u = new Users(name, phone, email, password);
		UserDao ud = new UserDao(ConnectionProvider.getConnection());
		
		ud.saveUser(u);
		
		response.sendRedirect("login.jsp");
		
//		out.println(name);
//		out.println(phone);
//		out.println(email);
//		out.println(password);
		
	}
}

package com.poll.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.poll.dao.UserDAO;
import com.poll.models.User;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO dao = new UserDAO();
       
    public UserController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action.equals("register")) {
			register(request, response);
		} else if (action.equals("login")) {
			login(request, response);
		}
		
		
		
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
				String name = request.getParameter("name");
				String email = request.getParameter("name");
				String password = request.getParameter("name");
				boolean isAdmin = request.getParameter("isAdmin").equalsIgnoreCase("user") ? false : true;
				String address = request.getParameter("address");
				
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setAdmin(isAdmin);
				user.setAddress(address);
				
				dao.save(user);
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<b>User Created!!</b>");
				out.print("<br/><a href='/candpapp'>Home</a>'");
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		String email = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = dao.findUserByEmail(email, password);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(user.getName());
		out.print("<br/><a href='/candpapp'>Home</a>'");
	}
	

}

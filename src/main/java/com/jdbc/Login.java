package com.jdbc;

//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//
//@WebServlet("/add")
//public class Login extends HttpServlet{
//	
//	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
//	{
//		  int i = Integer.parseInt(req.getParameter("num1")); 
//		  int j = Integer.parseInt(req.getParameter("num2"));
//		 
//		
//		int k = i + j;
//		
//		
//		req.setAttribute("k",k);
//		
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
//		
//		PrintWriter out = res.getWriter();
//		out.println("Value is now " + k);
//	}
//
//}




import java.io.IOException;

import java.io.PrintWriter;

import com.jdbc.dao.LoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String uname = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		
		LoginDao dao = new LoginDao();
		
		if(dao.check(uname,pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("hello.jsp");
		}
		else
		{
			response.sendRedirect("LoginJDBC.jsp");
		}
	}

}

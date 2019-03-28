package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet(loadOnStartup=1, name="helloWorld", urlPatterns= {"/hello","/helloWorld","/login"})
public class HelloWordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public HelloWordController() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("Hello world");
	
	out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		if(username.equals("root") && password.equals("root")) {
			out.println("<h2>Login successful. Welcome"+username+"</h2>");
		}
		else 
			out.println("<h1>login failed </h1>");
	}

}

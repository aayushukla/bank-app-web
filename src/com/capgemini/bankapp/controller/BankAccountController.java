package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BankAccountService bankService;
	public BankAccountController() {
		bankService= new BankAccountServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String path= request.getServletPath();
		System.out.println(path);
		
		if(path.contentEquals("/addNewBankAccount.do")) {
			String accountHolderName= request.getParameter("customerName");
			String accountType=  request.getParameter("account_type");
			double balance= Double.parseDouble(request.getParameter("balance"));
			
			BankAccount account = new BankAccount(accountHolderName, accountType, balance);
			if(bankService.addNewBankAccount(account))
			{
				out.println("<h2> Bankaccount is created succesfully</h2>");
				out.close();
			}
		
		}
		
	
		
		
	}

}

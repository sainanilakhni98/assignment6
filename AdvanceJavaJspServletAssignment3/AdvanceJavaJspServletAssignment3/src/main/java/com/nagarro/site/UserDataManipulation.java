package com.nagarro.site;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.site.model.User;
import com.nagarro.site.user.SetUserDetails;

/**
 * Servlet implementation class GetUserController
 */
public class UserDataManipulation extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aid=request.getParameter("aid");
		String password=request.getParameter("pass");		
		SetUserDetails dao=new SetUserDetails();
		
		try {
			boolean isuser=SetUserDetails.getUser(aid,password);
			String destpage="index.jsp";
			
			if(isuser == true)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username",aid);
				destpage="showUser.jsp";
			}else {
				String message="Invlid email/password";
				request.setAttribute("message",message);
			}
			RequestDispatcher dispatcher=request.getRequestDispatcher(destpage);
			dispatcher.forward(request, response);
		}
		catch(Exception e){
			System.out.println("fail");
			throw new ServletException(e);
		}
		
	}

}

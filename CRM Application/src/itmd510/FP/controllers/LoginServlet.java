package itmd510.FP.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import itmd510.FP.dao.LoginDAO;


public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String username=request.getParameter("username");  
        String password=request.getParameter("userpass"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", username);
        

        try {
        	Integer IsAdmin=LoginDAO.IsAdmin(username, password);
        
			if(LoginDAO.validate(username, password) && IsAdmin==1){  
				session.setAttribute("role", true);
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  
			    rd.forward(request,response);  
			}
			else if(LoginDAO.validate(username, password) && IsAdmin==0){  
				session.setAttribute("role", false);
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
			    rd.forward(request,response);  
			}  
			else{  
			    out.print("<p style=\"color:red\">Invalid username or password!!!</p>");  
			    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			    rd.include(request,response);  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
        

        out.close();  
    }  
}
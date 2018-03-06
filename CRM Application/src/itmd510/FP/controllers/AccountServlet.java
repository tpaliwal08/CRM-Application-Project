package itmd510.FP.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itmd510.FP.dao.AccountsDAO;
import itmd510.FP.models.Accounts;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/accounts.jsp";
    private static String LIST_account = "/listaccount.jsp";
    private AccountsDAO dao;
    
    public AccountServlet() throws SQLException {
        super();
        dao = new AccountsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        try{
            if (action.equalsIgnoreCase("delete")){
                String accId = request.getParameter("AccId");
                dao.deleteAccount(accId);
                forward = LIST_account;
                request.setAttribute("accounts", dao.getAllAccounts());    
            } else if (action.equalsIgnoreCase("edit")){
                forward = INSERT_OR_EDIT;
                String accId = request.getParameter("AccId");
                Accounts account = dao.getAccountsById(accId);
                request.setAttribute("account", account);
            } else if (action.equalsIgnoreCase("listaccount")){
                forward = LIST_account;
                request.setAttribute("accounts", dao.getAllAccounts());
            } else {
                forward = INSERT_OR_EDIT;
            }
     
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
         } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 
    	try{
    	Accounts account = new Accounts();
    	account.setOppId(Integer.parseInt(request.getParameter("OppId")));
    	//account.setAccId(Integer.parseInt(request.getParameter("AccId")));
        account.setAccName(request.getParameter("AccName"));
        account.setAccNo(request.getParameter("AccNo"));
        account.setAccPhone(Integer.parseInt(request.getParameter("AccPhone")));
        account.setAccAddress(request.getParameter("AccAddress"));
        account.setAccEmail(request.getParameter("AccEmail"));
    	account.setAccFax(Integer.parseInt(request.getParameter("AccFax")));
    	
    	String accId = request.getParameter("AccName");
    	account.setAccName(accId);
        dao.checkAccount(account);

        
        RequestDispatcher view = request.getRequestDispatcher(LIST_account);
        request.setAttribute("accounts", dao.getAllAccounts());
        view.forward(request, response);
    	
    	} catch (Exception e) {
        e.printStackTrace();
    }
    }
}

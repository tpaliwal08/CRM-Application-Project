package itmd510.FP.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itmd510.FP.dao.OpportunityDAO;
import itmd510.FP.models.Opportunity;

/**
 * Servlet implementation class OpportunityServlet
 */
@WebServlet("/OpportunityServlet")
public class OpportunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/opportunity.jsp";
    private static String LIST_opportunity = "/listopportunity.jsp";
	private OpportunityDAO dao;
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public OpportunityServlet() throws SQLException {
        super();
        dao= new OpportunityDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String forward="";
	        String action = request.getParameter("action");
	       try{ 
	        if (action.equalsIgnoreCase("delete")){
	            String oppId = request.getParameter("OppId");
	            dao.deleteOpportunity(oppId);
	            forward = LIST_opportunity;
	            request.setAttribute("opportunities",dao.getAllOpportunities()); 
	       }
	        else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            String oppId = request.getParameter("OppId");
	            Opportunity opportunity = dao.getOpportunityById(oppId);
	            request.setAttribute("opportunity", opportunity);
	        }
	        else if (action.equalsIgnoreCase("listOpportunity")){
	            forward = LIST_opportunity;
	            request.setAttribute("opportunities", dao.getAllOpportunities());
	        }
	         else {
                forward = INSERT_OR_EDIT;
    }
	        //request.setAttribute("menu", dao.getLeadMenu());
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }  
		catch (Exception e) {
        e.printStackTrace();
    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		Opportunity opportunity = new Opportunity();
		 //opportunity.setOppId(Integer.parseInt(request.getParameter("OpportunityId")));
		 opportunity.setLeadId(Integer.parseInt(request.getParameter("leadId")));
		 //opportunity.setOppId(Integer.parseInt(request.getParameter("OppId")));   		 
		 opportunity.setOppDesc(request.getParameter("OppDesc"));
		 opportunity.setOppPipelinePhase(request.getParameter("OppPipelinePhase"));
		 opportunity.setOppStatus(request.getParameter("OppStatus"));
		 opportunity.setOppEstRevenue(Double.parseDouble(request.getParameter("OppEstRevenue")));
		 opportunity.setOppEstCloseDate((request.getParameter("OppEstCloseDate")));
		
		 String oppId = request.getParameter("OppDesc");
     	opportunity.setOppDesc(oppId);
	        dao.checkOpportunity(opportunity);
	        RequestDispatcher view = request.getRequestDispatcher(LIST_opportunity);
	        request.setAttribute("leads", dao.getAllOpportunities());
	        view.forward(request, response);
	}
	catch (Exception e) {
        e.printStackTrace();
    }
	}
}

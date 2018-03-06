package itmd510.FP.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itmd510.FP.dao.LeadDAO;
import itmd510.FP.models.Lead;

/**
 * Servlet implementation class LeadServlet
 */
@WebServlet("/LeadServlet")
public class LeadServlet extends HttpServlet {
	   private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/lead.jsp";
	    private static String LIST_lead = "/listlead.jsp";
	    private LeadDAO dao;
	 
	    public LeadServlet() throws SQLException {
	        super();
	        dao = new LeadDAO();
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");
	 try{
	        if (action.equalsIgnoreCase("delete")){
	            String leadId = request.getParameter("leadId");
	            dao.deleteLead(leadId);
	            forward = LIST_lead;
	            request.setAttribute("leads", dao.getAllLeads());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            String leadId = request.getParameter("leadId");
	            Lead lead = dao.getLeadById(leadId);
	            request.setAttribute("lead", lead);
	            
	        } else if (action.equalsIgnoreCase("listlead")){
	            forward = LIST_lead;
	            request.setAttribute("leads", dao.getAllLeads());
	        } else {
	        	request.setAttribute("leads", dao.getAllLeads());
	        	forward = INSERT_OR_EDIT;
	        }
	 
	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);

	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
}
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	        try{
	    	Lead lead = new Lead();
	        lead.setFirstname(request.getParameter("LeadFirstName"));
        	lead.setLastname(request.getParameter("LeadLastName"));
        	lead.setJobitle(request.getParameter("LeadJobTitle"));
        	lead.setCompanyname(request.getParameter("LeadCompanyName"));
        	lead.setEmail(request.getParameter("LeadEmailId"));
        	lead.setPhone(Integer.parseInt(request.getParameter("LeadPhoneNo")));
        	lead.setFax(Integer.parseInt(request.getParameter("LeadFax")));
        	lead.setStatus(request.getParameter("LeadStatus"));
        	lead.setAddress(request.getParameter("LeadAddress"));
        	lead.setState(request.getParameter("LeadState"));
        	lead.setCountry(request.getParameter("LeadCountry"));
        	lead.setZip(request.getParameter("LeadZip"));
	        //lead.setLeadid(Integer.parseInt(request.getParameter("LeadId")));
        	String leadid = request.getParameter("LeadFirstName");
        	lead.setFirstname(leadid);
	        dao.checkLead(lead);
    
	    	RequestDispatcher view = request.getRequestDispatcher(LIST_lead);
	        request.setAttribute("leads", dao.getAllLeads());
	        view.forward(request, response);
	        }
	    
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
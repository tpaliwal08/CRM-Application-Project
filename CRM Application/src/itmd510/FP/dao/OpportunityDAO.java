package itmd510.FP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itmd510.FP.models.Lead;
import itmd510.FP.models.Opportunity;
import itmd510.FP.util.Connector;

public class OpportunityDAO extends LeadDAO{
	private Connection connection;
	 
    public OpportunityDAO() throws SQLException {
    	Connector con = new Connector();
        connection = con.getDBConnect();
    }
 
	public void checkOpportunity(Opportunity opportunity) {
		
		 try {
	            PreparedStatement ps = connection.prepareStatement("select OppDesc from tbl_Opportunity where OppDesc = ?");
	            ps.setString(1, opportunity.getOppDesc());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) // found
	            {
	                updateOpportunity(opportunity);
	            } else {
	                addOpportunity(opportunity);
	            }
	        } catch (Exception ex) {
	            System.out.println("Error in check() -->" + ex.getMessage());
	        } 
	}

	public List<Lead> getLeadMenu(){
	        List<Lead> leadsmenu = new ArrayList<Lead>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select LeadId,LeadFirstName from tbl_Leads");
	            while (rs.next()) {
	                Lead lead = new Lead();
	                lead.setLeadid(rs.getInt("LeadId"));
	                lead.setFirstname(rs.getString("LeadFirstName"));
	            	//lead.setLastname(rs.getString("LeadLastName"));       	
	                leadsmenu.add(lead);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	        return leadsmenu;
	    }
	
	
	public void addOpportunity(Opportunity opportunity) {
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tbl_Opportunity(LeadId,OppDesc, OppEstRevenue,  OppPipelinePhase ,OppEstCloseDate,OppStatus) values (?,?, ?, ?, ?,? )");
            // Parameters start with 10
            preparedStatement.setInt(1, opportunity.getLeadId());
            preparedStatement.setString(2, opportunity.getOppDesc());
            preparedStatement.setDouble(3, opportunity.getOppEstRevenue());
            preparedStatement.setString(4, opportunity.getOppPipelinePhase());            
            preparedStatement.setString(5, opportunity.getOppEstCloseDate());
            preparedStatement.setString(6, opportunity.getOppStatus());
            
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


	public void deleteOpportunity(String OppId) {
		
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from tbl_Opportunity where OppId=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, OppId);
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	public List<Opportunity> getAllOpportunities() {
		
		List<Opportunity> opportunities = new ArrayList<Opportunity>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tbl_Opportunity");
            while (rs.next()) {
            	Opportunity opportunity = new Opportunity();
            	opportunity.setLeadId(rs.getInt("leadid"));
            	opportunity.setOppId(rs.getInt("OppId"));
                opportunity.setOppDesc(rs.getString("OppDesc"));
                opportunity.setOppEstRevenue(rs.getDouble("OppEstRevenue"));
                opportunity.setOppEstCloseDate(rs.getString("OppEstCloseDate"));
                opportunity.setOppPipelinePhase(rs.getString("OppPipelinePhase"));
                opportunity.setOppStatus(rs.getString("OppStatus"));
            	
                opportunities.add(opportunity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return opportunities;
	}

	public Opportunity getOpportunityById(String oppId) {
		
		Opportunity opp = new Opportunity();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_Opportunity where OppId=?");
            preparedStatement.setString(1, oppId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
            	opp.setOppId(rs.getInt("OppId"));
            	opp.setOppDesc(rs.getString("OppDesc"));
                opp.setOppEstRevenue(rs.getDouble("OppEstRevenue"));
                opp.setOppEstCloseDate(rs.getString("OppEstCloseDate"));
                opp.setOppPipelinePhase(rs.getString("OppPipelinePhase"));
                opp.setOppStatus(rs.getString("OppStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return opp;
	}

	private void updateOpportunity(Opportunity opportunity) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update tbl_Opportunity set LeadId=?, OppEstRevenue=?, OppPipelinePhase=?,OppEstCloseDate=?,OppStatus=?"
	                    + "where OppDesc=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, opportunity.getLeadId());
	            preparedStatement.setDouble(2, opportunity.getOppEstRevenue());
	            preparedStatement.setString(3, opportunity.getOppPipelinePhase());            
	            preparedStatement.setString(4, opportunity.getOppEstCloseDate());
	            preparedStatement.setString(5, opportunity.getOppStatus());
	            preparedStatement.setString(6, opportunity.getOppDesc());
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	

	

}

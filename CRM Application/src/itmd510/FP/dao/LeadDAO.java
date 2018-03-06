package itmd510.FP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itmd510.FP.models.Lead;
import itmd510.FP.util.Connector;

public class LeadDAO {
	private Connection connection;
	 
    public LeadDAO() throws SQLException {
    	Connector con = new Connector();
        connection = con.getDBConnect();
    }
 
    public void checkLead(Lead lead) {
        try {
            PreparedStatement ps = connection.prepareStatement("select LeadFirstName from tbl_Leads where LeadFirstName = ?");
            ps.setString(1, lead.getFirstname());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateLead(lead);
            } else {
                addLead(lead);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public void addLead(Lead lead) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tbl_Leads(LeadFirstName, LeadLastName, LeadJobTitle, LeadCompanyName,LeadEmailId,LeadPhoneNo,LeadFax,LeadStatus,LeadAddress,LeadState,LeadCountry,LeadZip) values (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, lead.getFirstname());
            preparedStatement.setString(2, lead.getLastname());
            preparedStatement.setString(3, lead.getJobitle());            
            preparedStatement.setString(4, lead.getCompanyname());
            preparedStatement.setString(5, lead.getEmail());
            preparedStatement.setInt(6, lead.getPhone());
            preparedStatement.setInt(7, lead.getFax());
            preparedStatement.setString(8, lead.getStatus());
            preparedStatement.setString(9, lead.getAddress());
            preparedStatement.setString(10, lead.getState());
            preparedStatement.setString(11,lead.getCountry());
            preparedStatement.setString(12, lead.getZip());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void deleteLead(String leadId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tbl_Leads where LeadId=?");
            // Parameters start with 1
            preparedStatement.setString(1, leadId);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updateLead(Lead lead) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update tbl_Leads set  LeadJobTitle=?,LeadCompanyName=?,LeadEmailId=?,LeadPhoneNo=?,LeadFax=?,LeadStatus=?,LeadAddress=?,LeadState=?,LeadCountry=?,LeadZip=?"
                    + "where LeadFirstName=? and LeadLastName=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, lead.getJobitle());            
            preparedStatement.setString(2, lead.getCompanyname());
            preparedStatement.setString(3, lead.getEmail());
            preparedStatement.setInt(4, lead.getPhone());
            preparedStatement.setInt(5, lead.getFax());
            preparedStatement.setString(6, lead.getStatus());
            preparedStatement.setString(7, lead.getAddress());
            preparedStatement.setString(8, lead.getState());
            preparedStatement.setString(9,lead.getCountry());
            preparedStatement.setString(10, lead.getZip());
            preparedStatement.setString(11, lead.getFirstname());
            preparedStatement.setString(12, lead.getLastname());
            //preparedStatement.setInt(13, lead.getLeadid());
            //preparedStatement.setInt(13, lead.leadId);
            //spreparedStatement.setString(13, leadId);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public List<Lead> getAllLeads() {
        List<Lead> leads = new ArrayList<Lead>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tbl_Leads");
            while (rs.next()) {
                Lead lead = new Lead();
                lead.setLeadid(rs.getInt("LeadId"));
                lead.setFirstname(rs.getString("LeadFirstName"));
            	lead.setLastname(rs.getString("LeadLastName"));
            	lead.setJobitle(rs.getString("LeadJobTitle"));
            	lead.setCompanyname(rs.getString("LeadCompanyName"));
            	lead.setEmail(rs.getString("LeadEmailId"));
            	lead.setPhone(rs.getInt("LeadPhoneNo"));
            	lead.setFax(rs.getInt("LeadFax"));
            	lead.setStatus(rs.getString("LeadStatus"));
            	lead.setAddress(rs.getString("LeadAddress"));
            	lead.setState(rs.getString("LeadState"));
            	lead.setCountry(rs.getString("LeadCountry"));
            	lead.setZip(rs.getString("LeadZip"));
                leads.add(lead);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return leads;
    }
 
    public Lead getLeadById(String leadId) {
        Lead lead = new Lead();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_Leads where LeadId=?");
            preparedStatement.setString(1, leadId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
            	lead.setLeadid(rs.getInt("LeadId"));
            	lead.setFirstname(rs.getString("LeadFirstName"));
            	lead.setLastname(rs.getString("LeadLastName"));
            	lead.setJobitle(rs.getString("LeadJobTitle"));
            	lead.setCompanyname(rs.getString("LeadCompanyName"));
            	lead.setEmail(rs.getString("LeadEmailId"));
            	lead.setPhone(rs.getInt("LeadPhoneNo"));
            	lead.setFax(rs.getInt("LeadFax"));
            	lead.setStatus(rs.getString("LeadStatus"));
            	lead.setAddress(rs.getString("LeadAddress"));
            	lead.setState(rs.getString("LeadState"));
            	lead.setCountry(rs.getString("LeadCountry"));
            	lead.setZip(rs.getString("LeadZip"));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return lead;
    }

}

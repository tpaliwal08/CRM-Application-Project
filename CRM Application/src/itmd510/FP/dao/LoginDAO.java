	package itmd510.FP.dao;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import itmd510.FP.util.Connector;

	public class LoginDAO {
		private static Connection connection;
	    public static boolean validate(String name, String pass) throws SQLException { 
	    	
	    	boolean status = false;
	    	Connector con = new Connector();
	        connection = con.getDBConnect();
	        
	        try {
	        	PreparedStatement ps = connection.prepareStatement("select * from tbl_Users where UsrName=? and UsrPassword=?");
	            ps.setString(1, name);
	            ps.setString(2, pass);
	            ResultSet rs = ps.executeQuery();
	            
	            status = rs.next();

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return status;
	    }
	    
	    public static int IsAdmin(String name, String pass) throws SQLException { 
	    	
	    	int IsAdmin=0;
	    	Connector con = new Connector();
	        connection = con.getDBConnect();
	        try {
	        	PreparedStatement ps = connection.prepareStatement("select IsAdmin from tbl_Users where UsrName=? and UsrPassword=?");
	            ps.setString(1, name);
	            ps.setString(2, pass);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next ())
	            {
	            IsAdmin = rs.getInt("IsAdmin");
	            }
	            rs.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return IsAdmin;
	    }
	}


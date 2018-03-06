package itmd510.FP.util;

import java.sql.*;


/** This Class Connector connects to the MySQL database using the JDBC driver
 * This Class is under the package models and return the connection object.
 * @author   : Shreya Gandhi
 * @since    : 2016-11-09
 * @filename : Connector.java
 * @labname  : Final Project
 */

public class Connector{
	   // JDBC driver name and database URL
	   static final String JDBCdriver = "com.mysql.jdbc.Driver";  
	   static final String DBURL = "jdbc:mysql://www.papademas.net:3306/fp";

	   //  Database credentials
	   static final String UserName = "dbfp";
	   static final String Password = "510";


	public Connection getDBConnect() throws SQLException
	{
		   Connection conn = null;
		   
		   try{
		      //Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //Open a connection
		      conn = DriverManager.getConnection(DBURL, UserName, Password);

		      }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		      return conn;
	  
	}
}


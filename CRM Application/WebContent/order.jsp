<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<h2>Add/Edit Orders</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Order</title>
</head>
<body>
<%

Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://www.papademas.net:3306/fp?user=dbfp&password=510");

       Statement statement = connection.createStatement() ;
       resultset =statement.executeQuery("select AccId,AccName from tbl_Accounts;") ;
%>

	<form method="POST" action='OrderServlet' name="frmAddOrder" onSubmit="return validateForm()"s>
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
           Account Name : <select name="AccId" id="AccId"><%  while(resultset.next()){ %>
            	  	 <option value="<%=resultset.getInt(1)%>"><%=resultset.getString(2)%></option>
        			<% } %>
        			</select>
        			<br />

          				<input type="hidden" name="OrdId"
                               value="<c:out value="${order.ordId}" />" /> <br />

            
            Order Description : <input type="text" name="OrdDesc" required="required"
                               value="<c:out value="${order.ordDesc}" />" /> <br />
            
           Order Type :  <SELECT name = "OrdType" id="OrdType" 
                    value="<c:out value ='${order.ordType}'/>" >
							<OPTION value="" ></OPTION>
							<OPTION value="Normal" >Active</OPTION> 
							<OPTION value="Bulk" >Inactive</OPTION>
							</SELECT>
					<br/>
            
            Order Amount  : <input type="text" name="OrdAmount"
                               value="<c:out value="${order.ordAmount}" />" /> <br />
            
            Order Quantity : <input type="text" name="OrdQuantity"
                               value="<c:out value="${order.ordQuantity}" />" /> <br />
            
            Order Date (YYYY-MM-DD)*: <input type="date" name="OrdDate" required="required"
                               value="<c:out value="${order.ordDate}" />" /> <br />
                        
            <input style="background:#000033 font-color:white" type="submit" value="Submit" />
        </form>

</body>
</html>
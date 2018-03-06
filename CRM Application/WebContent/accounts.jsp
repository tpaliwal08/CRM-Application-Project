<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<h2>Add/Edit Accounts</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Account</title>
        <script>
         
     
        function validateForm()
		{
        	function IsNumber(inputtxt)  
            {  
               var numbers = /^[-+]?[0-9]+$/;  
               if(inputtxt.value.match(numbers))  
               {  
            	   inputtxt.value.focus();  
               return false;  
               }  
               else  
               {  
            	   inputtxt.value.focus();  
               return true;  
               }  
            }
		
        	 var numbers=/^[0-9]+$/;
        	
		   if IsNumber(document.frmAddAccount.AccPhone)  
		      {  
		        alert("Enter Valid Phone Number");  
		        document.frmAddAccount.AccPhone.focus();  
		        return false;  
		        }  
		  
		    else 
		    	return true;
		    
		    
		}
</script>
</head>
<body>
<%
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://www.papademas.net:3306/fp?user=dbfp&password=510");

       Statement statement = connection.createStatement() ;
       resultset =statement.executeQuery("select distinct OppId,OppDesc from tbl_Opportunity") ;
%>

	
		<form method="POST" action='AccountServlet' name="frmAddAccount" onSubmit="return validateForm()">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
           
           				<input type="hidden" name="AccId"
                               value="<c:out value="${account.accId}" />" readonly="readonly"/> <br /> 
           
            
            Opportunity Description: <select name="OppId" id="OppId"><%  while(resultset.next()){ %>
            	  <option value="<%=resultset.getInt(1)%>"><%=resultset.getString(2)%></option>
        			<% } %>
        			</select>
        	<br />

            <% if (action.equalsIgnoreCase("edit")) {%>
            Account Name* : <input type="text" name="AccName" required="required"
                               value="<c:out value="${account.accName}" />" readonly="readonly"/><br /> 
            <%} else {%>
            Account Name : <input type="text" name="AccName" required="required"
                               value="<c:out value="${account.accName}" />" /> <br />
            <%}%>
           
            
           Phone : <input type="text" name="AccPhone" required="required"
                               value="<c:out value="${account.accPhone}" />" /> <br />
            
           Fax : <input type="text" name="AccFax"
                               value="<c:out value="${account.accFax}" />" /> <br />
            
            <% if (action.equalsIgnoreCase("edit")) {%>
           Account Number* : <input type="text" name="AccNo" required="required"
                               value="<c:out value="${account.accNo}" />" readonly="readonly"/> <br /> 
            <%} else {%>
           Account Number : <input type="text" name="AccNo"
                               value="<c:out value="${account.accNo}" />" /> <br />
            <%}%>
            
           Email Id : <input type="text" name="AccEmail"
                               value="<c:out value="${account.accEmail}" />" /> <br />
            
           Address : <input type="text" name="AccAddress"
                               value="<c:out value="${account.accAddress}" />" /> <br />
            
            <input style="background:#000033 font-color:white" type="submit" value="Submit" />
        </form>
</body>
</html>
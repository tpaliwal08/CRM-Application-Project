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
<h2>Add/Edit Opportunity</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Opportunity</title>
<script>
        function validateForm()
		{
        	 
		    if (document.frmAddOpportunity.leadId.value=="")
		    {
		      alert("Lead Name cannot be left blank");
		      document.frmAddOpportunity.leadId.focus();
		      return false;
		    }
		  
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

       resultset =statement.executeQuery("select LeadId,LeadFirstName from tbl_Leads") ;
%>


	<form method="POST" action='OpportunityServlet' name="frmAddOpportunity" onSubmit="return validateForm()">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            
             <input type="hidden" name="OppId"
                               value="<c:out value="${opportunity.oppId}" />"/> <br />
            
            Lead Name*: <select name="leadId" id="leadId"><%  while(resultset.next()){ %>
            	  
            	  <option value="<%=resultset.getInt(1)%>"><%=resultset.getString(2)%></option>
        			<% } %>
        			</select>
        	<br />
                      
            <% if (action.equalsIgnoreCase("edit")) {%>
            Description* : <input type="text" name="OppDesc"  required="required"
                               value="<c:out value="${opportunity.oppDesc}" />" readonly="readonly"/> <br /> 
            <%} else {%>
            Description* : <input type="text" name="OppDesc"  required="required"
                               value="<c:out value="${opportunity.oppDesc}" />" /> <br />
            <%}%>
             
            
            Pipeline Phase : <input type="text" name="OppPipelinePhase"
                               value="<c:out value="${opportunity.oppPipelinePhase}" />" /> <br />
       
           
            Estimated Revenue : <input type="text" name="OppEstRevenue"  required="required"
                               value="<c:out value="${opportunity.oppEstRevenue}" />" /> <br />
           
           
            Estimated Close Date * : <input type="date"  name="OppEstCloseDate" required="required"
                               value="<c:out value="${opportunity.oppEstCloseDate}" />" /> <br />
           
            Status : <SELECT name = "OppStatus" id="OppStatus" 
                    value="<c:out value ='${opportunity.oppStatus}'/>" >
							<OPTION value="" ></OPTION>
							<OPTION value="Active" >Active</OPTION> 
							<OPTION value="Inactive" >Inactive</OPTION>
							</SELECT>
					<br/>		          
                              
             <input style="background:#000033 font-color:white" type="submit" value="Submit" />
        </form>

</body>
</html>
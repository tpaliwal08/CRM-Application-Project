<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Opportunities</title>
</head>
<body>
<h2><b>Opportunities</b></h2>
  
<ul id="menu">
	<li><a href="OpportunityServlet?action=insert" title="Add" class="selected">Add/Edit</a></li>
	<li><a href="OpportunityServlet?action=listOpportunity" title="View" class="selected">View</a></li>
	<li><a href="admin.jsp" title="Home" class="selected">Home</a></li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
		 <table border=1>
        <thead>
            <tr>
            	<th>Lead Id</th>
            	<th>Opportunity Id</th>
                <th>Description</th>
                <th>Pipeline Phase</th>
                <th>Estimated Revenue</th>
                <th>Estimated Close Date</th>
                <th>Status</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
         <tbody>
            <c:forEach items="${opportunities}" var="opportunity">
                <tr>
                    <td><c:out value= "${opportunity.leadid}" /></td>
                    <td><c:out value= "${opportunity.oppId}" /></td>
                    <td><c:out value= "${opportunity.oppDesc}" /></td>
                    <td><c:out value= "${opportunity.oppPipelinePhase}" /></td>
                    <td><c:out value= "${opportunity.oppEstRevenue}" /></td>
                    <td><c:out value= "${opportunity.oppEstCloseDate}" /></td>
                    <td><c:out value= "${opportunity.oppStatus}" /></td>
                    <td><a href="OpportunityServlet?action=edit&OppId=<c:out value="${opportunity.oppId}"/>">Update</a></td>
                    <td><a href="OpportunityServlet?action=delete&OppId=<c:out value="${opportunity.oppId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
    
</body>
</html>
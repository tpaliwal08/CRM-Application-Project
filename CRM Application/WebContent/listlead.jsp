
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Leads</title>
</head>
<body>
	<h2><b>Leads</b></h2>
	
<ul id="menu">
	<li><a href="LeadServlet?action=insert" title="Add" class="selected">Add/Edit</a></li>
	<li><a href="LeadServlet?action=listlead" title="View" class="selected">View</a></li>
	<li><a href="admin.jsp" title="Home" class="selected">Home</a></li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
	<br></br>
	<br></br>
	<br></br>
    <table border=1>
        <thead>
            <tr>
            	<th>LeadId</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Job Title</th>
                <th>Company Name</th>
                <th>Email Id</th>
                <th>Phone No</th>
                <th>Fax</th>
                <th>Status</th>
                <th>Address</th>
                <th>State</th>
                <th>Country</th>
                <th>Zip</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${leads}" var="lead">
                <tr>
                	<td><c:out value="${lead.leadid}" /></td>
                    <td><c:out value="${lead.firstname}" /></td>
                    <td><c:out value="${lead.lastname}" /></td>
                    <td><c:out value="${lead.jobitle}" /></td>
                    <td><c:out value="${lead.companyname}" /></td>
                    <td><c:out value="${lead.email}" /></td>
                    <td><c:out value="${lead.phone}" /></td>
                    <td><c:out value="${lead.fax}" /></td>
                    <td><c:out value="${lead.status}" /></td>
                    <td><c:out value="${lead.address}" /></td>
                    <td><c:out value="${lead.state}" /></td>
                    <td><c:out value="${lead.country}" /></td>
                    <td><c:out value="${lead.zip}" /></td>
                    
                    <td><a href="LeadServlet?action=edit&leadId=<c:out value="${lead.leadid}"/>">Update</a></td>
                    <td><a href="LeadServlet?action=delete&leadId=<c:out value="${lead.leadid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
</body>
</html>

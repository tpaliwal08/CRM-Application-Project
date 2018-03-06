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
<title>Show All Accounts</title>
</head>
<body>
<h2>Accounts</h2>

<c:if test="${true==sessionScope.role}">
	<ul id="menu">
	<li><a href="AccountServlet?action=insert" title="Add" class="selected">Add/Edit</a></li>
	<li><a href="AccountServlet?action=listaccount" title="View" class="selected">View</a></li>
	<li><a href="admin.jsp" title="Home" class="selected">Home</a></li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
	<br></br>
</c:if>
<c:if test="${false==sessionScope.role}">
		<ul id="menu">
	<li><a href="AccountServlet?action=insert" title="Add" class="selected">Add/Edit</a></li>
	<li><a href="AccountServlet?action=listaccount" title="View" class="selected">View</a></li>
	<li><a href="welcome.jsp" title="Home" class="selected">Home</a></li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
	<br></br>
</c:if>
<br></br>
<br></br>
<br></br>
<c:if test="${true==sessionScope.role}">
		<table border=1>
        <thead>
            <tr>
				<th>Account Id</th>
				<th>Opportunity Id</th>            
                <th>Account Name</th>
                <th>Account No</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Email Id</th>
                <th>Fax</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${accounts}" var="account">
                <tr>
                	<td><c:out value="${account.accId}" /></td>
                	<td><c:out value="${account.oppId}" /></td>
                    <td><c:out value="${account.accName}" /></td>
                    <td><c:out value="${account.accNo}" /></td>
                    <td><c:out value="${account.accPhone}" /></td>
                    <td><c:out value="${account.accAddress}" /></td>
                    <td><c:out value="${account.accEmail}" /></td>
                    <td><c:out value="${account.accFax}" /></td>
                    <td><a href="AccountServlet?action=edit&AccId=<c:out value="${account.accId}"/>">Update</a></td>
                    <td><a href="AccountServlet?action=delete&AccId=<c:out value="${account.accId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${false==sessionScope.role}">
		<table border=1>
        <thead>
            <tr>
				<th>Account Id</th>
				<th>Opportunity Id</th>            
                <th>Account Name</th>
                <th>Account No</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Email Id</th>
                <th>Fax</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${accounts}" var="account">
                <tr>
                	<td><c:out value="${account.accId}" /></td>
                	<td><c:out value="${account.oppId}" /></td>
                    <td><c:out value="${account.accName}" /></td>
                    <td><c:out value="${account.accNo}" /></td>
                    <td><c:out value="${account.accPhone}" /></td>
                    <td><c:out value="${account.accAddress}" /></td>
                    <td><c:out value="${account.accEmail}" /></td>
                    <td><c:out value="${account.accFax}" /></td>
                    
            
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<h2>Orders</h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
</head>
<body>
<c:if test="${true==sessionScope.role}">
<ul id="menu">
	<li><a href="OrderServlet?action=insert" title="Add" class="selected">Add/Edit</a></li>
	<li><a href="OrderServlet?action=listorder" title="View" class="selected">View</a></li>
	<li><a href="admin.jsp" title="Home" class="selected">Home</a></li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
</c:if>
<c:if test="${false==sessionScope.role}">
<ul id="menu">
	<li><a href="OrderServlet?action=insert" title="Add" class="selected">Add/Edit</a></li>
	<li><a href="OrderServlet?action=listorder" title="View" class="selected">View</a></li>
	<li><a href="welcome.jsp" title="Home" class="selected">Home</a></li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
</c:if>    
<br></br>
<br></br>
<br></br>
<c:if test="${true==sessionScope.role}">
	<table border=1>
        <thead>
            <tr>
                <th>Order Id</th>
                <th>Account Id</th>
                <th>Description</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Quantity</th>
                <th>Date</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><c:out value="${order.ordId}" /></td>
                    <td><c:out value="${order.accId}" /></td>
                    <td><c:out value="${order.ordDesc}" /></td>
                    <td><c:out value="${order.ordType}" /></td>
                    <td><c:out value="${order.ordAmount}" /></td>
                    <td><c:out value="${order.ordQuantity}" /></td>
                    <td><c:out value="${order.ordDate}" /></td>
                    
                    <td><a href="OrderServlet?action=edit&OrdId=<c:out value="${order.ordId}"/>">Update</a></td>
                    <td><a href="OrderServlet?action=delete&OrdId=<c:out value="${order.ordId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${false==sessionScope.role}">
		<table border=1>
        <thead>
            <tr>
                <th>Order Id</th>
                <th>Account Id</th>
                <th>Description</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Quantity</th>
                <th>Date</th>
                <th colspan=1>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><c:out value="${order.ordId}" /></td>
                    <td><c:out value="${order.accId}" /></td>
                    <td><c:out value="${order.ordDesc}" /></td>
                    <td><c:out value="${order.ordType}" /></td>
                    <td><c:out value="${order.ordAmount}" /></td>
                    <td><c:out value="${order.ordQuantity}" /></td>
                    <td><c:out value="${order.ordDate}" /></td>
                    
                    <td><a href="OrderServlet?action=edit&OrdId=<c:out value="${order.ordId}"/>">Update</a></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
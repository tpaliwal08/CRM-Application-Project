<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%> </title>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div name="header" id="header">

    <h4>
        Hello,<%=session.getAttribute("name")%>
    </h4>

  
<ul id="menu">
	<li><a href="#" title="Homepage" class="selected">Homepage</a></li>
	<li><a href="#" title="Accounts">Accounts</a>
		<ul>
			<li><a href="listaccount.jsp" title="ViewAcc">View Accounts</a>
			</li>
		</ul>
	</li>
	<li><a href="#" title="Orders">Orders</a>
		<ul>
			<li><a href="listorder.jsp" title="ViewOrders">View Orders</a>
			</li>
		</ul>
	</li>
	<li><a href="logout.jsp" title="Logout">Logout</a></li>
	</ul>
    </div>
        
    
</body>
</html>
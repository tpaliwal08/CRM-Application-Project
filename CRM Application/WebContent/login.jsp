<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link href="Application2.css" rel="stylesheet" type="text/css"/>
<h1><center>CRM Application</center></h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRM Application</title>
</head>
<body style="left-margin:30px">

    <form action="loginServlet" method="post">
        <fieldset style="width: 300px">
            <legend>Login</legend>
            <br></br>
            <p>Please enter your user name and password:</p>
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="username" required="required" /></td>
                </tr>
                <tr><td></td></tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass" required="required" /></td>
                </tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr>
                    <td><input style="background:#000033 font-color:white" type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kipler
  Date: 20.08.2023
  Time: 01:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restore password</title>
    <link rel="stylesheet" type="text/css" href="resources/css/forgot_password.css">
</head>
<body>
<center>
<div class="forgotPassword">
    <h1>Restore password</h1></br>
    <form action="/restorePassword" method="post">
        <label for="email">Enter email: </label>
        <input type="email" id="email" name="email">
        <br/>
        <button type="submit">Enter</button>
    </form>
</div>
</center>
</body>
</html>

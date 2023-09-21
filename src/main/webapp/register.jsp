<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="resources/css/registration.css">
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<center>
    <div class="registration">
        <h2>Register</h2>
        <form action="/register" method="post">
            <label>Email</label>
            <input name="email" type="email"/>
            <br>
            <label>Password</label>
            <input name="password" type="password"/>
            <br>
            <label>Repeat password</label>
            <input name="rpassword" type="password"/>
            <br>
            <button type="submit">Register</button>
        </form>
    </div>
</center>
</body>
</html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>I-Shop</title>
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css">
    <meta name="description" content="Лучшая выпечка в городе">
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = "";
    if (request.getAttribute("error") != null) {
        error = (String) request.getAttribute("error");
    }
%>
<center>
    <div class="login">
        <h2> Enter your login and password</h2>
        <br/>
        <form action="/login" method="post">
            <label for="email">Enter email: </label>
            <input type="email" id="email" name="email">
            <br/>

            <label for="password">Enter password: </label>
            <input type="password" id="password" name="password">
            <br/>
            <button type="submit">Enter</button>
        </form>
        <button type="submit" onclick="window.location.href='/restorePassword'">I forgot my password</button>
        <h2><%=error%></h2>
    </div>
</center>
<center>
    <div class="noAccount">
        <h2> You can register if you don't have account</h2>
        <button type="submit" onclick="window.location.href='/register'">Register</button>
    </div>
</center>
<br/>
<br/>

</body>
</html>
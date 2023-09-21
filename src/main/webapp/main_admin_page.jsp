<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body bgcolor="aqua">

<center>
    <h1>Success login</h1>
</center>

<%
    Integer countUserEnterToLogin = (Integer) session.getAttribute("count");
    if (countUserEnterToLogin != null) {
        out.println("<h2> count: " + countUserEnterToLogin + "</h2>");
    }
%>

<ol>
    <li><a href="/product">Вывести все товары</a></li>
    <li><a href="">Добавить товар</a></li>
    <li><a href="/admin/users">Вывести всех пользователей</a></li>
    <li><a href="/admin/users/add">Добавить пользователя</a></li>
</ol>

</body>
</html>

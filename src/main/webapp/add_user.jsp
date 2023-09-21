<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add user</title>
</head>
<body>

<center>
  <h2> Add new User to DB:</h2>
  <br/>
  <form action="/admin/users/add" method="post">
    <label for="email">Enter email: </label>
    <input type="email" id="email" name="email"/>
    <br/>

    <label for="password">Enter password: </label>
    <input type="password" id="password" name="password"/>
    <br/>
    <input type="submit" value="Enter!"/>
  </form>
</center>


</body>
</html>

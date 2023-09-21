<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit user</title>
</head>
<body>
<form action="/admin/users/update" method="post" >
  <table>
    <tr>
      <input name="id" type="hidden" value="${user.userId}"/>
    </tr>
    <tr>
      <td>Edit email:</td>
      <td><input type="text" name="email" value="${user.email}" /></td>
    </tr>
    <tr>
      <td>Edit password:</td>
      <td><input type="text" name="passwordNotEncoded"   value="${user.passwordNotEncoded}"  /></td>
    </tr>
  </table>
  <input type="submit" value="Update user data" />
</form>
</body>
</html>
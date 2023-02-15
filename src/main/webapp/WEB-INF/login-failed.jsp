<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 15/02/2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div>ERROR: Username or password incorrect</div>

<form method="POST" action="j_security_check" accept-charset="latin-1">
  <label for="username">Username : </label>
  <input id="username" type="text" name="j_username" required><br>
  <label for="password">Password : </label>
  <input id="password" type="password" name="j_password" required><br>
  <button type="submit">Login</button>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Login Page</title>
</head>
<body>
<form method="POST" action="j_security_check" accept-charset="latin-1">
    <label for="username">Username : </label>
    <input id="username" type="text" name="j_username" required><br>
    <label for="password">Password : </label>
    <input id="password" type="password" name="j_password" required><br>
    <button type="submit">Login</button>
</form>
</body>
</html>

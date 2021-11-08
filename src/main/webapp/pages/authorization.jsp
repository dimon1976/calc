<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 26.10.2021
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<p><a href="/">На главную</a></p>
<form action="/authorization" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${requestScope.message}</p>
</body>
</html>

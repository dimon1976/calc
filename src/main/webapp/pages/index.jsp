<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 26.10.2021
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>Hello ${requestScope.user.name}</p>
<a href="/register">Registration</a>
<a href="/authorization">Authorization</a>
<a href="/logout">Logout</a>
</body>
</html>

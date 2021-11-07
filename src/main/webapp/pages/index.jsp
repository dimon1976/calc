<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 26.10.2021
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>Hello ${sessionScope.user.name}</p>
<p>${requestScope.message}</p>
<c:if test="${sessionScope.user!=null}">
    <p><a href="/edit">Edit user</a></p>
    <p><a href="/delete">Delete user</a></p>
    <p><a href="/calc">Calc</a></p>
    <p><a href="/logout">Logout</a></p>
</c:if>

<c:if test="${sessionScope.user==null}">
<p><a href="/register">Registration</a></p>
<p><a href="/authorization">Authorization</a></p>
</c:if>

</body>
</html>

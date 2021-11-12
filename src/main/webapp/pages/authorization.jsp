
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<p><a href="/">На главную</a></p>
<form action="/authorization" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${requestScope.message}</p>
</body>
</html>

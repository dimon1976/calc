<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 31.10.2021
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<p>Hello ${sessionScope.user.name}</p>
<p><a href="/">На главную</a></p>
<form action="${pageContext.request.contextPath}/edit" method="post">
    <fieldset>
        <legend>Редактирование профиля ${sessionScope.user.name}</legend>
        <input type="text" autofocus name="name" placeholder="${sessionScope.user.name}">
        <input type="text" autofocus name="username" placeholder="${sessionScope.user.login}">
        <input type="text" autofocus name="password">
        <button>Отправить</button>
    </fieldset>
</form>
</body>
</html>

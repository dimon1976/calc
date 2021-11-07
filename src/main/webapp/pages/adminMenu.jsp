<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 07.11.2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Administrator Menu</title>
</head>
<body>
<c:if test="${sessionScope.user.admin==1}">
    <p><a href="/">На главную</a></p>
    <form action="/adminmenu" method="post">
    <fieldset>
        <legend>Зарегистрированные пользователи</legend>
        <label>
            <select name="operation">
                <option disabled selected autofocus >Действия</option>
                <option value="del">Удалить</option>
                <option value="adminon">Назначить администратором</option>
                <option value="adminoff">Назначить пользователем</option>
                <option value="history_operation">История операций</option>
                <option value="edit">Редактирование пользователя</option>
            </select>
        </label>
        <c:forEach var="users" items="${sessionScope.users}">
            <ul>
                <li><p>ID:${users.id} ${users.name}
                    <c:if test="${users.admin==1}"> - администратор</c:if>
                    <c:if test="${users.admin==0}"> - пользователь</c:if> <button type="submit" name="userId" value="${users.id}">Выполнить</button> </p></li>
            </ul>
        </c:forEach>
    </fieldset>
    </form>
</c:if>
</body>
</html>

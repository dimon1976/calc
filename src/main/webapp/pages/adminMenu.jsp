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
            <ul>
                <c:forEach var="users" items="${sessionScope.users}">
                    <c:if test="${sessionScope.user.id!=users.id}">
                        <li>
                            <p>ID:${users.id} ${users.name}
                                <c:if test="${users.admin==1}"> - администратор</c:if>
                                <c:if test="${users.admin==0}"> - пользователь</c:if>
                                <button type="submit" name="operation" value="adminon">Назначить администратором
                                </button>
                            </p>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </fieldset>
    </form>
</c:if>
<%--<label>--%>
<%--    <input type="text" name="userId" value="${users.id}">--%>
<%--</label>--%>
<%--<button type="submit" name="operation" value="del">Удалить</button>--%>
<%--<button type="submit" name="operation" value="adminon">Назначить администратором</button>--%>
<%--<button type="submit" name="operation" value="adminoff">Назначить пользователем</button>--%>
<%--<button type="submit" name="operation" value="history_operation">История операций</button>--%>
<%--                                <button type="submit" name="userId" value="${users.id}">Выполнить</button>--%>


</body>
</html>

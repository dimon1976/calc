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
<p>Hello ${sessionScope.user.name}</p>
<c:if test="${sessionScope.user.admin==1}">
    <p><a href="/">На главную</a></p>
    <fieldset>
        <legend>Зарегистрированные пользователи</legend>
        <ol>
            <c:forEach var="users" items="${sessionScope.users}">
                <c:if test="${sessionScope.user.id!=users.id}">
                    <li>
                        <form action="/adminmenu" method="post">
                            <p><label>
                                <input type="text" name="userId" hidden value="${users.id}">
                            </label> ${users.name}
                                <c:if test="${users.admin==1}"> - администратор</c:if>
                                <c:if test="${users.admin==0}"> - пользователь</c:if>
                                <button type="submit" name="operation" value="del">Удалить</button>
                                <button type="submit" name="operation" value="adminon">Назначить администратором
                                </button>
                                <button type="submit" name="operation" value="adminoff">Назначить пользователем</button>
                                <button type="submit" name="operation" value="history_operation">История операций
                                </button>
                            </p>
                            <c:if test="${requestScope.operation.equals('history_operation')}">
                                <c:if test="${requestScope.userid==users.id}">
                                    <c:forEach var="results" items="${requestScope.results}">
                                        <ul>
                                            <li><p>${results.num1} ${results.operation} ${results.num2}
                                                = ${results.result}</p></li>
                                        </ul>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </form>
                    </li>
                </c:if>
            </c:forEach>
        </ol>
    </fieldset>
</c:if>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 28.10.2021
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>
<p>Hello ${sessionScope.user.name}</p>
<form action="${pageContext.request.contextPath}/calc" method="post">
    <fieldset>
        <legend>Калькулятор</legend>
        <label>
            <input type="number" autofocus name="num1" placeholder="Number">
        </label>
        <label>
            <select name="operation">
                <option disabled selected>Select operation</option>
                <option value="sum">+</option>
                <option value="subtrack">-</option>
                <option value="multiply">*</option>
                <option value="div">/</option>
            </select>
        </label>
        <label>
            <input type="number" name="num2" placeholder="Number">
        </label>
        <button>=</button>
        ${requestScope.message}
    </fieldset>
    <fieldset>
        <legend>История операций</legend>
        <c:forEach var="results" items="${requestScope.results}">
            <ul><li><p>${results.num1} ${results.operation} ${results.num2} = ${results.result}</p></li></ul>
        </c:forEach>
    </fieldset>
</form>
</body>
</html>
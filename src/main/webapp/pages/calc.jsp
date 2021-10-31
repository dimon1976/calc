<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 28.10.2021
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <option name="sum">+</option>
                <option name="subtrack">-</option>
                <option name="multiply">*</option>
                <option name="div">/</option>
            </select>
        </label>
        <label>
            <input type="number" name="num2" placeholder="Number">
        </label>
        <button>=</button>
    </fieldset>
</form>
</body>
</html>
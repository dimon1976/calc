<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center m-5">
        <div class="col-sm-3">
            <form action="<c:url value="/delete"/>" method="post">
                <button type="submit" name="confirm" value="yes" class="btn btn-primary">Confirm delete</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

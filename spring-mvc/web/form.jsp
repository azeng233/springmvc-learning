<%--
  Created by IntelliJ IDEA.
  User: 曾晨
  Date: 2023/1/20
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/dd" method="post">
    <input type="text" name="list[0].username"><br>
    <input type="text" name="list[0].age"><br>
    <%--<input type="text" name="list[1].username"><br>--%>
    <%--<input type="text" name="list[1].age"><br>--%>
    <input type="submit" value="提交"/>
</form>
</body>
</html>

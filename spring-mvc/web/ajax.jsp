<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    这里必须要有一个反括号 要不然不能请求--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>

    <script>
        var userList = new Array();
        userList.push({username:"zc", age: 22})
        userList.push({username:"xws", age: 23})

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/ee",
            data: JSON.stringify(userList),
            contentType: "application/json;charset=utf-8"
        });


    </script>
</head>
<body>

</body>
</html>

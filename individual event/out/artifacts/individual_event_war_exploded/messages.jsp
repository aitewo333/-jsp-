
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>收件箱</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="./css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
    <script src = "js/jquery.min.js"></script>
    <script src = "js/bootstrap.min.js"></script>
    <h2>${login_user.nickname}的收件箱</h2>
    <hr>
    <a href="send.jsp">发送短消息</a>
    <a href="logout.shtml" onclick="return confirm('确定要注销吗？')";>注销</a>
    <hr>
    <table class="table table-bordered table-hover">
        <tr class="active">
            <td>状态</td>
            <td>编号</td>
            <td>标题</td>
            <td>发件人</td>
            <td>日期</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${msgList }" var="msg">
        <tr>
            <td>
                <c:if test="${msg.state == 0}">
                    <span class="glyphicon glyphicon-envelope"></span>
                </c:if>
                <c:if test="${msg.state == 1}">
                    <span class="glyphicon glyphicon-leaf"></span>
                </c:if>
            </td>
            <td>${msg.id}</td>
            <td>${msg.title}</td>
            <td>${msg.sendUserId}</td>
            <td>${msg.sendDate}</td>
            <td>
                <a href="delete.shtml?id=${msg.id}" onclick="return confirm('确定要删除吗？');">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>

    <script src="./js/jquery.min.js"></script>

    <script src="./js/bootstrap.min.js"></script>
    

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>发送短消息</title>
</head>
<body>
    <h2>发送短消息</h2>
    <hr>
    <form action="add.shtml" method="post">
        <input type="hidden" name="send_id" value="${login_user.id}"><br>
        收件人：<input type="text" name="recive_id"><br>
        标题：<input type="text" name="title"><br>
        内容：<textarea name="content" id="" cols="30" rows="8"></textarea><br>
        <button>发送</button>
    </form>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
</head>
<body>
    <h2>用户登录</h2>
    <hr />
    <form action="login.shtml" method="post">
        <div>
            Username:<input type="text" name="username">
        </div>
        <div>
            Password:<input type="password" name="password" id="">
        </div>
        <button>登录</button>
        <br>
        <a href="./reg.jsp">没有账号，点击注册</a>
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 30.03.2024
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Lab5</title>
</head>
<body>
<p>Вход</p>
<form action="login" method="POST">
    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="pass"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Войти"></td>
        </tr>
    </table>
</form>
<a href="registration">Зарегистрироваться</a>
</body>
</html>

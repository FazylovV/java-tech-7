<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 30.03.2024
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Lab5</title>
</head>
<body>
<p>Регистрация</p>
<form action="registration" method="POST" id="registr">
    <table>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="pass"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Зарегистрироваться"></td>
        </tr>
    </table>
</form>
<a href="login">Войти, если уже зарегистрирован.</a>
</body>
</html>

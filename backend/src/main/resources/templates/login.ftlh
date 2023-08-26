<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="/css/login.css" rel="stylesheet"/>
</head>

<body>
<div class="header">
    <a href="/" class="link link__homepage">&#8678; На главную</a>
</div>
    <div class="auth-page-form">
        <h3>Авторизация</h3>
        <form action="/login" method="post">
            <input type="email" name="username"><br><br>
            <input type="password" name="password"><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Вход">
        </form>
        <a href="/registration" class="registration-link link">Зарегестрироваться</a>
    </div>
</body>
</html>
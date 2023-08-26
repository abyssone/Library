<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<form action="/registration" method="post">
    Имя: <input type="text" name="name"><br><br>
    Эл. почта: <input type="email" name="email"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегестрироваться">
</form>
</body>
</html>>
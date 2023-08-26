<!DOCTYPE html>
<html>
<head>
    <title>LitHub Homepage</title>
    <link href="/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="header">
    <div class="header__left">
        <a href="/" class="header__logo">
            LitHub
        </a>
        <form action="/" method="get" class="search-form">
            <input type="text" name="title" class="input-text search-form__input-text">
            <input type="submit" value="Поиск" class="input-button">
        </form>
    </div>
    <div class="header__right">
        <#if user??>
        <p class="header__username">${user.name}</p>
    </#if>
    <a href="/login" class="link-button">Вход</a>
</div>
</div>
<h1>Вы - админ!</h1>
</body>
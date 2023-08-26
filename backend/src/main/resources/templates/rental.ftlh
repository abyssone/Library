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
<h1>Добавление записи о прокате</h1>
<form action="/rental" method="post">
    Название книги: <input type="text" name="bookTitle">
    Email библиотекаря: <input type="email" name="librarianEmail">
    Email читателя: <input type="email" name="readerEmail">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit">
</form>
</body>
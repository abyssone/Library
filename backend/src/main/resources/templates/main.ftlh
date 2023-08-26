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
                <input type="submit" value="Поиск" class="link-button">
            </form>
        </div>
        <div class="header__right">
            <#if user??>
                <p class="header__username">${user.name}</p>
                <#if user.roles?seq_contains("ROLE_ADMIN")>
                <p class="header__username">[ADMIN]</p>
                    <a href="/admin" class="link-button">Admin</a>
                </#if>
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Выход" class="link-button">
                </form>
            <#else>
                <a href="/login" class="link-button">Вход</a>
            </#if>
        </div>

    </div>
    <hr>
    <div class="main">
        <div class="left-side-menu">
            <p>Поиск</p>
            <p>Поиск</p>
            <p>Поиск</p>
            <p>Поиск</p>
            <p>Поиск</p>
        </div>
        <div class="book_container">
            <#if main??>
            <#list main as book>
            <div class="book_card">
                <p class="book_card__image-container">
                    <#if book.image??>
                    <img src="/images/${book.image.id}" height="70px" class="book_card__image">
                </#if>
                </p>
                <p class="book_card__title"><b>${book.title}</b></p>
                <p class="book_card__author">${book.author}</p>
                <p class="book_card__more"><a href="/book/${book.id}" class="link">Подробнее</a></p>
            </div>
        </#list>
        <#else>
        <b>Книг нет</b>
    </#if>
    </div>
    </div>




    <hr>
    <h4>Добавление книги</h4>
    <form action="bookcreate" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        Название книги: <input type="text" name="title">
        Автор: <input type="text" name="author">
        Изображение: <input type="file" name="imageFile">
        <input type="submit" value="Добавить">
    </form>
</body>
</html>
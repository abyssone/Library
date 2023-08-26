<!DOCTYPE html>
<html>
<head>
    <title>Lib</title>
    <link href="/styles.css" rel="stylesheet"/>
</head>
<body>
<h1>Информация о товаре</h1><hr>
<img src="/images/${image.id}" height="60px" alt="">
<p>Название книги: ${book.title}</p>
<p>Имя автора: ${book.author}</p>
<hr>
<form action="delete/${book.id}" method="post">
    <input type="submit" value="Удалить книгу">
</form>
</body>
</html>
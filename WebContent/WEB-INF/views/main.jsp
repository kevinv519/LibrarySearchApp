<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca</title>
<link rel="stylesheet" href="resources/css/default.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/books/search" method="post" autocomplete="off">
    Buscar por:
    <select name="filter">
        <option value="title">Titulo</option>
        <option value="isbn">ISBN</option>
        <option value="author">Autor</option>
        <option value="gender">Género</option>
    </select>
    <input type="text" name="value" id="">
    <button type="submit">Buscar</button>
</form>
<br>
<button onclick="location.href='${pageContext.request.contextPath}/books'">Ver todos</button>
</body>
</html>
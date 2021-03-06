<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca</title>
<link rel="stylesheet" href="resources/css/default.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="bg-light">
	<div class="container bg-white p-5 text-center">
    	<h1>Library Search Web App</h1>
    	<br>
        <form action="${pageContext.request.contextPath}/books/search" method="get" autocomplete="off" class="form-inline justify-content-center" id="searchForm">
            Buscar por:
            <select name="filter" class="form-control ml-2">
                <option value="title">Titulo</option>
                <option value="isbn">ISBN</option>
                <option value="author">Autor</option>
                <option value="genre">Género</option>
            </select>
            <input type="text" name="value" id="value" class="form-control ml-2" required>
            <button type="submit" class="btn btn-outline-primary ml-2">Buscar</button>
        </form>
        
        <a href="${pageContext.request.contextPath}/books" class="btn btn-outline-primary mt-3">Ver todos</a>
    </div>
    <script src="resources/js/main.js"></script>
</body>
</html>
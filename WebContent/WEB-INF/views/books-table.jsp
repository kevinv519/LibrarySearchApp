<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of books</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
<body class="bg-light">
    <div class="container bg-white p-4">
        <h1>Books</h1>
        <c:if test="${isSearch}">
            <p>Se encontraron <strong class="text-danger">${fn:length(books)}</strong> resultados para <strong class="text-danger">${value}</strong> en <strong class="text-danger">${criteria}</strong></p>
        </c:if>
        <c:if test="${!isSearch}">
            <p>Hay <strong class="text-danger">${totalBooks}</strong> libros en existencia, de <strong class="text-danger">${authors}</strong> autores diferentes</p>
        </c:if>

        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="bg-info text-white">
                    <tr>
                        <th scope="col">ISBN</th>
                        <th scope="col">Título</th>
                        <th scope="col">Autor</th>
                        <th scope="col">Género</th>
                        <th scope="col">Existencias</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td class="text-nowrap">${book.isbn}</td>
                            <td>${book.title}</td>
                            <td class="text-nowrap">${book.author}</td>
                            <td class="force-wrap">${book.genre}</td>
                            <td class="text-center">${book.quantity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
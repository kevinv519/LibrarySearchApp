<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of books</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    </head>
<body>
    <h1>Books</h1>
    <p>Hay ${totalBooks} libros en existencia, de ${authors} autores diferentes</p>

    <table>
    	<thead>
    		<tr>
    			<th>ISBN</th>
    			<th>Título</th>
    			<th>Autor</th>
    			<th>Género</th>
    			<th>Existencias</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${books}" var="book">
                <tr>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.genre}</td>
                <td>${book.quantity}</td>
                </tr>
    		</c:forEach>
    	</tbody>
    </table>
</body>
</html>
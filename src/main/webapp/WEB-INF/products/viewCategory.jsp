<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category View</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h1><c:out value="${category.name}"></c:out></h1>
<ul>
<c:forEach items="${category.products}" var="product">
<li><c:out value="${product.name}"></c:out></li>
</c:forEach>
</ul>
<form action="/addproduct/${category.id}" method="POST">
    <p>
        <label>Add Product:</label>
        <select name="p"><c:forEach items="${product}" var="product">
        <option value="${product.id}"><c:out value="${product.name}"/></option>
        </c:forEach></select>
    </p>
    <button type="submit">Add</button>
</form>
</body>
</html>
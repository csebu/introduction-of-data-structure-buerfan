<%@page import="java.util.List"%>
<%@page import="dao.DBData"%>
<%@page import="model.CategoryModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	
	<h2 align="center">Category</h2>
	<a href="./categories?action=new">Add New Category</a>
	<a href="./subcategories?action=new">Add New Sub Category</a>
	
	<%
	DBData db = new DBData();
	List<CategoryModel> categoryModel = db.getAllCategories();
	request.setAttribute("categories", categoryModel);
	%>

	<table align="center" border="1">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Description</td>

		</tr>

		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.categoryDescription}</td>
				<td><a href="/eCommerce/categories?action=update&id=${category.categoryId}">Update</a></td>
				<td><a href="/eCommerce/categories?action=delete&id=${category.categoryId}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>





</body>
</html>
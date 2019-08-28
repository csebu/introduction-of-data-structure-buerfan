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
<title>Subcategory</title>
</head>
<body>
	
	<h2>Subcategory</h2>
	
	<form action="/eCommerce/subcategories" method="post">
		<table align="center">
			
			<tr>
				<td>Subcategory Name</td>
				<td><input type="text" name="subcategory_name"  value=""></td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td><input type="text" name="subcategory_description" value=""></td>
			</tr>
			
			<%
			
			DBData db = new DBData();
			List<CategoryModel> categoryModel = db.getAllCategories();
			request.setAttribute("subcategories", categoryModel);

			%>
			
		<tr>
		<td>Category ID</td>
		<td>
		<select name="dropdownCategory">
    <c:forEach items="${subcategories}" var="category">
        <option value="${category.categoryId}">${category.categoryId}     ${category.categoryName}</option>
    </c:forEach>
</select>
		</td>
		</tr>
		
		
			<tr>
				<td>
				
				<c:if test="${action=='update'}">
				<input type="hidden" value="update" name="action">	
				</c:if>
				
				<c:if test="${action=='new'}">
				<input type="hidden" value="new" name="action">
				</c:if>
				</td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>
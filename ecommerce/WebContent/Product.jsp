<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<center>
		<h2>Product</h2>
	
	
	
		<form action="" method="post">
		
			<table border="1px solid black">
			
				<tr>
					<td>Product Name</td>
					<td><input type="text" value="" placeholder="Enter the product name"> </td>
				</tr>
				
				<tr>
					<td>Product Description</td>
					<td><input type="text" value="" placeholder="Enter the product Description"> </td>
				</tr>
				
				<tr>
					<td>Product Image</td>
					<td><input type="file" value="" placeholder="Enter the product Image"> </td>
				</tr>
				
				<tr>
					<td>Product Category</td>
					<td>
					
					<select name="dropdownProductCategory">
						<option>Fish</option>
						<option>Vegetable</option>
						<option>Fruits</option>
					</select>
					
					</td>
				</tr>
				
				<tr>
					<td>Product Sub-categoruy</td>
					<td>
					
					<select name="dropdownProductSubcategory">
						<option>Fish1</option>
						<option>Fish2</option>
						<option>Fish3</option>
					</select>
					
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="submit"></td>
				</tr>
			
			</table>
		
		</form>
	
	</center>
	
</body>
</html>
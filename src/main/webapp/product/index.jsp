<%@page import="vn.aptech.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h3>
		<a href="Controller?a=DisplayCreate">Create New</a>
	</h3>
	<h1>Product List</h1>
	<h2>${data}</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (request.getAttribute("prods") != null) {
				List<ProductDto> prods = (List<ProductDto>) request.getAttribute("prods");
				for (ProductDto p : prods) {
			%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getPrice()%></td>
			</tr>
			<%
				}
			}
			%>
		</tbody>
	</table>
</body>
</html>
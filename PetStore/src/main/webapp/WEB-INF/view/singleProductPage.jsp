<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <table class="table">
			<tr>
				<td>Product Name :</td>
				<td>${productdata.name }</td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td>${productdata.description }</td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td>${productdata.price }</td>
			</tr>
			<tr>
				<td>Category Name</td>
				<td>${productdata.category.categoryName}</td>
			</tr>
		</table>  --%>
		
		
		
		<div class="container-wrapper">
		<div class="container">
			<table class="table table-striped">

				<thead>
					<tr>
					    <th>Image</th>
						<th>Id</th>
						<th>Name</th>
						<th>Price</th>
						<th>Description</th>
						<th>Category Name</th>
					</tr>

				</thead>
				
					<tr>
					    <td>${productdata.file}</td>
						<td>${productdata.id}</td>
						<td>${productdata.name}</td>
						<td>${productdata.price}</td>
						<td>${productdata.description}</td>
						<td>${productdata.category.categoryName}</td>
						
					</tr>


			</table>


		</div>

	</div>
<%-- ${productdata.id } 
${productdata.name }
${productdata.price }
  --%>
</body>
</html>
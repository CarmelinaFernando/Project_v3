<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
						<th>Edit</th>
					</tr>

				</thead>
				<c:forEach items="${productlist}" var="p">
					<tr>
					    <td>${p.pImage}</td>
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td>${p.price}</td>
						<td>${p.description}</td>
						<td><c:url value="/admin/product/viewProduct/${p.id}" var="view"></c:url><a href="${view}"><span class="glyphicon glyphicon-info-sign"></span></a>
						<c:url value="/admin/product/deleteProduct/${p.id}" var="delete"></c:url><a href="${delete}"><span class="glyphicon glyphicon-remove"></span></a>
						<a href=""><span class="glyphicon glyphicon-pencil"></span></a></td>

					</tr>


				</c:forEach>

			</table>


		</div>

	</div>

</body>
</html>
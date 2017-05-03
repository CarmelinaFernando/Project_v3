<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN || ADD CATEGORY</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
		<div class="col-md-5">
			<c:url value="/admin/category/addCategory" var="url">
			</c:url>

			<form:form method="POST" action="${url}" commandName="category">
				<div class="form-group">
					
					<form:hidden path="id" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="categoryName">Name</form:label>

					<form:input path="categoryName" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="categoryDetails">Category Details</form:label>
					<form:input path="categoryDetails" class="form-control" />
				</div>
	
				<input type="submit" value="Add Category" />


			</form:form>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">

				<table class="table">
					<thead>
						<tr>
							<th>Category Id</th>
							<th>Category Name</th>
							<th>Category Details</th>
						</tr>

					</thead>
					<c:forEach items="${categorylist}" var="c">
						<tr>
							<td>${c.id }</td>
							<td>${c.categoryName }</td>
							<td>
							<td><c:url value="/admin/category/viewCategory/${c.id}"
									var="view"></c:url><a href="${view}"><span
									class="glyphicon glyphicon-eye-open"></span></a> <c:url
									value="/admin/category/deleteCategory/${c.id}" var="delete"></c:url><a
								href="${delete}"><span class="glyphicon glyphicon-trash"></span></a>
								<c:url value="/admin/category/editCategory/${c.id}" var="edit"></c:url>
								<a href="${edit}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
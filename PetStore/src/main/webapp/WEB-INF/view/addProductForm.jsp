<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN || ADD PRODUCT</title>
</head>
<body>
	<div class="container-wrapper">
		<div class="container">
			<c:url value="/admin/product/addProduct" var="url">
			</c:url>

			<form:form method="POST" action="${url}" commandName="product" enctype="multipart/form-data">
				<div class="form-group">
					
					<form:hidden path="id" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" class="form-control" />
					<form:errors path="name"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="description">Description</form:label>
					<form:input path="description" class="form-control" />
					<form:errors path="description"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="price">Price</form:label>
					<form:input path="price" class="form-control" />
					<form:errors path="price"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="quantity">Quantity</form:label>
					<form:input path="quantity" class="form-control" />
					<form:errors path="quantity"></form:errors>
				</div>
				
				 <div class="form-group">
				    <form:label path="pImage">Picture</form:label>
			       <form:input type="file" path="pImage" class="form-control"/>
			        <form:errors path="pImage"></form:errors>
	            </div> 
	            
				<input type="submit" value="Add Product" />
			</form:form>
		</div>

	</div>

</body>
</html>
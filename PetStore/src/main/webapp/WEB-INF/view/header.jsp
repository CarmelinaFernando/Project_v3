<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Angular Js -->
<script 
    src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

</head>

<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<c:url value="/all/about" var="about" />
				<li><a href="${about}">About Us</a></li>
				<c:url value="/all/contact" var="contact" />
				<li><a href="${contact}">Contact Us</a></li>
				<c:url value="/all/product" var="product" />
				<li><a href="${product}">Product</a></li>
				<%-- <c:url value="/all/category" var="category"/>
				<li><a href="${category}">Category</a></li> --%>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${categorylist}" var="c">

							<li><a href="">${c.categoryName}</a></li>

						</c:forEach>
					</ul>
					</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
						<c:url value="/login" var="login" />
				<li><a href="${login}"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>


</body>
</html>

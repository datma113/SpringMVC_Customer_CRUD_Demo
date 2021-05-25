<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>hello spring 3</p>
	<div>
		<a
			href="${pageContext.request.contextPath }/customer/customer-save-form">create
			customer</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/customer/customer-list">see
			all list</a>
	</div>

</body>
</html>
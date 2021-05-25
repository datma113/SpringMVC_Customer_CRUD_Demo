<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save" modelAttribute="customer" method="POST">
	<form:hidden path="id"/>
		<div>
			<p> Username: </p>
			<form:input path="name"/>
		</div>
		<div>
			<p> email: </p>
			<form:input path="email"/>
		</div>
		<input type="submit" value="save">
	</form:form>

</body>
</html>
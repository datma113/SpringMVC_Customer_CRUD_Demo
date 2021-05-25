<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
				<th>update </th>
			<th>Delete </th>
		<tr>
		<c:forEach var="customer" items="${customers }">
		<c:url var="updateLink" value="/customer/update">
			<c:param name="customerId" value="${customer.id }"></c:param>
		 </c:url>
		 <c:url var="deleteLink" value="/customer/delete">
			<c:param name="customerId" value="${customer.id }"></c:param>
		 </c:url>
			<tr>
			<td>${customer.name }</td>
			<td>${customer.email }</td>
			<td><a href="${updateLink }">update</a></td>
			<td><a href="${deleteLink }">delete</a></td>
			</tr>		
			
		</c:forEach>
	</table>
</body>
</html>
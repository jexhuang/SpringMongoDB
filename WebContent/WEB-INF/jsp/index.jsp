<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>

	<form action="person/save" method="post">
		<input type="hidden" name="id"> <label for="name">Person
			Name</label> <input type="text" id="name" name="name" /> <input type="submit"
			value="Submit" />
	</form>

	<table border="1">
		<c:forEach var="person" items="${personList}">
			<tr>
				<td>${person.name}</td>
				<td><input type="button" value="delete"
					onclick="window.location='person/delete?id=${person.id}'" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
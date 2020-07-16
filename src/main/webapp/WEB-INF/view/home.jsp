<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h2>Home Page</h2>
	<p>Welcome! ahmedgaber.org</p>

	<hr>


	<p>
		User:
		
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	

	<security:authorize access="hasRole('MANAGER')">
	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Panel</a> (Only for Managers)
		</p>
	</security:authorize>


	<security:authorize access="hasRole('ADMIN')">
	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/systems">Admin Panel</a>
			(Only for Admins)
		</p>
	</security:authorize>

	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST" class="form-horizontal">

		<input type="submit" value="Logout" />
	</form:form>


</body>
</html>
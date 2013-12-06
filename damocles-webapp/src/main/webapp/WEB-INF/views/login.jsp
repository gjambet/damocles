<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<body>
		<form:form method="post" action="${pageContext.request.contextPath}/user/login">
		   <label>Login</label> : <input type="text" name="login" />
		   <label>Password</label> : <input type="password" name="password" />
		   <input type="submit"/>
		</form:form>
	</body>
</html>

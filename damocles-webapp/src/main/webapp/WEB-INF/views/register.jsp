<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<body>
    <form:form method="post" action="${pageContext.request.contextPath}/user/register">
		   <p><label>Mail</label> : <input type="text" name="mail" /></p>
		   <p><label>Login</label> : <input type="text" name="login" /></p>
		   <p><label>Password</label> : <input type="password" name="password" /></p>
		   <input type="submit">
    </form:form>
	</body>
</html>
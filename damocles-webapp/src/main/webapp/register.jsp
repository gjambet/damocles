<html>
	<header>
	</header>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/register.do">
		   <p><label>Mail</label> : <input type="text" name="mail" /></p>
		   <p><label>Login</label> : <input type="text" name="login" /></p>
		   <p><label>Password</label> : <input type="password" name="password" /></p>
		   <input type="submit">
		</form>
	</body>
</html>
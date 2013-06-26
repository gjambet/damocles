<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:form="http://www.springframework.org/tags/form"
  version="2.0">
<html>
	<header>
	</header>
	<body>
		<form:form method="post" action="${pageContext.request.contextPath}/login.do">
		   <label>Login</label> : <input type="text" name="login" />
		   <label>Password</label> : <input type="password" name="password" />
		   <input type="submit"/>
		</form:form>
	</body>
</html>
</jsp:root>
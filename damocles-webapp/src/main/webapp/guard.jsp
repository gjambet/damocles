<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:form="http://www.springframework.org/tags/form"
  version="2.0">
<html>
    <head>
    </head>
    <body>
        <form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/create.do">
		    <label for="message">Message</label> : <input id="message" type="text" name="message" />
		    <label for="recipient">Recipient</label> : <input id="recipient" type="text" name="recipient" />
            <input type="submit" value="Create" />
        </form:form>
    </body>
</html>
</jsp:root>

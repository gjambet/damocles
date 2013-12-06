<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/guard/create">
		    <label for="message">Message</label> : <input id="message" type="text" name="message" />
		    <label for="recipient">Recipient</label> : <input id="recipient" type="text" name="recipient" />
            <input type="submit" value="Create" />
        </form:form>
    </body>
</html>
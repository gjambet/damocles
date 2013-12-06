<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" 
  xmlns:c="http://java.sun.com/jsp/jstl/core"
  xmlns:form="http://www.springframework.org/tags/form"
  version="2.0">
  
<jsp:directive.page contentType="text/html" isErrorPage="false" isThreadSafe="true" pageEncoding="UTF-8"/>
<jsp:directive.page import="net.guillaume.damocles.entities.User" />

<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
      <jsp:useBean id="user" class="net.guillaume.damocles.entities.User" scope="request"/>
       Bonjour <jsp:getProperty name="user" property="login" />
       <br/>

        <form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/checkin.do">
            <input type="submit" value="Checkin" />
        </form:form>

       <br/>
        Mes Gardes
        <table>
           <c:forEach var="guard" items="${user.guards}">
             <tr>
               <td>${guard.name}</td>
               <td>${guard.trigger.lastCheckin}</td>
             </tr>
           </c:forEach>
         </table>

       <br/>
           <a href="/damocles/guard.jsp">creer une garde</a>
       <br/>
       logout
       <br/>
       supprimer mon compte
       <br/>
       editer mon compte
    </body>
</html>
</jsp:root>
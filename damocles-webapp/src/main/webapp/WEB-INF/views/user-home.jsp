<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
       Bonjour ${user.login}
       <br/>

        <form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/user/checkin">
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
           <a href="${pageContext.request.contextPath}/guard/create">creer une garde</a>
       <br/>
       logout
       <br/>
       supprimer mon compte
       <br/>
       editer mon compte
    </body>
</html>
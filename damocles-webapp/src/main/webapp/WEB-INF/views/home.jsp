<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head><title>Damocles</title></head>
 <body>

    <div>
      <h1>Damocles</h1>
    </div>
	<div>
	  <a href="${pageContext.request.contextPath}/user/register">S'enregistrer</a>&nbsp;<a href="${pageContext.request.contextPath}/user/login">Se logger</a>
	</div>

	<br/>

    <img src="<c:url value="/resources/sword_of_damocles_by_abou3.jpg"/>"/>

    <br/>

	<div>If you fail, this video will spread across the internet like a virus. [...] And, if anything should happen to me - if I get run over by a car, if YOU run me over with a car - this will upload automatically.</div>
	<div>Lisbeth Salander / Stieg Larsson</div>

 </body>
</html>

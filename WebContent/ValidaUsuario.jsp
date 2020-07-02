<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<!--Si no detecta usuario, desplega form de login-->
	<c:when test="${empty sessionScope.user}"> 
		<form action="ValidarLogin" method="POST">
			<!-- 			<p>Login</p> -->
			<input type="text" name="user" id="user" placeholder="Usuario"
				required> <input type="password" name="pass" id="pass"
				placeholder="Clave" required> <input type="hidden"
				name="parametro" value="sesion"> <input type="submit"
				value="Login">
		</form>
	</c:when>

	<c:otherwise>
		<!--si detecta usuario, muestra bienvenida-->
		<p>Bienvenido ${sessionScope.user}</p>
		<form action="${pageContext.request.contextPath}/LogOut" method="get">
			<input type="submit" value="Logout">
		</form>

	</c:otherwise>

</c:choose>
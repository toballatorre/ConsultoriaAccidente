<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<!--Si no detecta una sesión, muestra form de login-->
	<c:choose>

		<c:when test="${empty sessionScope.user}"> 
		
		<form class="validarUsuario" action="ValidarLogin" method="POST">
			<!--<p>Login</p> -->
			<input class="input" type="text" name="user" id="user" placeholder="Usuario" required>
			<input class="input" type="password" name="pass" id="pass" placeholder="Clave" required>
			<input class="input" type="hidden" name="parametro" value="sesion">
			<input class="input" type="submit" value="Login">
		</form>
	</c:when>

	<c:otherwise>
		<!--si detecta usuario, muestra bienvenida-->
		<p> <strong> Bienvenido ${sessionScope.user}</strong></p>
		<form action="${pageContext.request.contextPath}/LogOut" method="get">
			<input class="input" type="submit" value="Logout">
		</form>

	</c:otherwise>

</c:choose>
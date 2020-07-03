<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear usuario</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">	
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />

	<h1>Crear usuario</h1>
	<div class="mensajealerta">
		<c:if test="${cumensaje != null}">
			<c:out value="${cumensaje}" />
		</c:if>
	</div>
	<form action="CrearUsuario" method="post">
		Usuario: <input type="text" name="txtusuario" /><br />
		Tipo Usuario: <input type="text" name="txttipouser" /> <br />
		Clave: <input type="password" name="txtclave" /> <br />
		Mail: <input type="email" name="txtcorreo" /> <br />
		Activo: <input type="text" name="txtactivo" value="1" /> <br />
		<input type="submit" value="Agregar usuario" />
	</form>

	<a href="${pageContext.request.contextPath}/ListarUsuarios">Volver
		al listado de usuarios</a>
		
<jsp:include page="../footer.jsp" />
</body>
</html>
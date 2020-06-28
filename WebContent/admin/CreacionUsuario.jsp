<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear usuario</title>
	<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />

	<h1>Crear usuario</h1>

	<c:if test="${cumensaje != null}">
		<c:out value="${cumensaje}" />
	</c:if>

	<form action="CrearUsuario" method="post">
		Nombre: <input type="text" name="txtnombre" /><br /> Apellido: <input
			type="text" name="txtapellido" /> <br /> Telefono: <input
			type="text" name="txttelefono" /> <br /> Correo electrónico: <input
			type="email" name="txtcorreo" /> <br /> <input type="submit"
			value="Agregar usuario" />
	</form>

	<a href="${pageContext.request.contextPath}/ListarUsuarios">Volver
		al listado de usuarios</a>
		
<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado de Usuarios</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />
	
	<h1>Listado de Usuarios</h1>

	<c:if test="${cumensaje != null}">
		<c:out value="${cumensaje}" />
	</c:if>

	<table>
		<tr>
			<th>ID</th>
			<th>Usuario</th>
			<th>TipoUsuario</th>
			<th>Clave</th>
			<th>Mail</th>
			<th>Activo</th>
		</tr>

		<c:forEach items="${listadousuarios}" var="user">
			<tr>
				<td>${user.getIdusuario()}</td>
				<td>${user.getUsuario()}</td>
				<td>${user.getTipousuario()}</td>
				<td>${user.getClave()}</td>
				<td>${user.getMail()}</td>
				<td>${user.getActivo()}</td>
				<td><a href="${pageContext.request.contextPath}/EliminarUsuario?id=${user.getIdusuario()}">Eliminar</a>
					<a href="${pageContext.request.contextPath}/EditarUsuario?id=${user.getIdusuario()}">Editar</a>
				</td>
			</tr>
		</c:forEach>

	</table>

	<a href="${pageContext.request.contextPath}/CrearUsuario">Creación
		de usuarios</a>

<jsp:include page="../footer.jsp" />
</body>
</html>
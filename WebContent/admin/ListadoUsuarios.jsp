<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado de Usuarios</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
	<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../MenuAdmin.jsp" />
	<div class="contenido">
		<h1>Vista Administrador</h1>
		<h2>Listado de Usuarios</h2>
		<div class="mensajealerta">
			<c:if test="${cumensaje != null}">
				<c:out value="${cumensaje}" />
			</c:if>
		</div>
	
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
					<td><!-- <a href="${pageContext.request.contextPath}/EliminarUsuario?id=${user.getIdusuario()}">Eliminar</a> -->
						<a href="${pageContext.request.contextPath}/EditarUsuario?id=${user.getIdusuario()}"><i class="far fa-edit"></i></a>
					</td>
				</tr>
			</c:forEach>
	
		</table>
	
		<a href="${pageContext.request.contextPath}/CrearUsuario"><i class="far fa-plus-square"></i> Crear Usuario</a>
	</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
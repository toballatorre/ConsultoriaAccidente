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
		<table class="tabla">
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="txtusuario" /></td>
			</tr>
			<tr>
				<td>Tipo Usuario:</td>
				<td><label for="admin">Admin</label><input type="radio" id="admin" name="txttipouser" value="admin" checked>
					<label for="pro">Profesional</label><input type="radio" id="pro" name="txttipouser" value="profesional">
					<label for="cliente">Cliente</label><input type="radio" id="cliente" name="txttipouser" value="cliente"></td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><input type="password" name="txtclave" /></td>
			</tr>
			<tr>
				<td>Mail:</td>
				<td><input type="email" name="txtcorreo" /></td>
			</tr>
			<tr>
				<td>Activo:</td>
				<td><label for="si">Si</label><input type="radio" id="si" name="txtactivo" value="1" checked><br>
					<label for="no">No</label><input type="radio" id="no" name="txtactivo" value="0"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Agregar usuario" /></td>
			</tr>
		</table>
	</form>

	<a href="${pageContext.request.contextPath}/ListarUsuarios">Volver al listado de usuarios</a>
		
<jsp:include page="../footer.jsp" />
</body>
</html>
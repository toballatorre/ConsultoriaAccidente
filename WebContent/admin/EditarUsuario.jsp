<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar usuario</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />

	<h1>Editar usuario</h1>
	<div class="mensajealerta">
		<c:if test="${cumensaje != null}">
			<c:out value="${cumensaje}" />
		</c:if>
	</div>

	<form action="EditarUsuario" method="post">
		<input type="hidden" name="idusuario"  value="${datosusuario.getIdusuario()}" />
		<table class="tabla">
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="txtusuario" value="${datosusuario.getUsuario()}"/></td>
			</tr>
			<tr>
				<td>Tipo Usuario:</td>
				<td>
					<input type="text" name="txttipouser" value="${datosusuario.getTipousuario()}"/>
				</td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><input type="password" name="txtclave" value="${datosusuario.getClave()}"/></td>
			</tr>
			<tr>
				<td>Mail:</td>
				<td><input type="email" name="txtcorreo" value="${datosusuario.getMail()}"/></td>
			</tr>
			<tr>
				<td>Activo:</td>
				<td>
				<input type="text" name="txttipouser" value="${datosusuario.getActivo()}"/>
				</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Editar usuario" /></td>
			</tr>
		</table>
	</form>

	<a href="${pageContext.request.contextPath}/ListarUsuarios">Volver al listado de usuarios</a>

<jsp:include page="../footer.jsp" />
</body>
</html>
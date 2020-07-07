<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Profesional</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />
<div class="contenido">
	<h1>Mantener Información Profesionales</h1>
	<div class="mensajealerta">
		<c:if test="${cumensaje != null}">
			<c:out value="${cumensaje}" />
		</c:if>
	</div>

	<form action="ProfEditar" method="post">
		<input type="hidden" name="idempleado"  value="${datosprofesional.getIdempleado()}" />
		<input type="hidden" name="idusuario"  value="${datosprofesional.getIdusuario()}" />
		<table class="tabla">
			<tr>   
				<td>Nombre:</td>
				<td><input type="text" name="nombre" value="${datosprofesional.getNombre()}"/></td>
			</tr>
			<tr>
				<td>Celular:</td>
				<td><input type="text" name="celular" value="${datosprofesional.getCelular()}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Editar Profesional" /></td>
			</tr>
		</table>
	</form>

	<a href="${pageContext.request.contextPath}/ProfListar">Volver al listado de profesionales</a>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
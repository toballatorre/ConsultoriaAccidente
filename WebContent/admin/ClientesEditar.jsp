<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar cliente</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />
<div class="contenido">
	<h1>Editar cliente</h1>
	<div class="mensajealerta">
		<c:if test="${cumensaje != null}">
			<c:out value="${cumensaje}" />
		</c:if>
	</div>

	<form action="ClientesEditar" method="post">
		<input type="hidden" name="idcliente"  value="${datoscliente.getIdCliente()}" />
		<input type="hidden" name="idusuario"  value="${datoscliente.getIdUsuario()}" />
		<table class="tabla">
			<tr>
				<td>Nombre Empresa:</td>
				<td><input type="text" name="nombreempresa" value="${datoscliente.getNombreEmpresa()}"/></td>
			</tr>
			<tr>
				<td>RUT:</td>
				<td><input type="text" name="rutempresa" value="${datoscliente.getRutEmpresa()}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Editar cliente" /></td>
			</tr>
		</table>
	</form>

	<a href="${pageContext.request.contextPath}/ClientesListar">Volver al listado de clientes</a>
</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado Accidentabilidad</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Cliente</h1>
	<jsp:include page="../MenuAdmin.jsp" />
	<div class="contenido">
		<h1>Registros de Accidentes</h1>
		<div class="mensajealerta">
			<c:if test="${cumensaje != null}">
				<c:out value="${cumensaje}" />
			</c:if>
		</div>
	
		<table>
			<tr>
				<th>ID</th>
				<th>Tipo Accidente</th>
				<th>Dias perdidos</th>
				<th>Fecha accidente</th>
				<th>Lugar</th>
				<th>Descripcion</th>
			</tr>
	
			<c:forEach items="${listadoreportes}" var="reporte">
				<tr>
					<td>${reporte.getidReporte()}</td>
					<td>${reporte.gettipoAccidente()}</td>
					<td>${reporte.getdiasPerdidos()}</td>
					<td>${reporte.getfechaAccidente()}</td>
					<td>${reporte.getlugarAccidente()}</td>
					<td>${reporte.getdescripcion()}</td>
					<td><!-- <a href="${pageContext.request.contextPath}/EliminarUsuario?id=${user.getIdusuario()}">Eliminar</a> -->
						<a href="#">Editar</a>
					</td>
				</tr>
			</c:forEach>
	
		</table>
	
		<a href="${pageContext.request.contextPath}/ReporteCreate">Crear nuevo registro</a>
	</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
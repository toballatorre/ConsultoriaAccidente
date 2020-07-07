<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Accidentabilidad Cliente</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../MenuAdmin.jsp" />
	<div class="contenido">
	<h1>Vista Administrador: <c:out value='${sessionScope.nombreCliente}'/></h1>
		<h2>Registros de Accidentes</h2>
		<div class="mensajealerta">
			<c:if test="${cumensaje != null}">
				<c:out value="${cumensaje}" />
			</c:if>
		</div>
	
		<table>
			<tr>
				<th>ID</th>
				<th>Fecha accidente</th>
				<th>Lugar</th>
				<th>Tipo Accidente</th>
				<th>Dias perdidos</th>
				<th>Descripcion</th>
			</tr>
	
			<c:forEach items="${listadoreportes}" var="reporte">
				<tr>
					<td>${reporte.getIdReporte()}</td>
					<td>${reporte.getFechaAccidente()}</td>
					<td>${reporte.getLugarAccidente()}</td>
					<td>${reporte.getTipoAccidente()}</td>
					<td>${reporte.getDiasPerdidos()}</td>
					<td>${reporte.getDescripcion()}</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
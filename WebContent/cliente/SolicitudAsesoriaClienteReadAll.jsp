<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Solicitudes de Asesoria</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
		<h1>Vista Cliente: <c:out value='${sessionScope.nombreCliente}'/></h1>
	
		<jsp:include page="../MenuCliente.jsp" />
		<div class="contenido">
			<h1>Solicitudes de Asesoria</h1>
			<div class="mensajealerta">
				<c:if test="${cumensaje != null}">
					<c:out value="${cumensaje}" />
				</c:if>
			</div>
			
		<table>
			<tr>
				<th>ID</th>
				<th>Fecha solicitud</th>
				<th>Motivo</th>
				<th>Preferencia horario</th>
			</tr>
	
			<c:forEach items="${listadosolicitudes}" var="solicitud">
				<tr>
					<td>${solicitud.getIdSoliticud()}</td>
					<td>${solicitud.getFechaHora()}</td>
					<td>${solicitud.getMotivo()}</td>
					<td>${solicitud.getPreferenciaHorario()}</td>
					</tr>
			</c:forEach>
	
		</table>
			<a class="boton" href="${pageContext.request.contextPath}/SolicitarAsesoriaCreate">Solicitar Asesoria</a>
			
			
		</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear solicitud de Asesoria</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.structure.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.theme.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../MenuCliente.jsp" />
	<div class="contenido">
		<h1>Vista Cliente: <c:out value='${sessionScope.nombreCliente}'/></h1>
			<h1>Crear solicitud de Asesoria</h1>
			<div class="mensajealerta">
				<c:if test="${cumensaje != null}">
					<c:out value="${cumensaje}" />
				</c:if>
			</div>
		<form action="SolicitarAsesoriaCreate" method="POST">	
			<table>
				<tr>
					<td>Fecha solicitud</td>
					<td><input type="text" name="fechaSolicitud" id="fecha" required readonly></td>
				</tr>
				<tr>
					<td>Motivo</td>
					<td><input type="text" name="motivo" required></td>
				</tr>
				<tr>
					<td>Preferencia horario</td>
					<td><input type="radio" id="Laboral" name="horario" value="Mañana">
					<label for="horario">Mañana</label>
					<input type="radio" id="Trayecto" name="horario" value="Tarde">
					<label for="horario">Tarde</label><br>
					</td>
				</tr>
				<tr>
					<td><input type="number" name="idCliente" value="${sessionScope.idCliente}" hidden="true" required>
					<input type="submit" value="Enviar"></td>
				</tr>
			</table>
		</form>
			
			
		</div>
	<jsp:include page="../footer.jsp" />
		<!-- SCRIPT -->
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jqueryUi/external/jquery/jquery.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.js"></script>
		<!-- SCRIPT DATEPIKER -->
			<script type="text/javascript">
				$("#fecha").datepicker({
					dateFormat: "dd-mm-yy"
				});
			</script>
</body>
</html>
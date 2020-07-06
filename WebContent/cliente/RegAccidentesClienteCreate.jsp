<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear Registro Accidente</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.structure.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.theme.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Cliente: <c:out value='${sessionScope.nombreCliente}'/></h1>
	<jsp:include page="../MenuCliente.jsp" />
	<div class="contenido">
	<h1>Crear Registro Accidente</h1>
		<div class="mensajealerta">
			<c:if test="${cumensaje != null}">
				<c:out value="${cumensaje}" />
			</c:if>
		</div>

	<form action="ReporteAccCreate" method="POST">
		<table>
			<tr>
				<td>Tipo accidente</td>
				<td><input type="radio" id="Laboral" name="tipoAccidente" value="Laboral">
				<label for="tipoAccidente">Laboral</label>
				<input type="radio" id="Trayecto" name="tipoAccidente" value="Trayecto">
				<label for="tipoAccidente">Trayecto</label><br>
				</td>
			</tr>
			<tr>
				<td>Cantidad días perdidos</td>
				<td><input type="number" name="diasPerdidos" min="0" max="365" required></td>
			</tr>
			<tr>
				<td>Fecha del Accidente</td>	
				<td><input type="text" name="fechaAccidente" id="fecha" required readonly></td>
			</tr>
			<tr>
				<td>Dirección del lugar del accidente</td>
				<td><input type="text" name="lugarAccidente" required></td>
			</tr>
			<tr>
				<td>Descripción de los hechos:</td>
				<td><textarea name="descripcion" rows="10" cols="20"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="number" name="idCliente" value="${sessionScope.idCliente}" hidden="true" required>
				<input type="submit" value="Registrar"></td>
			</tr>
		</table>
	</form>
	<a class="boton" href="${pageContext.request.contextPath}/ReportesAccReadAll">Volver</a>
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
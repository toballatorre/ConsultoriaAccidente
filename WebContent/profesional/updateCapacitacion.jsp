<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Capacitacion</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.structure.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.theme.css">
<style type="text/css">
	table, tr, td{
		border: 1px solid #000;
	}
	tr, td{
		padding: 0.2rem;
	}

	textarea{
		width: 95%;
		height: 100px;
		text-lign: left;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Revisar Actividad Mejora</h1>
	<jsp:include page="../MenuProfesional.jsp" />
	
	<!--  idcapacitacion, cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro -->
	<main>
	<form action="${pageContext.request.contextPath}/ActualizarCapacitacion" method="post" class="contenido">
		<table>
			<tr>
				<td>Tema:</td>
				<td> <input type="text" name="titulo" value="${cap.getTema()}"></td>
				<td> <input type="text" id="fecha" name="fecha" value="${cap.getFecha()}" readonly> </td>
			</tr>
			<tr>
				<td>Objetivos</td>
				<td colspan="2"> <textarea name="objetivos" id="objetivos"> <c:out value="${cap.getObjetivos()}"/> </textarea> </td>
			</tr>
			<tr>
				<td>Contenidos</td>
				<td colspan="2"> <textarea name="contenidos" id="contenidos"> <c:out value="${cap.getContenidos()}"/> </textarea> </td>
			</tr>
			<tr>
				<td>Recursos</td>
				<td colspan="2"> <textarea name="recursos" id="recursos"> <c:out value="${cap.getRecursos()}"/> </textarea> </td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Actualizar">
					<input type="hidden" name="idCap" value="${cap.getIdCapacitacion()}">
				</td>
			</tr>
		</table>
	</form>
	</main>
	
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
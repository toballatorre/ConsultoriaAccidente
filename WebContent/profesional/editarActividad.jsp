<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Actividad</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.structure.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jqueryUi/jquery-ui.theme.css">
<style type="text/css">

	textarea{
		width: 95%;
		height: 100px;
		text-lign: left;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Profesional</h1>
	<jsp:include page="../MenuProfesional.jsp" />
	
		<main>
		<form class="contenido" action="${pageContext.request.contextPath}/updateActividad" method="post">
			<table>
				<tr>
					<td> <label for="titulo">Titulo</label> </td>
					<td> <input type="text" id="titulo" name="titulo" value="${actividad.getTitulo()}"> </td>
					<td> <label for="fecha">Fecha de Plazo</label> </td>
					<td> <input type="text" id="fecha" name="fecha" value="${actividad.getFechaPlazo()}" readonly> </td>
				</tr>
				<tr>
					<td> Status </td>
					<td>
						<label for="realizado">Realizado</label>
						<c:choose>
							<c:when test="${actividad.getStatus() == 'Realizado'}">
								<input type="radio" name="status" id="realizado" value="Realizado" checked>
							</c:when>
							<c:otherwise>
								<input type="radio" name="status" id="realizado" value="Realizado">						
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<label for="pendiente">Pendiente</label>
						<c:choose>
							<c:when test="${actividad.getStatus() == 'Pendiente'}">
								<input type="radio" name="status" id="Pendiente" value="Pendiente" checked>							
							</c:when>
							<c:otherwise>
								<input type="radio" name="status" id="pendiente" value="pendiente">														
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<input type="hidden" name="idActividad" value="${actividad.getIdActividad()}">
					</td>
				</tr>
				<tr>
					<td colspan="4">Detalle</td>					
				</tr>
				<tr> 
					<td colspan="4"> <textarea name="detalle" id="detalle"> <c:out value="${actividad.getDescripcion()}"/> </textarea> </td> 
				</tr>
				<tr>

					<td colspan="4">Comentarios</td>					
				</tr>
				<tr> 
					<td colspan="4"> <textarea name="comentarios" id="comentarios"> <c:out value="${actividad.getComentario()}"/> </textarea> </td> 
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Actualizar"></td>
					
					<td colspan= "2"><input type="reset" value="Limpiar Campos"></td>
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
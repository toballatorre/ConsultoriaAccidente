<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Capacitacion</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<style type="text/css">
	table, tr, td{
		border: 1px solid #000;
	}
	tr, td{
		padding: 0.2rem;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Revisar Actividad Mejora</h1>
	<jsp:include page="../MenuProfesional.jsp" />
	
	<!--  idcapacitacion, cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro -->
	<main>
	<section class="contenido">
		<table>
			<tr>
				<td>Tema:</td>
				<td> <c:out value="${cap.getTema()}"/> </td>
				<td> <c:out value="${cap.getFecha()}"/> </td>
			</tr>
			<tr>
				<td>Objetivos</td>
				<td colspan="2"> <c:out value="${cap.getObjetivos()}"/> </td>
			</tr>
			<tr>
				<td>Contenidos</td>
				<td colspan="2"> <c:out value="${cap.getContenidos()}"/> </td>
			</tr>
			<tr>
				<td>Recursos</td>
				<td colspan="2"> <c:out value="${cap.getRecursos()}"/> </td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="#?id=${cap.getIdCapacitacion()}">Editar</a>
					<a href="#?id=${cap.getIdCapacitacion()}">Eliminar</a>
				</td>
			</tr>
		</table>
	</section>
	</main>
	
	<jsp:include page="../footer.jsp" />
	
</body>
</html>
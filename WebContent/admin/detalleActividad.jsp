<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Actividad</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<style type="text/css">
	table, tr, th, td{
		border: 1px solid #000;
	}
	th, td{
		padding: 0.2rem;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />
	
	<main>
		<section class="contenido">
			<table>
				<tr>
					<td>Titulo</td>
					<td> <c:out value="${actividad.getTitulo()}"/> </td>
					<td> <c:out value="${actividad.getFechaPlazo()}"></c:out> </td>
					<td> <c:out value="${actividad.getStatus()}"/> </td>
				</tr>
				<tr>
					<td> Descripción </td>
					<td colspan="3"> <c:out value="${actividad.getDescripcion()}"></c:out> </td>
				</tr>
				<tr>
					<td> Comentario </td>
					<td colspan="3"> <c:out value="${actividad.getComentario()}"></c:out> </td>
				</tr>
				<tr>
					<td colspan="4"> <a href="VisualizarActividades">Volver</a> </td>
				</tr>
			</table>
		</section>
	</main>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>
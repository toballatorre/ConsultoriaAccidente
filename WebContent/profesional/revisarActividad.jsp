<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Revisar Actividades</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
		<jsp:include page="../MenuProfesional.jsp" />
	<div class="contenido">
		<h1>Vista Profesional</h1>
		<h2>Revisar Actividad Mejora</h2>
			<table>
				<tr>
					<th>Titulo</th>
					<th>Fecha</th>
					<th>Status</th>
					<th>Eliminar</th>
					<th>Editar</th>
					
				</tr>
				<c:forEach items="${listaActividades}" var="actividad">
					<tr>
						<td> <c:out value="${actividad.getTitulo()}"/> </td>
						<td> <c:out value="${actividad.getFechaPlazo()}"/> </td>
						<td> <c:out value="${actividad.getStatus()}"/> </td>
						<td>
							<a href="eliminarActividad?idActividad=${actividad.getIdActividad()}"><i class="fas fa-trash-alt"></i></a>
							</td>
							<td>
							<a href="updateActividad?idActividad=${actividad.getIdActividad()}"><i class="fas fa-edit"></i></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	
	<jsp:include page="../footer.jsp" />
	
</body>
</html>
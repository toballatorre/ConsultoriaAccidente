<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Revisar Actividad Mejora</h1>
	<jsp:include page="../MenuProfesional.jsp" />
	
	<main>
		<section class="contenido">
			<table>
				<tr>
					<th>Titulo</th>
					<th>Fecha</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${listaActividades}" var="actividad">
					<tr>
						<td> <c:out value="${actividad.getTitulo()}"/> </td>
						<td> <c:out value="${actividad.getFechaPlazo()}"/> </td>
						<td> <c:out value="${actividad.getStatus()}"/> </td>
						<td>
							<a href="eliminarActividad?idActividad=${actividad.getIdActividad()}">Eliminar</a>
							<a href="updateActividad?idActividad=${actividad.getIdActividad()}">Editar</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		
		</section>
	</main>
	
	<jsp:include page="../footer.jsp" />
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Capacitaiones</title>
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
					<th> Tema </th>
					<th> Fecha </th>
					<th> Cliente </th>
					<th></th>
				</tr>
				<c:forEach items="${listaCap}" var="cap">
				<tr>
					<td> <c:out value="${cap.getTema()}"/> </td>
					<td> <c:out value="${cap.getFecha()}"/> </td>
					<td> 
							<c:forEach items="${listaCliente}" var="cliente">
								<c:if test="${cliente.getIdCliente() == cap.getIdClientePK()}">
									<c:out value="${cliente.getNombreEmpresa()}"></c:out>
								</c:if>
							</c:forEach>
					</td>
					<td>
						<a href="DetalleCapacitacion?id=${cap.getIdCapacitacion()}"> Detalle </a>
						&nbsp;
						<a href="EliminarCapacitacion?id=${cap.getIdCapacitacion()}"> Eliminar </a> 
					</td>
				</tr>
				</c:forEach>
			</table>
		</section>
	</main>
	
	<jsp:include page="../footer.jsp" />
	
</body>
</html>
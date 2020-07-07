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
	<jsp:include page="../MenuProfesional.jsp" />
	
	<div class="contenido">
		<h1>Vista Profesional</h1>
		<h2>Listar Capacitaciones</h2>
			<table>
				<tr>
					<th>Tema </th>
					<th>Fecha </th>
					<th>Cliente </th>
					<th>Detalle</th>
					<th>Eliminar</th>
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
						<a href="DetalleCapacitacion?id=${cap.getIdCapacitacion()}"><i class="fas fa-info-circle"></i></a>
					</td>
					<td>
						<a href="EliminarCapacitacion?id=${cap.getIdCapacitacion()}"><i class="fas fa-trash-alt"></i></a> 
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	
	<jsp:include page="../footer.jsp" />
	
</body>
</html>
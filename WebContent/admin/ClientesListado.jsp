<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado de Clientes</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Administrador</h1>
	<jsp:include page="../MenuAdmin.jsp" />
	<div class="contenido">
		<h1>Listado de Clientes Activos</h1>
		<div class="mensajealerta">
			<c:if test="${cumensaje != null}">
				<c:out value="${cumensaje}" />
			</c:if>
		</div>
	
		<table>
			<tr>
				<th>ID</th>
				<th>Nombre Empresa</th>
				<th>Accidentabilidad</th>
				<th>Editar Info</th>
				
			</tr>
	
			<c:forEach items="${listadoclientes}" var="cliente">
				<tr>
					<td>${cliente.getIdCliente()}</td>
					<td>${cliente.getNombreEmpresa()}</td>
					<td></td>
					<td></td>
					
					<td></td>
				</tr>
			</c:forEach>
	
		</table>
	

	</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
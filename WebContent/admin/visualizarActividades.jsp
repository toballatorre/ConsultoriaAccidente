<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizar Actividades</title>
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
					<th> Titulo </th>
					<th> Fecha </th>
					<th> Status </th>
					<th> Empresa </th>
				</tr>
				<c:forEach items="${lista}" var="actividad">
					<tr>
						<td> <c:out value="${actividad.getTitulo()}"/> </td>
						<td> <c:out value="${actividad.getFechaPlazo()}"/> </td>
						<td> <c:out value="${actividad.getStatus()}"/> </td>
						<c:forEach items="${listaC}" var="cliente">
							<c:if test="${actividad.getIdClientePk() == cliente.getIdCliente()}">
								<td>
									<c:out value="${cliente.getNombreEmpresa()}"/>								
								</td>						
							</c:if>
						</c:forEach>
						<td> <a href="DetalleActividad?id=${actividad.getIdActividad()}">Detalle</a> </td>
					</tr>				
				</c:forEach>
			</table>
		</section>
	</main>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listado de Profesionales</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
	<script src="https://kit.fontawesome.com/0a0085a95e.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../MenuAdmin.jsp" />
	<div class="contenido">
		<h1>Vista Administrador</h1>
		<h2>Información de Profesionales</h2>
		<div class="mensajealerta">
			<c:if test="${cumensaje != null}">
				<c:out value="${cumensaje}" />
			</c:if>
		</div>
	
		<table>
			<tr>
				<th>IdEmpleado</th>
				<th>Nombre</th>
				<th>IdUsuario</th>
				<th>Celular</th>
				<th>Editar</th>
			</tr>
	
			<c:forEach items="${listadoprofesionales}" var="prof">
				<tr>
					<td>${prof.getIdempleado()}</td>
					<td>${prof.getNombre()}</td>
					<td>${prof.getIdusuario()}</td>
					<td>${prof.getCelular()}</td>
					<td><a href="${pageContext.request.contextPath}/ProfEditar?idemp=${prof.getIdempleado()}"><i class="far fa-edit"></i></a></td>
				</tr>
			</c:forEach>
	
		</table>
	

	</div>
<jsp:include page="../footer.jsp" />
</body>
</html>
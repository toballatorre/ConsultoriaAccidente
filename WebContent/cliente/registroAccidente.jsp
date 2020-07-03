<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Accidente</title>
<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<h1>Vista Cliente</h1>
	<jsp:include page="../MenuCliente.jsp" />

	<h1>Registro Accidente</h1>

	<form action="slvRegistroAccidente" method="POST">
		<table>
			<tr>
				<td><input type="text" name="tipoAccidente"
					placeholder="Tipo Accidente"></td>
			</tr>
			<tr>
				<!-- Se obtiene la hora del servidor -->
				<c:set var="Ahora" value="<%=new java.util.Date()%>" />
				<!-- FORMATEO DE FECHA -->
				<fmt:formatDate value="${Ahora}" type="date" pattern="dd-MM-yyyy"
					var="fechaAhora" />
				<!-- FORMATEO DE HORA -->
				<fmt:formatDate value="${Ahora}" type="time" timeStyle="short"
					var="tiempoAhora" />

				<td><input type="number" name="diasPerdidos" placeholder="Días perdidos..." required></td>
			</tr>
			<tr>
				<td><input type="date" name="fechaAccidente" placeholder="${fechaAhora}" required></td>
			</tr>
			<tr>
				<td><input type="text" name="lugarAccidente"
					placeholder="Lugar del Accidente" required></td>
			</tr>
			<tr>
				<td><textarea name="descripcion" rows="10" cols="20"
						placeholder="Descripción del accidente..."></textarea></td>
			</tr>
			<!-- 
				Utilizamos la fecha y hora formateada para que se guarde el momento del registro
				<c:set var="fechaRegistro" value="${fechaAhora} - ${tiempoAhora}" />
				<td><input type="hidden" name="fechaRegistro" value="${fechaRegistro}"></td>
			 -->
			<tr>
				<td><input type="submit" value="Registrar"></td>
			</tr>
		</table>
	</form>

	<jsp:include page="../footer.jsp" />
</body>
</html>
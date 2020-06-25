<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejercicio G5</title>
<link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
<jsp:include page="../header.jsp" />
<h1>Vista Cliente</h1>
<jsp:include page="../ValidaUsuario.jsp" />
	
	<jsp:include page="../menu.jsp" />

	<h1>Registro Accidente</h1>
	
	<form action="RegistroAccidente" method="POST">
	<table>
		<tr>
			<td><input type="text" name="asunto" placeholder="Tipo Accidente"></td>
		</tr>
		<tr>
			<!-- Se obtiene la hora del servidor -->
			<c:set var="Ahora" value = "<%= new java.util.Date() %>"/>
			<!-- FORMATEO DE FECHA -->
			<fmt:formatDate value = "${Ahora}"
							type = "date"
							pattern ="dd-MM-yyyy"
							var ="fechaAhora"/>	
			<!-- FORMATEO DE HORA -->			
			<fmt:formatDate value ="${Ahora}"
							type = "time"
							timeStyle= "short"
							var = "tiempoAhora"/>

			<td><input type="date" name="fechaAccidente" placeholder="${fechaAhora}" required></td>
			<td><input type="time" name="horaAccidente" placeholder="${tiempoAhora}" required></td>		
		</tr>
		<tr>
			<td><input type="text" name="lugarAccidente" placeholder="Lugar del Accidente" required></td>
		</tr>
		<tr>
			<td><textarea name="detalleAccidente" rows="10" cols="20" placeholder="Detalle del accidente..."></textarea></td>		
		</tr>
		<tr>
			<!-- Utilizamos la fecha y hora formateada para que se guarde el momento del registro -->
			<c:set var="fechaRegistro" value = "${fechaAhora} - ${tiempoAhora}"/>
			<td><input type="hidden" name="fechaRegistro" value = "${fechaRegistro}"></td>
			<td><input type="submit" value="Registrar"></td>		
		</tr>
	</table>
	</form>
	
		<jsp:include page="../footer.jsp" />
</body>
</html>
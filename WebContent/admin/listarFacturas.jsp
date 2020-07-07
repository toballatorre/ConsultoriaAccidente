<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Facturas</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../MenuAdmin.jsp" />
	<div class="contenido">
		<h1>Vista Administrador: <c:out value='${sessionScope.nombreCliente}'/></h1>
		<h2>Facturas</h2>
			<table>
				<tr>
					<th>Nº Factura</th>
					<th>Fecha Emisión</th>
					<th>Fecha Vencimiento</th>
					<th>Fecha Pago</th>
					<th>Detalle</th>
				</tr>
				<c:forEach items="${listafactura}" var="factura">
					<tr>
						<td> <c:out value="${factura.getIdFactura()}"/> </td>
						<td> <c:out value="${factura.getFechaEmision()}"/> </td>
						<td> <c:out value="${factura.getFechaVencimiento()}"/> </td>
						<td> <c:out value="${factura.getFechaPago()}"/> </td>
						<td> <a href="DetalleFactura?id=${factura.getIdFactura()}"><i class="fab fa-wpforms"></i></a> </td>
					</tr>
				</c:forEach>
			</table>			
		</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>
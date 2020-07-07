<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DetalleFactura</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
	
	
</head>
<body>
	<jsp:include page="../header.jsp" />
	<jsp:include page="../MenuAdmin.jsp" />
	
	<div class="contenido">
		<h1>Vista Administrador: <c:out value='${sessionScope.nombreCliente}'/></h1>
		<table>
			<tr>
				<td colspan="4"> <h3>FACTURA Nº <c:out value="${factura.getIdFactura()}"/></h3> </td>
			</tr>
			<tr>
				<th>Nº Factura</th>
				<th>Fecha Emisión</th>
				<th>Fecha Vencimiento</th>
				<th>Fecha Pago</th>
			</tr>
			<tr>
				<td> <c:out value="${factura.getIdFactura()}"/> </td>
				<td> <c:out value="${factura.getFechaEmision()}"/> </td>
				<td> <c:out value="${factura.getFechaVencimiento()}"/> </td>
				<td> <c:out value="${factura.getFechaPago()}"/> </td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td colspan="6"> <h4>Detalle</h4> </td>
			</tr>
			<tr>
				<th> Código </th>
				<th> Concepto </th>
				<th> Precio Uitario</th>
				<th> Cantidad</th>
				<th> Subtotales</th>
				<th> Totales</th>
			</tr>
			<c:forEach items="${factura.getListaItem()}" var="item">
				<tr>
					<td> <c:out value="${item.getIdItem()}"/> </td>
					<td> <c:out value="${item.getConcepto()}"/> </td>
					<td> <c:out value="${item.getPrecioUnitario()}"/> </td>
					<td> <c:out value="${item.getCantidad()}"/> </td>
					<td> $ <c:out value="${factura.subTotales(item)}"/> </td>
					<td> $ <c:out value="${factura.Totales(item)}"/> </td>
				</tr>
			</c:forEach>
			<tr>
				<td> <h4>Subtotales </h4> </td>
				<td colspan="2"> <h4> $ <c:out value="${factura.subTotales()}"/> </h4></td>
				<td> <h4> Totales </h4></td>
				<td colspan="2"> <h4> $ <c:out value="${factura.Totales()}"/> </h4></td>
			</tr>
		</table>
		<a href="ListarFacturas"><i class="fas fa-undo-alt"></i> Volver</a>
	</div>
	
	<jsp:include page="../footer.jsp" />
</body>
</html>
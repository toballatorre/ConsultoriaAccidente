<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar usuario</title>
</head>
<body>

<h1>Editar usuario</h1>

<c:if test="${cumensaje != null}">
	<c:out value="${cumensaje}" />
</c:if>

<form action="EditarUsuario" method="post">
	Nombre: <input type="text" name="txtnombre" value="${datosusuario.getNombre()}" /><br/>
	Apellido: <input type="text" name="txtapellido" value="${datosusuario.getApellido()}" /> <br/>
	Telefono: <input type="text" name="txttelefono" value="${datosusuario.getTelefono()}" /> <br/>
	Correo electrónico: <input type="email" name="txtcorreo" value="${datosusuario.getCorreo()}" /> <br/>
	<input type="hidden" name="hdnidusuario"  value="${datosusuario.getId()}" />
	<input type="submit" value="Agregar usuario" />
</form>

<a href="${pageContext.request.contextPath}/ListarUsuarios">Volver al listado de usuarios</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>Vista Cliente</h1>
	<jsp:include page="MenuCliente.jsp" />
	
	<jsp:include page="footer.jsp" />
</body>
</html>
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
	<div class="contenido">
		<h1>Bienvenido</h1><br>
		<h3>Use alguno de estos usuarios para ingresar</h3>
			<p>U: admin1 P: 123</p>
			<p>U: admin2 P: 123</p>
			<p>U: cliente1 P: 123</p>
			<p>U: cliente2 P: 123</p>
			<p>U: prev1 P: 123</p>
			<p>U: prev2 P: 123</p>
			<br>
		<h2>No m�s Accidentabilidad</h2>
		<h3>Integrantes</h3>
			<p>Takeshi Kita - <a target="_blank" href="https://github.com/takeshidev">takeshidev</a></p>
			<p>Crist�bal Latorre - <a target="_blank" href="https://github.com/toballatorre">toballatorre</a></p>
			<br>
		<h3>Tema:</h3>
		<p>Construir aplicaciones web din�micas utilizando el entorno de desarrollo Java.</p>
		<br>
		<h3>Objetivos del proyecto:</h3>
		<p>Interpretar especificaciones de sistemas utilizando casos de uso para su posterior implementaci�n
		Construir una aplicaci�n web din�mica utilizando el patr�n MVC con vistas JSP y controladores Servlets para el despliegue de informaci�n.
		Realizar conexi�n a una base de datos din�mica de acuerdo a las especificaciones entregadas</p>
		<br>
		<h3>Casos de uso implementados:</h3>
		<ol>
			<li>CU1 - Mantener informaci�n Cliente</li>
			<li>CU2 - Mantener informaci�n profesionales</li>
			<li>CU3 - Crear capacitacion</li>
			<li>CU6 - Reportar accidente</li>
			<li>CU8 - Ingresar actividad mejora</li>
			<li>CU9 - Revisar actividad mejora</li>
			<li>CU10 - Controlar pagos cliente</li>
			<li>CU12 - Calcular accidentabildiad</li>
			<li>CU14 - Visualizar actividades</li>
			<li>CU16 - Solicitar asesoria especial</li>
		</ol>
		<br>
		<h3>Preparaci�n del proyecto</h3>
		<p>1. Iniciamos dise�ando el diagrama de casos de uso que se provey� en la asignaci�n del proyecto.</p>
		<img src="img/DiagramasModelos/CasosDeUso.jpg">
		
		<p>2. Creamos el diagrama de casos</p>
		<img src="img/DiagramasModelos/DiagramaCasodeUso.jpeg" width="90%">
		
		<p>3. Modelo de Datos</p>
		<p><a target="_blank" href="SQL/ScriptUnico.sql">Ver script base de datos</a></p>
		
		<img src="img/DiagramasModelos/Relational_1.png" width="90%">
		
		<p>4. Secuencias</p>
		<img src="img/DiagramasModelos/SecuanciaAdmin.jpg" width="90%">
		<img src="img/DiagramasModelos/SecuenciaCliente.jpg" width="90%">
		<img src="img/DiagramasModelos/SecuenciaProfesional.jpg" width="90%">
		
		<h3>GitHub</h3>
		<p><a target="blank" href="https://github.com/toballatorre/ConsultoriaAccidente.git">https://github.com/toballatorre/ConsultoriaAccidente.git</a></p>
		
		</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
		<c:when test="${empty sessionScope.user}">
			<jsp:include page="login.jsp" />
		</c:when>

		<c:otherwise>
			<p>Bienvenido ${sessionScope.user}</p>
			<form action="${pageContext.request.contextPath}/LogOut" method="get">
				<input type="submit" value="Logout">
			</form>

		</c:otherwise>

	</c:choose>
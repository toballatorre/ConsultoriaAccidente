		<form action="ValidarLogin" method="POST">
			<h2>Login</h2>
			<input type="text" name="user" id="user" placeholder="Usuario" required>
			<input type="password" name="pass" id="pass" placeholder="Clave" required>
			<input type="hidden" name="parametro" value="sesion">
			<input type="submit" value="Login">
		</form>
package model.usuarios;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void testValidar() {
		Usuario usuario = new Usuario();
		String user = "cliente";
		System.out.println(Arrays.toString(usuario.getArr()));
		
		assertEquals(true, usuario.validar(user), "mensaje");
		assertEquals(true, usuario.validar("cliente"), "mensaje");
		assertEquals(true, usuario.validar("admin"), "mensaje");
		assertEquals(true, usuario.validar("profesional"), "mensaje");
		assertEquals(false, usuario.validar(""), "mensaje");
		assertEquals(false, usuario.validar("aaaaa"), "mensaje");
		
		
		//fail("Not yet implemented");
	}

}

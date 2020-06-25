package model.usuarios;

public class Usuario {

	private String usuarios[] = { "cliente", "admin", "profesional" };

	public Usuario() {
		super();
	}
	
	public boolean validar(String user) {
		boolean status=false;
		for (String string : usuarios) {
			if (user.equals(string)) {
				status = true;
			}
		}
		if (status) {
			return true;
		} else {
			return false;
		}
	
	}

	public String[] getArr() {
		return usuarios;
	}




}

package modelo;

public class LoginDTO {

	
	/* ATRIBUTOS */
	private int idusuario;
	private String usuario;
	private String tipousuario;
	private String clave;
	private String mail;
	private String activo;
	
	
	public LoginDTO(int idusuario, String usuario, String tipousuario, String clave, String mail, String activo) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.tipousuario = tipousuario;
		this.clave = clave;
		this.mail = mail;
		this.activo = activo;
	}

	/*GET SET, yo solo quiero ser del JET SET*/
	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getTipousuario() {
		return tipousuario;
	}


	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getActivo() {
		return activo;
	}


	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	
}

package modelo;

public class UsuarioDTO {

	/* ATRIBUTOS */
	private int idusuario;
	private String usuario;
	private String tipousuario;
	private String clave;
	private String mail;
	private String activo;
	
	/*bob el CONSTRUCTOR */
	public UsuarioDTO() {
	}

	public UsuarioDTO(String usuario, String tipousuario, String clave, String mail, String activo) {
		super();
		this.usuario = usuario;
		this.tipousuario = tipousuario;
		this.clave = clave;
		this.mail = mail;
		this.activo = activo;
	}
	public UsuarioDTO(int idusuario, String usuario, String tipousuario, String clave, String mail, String activo) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.tipousuario = tipousuario;
		this.clave = clave;
		this.mail = mail;
		this.activo = activo;
	}
	
	/**
	 * Constructos sólo para traer dos datos necesarios para usarlo en el formulario para identificar el usuario con su nombre e identificadr único (id)
	 * @param idusuario
	 * @param usuario
	 */
	public UsuarioDTO(int idusuario, String usuario) {
		this.idusuario = idusuario;
		this.usuario = usuario;
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

	@Override
	public String toString() {
		return "UsuarioDTO [idusuario=" + idusuario + ", usuario=" + usuario + ", tipousuario=" + tipousuario
				+ ", clave=" + clave + ", mail=" + mail + ", activo=" + activo + "]";
	}
	
}

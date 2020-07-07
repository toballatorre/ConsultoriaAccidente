package modelo;

public class ProfesionalDTO {

	/* ATRIBUTOS */
	private int idempleado;
	private String nombre;
	private int idusuario;
	private String celular;
	
	/*bob el CONSTRUCTOR */
	
	public ProfesionalDTO() {
		super();
	}
	/* CON id*/	

	public ProfesionalDTO(int idempleado, String nombre, int idusuario, String celular) {
		super();
		this.idempleado = idempleado;
		this.nombre = nombre;
		this.idusuario = idusuario;
		this.celular = celular;
	}
	
	/*SIN id*/
	public ProfesionalDTO(String nombre, int idusuario, String celular) {
		super();
		this.nombre = nombre;
		this.idusuario = idusuario;
		this.celular = celular;
	}
	
	/*GET SET, yo solo quiero ser del JET SET*/
	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}

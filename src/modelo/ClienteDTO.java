package modelo;

public class ClienteDTO {

	/* ATRIBUTOS */
	private int idCliente;
	private String nombreEmpresa;
	private String rutEmpresa;
	private int idUsuario;

	/*bob el CONSTRUCTOR */

	public ClienteDTO() {
		super();
	}
	/* CON id*/	
	public ClienteDTO(int idCliente, String nombreEmpresa, String rutEmpresa, int idUsuario) {
		super();
		this.idCliente = idCliente;
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.idUsuario = idUsuario;
	}

	public ClienteDTO(String nombreEmpresa, String rutEmpresa, int idUsuario) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.idUsuario = idUsuario;
	}
	/*GET SET, yo solo quiero ser del JET SET*/
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getRutEmpresa() {
		return rutEmpresa;
	}
	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	

}

<<<<<<< HEAD
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
=======
package modelo;

public class ClienteDTO {
	
	private int idCliente;
	private String NombreEmpresa;
	private int RutEmpresa;
	private int idUsuarioPK;
	
	/* CONSTRUCTOR */
	public ClienteDTO() {
	}
	
	public ClienteDTO(int idCliente, String nombreEmpresa, int rutEmpresa, int idUsuarioPK) {
		this.idCliente = idCliente;
		NombreEmpresa = nombreEmpresa;
		RutEmpresa = rutEmpresa;
		this.idUsuarioPK = idUsuarioPK;
	}
	
	public ClienteDTO(int idCliente, String nombreEmpresa) {
		this.idCliente = idCliente;
		NombreEmpresa = nombreEmpresa;
	}

	/* GET AND SET */
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreEmpresa() {
		return NombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}

	public int getRutEmpresa() {
		return RutEmpresa;
	}

	public void setRutEmpresa(int rutEmpresa) {
		RutEmpresa = rutEmpresa;
	}

	public int getIdUsuarioPK() {
		return idUsuarioPK;
	}

	public void setIdUsuarioPK(int idUsuarioPK) {
		this.idUsuarioPK = idUsuarioPK;
	}

	/* TO STRING */
	@Override
	public String toString() {
		return "ClienteDTO [idCliente=" + idCliente + ", NombreEmpresa=" + NombreEmpresa + ", RutEmpresa=" + RutEmpresa
				+ ", idUsuarioPK=" + idUsuarioPK + "]";
	}
		
}
>>>>>>> toballatorre05

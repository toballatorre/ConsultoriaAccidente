package modelo;

public class RegistroAccidente {
	
	/* ATRIBUTOS */
	private int idReporte;
	private String tipoAccidente;
	private int diasPerdidos;
	private String fechaAccidente;
	private String lugarAccidente;
	private String descripcion;
	private int pkIdCliente;
	
	/* CONSTRUCTORES */
	public RegistroAccidente() {
	}
	
	/* Todos los campos */
	public RegistroAccidente(int idReporte, String tipoAccidente, int diasPerdidos, String fechaAccidente,
			String lugarAccidente, String descripcion, int pkIdCliente) {
		this.idReporte = idReporte;
		this.tipoAccidente = tipoAccidente;
		this.diasPerdidos = diasPerdidos;
		this.fechaAccidente = fechaAccidente;
		this.lugarAccidente = lugarAccidente;
		this.descripcion = descripcion;
		this.pkIdCliente = pkIdCliente;
	}
	/* Sin el campo id */
	public RegistroAccidente(String tipoAccidente, int diasPerdidos, String fechaAccidente, String lugarAccidente,
			String descripcion, int pkIdCliente) {
		this.tipoAccidente = tipoAccidente;
		this.diasPerdidos = diasPerdidos;
		this.fechaAccidente = fechaAccidente;
		this.lugarAccidente = lugarAccidente;
		this.descripcion = descripcion;
		this.pkIdCliente = pkIdCliente;
	}
	
	/* GET n' SET*/
	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public String getTipoAccidente() {
		return tipoAccidente;
	}

	public void setTipoAccidente(String tipoAccidente) {
		this.tipoAccidente = tipoAccidente;
	}

	public int getDiasPerdidos() {
		return diasPerdidos;
	}

	public void setDiasPerdidos(int diasPerdidos) {
		this.diasPerdidos = diasPerdidos;
	}

	public String getFechaAccidente() {
		return fechaAccidente;
	}

	public void setFechaAccidente(String fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}

	public String getLugarAccidente() {
		return lugarAccidente;
	}

	public void setLugarAccidente(String lugarAccidente) {
		this.lugarAccidente = lugarAccidente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPkIdCliente() {
		return pkIdCliente;
	}

	public void setPkIdCliente(int pkIdCliente) {
		this.pkIdCliente = pkIdCliente;
	}
	
	
	
}

package modelo;

import java.sql.Date;

public class CapacitacionDTO {

	private int idCapacitacion;
	private int idClientePK;
	private String tema;
	private String objetivos;
	private String contenidos;
	private String recursos;
	private Date fecha;
	private int idProfesionalPK;
	
	/* CONSTRUCTORES */
	public CapacitacionDTO() {
	}
	
	public CapacitacionDTO(int idCapacitacion, int idClientePK, String tema, String objetivos, String contenidos,
			String recursos, Date fecha, int idProfesionalPK) {
		this.idCapacitacion = idCapacitacion;
		this.idClientePK = idClientePK;
		this.tema = tema;
		this.objetivos = objetivos;
		this.contenidos = contenidos;
		this.recursos = recursos;
		this.fecha = fecha;
		this.idProfesionalPK = idProfesionalPK;
	}
	
	public CapacitacionDTO(int idCapacitacion, int idClientePK, String tema, String objetivos, String contenidos,
			String recursos, Date fecha, int idProfesionalPK, String nombreCliente) {
		this.idCapacitacion = idCapacitacion;
		this.idClientePK = idClientePK;
		this.tema = tema;
		this.objetivos = objetivos;
		this.contenidos = contenidos;
		this.recursos = recursos;
		this.fecha = fecha;
		this.idProfesionalPK = idProfesionalPK;
	}

	/* GET AND SET*/

	public int getIdCapacitacion() {
		return idCapacitacion;
	}
	public void setIdCapacitacion(int idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}
	public int getIdClientePK() {
		return idClientePK;
	}
	public void setIdClientePK(int idClientePK) {
		this.idClientePK = idClientePK;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	public String getContenidos() {
		return contenidos;
	}
	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}
	public String getRecursos() {
		return recursos;
	}
	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdProfesionalPK() {
		return idProfesionalPK;
	}
	public void setIdProfesionalPK(int idProfesionalPK) {
		this.idProfesionalPK = idProfesionalPK;
	}
	
	/* TO STRING */
	@Override
	public String toString() {
		return "capacitacionDTO [idCapacitacion=" + idCapacitacion + ", idClientePK=" + idClientePK + ", tema=" + tema
				+ ", objetivos=" + objetivos + ", contenidos=" + contenidos + ", recursos=" + recursos + ", fecha="
				+ fecha + ", idProfesionalPK=" + idProfesionalPK + "]";
	}
	
	
	
}

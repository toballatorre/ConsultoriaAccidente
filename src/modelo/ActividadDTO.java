package modelo;

import java.sql.Date;

public class ActividadDTO {
	 /* ATRIBUTOS */
	private int idActividad;
	private String titulo;
	private String descripcion;
	private Date fechaPlazo;
	private String status;
	private String comentario;
	private int idClientePk;
	
	/* CONSTRUCTORES */
	
	// Vacío
	public ActividadDTO() {
	}
	
	// Todos los atributos
	public ActividadDTO(int idActividad, String titulo, String descripcion, Date fechaPlazo, String status,
			String comentario, int idClientePk) {
		this.idActividad = idActividad;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaPlazo = fechaPlazo;
		this.status = status;
		this.comentario = comentario;
		this.idClientePk = idClientePk;
	}
	
	public ActividadDTO(String titulo, String descripcion, Date fechaPlazo, String status, String comentario,
			int idClientePk) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaPlazo = fechaPlazo;
		this.status = status;
		this.comentario = comentario;
		this.idClientePk = idClientePk;
	}

	// GET N' SET
	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaPlazo() {
		return fechaPlazo;
	}

	public void setFechaPlazo(Date fechaPlazo) {
		this.fechaPlazo = fechaPlazo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdClientePk() {
		return idClientePk;
	}

	public void setIdClientePk(int idClientePk) {
		this.idClientePk = idClientePk;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "ActividadDTO [idActividad=" + idActividad + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", fechaPlazo=" + fechaPlazo + ", status=" + status + ", comentario=" + comentario + ", idClientePk="
				+ idClientePk + "]";
	}	
}

package modelo;

import java.sql.Date;

public class SolicitudAsesoriaDTO {

	/* ATRIBUTOS */
	private int idSoliticud;
	private Date fechaHora;
	private String motivo;
	private String preferenciaHorario;
	private int idCliente;

	/*bob el CONSTRUCTOR */
	public SolicitudAsesoriaDTO() {
		super();
	}

	/*bob el CONSTRUCTOR  SIN id*/
	public SolicitudAsesoriaDTO(Date fechaHora, String motivo, String preferenciaHorario, int idCliente) {
		super();
		this.fechaHora = fechaHora;
		this.motivo = motivo;
		this.preferenciaHorario = preferenciaHorario;
		this.idCliente = idCliente;
	}

	/*bob el CONSTRUCTOR  CON id*/
	public SolicitudAsesoriaDTO(int idSoliticud, Date fechaHora, String motivo, String preferenciaHorario,
			int idCliente) {
		super();
		this.idSoliticud = idSoliticud;
		this.fechaHora = fechaHora;
		this.motivo = motivo;
		this.preferenciaHorario = preferenciaHorario;
		this.idCliente = idCliente;
	}

	/*GET SET, yo solo quiero ser del jet set*/
	public int getIdSoliticud() {
		return idSoliticud;
	}

	public void setIdSoliticud(int idSoliticud) {
		this.idSoliticud = idSoliticud;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getPreferenciaHorario() {
		return preferenciaHorario;
	}

	public void setPreferenciaHorario(String preferenciaHorario) {
		this.preferenciaHorario = preferenciaHorario;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	

	
	
	
}

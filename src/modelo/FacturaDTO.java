package modelo;

import java.sql.Date;
import java.util.List;

public class FacturaDTO {

	/* CONSTANTE */
	private final float IVA = 0.19f;
	
	/* CABECERA */
	private int idFactura;
	private int cliente_idCliente;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Date fechaPago;
	
	/* DETALLE */
	private List<ItemDTO> listaItem = null;

	/* CONSTRUCTORES */
	public FacturaDTO() {
	}

	public FacturaDTO(int idFactura, int cliente_idCliente, Date fechaEmision, Date fechaVencimiento, Date fechaPago,
			List<ItemDTO> listaItem) {
		this.idFactura = idFactura;
		this.cliente_idCliente = cliente_idCliente;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaPago = fechaPago;
		this.listaItem = listaItem;
	}

	/* GET AND SET */
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCliente_idCliente() {
		return cliente_idCliente;
	}

	public void setCliente_idCliente(int cliente_idCliente) {
		this.cliente_idCliente = cliente_idCliente;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public List<ItemDTO> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemDTO> listaItem) {
		this.listaItem = listaItem;
	}

	public float getIVA() {
		return IVA;
	}
	
	/* METODOS */
	/**
	 * Retorna el subtotal de todos los itemes
	 * @return
	 */
	public float subTotales() {
		float total = 0;
		
		for (ItemDTO i : listaItem) {
			total += (i.getCantidad() * i.getPrecioUnitario());
		}
		
		return total;
	}
	
	/**
	 * Retorna el subtotal de un item en específico
	 * @param i ItemDTO a calcular
	 * @return
	 */
	public float subTotales(ItemDTO i) {
		return (i.getCantidad() * i.getPrecioUnitario());
	}
	
	/**
	 * Retorna el total de todos los itemes
	 * @return
	 */
	public float Totales() {
		float total = 0;
		
		for (ItemDTO i : listaItem) {
			total += ((i.getCantidad() * i.getPrecioUnitario())*(1+IVA));
		}
		
		return total;
	}
	/**
	 * Retorna el total de un item en específico
	 * @param i ItemDTO a calcular
	 * @return
	 */
	public float Totales(ItemDTO i) {
		return ((i.getCantidad() * i.getPrecioUnitario())*(1+IVA));
	}
	
}

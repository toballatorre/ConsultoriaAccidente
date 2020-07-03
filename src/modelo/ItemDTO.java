package modelo;

public class ItemDTO {
	
	/* ATRIBUTOS */
	private int idItem;
	private String concepto;
	private float precio;
	private int cantidad;
	private int idFracturaPK;
	
	/* CONSTRUCTORES */
	public ItemDTO() {
		
	}
	
	public ItemDTO(String concepto, float precio, int cantidad) {
		this.concepto = concepto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public ItemDTO(int idItem, String concepto, float precio, int cantidad, int idFracturaPK) {
		this.idItem = idItem;
		this.concepto = concepto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.idFracturaPK = idFracturaPK;
	}

	/* GET SET */
	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdFracturaPK() {
		return idFracturaPK;
	}

	public void setIdFracturaPK(int idFracturaPK) {
		this.idFracturaPK = idFracturaPK;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", concepto=" + concepto + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", idFracturaPK=" + idFracturaPK + "]";
	}
		
}


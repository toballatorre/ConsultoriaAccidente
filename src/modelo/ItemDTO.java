package modelo;

public class ItemDTO {
	
	/* ATRIBUTOS */
	private int idItem;
	private String concepto;
	private float precioUnitario;
	private int cantidad;
	private int factira_facturaId;
	
	/* CONSTRUCTORES */
	public ItemDTO() {
	}

	public ItemDTO(int idItem, String concepto, float precioUnitario, int cantidad, int factira_facturaId) {
		this.idItem = idItem;
		this.concepto = concepto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.factira_facturaId = factira_facturaId;
	}

	/* GET AND SET */
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

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getFactira_facturaId() {
		return factira_facturaId;
	}

	public void setFactira_facturaId(int factira_facturaId) {
		this.factira_facturaId = factira_facturaId;
	}

	@Override
	public String toString() {
		return "ItemDTO [idItem=" + idItem + ", concepto=" + concepto + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", factira_facturaId=" + factira_facturaId + "]";
	}
			
}


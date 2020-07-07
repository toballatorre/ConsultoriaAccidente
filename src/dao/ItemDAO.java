package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.ItemDTO;

public class ItemDAO implements IObjectDao<ItemDTO> {
	
	private static final String SQL_INSERT = "INSERT INTO item (iditem, concepto, preciounit, cantidad, factura_idfactura) VALUES(?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM item WHERE iditem = ?";
	private static final String SQL_UPDATE = "UPDATE item SET concepto = ?, preciounit = ?, cantidad = ? WHERE iditem = ?";
	private static final String SQL_READ = "SELECT * FROM item WHERE iditem = ?";
	private static final String SQL_READALL = "SELECT * FROM item";
	private static final String SQL_READALLBYFACTURA = "SELECT * FROM item WHERE factura_idfactura = ?";
	
	private static final Conexion con = Conexion.connect();

	@Override
	public boolean create(ItemDTO o) {
		
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			
			ps= con.getConection().prepareStatement(SQL_INSERT);
			ps.setInt(1, o.getIdItem());
			ps.setString(2, o.getConcepto());
			ps.setFloat(3, o.getPrecioUnitario());
			ps.setInt(4, o.getCantidad());
			ps.setInt(5, o.getFactira_facturaId());
			
			if(ps.execute())
				creado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO create()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return creado;
	}

	@Override
	public boolean delete(Object key) {
		
		boolean eliminado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_DELETE);
			ps.setString(1, key.toString());
			
			if(ps.execute())
				eliminado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO delete()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		} 		
		
		return eliminado;
	}

	@Override
	public boolean update(ItemDTO o) {
		
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {

			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getConcepto());
			ps.setFloat(2, o.getPrecioUnitario());
			ps.setInt(3, o.getCantidad());
			ps.setInt(4, o.getIdItem());
			
			if (ps.execute())
				actualizado = true;
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO update()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return actualizado;
	}

	@Override
	public ItemDTO read(Object key) {
		
		PreparedStatement ps;
		ResultSet res;
		ItemDTO item = null;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
						
			while(res.next())
				item = new ItemDTO(res.getInt("iditem"), res.getString("concepto"), res.getFloat("preciounit"), res.getInt("cantidad"), res.getInt("factura_idfactura"));
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO read()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return item;
	}

	@Override
	public List<ItemDTO> readAll() {
		
		ArrayList<ItemDTO> listaItems = new ArrayList<ItemDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next())
				listaItems.add(new ItemDTO(res.getInt("iditem"), res.getString("concepto"), res.getFloat("preciounit"), res.getInt("cantidad"), res.getInt("factura_idfactura")));
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO readAll()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return listaItems;
	}
	
public List<ItemDTO> readAllByIdFactura(Object key) {
		
		ArrayList<ItemDTO> listaItems = new ArrayList<ItemDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALLBYFACTURA);
			ps.setString(1, key.toString());
			res = ps.executeQuery();
			
			while(res.next())
				listaItems.add(new ItemDTO(res.getInt("iditem"), res.getString("concepto"), res.getFloat("preciounit"), res.getInt("cantidad"), res.getInt("factura_idfactura")));
			
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO readAll()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return listaItems;
	}


}

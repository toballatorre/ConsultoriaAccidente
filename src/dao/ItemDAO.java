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
	
	private static final String SQL_INSERT = "INSERT INTO item (concepto, precio, cantidad, factura_idfactura) VALUES(?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM item WHERE iditem = ?";
	private static final String SQL_UPDATE = "UPDATE item SET concepto = ?, precio = ?, cantidad = ? WHERE iditem = ?";
	private static final String SQL_READ = "SELECT * FROM item WHERE iditem = ?";
	private static final String SQL_READALL = "SELECT * FROM item";
	
	private static final Conexion con = Conexion.connect();

	@Override
	public boolean create(ItemDTO o) {
		boolean creado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_INSERT);
			ps.setString(1, o.getConcepto());
			ps.setFloat(2, o.getPrecio());
			ps.setInt(3, o.getCantidad());
			ps.setInt(4, o.getIdFracturaPK());	
			
			if (ps.executeUpdate() > 0) {
				creado = true;
			}
			
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
		boolean borrado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_DELETE);
			ps.setString(1, key.toString());
			
			if(ps.executeUpdate() > 0)
				borrado = true;
			
		} catch (Exception e) {
			System.out.println("Error: ItemDAO delete()");
			e.printStackTrace();
			
		}finally {
			con.closeConnection();
		}
		
		return borrado;
	}

	@Override
	public boolean update(ItemDTO o) {
		
		boolean actualizado = false;
		PreparedStatement ps;
		
		try {
			ps = con.getConection().prepareStatement(SQL_UPDATE);
			ps.setString(1, o.getConcepto());
			ps.setFloat(2, o.getPrecio());
			ps.setInt(3, o.getCantidad());
			ps.setInt(4, o.getIdItem());
			
			if(ps.executeUpdate() > 0) {
				actualizado = true;
			}
		}catch (Exception e) {
			System.out.println("Error: ItemDAO update()");
			e.printStackTrace();
			
		}finally {
			con.closeConnection();
		}
		
		return actualizado;
	}

	@Override
	public ItemDTO read(Object key) {
		ItemDTO i = null;
		
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			
			while(res.next()) {
				i = new ItemDTO(res.getInt("iditem"), res.getString("concepto"), res.getFloat("precio"), res.getInt("cantidad"), res.getInt("factura_idfactura"));
			}
		} catch (SQLException e) {
			System.out.println("Error: ItemDAO read()");
			e.printStackTrace();
		}finally {
			con.closeConnection();
		}
				
		return i;
	}

	@Override
	public List<ItemDTO> readAll() {
		ArrayList<ItemDTO> listaItem = new ArrayList<ItemDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next()) {
				listaItem.add(new ItemDTO(res.getInt("iditem"), res.getString("concepto"), res.getFloat("precio"), res.getInt("cantidad"), res.getInt("factura_idfactura")));
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error: ItemDAO readAll");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}

		return listaItem;
	}

}

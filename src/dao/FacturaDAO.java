package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectar.Conexion;
import idao.IObjectDao;
import modelo.FacturaDTO;
import modelo.ItemDTO;

public class FacturaDAO implements IObjectDao<FacturaDTO> {
	
	private static final String SQL_READ = "SELECT * FROM factura WHERE factura.idfactura = ?";
	private static final String SQL_READALL = "SELECT * FROM factura";
	
	private static final Conexion con = Conexion.connect();
	
	@Override
	public boolean create(FacturaDTO o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(FacturaDTO o) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Lee una factura y obtiene todos los itemes que tiene relacionado
	 */
	@Override
	public FacturaDTO read(Object key) {
		
		PreparedStatement ps;
		ResultSet res;
		FacturaDTO factura = null;
		List<ItemDTO> listaItemes = new ArrayList<ItemDTO>();
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READ);
			ps.setString(1, key.toString());
			
			res = ps.executeQuery();
			
			while(res.next()) {
				factura = new FacturaDTO(res.getInt("idfactura"), res.getInt("cliente_idcliente"), res.getDate("fechaemision"), res.getDate("fechaVencimiento"), res.getDate("fechaPago"), null);
				listaItemes = new ItemDAO().readAllByIdFactura(res.getInt("idfactura"));
			}
			
			factura.setListaItem(listaItemes);
			
		} catch (SQLException e) {
			System.out.println("");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
		
		return factura;
	}
	
	/**
	 * Solo trae los datos de la factura para luego ser listado
	 */
	@Override
	public List<FacturaDTO> readAll() {
		
		List<FacturaDTO> listaFactura = new ArrayList<FacturaDTO>();
		PreparedStatement ps;
		ResultSet res;
		
		try {
			
			ps = con.getConection().prepareStatement(SQL_READALL);
			res = ps.executeQuery();
			
			while(res.next())
				listaFactura.add(new FacturaDTO(res.getInt("idfactura"), res.getInt("cliente_idcliente"), res.getDate("fechaemision"), res.getDate("fechaVencimiento"), res.getDate("fechaPago"), null));
			
		} catch (SQLException e) {
			System.out.println("Error: FacturaDAO readAll()");
			e.printStackTrace();
		} finally {
			con.closeConnection();
		}
			
		return listaFactura;
	}

}

package pruebas;

import java.util.ArrayList;
import java.util.List;

import dao.FacturaDAO;
import dao.ItemDAO;
import modelo.FacturaDTO;
import modelo.ItemDTO;

public class Prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ItemDAO item = new ItemDAO();
		ItemDTO itembuscado = item.read(11);
		System.out.println(itembuscado.getConcepto());
		
		
		
		UsuarioDAO itemdao = new UsuarioDAO();
		UsuarioDTO userbuscado = itemdao.obtenerUsuario(5) ;
		System.out.println(userbuscado.getIdusuario()+" "+userbuscado.getUsuario()+" "+userbuscado.getMail()+" "+userbuscado.getTipousuario());*/
		
		
		/*UsuarioDAO uDAO = new UsuarioDAO();
		List<UsuarioDTO> listaUsuarios = new ArrayList<UsuarioDTO>();
		listaUsuarios = uDAO.readAll();
		
		for (UsuarioDTO u : listaUsuarios) {
			System.out.println(u.toString());
		}*/
		/*
		ReporteAccidenteDAO reportedao = new ReporteAccidenteDAO();
		List<ReporteAccidenteDTO> lreportes = new ArrayList<ReporteAccidenteDTO>();
		lreportes = reportedao.readAll(2);
		
		for (ReporteAccidenteDTO u : lreportes) {
			System.out.println(u.toString());
		}*/
		
		/*
		UsuarioDAO uDAO = new UsuarioDAO();
		UsuarioDTO uDTO = uDAO.readUsername("admin1");
		System.out.println(uDTO.toString());
		*/
		/*
		FacturaDAO fDAO = new FacturaDAO();
		FacturaDTO factura =  new FacturaDTO();
		factura = fDAO.read(13);
		String f = factura.toString();
		System.out.println(f);
		for (ItemDTO i : factura.getListaItem()) {
			System.out.println(i.toString());
		}*/
	}

}

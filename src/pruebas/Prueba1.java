package pruebas;

import dao.ItemDAO;
import modelo.ItemDTO;
import dao.LoginDAO;
import modelo.LoginDTO;

public class Prueba1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemDAO item = new ItemDAO();
		ItemDTO itembuscado = item.read(11);
		System.out.println(itembuscado.getConcepto());
		
		
		
		
		
	}

}

package controller.profesional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import dao.profesional.CapacitacionDAO;
import modelo.CapacitacionDTO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class ListarCapacitaciones
 */
@WebServlet("/ListarCapacitaciones")
public class ListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		int idUser = Integer.parseInt(sesion.getAttribute("idUsuario").toString());
		
		
		List<CapacitacionDTO> listaCapacitacion = new ArrayList<CapacitacionDTO>();
		CapacitacionDAO cDAO = new CapacitacionDAO();
				
		listaCapacitacion = cDAO.readAllByProf(idUser);
		
		ClienteDAO clDAO = new ClienteDAO();
		List<ClienteDTO> listaCliente =  clDAO.readAll();
		
		request.setAttribute("listaCliente", listaCliente);
		request.setAttribute("listaCap", listaCapacitacion);
		request.getRequestDispatcher("/profesional/listarCapacitaciones.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

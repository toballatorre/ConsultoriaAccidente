package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.profesional.ActividadDAO;
import modelo.ActividadDTO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class VisualizarActividades
 */
@WebServlet("/VisualizarActividades")
public class VisualizarActividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizarActividades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ActividadDTO> listaActividades = new ArrayList<ActividadDTO>();
		ActividadDAO aDAO = new ActividadDAO();
		
		listaActividades = aDAO.readAll();
		
		ClienteDAO cDAO = new ClienteDAO();
		List<ClienteDTO> listaClientes = cDAO.readAll();
		
		
		request.setAttribute("listaC", listaClientes);
		request.setAttribute("lista", listaActividades);
		request.getRequestDispatcher("/admin/visualizarActividades.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

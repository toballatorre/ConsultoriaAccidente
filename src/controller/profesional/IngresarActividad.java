package controller.profesional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import dao.profesional.ActividadDAO;
import modelo.ActividadDTO;
import modelo.ClienteDTO;
import utilidades.FechaSQL;


/**
 * Servlet implementation class IngresarActividad
 */
@WebServlet("/IngresarActividad")
public class IngresarActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO uDAO = new UsuarioDAO();
		List<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();
		
		listaClientes = uDAO.readCliente();
		
		request.setAttribute("listaClientes", listaClientes);
		request.getRequestDispatcher("/profesional/ingresarActividad.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		
		String fecha = request.getParameter("fecha");
		java.sql.Date sqlFecha = new FechaSQL().toSQL(fecha); // convierte la fecha a formato compatible con SQL
				
		String status = request.getParameter("status");
		int clienteId = Integer.parseInt(request.getParameter("cliente"));
		String detalle = request.getParameter("detalle");
		String comentarios = request.getParameter("comentarios");
		
		ActividadDTO actividad = new ActividadDTO(titulo, detalle, sqlFecha, status, comentarios, clienteId);
		ActividadDAO aDAO = new ActividadDAO();
		
		aDAO.create(actividad);
		
		doGet(request, response);
	}

}

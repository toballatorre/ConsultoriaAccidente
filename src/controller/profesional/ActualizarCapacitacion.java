package controller.profesional;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.profesional.CapacitacionDAO;
import modelo.CapacitacionDTO;

/**
 * Servlet implementation class ActualizarCapacitacion
 */
@WebServlet("/ActualizarCapacitacion")
public class ActualizarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idCap = Integer.parseInt(request.getParameter("id"));
		
		CapacitacionDAO cDAO = new CapacitacionDAO();
		CapacitacionDTO capacitacion = cDAO.read(idCap);
		
		request.setAttribute("cap", capacitacion);
		request.getRequestDispatcher("/profesional/updateCapacitacion.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idCap = Integer.parseInt(request.getParameter("idCap"));
		String titulo = request.getParameter("titulo");
		String objetivos = request.getParameter("objetivos");
		String contenidos = request.getParameter("contenidos");
		String recursos = request.getParameter("recursos");
		
		CapacitacionDTO cap = new CapacitacionDTO(idCap, titulo, objetivos, contenidos, recursos);
		CapacitacionDAO cDAO = new CapacitacionDAO();
		cDAO.update(cap);
	
		request.getRequestDispatcher("/ListarCapacitaciones").forward(request, response);

	}

}

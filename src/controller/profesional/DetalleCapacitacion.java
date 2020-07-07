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
 * Servlet implementation class DetalleCapacitacion
 */
@WebServlet("/DetalleCapacitacion")
public class DetalleCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleCapacitacion() {
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
		request.getRequestDispatcher("/profesional/detalleCapacitacion.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
	}

}

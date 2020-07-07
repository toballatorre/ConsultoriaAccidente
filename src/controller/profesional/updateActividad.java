package controller.profesional;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.profesional.ActividadDAO;
import modelo.ActividadDTO;

/**
 * Servlet implementation class updateActividad
 */
@WebServlet("/updateActividad")
public class updateActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		
		ActividadDAO aDAO = new ActividadDAO();
		ActividadDTO actividad = aDAO.read(idActividad);
		
		request.setAttribute("actividad", actividad);
		request.getRequestDispatcher("profesional/editarActividad.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String status = request.getParameter("status");
		String detalle = request.getParameter("detalle");
		String comentario = request.getParameter("comentarios");
		int idActividad = Integer.parseInt(request.getParameter("idActividad"));
		
		ActividadDTO actividad = new ActividadDTO(idActividad, titulo, detalle, status, comentario);
		ActividadDAO aDAO = new ActividadDAO();
		aDAO.update(actividad);
		
		response.sendRedirect(getServletContext().getContextPath()+"/revisarActividades");
	}

}

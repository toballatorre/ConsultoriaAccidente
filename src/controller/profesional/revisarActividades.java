package controller.profesional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.profesional.ActividadDAO;
import modelo.ActividadDTO;

/**
 * Servlet implementation class revisarAccidente
 */
@WebServlet("/revisarActividades")
public class revisarActividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public revisarActividades() {
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
		
		request.setAttribute("listaActividades", listaActividades);
		request.getRequestDispatcher("/profesional/revisarActividad.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

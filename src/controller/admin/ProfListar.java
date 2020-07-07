package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfesionalDAO;
import modelo.ProfesionalDTO;

/**
 * Servlet implementation class ProfListar
 */
@WebServlet("/ProfListar")
public class ProfListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listando profesionales");
		ProfesionalDAO profdao = new ProfesionalDAO();
		List<ProfesionalDTO> lprofesionales = new ArrayList<ProfesionalDTO>();
		
		lprofesionales = profdao.readAll();
		
		request.setAttribute("listadoprofesionales", lprofesionales);
		request.getRequestDispatcher("admin/ProfesionalesListar.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

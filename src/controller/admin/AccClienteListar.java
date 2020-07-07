package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReporteAccidenteDAO;
import modelo.ReporteAccidenteDTO;

/**
 * Servlet implementation class AccClienteListar
 */
@WebServlet("/AccClienteListar")
public class AccClienteListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccClienteListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		System.out.println("Accidentabilidad cliente: "+idcliente);
		
		ReporteAccidenteDAO reportedao = new ReporteAccidenteDAO();
		List<ReporteAccidenteDTO> lreportes = new ArrayList<ReporteAccidenteDTO>();
		lreportes = reportedao.readAllIdClient(idcliente);
		
		request.setAttribute("listadoreportes", lreportes);
		request.getRequestDispatcher("admin/AccidentesListar.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

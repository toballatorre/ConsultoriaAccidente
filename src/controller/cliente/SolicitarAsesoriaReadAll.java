package controller.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReporteAccidenteDAO;
import dao.SolicitudAsesoriaDAO;
import modelo.ReporteAccidenteDTO;
import modelo.SolicitudAsesoriaDTO;

/**
 * Servlet implementation class SolicitarAsesoriaReadAll
 */
@WebServlet("/SolicitarAsesoriaReadAll")
public class SolicitarAsesoriaReadAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitarAsesoriaReadAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SolicitudAsesoriaDAO solicituddao = new SolicitudAsesoriaDAO();
		List<SolicitudAsesoriaDTO> lsolicitudes = new ArrayList<SolicitudAsesoriaDTO>();
		int id = (int) request.getSession(false).getAttribute("idCliente");
		lsolicitudes = solicituddao.readAllIdClient(id);
		
		request.setAttribute("listadosolicitudes", lsolicitudes);
		request.getRequestDispatcher("cliente/SolicitudAsesoriaClienteReadAll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class ClientesEditar
 */
@WebServlet("/ClientesEditar")
public class ClientesEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		System.out.println("Editando cliente: "+idcliente);
		
		ClienteDAO clientedao = new ClienteDAO();
		ClienteDTO cliente = new ClienteDTO();
		cliente = clientedao.read(idcliente);
		
		request.setAttribute("datoscliente", cliente);
		request.getRequestDispatcher("admin/ClientesEditar.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		String nombreempresa = request.getParameter("nombreempresa");
		String rutempresa = request.getParameter("rutempresa");
		int idusuario = Integer.parseInt(request.getParameter("idusuario"));
		
		ClienteDTO cliente = new ClienteDTO(idcliente,nombreempresa, rutempresa,idusuario);

		ClienteDAO clientedao = new ClienteDAO();
		boolean editar = clientedao.update(cliente);
		
		String mensaje = "";
		
		if (editar)
			mensaje = "El cliente se ha editado exitosamente";
		else
			mensaje = "Ocurrió un error al editar el cliente";

		request.setAttribute("datoscliente", cliente);
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("admin/ClientesEditar.jsp").forward(request, response);
				

		
	}

}

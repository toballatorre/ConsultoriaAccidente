package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfesionalDAO;
import modelo.ProfesionalDTO;

/**
 * Servlet implementation class ProfEditar
 */
@WebServlet("/ProfEditar")
public class ProfEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idempleado = Integer.parseInt(request.getParameter("idemp"));
		System.out.println("Editando empleado: "+idempleado);
	
		ProfesionalDAO profdao = new ProfesionalDAO();
		ProfesionalDTO profesional = new ProfesionalDTO();
		profesional = profdao.read(idempleado);
		
		request.setAttribute("datosprofesional", profesional);
		request.getRequestDispatcher("admin/ProfesionalesEditar.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int idempleado = Integer.parseInt(request.getParameter("idempleado"));
	int idusuario = Integer.parseInt(request.getParameter("idusuario"));
	String nombre = request.getParameter("nombre");
	String celular = request.getParameter("celular");
	
	ProfesionalDTO profesional = new ProfesionalDTO(idempleado,nombre,idusuario,celular);
	ProfesionalDAO profdao = new ProfesionalDAO();
		
	boolean editar = profdao.update(profesional);
	String mensaje = "";
	
	if (editar)
		mensaje = "El profesional se ha editado exitosamente";
	else
		mensaje = "Ocurrió un error al editar el profesional";

	request.setAttribute("datosprofesional", profesional);
	request.setAttribute("cumensaje", mensaje);
	request.getRequestDispatcher("admin/ProfesionalesEditar.jsp").forward(request, response);
			

	
	}

}

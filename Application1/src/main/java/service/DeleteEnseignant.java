package service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.EnseignantDAO;

/**
 * Servlet implementation class DeleteEnseignant
 */

public class DeleteEnseignant extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  DeleteEnseignant(){
		super();
		// TODO Auto-generated constructor stub
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the Matricule parameter from the request
        Long matricule = Long.parseLong(request.getParameter("matricule"));

        // Call EnseignantDAO to delete the Enseignant by Matricule
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        enseignantDAO.deleteEnseignantByMatricule(matricule);

        // Redirect to the home page after deletion
        response.sendRedirect(request.getContextPath() + "/home");
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

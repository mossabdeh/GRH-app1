package service;

import DAO.EnseignantDAO;
import model.Etat;
import model.Gender;
import model.Promotion;
import model.Situation;
import model.Department;
import model.Echelon;
import model.Enseignant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Create a dummy enseignant
        // Enseignant dummyEnseignant = createDummyEnseignant();

        // Call EnseignantDAO to add the dummy enseignant to the database
        EnseignantDAO enseignantDAO = new EnseignantDAO();
       // enseignantDAO.addEnseignant(dummyEnseignant);
        // Call EnseignantDAO to get all enseignants
    
        List<Enseignant> allEnseignants = enseignantDAO.getAllEnseignants();

        // Set the list of enseignants as a request attribute
        request.setAttribute("allEnseignants", allEnseignants);

        // Forward the request to enseignant.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHome.jsp");
        dispatcher.forward(request, response);
    }




        
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

  
}

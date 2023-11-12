package service;

import DAO.EnseignantDAO;
import model.Department;
import model.Enseignant;
import model.Etat;
import model.Gender;
import model.Situation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addEns")
public class AddEns extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the addEnseignant.jsp page
        request.getRequestDispatcher("/AdminAddE.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle the form submission
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexeStr = request.getParameter("sexe");
        Gender sexe = Gender.valueOf(sexeStr); // Assuming Gender is an enum
        Date dateNaissance = Date.valueOf(request.getParameter("dateNaissance"));
        String lieuNaissance = request.getParameter("lieuNaissance");
        String situationFamilleStr = request.getParameter("situationFamille");
        Situation situationFamille = Situation.valueOf(situationFamilleStr); // Assuming Situation is an enum
        String conjoint = request.getParameter("conjoint");
        int enfantCharge = Integer.parseInt(request.getParameter("enfantCharge"));
        Date dateRecrutement = Date.valueOf(request.getParameter("dateRecrutement"));
        String diplomeRecrutement = request.getParameter("diplomeRecrutement");
        String departementAffectationStr = request.getParameter("departementAffectation");
        Department departementAffectation = Department.valueOf(departementAffectationStr); // Assuming Department is an enum
        String etatActualStr = request.getParameter("etatActual");
        Etat etatActual = Etat.valueOf(etatActualStr); // Assuming Etat is an enum

        // Create an Enseignant object from form parameters
        Enseignant enseignant = new Enseignant(null, nom, prenom, sexe, dateNaissance, lieuNaissance,
                situationFamille, conjoint, enfantCharge, dateRecrutement, diplomeRecrutement,
                departementAffectation, new ArrayList<>(), new ArrayList<>(), etatActual);

        // Call EnseignantDAO to add the enseignant to the database
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        enseignantDAO.addEnseignant(enseignant);

     // Set a success message to be displayed in home.jsp
        request.setAttribute("successMessage", "Enseignant added successfully!");

        // Redirect to the home page after adding enseignant
        response.sendRedirect(request.getContextPath() + "/home");
    }
}

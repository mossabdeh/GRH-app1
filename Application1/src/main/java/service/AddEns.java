package service;

import DAO.EnseignantDAO;
import model.Department;
import model.Enseignant;
import model.Etat;
import model.Gender;
import model.MatriculeGenerator;
import model.Situation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
        Gender sexe = Gender.valueOf(sexeStr);
        Date dateNaissance = Date.valueOf(request.getParameter("dateNaissance"));
        String lieuNaissance = request.getParameter("lieuNaissance");
        String situationFamilleStr = request.getParameter("situationFamille");
        Situation situationFamille = Situation.valueOf(situationFamilleStr);
        String conjoint = request.getParameter("conjoint");
        int enfantCharge = Integer.parseInt(request.getParameter("enfantCharge"));
        Date dateRecrutement = Date.valueOf(request.getParameter("dateRecrutement"));
        String diplomeRecrutement = request.getParameter("diplomeRecrutement");
        String departementAffectationStr = request.getParameter("departementAffectation");
        Department departementAffectation = Department.valueOf(departementAffectationStr);
        String etatActualStr = request.getParameter("etatActual");
        Etat etatActual = Etat.valueOf(etatActualStr);

        // Call EnseignantDAO to get the last used sequential number for the given year
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        int recruitmentYear = getYearFromDate(dateRecrutement);

        // Generate a unique Matricule using MatriculeGenerator
        Long matricule = generateUniqueMatricule(dateRecrutement, recruitmentYear, enseignantDAO);

        // Create an Enseignant object with the generated Matricule
        Enseignant enseignant = new Enseignant(matricule, nom, prenom, sexe, dateNaissance, lieuNaissance,
                situationFamille, conjoint, enfantCharge, dateRecrutement, diplomeRecrutement,
                departementAffectation, new ArrayList<>(), new ArrayList<>(), etatActual);

        // Call EnseignantDAO to add the enseignant to the database
        enseignantDAO.addEnseignant(enseignant);

        // Set a success message to be displayed in home.jsp
        request.setAttribute("successMessage", "Enseignant added successfully!");

        // Redirect to the home page after adding enseignant
        response.sendRedirect(request.getContextPath() + "/home");
    }

    // Utility method to extract the year from a Date
    private int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    // Utility method to generate a unique Matricule
    private Long generateUniqueMatricule(Date dateRecrutement, int recruitmentYear, EnseignantDAO enseignantDAO) {
        // Get the last used Matricule for the given year
        Long lastMatricule = enseignantDAO.getLastMatricule(recruitmentYear);

        // Extract the sequential number from the last Matricule
        long sequentialNumber = extractSequentialNumber(lastMatricule);

        // Increment the sequential number if necessary
        sequentialNumber = Math.max(sequentialNumber + 1, enseignantDAO.getHighestSequentialNumber(recruitmentYear) + 1);

        return MatriculeGenerator.generateMatricule(recruitmentYear, sequentialNumber);
    }


    // Utility method to extract the sequential number from a Matricule
    private long extractSequentialNumber(Long matricule) {
        if (matricule != null) {
            String matriculeStr = String.valueOf(matricule);
            return Long.parseLong(matriculeStr.substring(4)); // Assuming the sequential number is in positions 5 to 8
        }
        return 0;
    }
}
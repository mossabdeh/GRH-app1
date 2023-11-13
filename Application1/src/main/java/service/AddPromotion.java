package service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promotion;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import DAO.PromotionDAO;

/**
 * Servlet implementation class AddPromotion
 */
@WebServlet("/PromotionServlet")
public class AddPromotion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get matricule parameter from the request
        Long matricule = Long.parseLong(request.getParameter("matricule"));

        // Call PromotionDAO to get all promotions for the specified enseignant
        PromotionDAO promotionDAO = new PromotionDAO();
        List<Promotion> promotions = promotionDAO.getPromotionsByMatricule(matricule);

        // Set promotions as a request attribute
        request.setAttribute("promotions", promotions);
     // Assuming you have retrieved the matricule value
        request.setAttribute("matricule", matricule);

        // Forward the request to the promotions JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Promotions.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data from the request
        Long matricule = Long.parseLong(request.getParameter("matricule"));
        Date datePromotion = Date.valueOf(request.getParameter("datePromotion"));
        String gradePromotion = request.getParameter("gradePromotion");
        String diplomePromotion = request.getParameter("diplomePromotion");

        // Create a Promotion object with the form data
        Promotion promotion = new Promotion(datePromotion, gradePromotion, diplomePromotion);

        // Call PromotionDAO to add the promotion for the specified enseignant
        PromotionDAO promotionDAO = new PromotionDAO();
        promotionDAO.addPromotion(promotion, matricule);

        // Redirect to the promotions servlet to display all promotions for the enseignant
        response.sendRedirect(request.getContextPath() + "/PromotionServlet?matricule=" + matricule);
    }

}

package DAO;

import model.Promotion;
import model.Enseignant;
import config.PostgreSQLJDBCConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PromotionDAO {

    private Connection connection;

    public PromotionDAO() {
        connection = PostgreSQLJDBCConfig.connect();
    }

    // Method to add a promotion
    public void addPromotion(Promotion promotion, Long matricule) {
        try {
            // First, check if the enseignant exists
            EnseignantDAO enseignantDAO = new EnseignantDAO();
            Enseignant enseignant = enseignantDAO.getEnseignantByMatricule(matricule);

            if (enseignant != null) {
                String sql = "INSERT INTO promotion (date_promotion, grade_promotion, diplome_promotion, enseignant_matricule) VALUES (?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setDate(1, new java.sql.Date(promotion.getDatePromotion().getTime()));
                    preparedStatement.setString(2, promotion.getGradePromotion());
                    preparedStatement.setString(3, promotion.getDiplomePromotion());
                    preparedStatement.setLong(4, matricule);

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Method to update a promotion
    public void updatePromotion(Promotion promotion) {
        try {
            String sql = "UPDATE promotion SET date_promotion = ?, grade_promotion = ?, diplome_promotion = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setDate(1, new java.sql.Date(promotion.getDatePromotion().getTime()));
                preparedStatement.setString(2, promotion.getGradePromotion());
                preparedStatement.setString(3, promotion.getDiplomePromotion());
                preparedStatement.setLong(4, promotion.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Method to delete a promotion by ID
    public void deletePromotionById(int id) {
        try {
            String sql = "DELETE FROM promotion WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Method to get all promotions for a specific enseignant
    public List<Promotion> getPromotionsByMatricule(Long matricule) {
        List<Promotion> promotions = new ArrayList<>();

        // First, retrieve the enseignant
        EnseignantDAO enseignantDAO = new EnseignantDAO();
        Enseignant enseignant = enseignantDAO.getEnseignantByMatricule(matricule);

        if (enseignant != null) {
            String sql = "SELECT * FROM promotion WHERE enseignant_matricule = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, matricule);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Promotion promotion = mapResultSetToPromotion(resultSet);
                    promotion.setEnseignant(enseignant);
                    promotions.add(promotion);
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }

        return promotions;
    }

    // Method to map result set to Promotion object
    private Promotion mapResultSetToPromotion(ResultSet resultSet) throws SQLException {
        Promotion promotion = new Promotion();
        promotion.setId(resultSet.getLong("id"));
        promotion.setDatePromotion(resultSet.getDate("date_promotion"));
        promotion.setGradePromotion(resultSet.getString("grade_promotion"));
        promotion.setDiplomePromotion(resultSet.getString("diplome_promotion"));
        return promotion;
    }

    // Close the connection
    public void close() {
        PostgreSQLJDBCConfig.close();
    }
}

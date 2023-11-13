package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.PostgreSQLJDBCConfig;
import model.Enseignant;
import model.Echelon;

public class EchelonDAO {
    private Connection connection;

    public EchelonDAO() {
        // Initialize the database connection in the constructor
    	connection = PostgreSQLJDBCConfig.connect();
    }

    // Add Echelon for a specified enseignant matricule
    public void addEchelon(Echelon echelon, Long matricule) {
        try {
            // First, check if the enseignant exists
            EnseignantDAO enseignantDAO = new EnseignantDAO();
            Enseignant enseignant = enseignantDAO.getEnseignantByMatricule(matricule);

            if (enseignant != null) {
                String sql = "INSERT INTO echelon (date_promotion, nombre_echelon, enseignant_matricule) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setDate(1, new java.sql.Date(echelon.getDatePromotion().getTime()));
                    preparedStatement.setInt(2, echelon.getNombreEchelon());
                    preparedStatement.setLong(3, matricule);

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Get all echelons for a specified enseignant matricule
    public List<Echelon> getEchelonsByMatricule(Long matricule) {
        List<Echelon> echelons = new ArrayList<>();

        try {
            String sql = "SELECT * FROM echelon WHERE enseignant_matricule = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, matricule);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Long id = resultSet.getLong("id");
                        Date datePromotion = resultSet.getDate("date_promotion");
                        int nombreEchelon = resultSet.getInt("nombre_echelon");

                        // Create Echelon object
                        Echelon echelon = new Echelon(id, datePromotion, nombreEchelon, null);

                        // Add to the list
                        echelons.add(echelon);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return echelons;
    }

    // Other CRUD operations can be added as needed
}

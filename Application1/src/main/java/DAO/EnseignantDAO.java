package DAO;

import config.PostgreSQLJDBCConfig;
import model.Department;
import model.Enseignant;
import model.Etat;
import model.Gender;
import model.Situation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EnseignantDAO {

    private final Connection connection;

    public EnseignantDAO() {
        // Establish a database connection using the PostgreSQLJDBCConfig class
        this.connection = PostgreSQLJDBCConfig.connect();
    }

    // Method to add an Enseignant to the database
    public void addEnseignant(Enseignant enseignant) {
        String sql = "INSERT INTO enseignant (Nom, Prenom, Sexe, DateNaissance, LieuNaissance, " +
                     "SituationFamille, Conjoint, EnfantCharge, DateRecrutement, DiplomeRecrutement, " +
                     "DepartementAffectation, EtatActual) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the prepared statement using the Enseignant object
            preparedStatement.setString(1, enseignant.getNom());
            preparedStatement.setString(2, enseignant.getPrenom());
            preparedStatement.setObject(3, enseignant.getSexe(), Types.OTHER); // fixed
            preparedStatement.setDate(4, enseignant.getDateNaissace());
            preparedStatement.setString(5, enseignant.getLieuNaissance());
            preparedStatement.setObject(6, enseignant.getSituationFamille(), Types.OTHER); // fixed
            preparedStatement.setString(7, enseignant.getConjoint());
            preparedStatement.setInt(8, enseignant.getEnfantCharge());
            preparedStatement.setDate(9, enseignant.getDateRecrutment());
            preparedStatement.setString(10, enseignant.getDiplomeRecrutment());
            preparedStatement.setObject(11, enseignant.getDepartementAffectation(), Types.OTHER);// fixed
            preparedStatement.setObject(12, enseignant.getEtatActual(), Types.OTHER); // fixed

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Method to get an Enseignant by Matricule
    public Enseignant getEnseignantByMatricule(Long matricule) {
        String sql = "SELECT * FROM enseignant WHERE Matricule = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set Matricule value for the prepared statement
            preparedStatement.setLong(1, matricule);

            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a row is returned
            if (resultSet.next()) {
                // Create and return an Enseignant object based on the retrieved data
                return mapResultSetToEnseignant(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return null; // Return null if no Enseignant is found
    }

    // Method to delete an Enseignant by Matricule
    public void deleteEnseignantByMatricule(Long matricule) {
        String sql = "DELETE FROM enseignant WHERE Matricule = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set Matricule value for the prepared statement
            preparedStatement.setLong(1, matricule);

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    // Method to update an Enseignant
    public void updateEnseignant(Enseignant enseignant) {
        String sql = "UPDATE enseignant SET Nom = ?, Prenom = ?, Sexe = ?, DateNaissance = ?, " +
                     "LieuNaissance = ?, SituationFamille = ?, Conjoint = ?, EnfantCharge = ?, " +
                     "DateRecrutement = ?, DiplomeRecrutement = ?, DepartementAffectation = ?, " +
                     "EtatActual = ? WHERE Matricule = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set values for the prepared statement using the Enseignant object
            preparedStatement.setString(1, enseignant.getNom());
            preparedStatement.setString(2, enseignant.getPrenom());
            preparedStatement.setString(3, enseignant.getSexe().name());
            preparedStatement.setDate(4, enseignant.getDateNaissace());
            preparedStatement.setString(5, enseignant.getLieuNaissance());
            preparedStatement.setString(6, enseignant.getSituationFamille().name());
            preparedStatement.setString(7, enseignant.getConjoint());
            preparedStatement.setInt(8, enseignant.getEnfantCharge());
            preparedStatement.setDate(9, enseignant.getDateRecrutment());
            preparedStatement.setString(10, enseignant.getDiplomeRecrutment());
            preparedStatement.setString(11, enseignant.getDepartementAffectation().name());
            preparedStatement.setString(12, enseignant.getEtatActual().name());
            preparedStatement.setLong(13, enseignant.getMatricule());

            // Execute the SQL statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    
 // Method to get all enseignants from the database
    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();
        String sql = "SELECT * FROM enseignant";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and add enseignants to the list
            while (resultSet.next()) {
                Enseignant enseignant = mapResultSetToEnseignant(resultSet);
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return enseignants;
    }
    
    

    // Helper method to map a ResultSet to an Enseignant object
    private Enseignant mapResultSetToEnseignant(ResultSet resultSet) throws SQLException {
        // Create and return an Enseignant object based on the retrieved data
        return new Enseignant(
                resultSet.getLong("Matricule"),
                resultSet.getString("Nom"),
                resultSet.getString("Prenom"),
                Gender.valueOf(resultSet.getString("Sexe")),
                resultSet.getDate("DateNaissance"),
                resultSet.getString("LieuNaissance"),
                Situation.valueOf(resultSet.getString("SituationFamille")),
                resultSet.getString("Conjoint"),
                resultSet.getInt("EnfantCharge"),
                resultSet.getDate("DateRecrutement"),
                resultSet.getString("DiplomeRecrutement"),
                Department.valueOf(resultSet.getString("DepartementAffectation")),
                null, // You can load promotions and echelons here if needed
                null,
                Etat.valueOf(resultSet.getString("EtatActual"))
        );
    }
}

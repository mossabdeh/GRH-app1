<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Enseignant" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Enseignant Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Add your custom styles.css if needed -->
    <style>
        html,
        body,
        .intro {
            height: 100%;
        }

        /* Add any additional styling for your table or other elements here */
    </style>

    <!-- Add Bootstrap's JavaScript and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.9/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>

    <section class="intro">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h2>Enseignant Details</h2>
                            <a href="AddEns" class="btn btn-primary">Add Enseignant</a>
                        </div>
                        <div class="card-body">
                         <%-- ----------------------------------------------------------------- --%>
                         <%-- Display success message if available --%>
                         <% String successMessage = (String) request.getAttribute("successMessage"); %>
                         <% if (successMessage != null && !successMessage.isEmpty()) { %>
                           <div class="alert alert-success" role="alert">
                           <%= successMessage %>
                            </div>
                            <% } %>
                            <div class="table-responsive">
              <table class="table table-striped table-hover table-bordered">
    <thead>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Sexe</th>
            <th>Date Naissance</th>
            <th>Lieu Naissance</th>
            <th>Situation</th>
            <th>Date Recrutment</th>
            <th>Diplome Recrutment</th>
            <th>Deprt</th>
            <th>Etat</th>
            <th colspan="2" style="text-align: center;">Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- Display Enseignant details -->
        <% 
            // Retrieve the list of enseignants from the request attribute
            List<Enseignant> allEnseignants = (List<Enseignant>) request.getAttribute("allEnseignants");

            // Iterate over the list and display each enseignant
            for (Enseignant enseignant : allEnseignants) {
        %>
            <tr>
                <td><%= enseignant.getMatricule() %></td>
                <td><%= enseignant.getNom() %></td>
                <td><%= enseignant.getPrenom() %></td>
                <td><%= enseignant.getSexe() %></td>
                <td><%= enseignant.getDateNaissace() %></td>
                <td><%= enseignant.getLieuNaissance() %></td>
                <td><%= enseignant.getSituationFamille() %></td>
                <td><%= enseignant.getDateRecrutment() %></td>
                <td><%= enseignant.getDiplomeRecrutment() %></td>
                <td><%= enseignant.getDepartementAffectation() %></td>
                <td><%= enseignant.getEtatActual() %></td>
                <!-- Edit button with secondary color -->
                <td>
                    <a href="UpdateEnseignant?matricule=<%= enseignant.getMatricule() %>" class="btn btn-secondary" role="button">
                        <i class="fa fa-edit" style="font-size: 10px;"></i> Edit
                    </a>
                 </td>  
                  
                 <!-- Delete button with danger color and confirmation dialog -->
                  <td>   
                  <a href="#" class="btn btn-danger" role="button" onclick="confirmDelete('<%= enseignant.getMatricule() %>')">
                   <i class="fa fa-trash" style="font-size: 10px;"></i> Delete
                  </a>
                  </td>
            </tr>
        <% } %>
    </tbody>
</table>



                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    

</body>
 <!-- Add this script at the end of your JSP file or in the head section -->
<script>
    function confirmDelete(matricule) {
        // Display a confirmation dialog
        if (confirm("Are you sure you want to delete this Enseignant?")) {
            // If the user clicks "OK", proceed with the deletion by navigating to the DeleteEnseignant servlet
            window.location.href = "DeleteEnseignant?matricule=" + matricule;
        }
    }
</script>






 
</html>

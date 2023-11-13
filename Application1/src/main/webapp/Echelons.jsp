<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Echelon" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Echelon Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Add your custom styles.css if needed -->
    <style>
        .echelon-card {
            margin-bottom: 20px;
        }

        .echelon-list {
            list-style: none;
            padding: 0;
        }

        .echelon-list-item {
            border: 1px solid #ccc;
            margin-bottom: 10px;
            padding: 10px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-4">
            <!-- Echelon Card -->
            <div class="card echelon-card">
                <div class="card-header">
                    <h2 class="mb-0">Add Echelon</h2>
                </div>
                <div class="card-body">
                    <form action="AddEchelon" method="post">
                        <!-- Add a hidden field for matricule -->
                        <input type="hidden" name="matricule" value="<%= request.getAttribute("matricule") %>">

                        <div class="form-group">
                            <label for="datePromotion">Date Promotion:</label>
                            <input type="date" class="form-control" id="datePromotion" name="datePromotion" required>
                        </div>

                        <div class="form-group">
                            <label for="nombreEchelon">Nombre Echelon:</label>
                            <input type="text" class="form-control" id="nombreEchelon" name="nombreEchelon" required>
                        </div>

                        <!-- Add other form fields for echelon as needed -->

                        <button type="submit" class="btn btn-primary">Add Echelon</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8">
           <%
               // Retrieve the list of echelons from the request attribute
               List<Echelon> allEchelons = (List<Echelon>) request.getAttribute("echelons");
           %>

           <!-- Echelon List -->
           <ul class="echelon-list">
               <!-- Iterate over the list of echelons and display each one -->
               <% for (Echelon echelon : allEchelons) { %>
                   <li class="echelon-list-item">
                       <h5>Echelon ID: <%= echelon.getId() %></h5>
                       <p>Date: <%= echelon.getDatePromotion() %></p>
                       <p>Nombre Echelon: <%= echelon.getNombreEchelon() %></p>
                       <!-- Add other echelon details as needed -->
                   </li>
               <% } %>
           </ul>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>

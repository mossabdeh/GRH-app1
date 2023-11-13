<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Promotion" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Promotion Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Add your custom styles.css if needed -->
    <style>
        .promotion-card {
            margin-bottom: 20px;
        }

        .promotion-list {
            list-style: none;
            padding: 0;
        }

        .promotion-list-item {
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
            <!-- Promotion Card -->
          <!-- Promotion Card -->
<!-- Promotion Card -->
<!-- Promotion Card -->
<div class="card promotion-card">
    <div class="card-header">
        <h2 class="mb-0">Add Promotion</h2>
    </div>
    <div class="card-body">
        <form action="AddPromotion" method="post">
            <!-- Add a hidden field for matricule -->
            <input type="hidden" name="matricule" value="<%= request.getAttribute("matricule") %>">

            <div class="form-group">
                <label for="datePromotion">Date Promotion:</label>
                <input type="date" class="form-control" id="datePromotion" name="datePromotion" required>
            </div>

            <div class="form-group">
                <label for="gradePromotion">Grade Promotion:</label>
                <input type="text" class="form-control" id="gradePromotion" name="gradePromotion" required>
            </div>

            <div class="form-group">
                <label for="diplomePromotion">Diplome Promotion:</label>
                <input type="text" class="form-control" id="diplomePromotion" name="diplomePromotion" required>
            </div>

            <!-- Add other form fields for promotion as needed -->

            <button type="submit" class="btn btn-primary">Add Promotion</button>
        </form>
    </div>
</div>



        </div>
        <div class="col-md-8">
           <%
    // Retrieve the list of promotions from the request attribute
    List<Promotion> allPromotions = (List<Promotion>) request.getAttribute("promotions");
           %>

      <!-- Promotion List -->
     <ul class="promotion-list">
        <!-- Iterate over the list of promotions and display each one -->
         <% for (Promotion promotion : allPromotions) { %>
        <li class="promotion-list-item">
            <h5>Promotion ID: <%= promotion.getId() %></h5>
            <p>Date: <%= promotion.getDatePromotion() %></p>
            <p>Grade: <%= promotion.getGradePromotion() %></p>
            <p>Diplome: <%= promotion.getDiplomePromotion() %></p>
            <!-- Add other promotion details as needed -->
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

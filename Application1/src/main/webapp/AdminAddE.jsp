<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Enseignant</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h2 class="mb-0">Add Enseignant</h2>
        </div>
        <div class="card-body">
            <form action="AddEns" method="post">
                <div class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom" required>
                </div>

                <div class="form-group">
                    <label for="prenom">Prenom:</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" required>
                </div>

                <div class="form-group">
                    <label for="sexe">Sexe:</label>
                    <select class="form-control" id="sexe" name="sexe" required>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="dateNaissance">Date Naissance:</label>
                    <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" required>
                </div>

                <div class="form-group">
                    <label for="lieuNaissance">Lieu Naissance:</label>
                    <input type="text" class="form-control" id="lieuNaissance" name="lieuNaissance" required>
                </div>

                <div class="form-group">
                    <label for="situationFamille">Situation Famille:</label>
                    <select class="form-control" id="situationFamille" name="situationFamille" required>
                        <option value="C">Single</option>
                        <option value="M">Married</option>
                        <option value="D">Divorced</option>
                        <option value="V">V idk</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="conjoint">Conjoint:</label>
                    <input type="text" class="form-control" id="conjoint" name="conjoint">
                </div>

                <div class="form-group">
                    <label for="enfantCharge">Enfant Charge:</label>
                    <input type="number" class="form-control" id="enfantCharge" name="enfantCharge" min="0">
                </div>

                <div class="form-group">
                    <label for="dateRecrutement">Date Recrutement:</label>
                    <input type="date" class="form-control" id="dateRecrutement" name="dateRecrutement" required>
                </div>

                <div class="form-group">
                    <label for="diplomeRecrutement">Diplome Recrutement:</label>
                    <input type="text" class="form-control" id="diplomeRecrutement" name="diplomeRecrutement" required>
                </div>

                <div class="form-group">
                    <label for="departementAffectation">Departement Affectation:</label>
                    <select class="form-control" id="departementAffectation" name="departementAffectation" required>
                        <option value="TLSI">TLSI</option>
                        <option value="IFA">IFA</option>
                        <option value="NTIC">NTIC</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="etatActual">Etat Actual:</label>
                    <select class="form-control" id="etatActual" name="etatActual" required>
                        <option value="Actif">Actif</option>
                        <option value="Retraite">Retraite</option>
                    </select>
                </div>

                <!-- Add other form fields here -->
                <!-- <div class="form-group">
                    <label for="fieldName">Field Label:</label>
                    <input type="text" class="form-control" id="fieldName" name="fieldName" required>
                </div> -->

                <button type="submit" class="btn btn-primary">Add Enseignant</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>

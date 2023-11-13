<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Enseignant" %>
<%@ page import="model.Gender" %>
<%@ page import="model.Situation" %>
<%@ page import="model.Etat" %>
<%@ page import="model.Department" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Update Enseignant</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h2 class="mb-0">Update Enseignant</h2>
        </div>
        <div class="card-body">
       <% Enseignant enseignant = (Enseignant) request.getAttribute("enseignant"); %>

            <form action="UpdateEnseignant" method="post">
                <div class="form-group">
                    <label for="matricule">Matricule:</label>
                    <input type="text" class="form-control" id="matricule" name="matricule" value="<%= enseignant.getMatricule() %>" readonly>
                </div>

                <div class="form-group">
                    <label for="nom">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom" value="<%= enseignant.getNom() %>" required>
                </div>

                <div class="form-group">
                    <label for="prenom">Prenom:</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="<%= enseignant.getPrenom() %>" required>
                </div>

                <div class="form-group">
                    <label for="sexe">Sexe:</label>
                    <select class="form-control" id="sexe" name="sexe" required>
                        <option value="Male" <%= enseignant.getSexe() == Gender.Male ? "selected" : "" %>>Male</option>
                        <option value="Female" <%= enseignant.getSexe() == Gender.Female ? "selected" : "" %>>Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="dateNaissance">Date Naissance:</label>
                    <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" value="<%= enseignant.getDateNaissace() %>" required>
                </div>

                <div class="form-group">
                    <label for="lieuNaissance">Lieu Naissance:</label>
                    <input type="text" class="form-control" id="lieuNaissance" name="lieuNaissance" value="<%= enseignant.getLieuNaissance() %>" required>
                </div>

                <div class="form-group">
                    <label for="situationFamille">Situation Famille:</label>
                    <select class="form-control" id="situationFamille" name="situationFamille" required>
                        <option value="C" <%= enseignant.getSituationFamille() == Situation.C ? "selected" : "" %>>Single</option>
                        <option value="M" <%= enseignant.getSituationFamille() == Situation.M ? "selected" : "" %>>Married</option>
                        <option value="D" <%= enseignant.getSituationFamille() == Situation.D ? "selected" : "" %>>Divorced</option>
                        <option value="V" <%= enseignant.getSituationFamille() == Situation.V ? "selected" : "" %>>V idk</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="conjoint">Conjoint:</label>
                    <input type="text" class="form-control" id="conjoint" name="conjoint" value="<%= enseignant.getConjoint() %>">
                </div>

                <div class="form-group">
                    <label for="enfantCharge">Enfant Charge:</label>
                    <input type="number" class="form-control" id="enfantCharge" name="enfantCharge" value="<%= enseignant.getEnfantCharge() %>" min="0">
                </div>

                <div class="form-group">
                    <label for="dateRecrutement">Date Recrutement:</label>
                    <input type="text" class="form-control" id="dateRecrutement" name="dateRecrutement" value="<%= enseignant.getDateRecrutment() %>" readonly>
                </div>

                <div class="form-group">
                    <label for="diplomeRecrutement">Diplome Recrutement:</label>
                    <input type="text" class="form-control" id="diplomeRecrutement" name="diplomeRecrutement" value="<%= enseignant.getDiplomeRecrutment() %>" required>
                </div>

                <div class="form-group">
                    <label for="departementAffectation">Departement Affectation:</label>
                    <select class="form-control" id="departementAffectation" name="departementAffectation" required>
                        <option value="TLSI" <%= enseignant.getDepartementAffectation() == Department.TLSI ? "selected" : "" %>>TLSI</option>
                        <option value="IFA" <%= enseignant.getDepartementAffectation() == Department.IFA ? "selected" : "" %>>IFA</option>
                        <option value="NTIC" <%= enseignant.getDepartementAffectation() == Department.NTIC ? "selected" : "" %>>NTIC</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="etatActual">Etat Actual:</label>
                    <select class="form-control" id="etatActual" name="etatActual" required>
                        <option value="Actif" <%= enseignant.getEtatActual() == Etat.Actif ? "selected" : "" %>>Actif</option>
                        <option value="Retraite" <%= enseignant.getEtatActual() == Etat.Retraite ? "selected" : "" %>>Retraite</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Update Enseignant</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></

package model.JPA;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import model.Department;
import model.Echelon;
import model.Etat;
import model.Gender;
import model.Promotion;
import model.Situation;

@Entity
@Table(name = "enseignant")
public class EnseignantJPA {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Matricule;
	private String Nom ;
	private String Prenom ;
	private Gender sexe;
	private Date DateNaissace; // java.sql.Date  JDBC
	private String LieuNaissance ;
	private Situation SituationFamille;
	private String Conjoint; // if Situation = M
	private int EnfantCharge;
	
	private Date DateRecrutment;
	private String DiplomeRecrutment;
	private Department DepartementAffectation;
	
	// list des promotions 
	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	private List<Promotion> promotions;
	// list des echelon
	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	private List<Echelon> echelons; //for every new promotion counter = 0
	
	private Etat EtatActual ;
	
	

	public EnseignantJPA(Long matricule, String nom, String prenom, Gender sexe, Date dateNaissace,
			String lieuNaissance, Situation situationFamille, String conjoint, int enfantCharge, Date dateRecrutment,
			String diplomeRecrutment, Department departementAffectation, List<Promotion> promotions,
			List<Echelon> echelons, Etat etatActual) {
		Matricule = matricule;
		Nom = nom;
		Prenom = prenom;
		this.sexe = sexe;
		DateNaissace = dateNaissace;
		LieuNaissance = lieuNaissance;
		SituationFamille = situationFamille;
		Conjoint = conjoint;
		EnfantCharge = enfantCharge;
		DateRecrutment = dateRecrutment;
		DiplomeRecrutment = diplomeRecrutment;
		DepartementAffectation = departementAffectation;
		this.promotions = promotions;
		this.echelons = echelons;
		EtatActual = etatActual;
	}



	public EnseignantJPA() {
	}



	public Long getMatricule() {
		return Matricule;
	}



	public void setMatricule(Long matricule) {
		Matricule = matricule;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public String getPrenom() {
		return Prenom;
	}



	public void setPrenom(String prenom) {
		Prenom = prenom;
	}



	public Gender getSexe() {
		return sexe;
	}



	public void setSexe(Gender sexe) {
		this.sexe = sexe;
	}



	public Date getDateNaissace() {
		return DateNaissace;
	}



	public void setDateNaissace(Date dateNaissace) {
		DateNaissace = dateNaissace;
	}



	public String getLieuNaissance() {
		return LieuNaissance;
	}



	public void setLieuNaissance(String lieuNaissance) {
		LieuNaissance = lieuNaissance;
	}



	public Situation getSituationFamille() {
		return SituationFamille;
	}



	public void setSituationFamille(Situation situationFamille) {
		SituationFamille = situationFamille;
	}



	public String getConjoint() {
		return Conjoint;
	}



	public void setConjoint(String conjoint) {
		Conjoint = conjoint;
	}



	public int getEnfantCharge() {
		return EnfantCharge;
	}



	public void setEnfantCharge(int enfantCharge) {
		EnfantCharge = enfantCharge;
	}



	public Date getDateRecrutment() {
		return DateRecrutment;
	}



	public void setDateRecrutment(Date dateRecrutment) {
		DateRecrutment = dateRecrutment;
	}



	public String getDiplomeRecrutment() {
		return DiplomeRecrutment;
	}



	public void setDiplomeRecrutment(String diplomeRecrutment) {
		DiplomeRecrutment = diplomeRecrutment;
	}



	public Department getDepartementAffectation() {
		return DepartementAffectation;
	}



	public void setDepartementAffectation(Department departementAffectation) {
		DepartementAffectation = departementAffectation;
	}



	public List<Promotion> getPromotions() {
		return promotions;
	}



	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}



	public List<Echelon> getEchelons() {
		return echelons;
	}



	public void setEchelons(List<Echelon> echelons) {
		this.echelons = echelons;
	}



	public Etat getEtatActual() {
		return EtatActual;
	}



	public void setEtatActual(Etat etatActual) {
		EtatActual = etatActual;
	}
	
	
	
	
	
	
	
	
	

}

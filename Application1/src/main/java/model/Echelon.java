package model;

import java.sql.Date;

public class Echelon {
	
	private Long id; // Added id attribute
	private Date DatePromotion;
	private int NombreEchelon;
	private Enseignant enseignant;
	
	
	public Echelon() {
		super();
	}
	

	public Echelon(Long id, Date datePromotion, int nombreEchelon, Enseignant enseignant) {
		this.id = id;
		DatePromotion = datePromotion;
		NombreEchelon = nombreEchelon;
		this.enseignant = enseignant;
	}



	public Echelon(Date datePromotion, int nombreEchelon) {
		super();
		DatePromotion = datePromotion;
		NombreEchelon = nombreEchelon;
	}


	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Enseignant getEnseignant() {
		return enseignant;
	}



	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}




	public Date getDatePromotion() {
		return DatePromotion;
	}


	public void setDatePromotion(Date datePromotion) {
		DatePromotion = datePromotion;
	}


	public int getNombreEchelon() {
		return NombreEchelon;
	}


	public void setNombreEchelon(int nombreEchelon) {
		NombreEchelon = nombreEchelon;
	}
	
	// Getters /Setters
	
	
	
	

}

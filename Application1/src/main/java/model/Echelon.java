package model;

import java.sql.Date;

public class Echelon {
	
	private Date DatePromotion;
	private int NombreEchelon;
	
	
	public Echelon() {
		super();
	}


	public Echelon(Date datePromotion, int nombreEchelon) {
		super();
		DatePromotion = datePromotion;
		NombreEchelon = nombreEchelon;
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

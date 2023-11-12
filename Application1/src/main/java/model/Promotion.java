package model;

import java.sql.Date;

public class Promotion {

	private Date DatePromotion ;
	private String GradePromotion ;
	private String DiplomePromotion;
	
	
	public Promotion() {
		super();
	}


	public Promotion(Date datePromotion, String gradePromotion, String diplomePromotion) {
		super();
		DatePromotion = datePromotion;
		GradePromotion = gradePromotion;
		DiplomePromotion = diplomePromotion;
	}


	public Date getDatePromotion() {
		return DatePromotion;
	}


	public void setDatePromotion(Date datePromotion) {
		DatePromotion = datePromotion;
	}


	public String getGradePromotion() {
		return GradePromotion;
	}


	public void setGradePromotion(String gradePromotion) {
		GradePromotion = gradePromotion;
	}


	public String getDiplomePromotion() {
		return DiplomePromotion;
	}


	public void setDiplomePromotion(String diplomePromotion) {
		DiplomePromotion = diplomePromotion;
	}
	
	
	// Getters / Setters
	
}

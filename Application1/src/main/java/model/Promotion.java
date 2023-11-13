package model;

import java.sql.Date;

public class Promotion {

	private Long id; // Added id attribute
	private Date DatePromotion ;
	private String GradePromotion ;
	private String DiplomePromotion;
	private Enseignant enseignant;
	
	
	public Promotion() {
		super();
	}
	  
	public Promotion(Date datePromotion, String gradePromotion, String diplomePromotion) {
        this.DatePromotion = datePromotion;
        this.GradePromotion = gradePromotion;
        this.DiplomePromotion = diplomePromotion;
    }

	


        public Promotion(Long id, Date datePromotion, String gradePromotion, String diplomePromotion,
			Enseignant enseignant) {
		this.id = id;
		DatePromotion = datePromotion;
		GradePromotion = gradePromotion;
		DiplomePromotion = diplomePromotion;
		this.enseignant = enseignant;
	}

   


		public Long getId() {
		return id;
	       }





	    public void setId(Long id) {
		this.id = id;
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




	public Enseignant getEnseignant() {
		return enseignant;
	}




	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	  
	
	
	// Getters / Setters
	
}

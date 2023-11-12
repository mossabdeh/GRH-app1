package model.JPA;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "promotion")
public class PromotionJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date DatePromotion;
    private String GradePromotion;
    private String DiplomePromotion;
    
     @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private EnseignantJPA enseignant;

    
// Constructors, getters, setters...
    
    
   
	

	public PromotionJPA(Date datePromotion, String gradePromotion, String diplomePromotion, EnseignantJPA enseignant) {
		DatePromotion = datePromotion;
		GradePromotion = gradePromotion;
		DiplomePromotion = diplomePromotion;
		this.enseignant = enseignant;
	}


	public PromotionJPA() {
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


	public EnseignantJPA getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(EnseignantJPA enseignant) {
		this.enseignant = enseignant;
	}

    
	
    
    
    
}
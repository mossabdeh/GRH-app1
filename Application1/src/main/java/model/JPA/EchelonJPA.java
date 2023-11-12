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
@Table(name = "echelon")
public class EchelonJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date DatePromotion;
    private int NombreEchelon;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private EnseignantJPA enseignant;
    
    // Constructors, getters, setters...
    
    
public EchelonJPA(Date datePromotion, int nombreEchelon, EnseignantJPA enseignant) {
		DatePromotion = datePromotion;
		NombreEchelon = nombreEchelon;
		this.enseignant = enseignant;
	}

    




    
	public EchelonJPA() {
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

	public int getNombreEchelon() {
		return NombreEchelon;
	}

	public void setNombreEchelon(int nombreEchelon) {
		NombreEchelon = nombreEchelon;
	}

	public EnseignantJPA getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(EnseignantJPA enseignant) {
		this.enseignant = enseignant;
	}

   
    
    
}
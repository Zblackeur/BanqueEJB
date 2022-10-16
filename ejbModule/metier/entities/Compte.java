package metier.entities;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity
@Table(name="COMPTE")

public class Compte implements Serializable {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code;
	
	private String nom;
	private double solde;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	private boolean active;
	private static final long serialVersionUID = 1L;

	public Compte() {
		super();
	} 
	public Compte(double solde, Date dateCreation, boolean active,String nom) {
		super();
		this.nom =nom;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.active = active;
	}
	public Long getCode() {
		return this.code;
	}

	public void setCode(Long Code) {
		this.code = Code;
	}   
	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double Solde) {
		this.solde = solde;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}   
	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
   
}

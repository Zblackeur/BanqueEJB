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
	private long Code;
	
	
	private double solde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;
	private boolean active;
	private static final long serialVersionUID = 1L;

	public Compte() {
		super();
	}   
	public Long getCode() {
		return this.Code;
	}

	public void setCode(Long Code) {
		this.Code = Code;
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

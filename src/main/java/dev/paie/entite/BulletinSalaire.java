package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bulletin_salaire")
public class BulletinSalaire {
	
	@Id @GeneratedValue private Integer id;
	@ManyToOne
	@JoinColumn(name="remuneration_employe")
	private RemunerationEmploye remunerationEmploye;
	@ManyToOne private Periode periode;
	@JoinColumn(name="prime_exceptionnelle")
	private BigDecimal primeExceptionnelle;
	
	LocalDateTime db;
	
	
	
	public LocalDateTime getDb() {
		return db;
	}
	public void setDb(LocalDateTime db) {
		this.db = db;
	}
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}

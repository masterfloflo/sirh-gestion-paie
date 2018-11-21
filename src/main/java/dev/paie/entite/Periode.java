package dev.paie.entite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "periode")
public class Periode {

	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany(mappedBy = "periode")
	private List<BulletinSalaire> bull;
	@Column(name = "date_debut")
	private LocalDate dateDebut;
	@Column(name = "date_fin")
	private LocalDate dateFin;
	
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getDateDebutFin() {
		return getDateDebut() + " - " + getDateFin();
	}

}

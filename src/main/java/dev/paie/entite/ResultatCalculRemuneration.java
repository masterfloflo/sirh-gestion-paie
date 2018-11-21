package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resultat_calcul_remuneration")
public class ResultatCalculRemuneration {
	@Id @GeneratedValue 
	private String id;
	private String salaireDeBase;
    private String salaireBrut;
    private String totalRetenueSalarial;
    private String totalCotisationsPatronales;
    private String netImposable;
    private String netAPayer;
    
	public String getSalaireDeBase() {
		return salaireDeBase;
	}
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}
	public String getSalaireBrut() {
		return salaireBrut;
	}
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
	}
	public String getNetImposable() {
		return netImposable;
	}
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}
	public String getNetAPayer() {
		return netAPayer;
	}
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}

    
    
   
	
}

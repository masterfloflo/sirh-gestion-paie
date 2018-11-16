package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {


	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin1) {
		//SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal salaireBase = bulletin1.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin1.getRemunerationEmploye().getGrade().getTauxBase());
		//SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaireBrut = salaireBase.add(bulletin1.getPrimeExceptionnelle());
		//TOTAL_RETENUE_SALARIALE = SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		//BigDecimal totalRetenueSalariale = 
		//TOTAL_COTISATIONS_PATRONALES = SOMME(COTISATION_NON_IMPOSABLE.TAUX_PATRONAL*SALAIRE_BRUT)

		//NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE

		//NET_A_PAYER = NET_IMPOSABLE - SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)


		
		return null ;
	}

}

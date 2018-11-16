package dev.paie.repository;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
@ContextConfiguration(classes = {ServicesConfig.class })

@RunWith(SpringRunner.class)
public class JpaRepositoryTest {
	
	@Autowired private AvantageRepository avantageRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void test_sauvegarder_lister_mettre_a_jour() {
    	
    	Avantage av = new Avantage();
        //  sauvegarder un nouvel avantage
    	 avantageRepository.save(av); 

    	av.setCode("pop");
    	av.setNom("chomeur");
    	av.setMontant(new BigDecimal(100)); 

    	Avantage av2 = avantageRepository.findOne(3);
        // TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
    	av2.setCode("pup");
    	av2.setMontant(new BigDecimal(50));
    	av2.setNom("patron");

        // TODO modifier un avantage

        // TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
    }
}
package dev.paie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.JpaConfig;
import dev.paie.entite.Cotisation;
@ContextConfiguration(classes = {JpaConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class JpaTest {
	
	@PersistenceContext EntityManager em;

    @Test @Transactional @Rollback(false)
    public void test_sauvegarder_lister_mettre_a_jour() {
        //  sauvegarder une nouvelle cotisation
    		Cotisation coti = new Cotisation();
    		em.persist(coti);
        // TODO vérifier qu'il est possible de récupérer la nouvelle cotisation

        // TODO modifier une cotisation

        // TODO vérifier que les modifications sont bien prises en compte
    }
}
package dev.paie;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.DataSourcePostgreSQLConfig;
import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;

// compléter la configuration
@ContextConfiguration(classes = {DataSourcePostgreSQLConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class JdbcTemplateTest {

    // TODO sauvegarder un nouveau grade

	@Autowired DataSource dataSource;

    @Test
    public void test_sauvegarder_lister_mettre_a_jour() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                
        // insertion
        String sql = "INSERT INTO Grade (id, nbhbases, tauxbase, code) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, 1, 35, 10, "aaa");
        
      //  String recup = "SELECT "
        
        // assertThat(grade.get equalTo("2683.30"));

        // TODO vérifier qu'il est possible de récupérer le nouveau grade
        // String sql = "SELECT * FROM PIZZA";
        // List<Pizza> pizzas = jdbcTemplate.query(sql, new PizzaMapper());
        // TODO modifier un grade

        // TODO vérifier que les modifications sont bien prises en compte
    }
}
	
	


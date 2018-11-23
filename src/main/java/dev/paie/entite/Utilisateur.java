package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur {

    public enum ROLES {
        ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
    }

    
    @Id
    @GeneratedValue
    private Integer id;
    private String nomUtilisateur;
    private String motDePasse;
    private Boolean estActif;
    private ROLES role;
    

}
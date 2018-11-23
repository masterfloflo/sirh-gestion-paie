package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Utilisateur;
import dev.paie.repository.UtilisateurRepository;

@Controller
@RequestMapping("/employes")
public class UtilisateurController {

	
	@Autowired private UtilisateurRepository utiRepo;

	@RequestMapping(method = RequestMethod.GET, path = "/creerutilisateur")
    public ModelAndView creerUtilisateur() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employes/creerutilisateur");
        mv.addObject("utilisateur", new Utilisateur());
        return mv;
    }
	
    @RequestMapping(method = RequestMethod.POST, path = "/creerutilisateur")
    public ModelAndView submit(@ModelAttribute("utilisateur") Utilisateur uti ) {
    	
    	utiRepo.save(uti);
        return creerUtilisateur();

    }
	
}

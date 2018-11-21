package dev.paie.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	
	@Autowired private EntrepriseRepository entrepriseRepository;
	@Autowired private GradeRepository gradeRepository;
	@Autowired private ProfilRemunerationRepository profilRemunerationRepository;
	@Autowired private	RemunerationEmployeRepository	remEmpRep;
	
    @RequestMapping(method = RequestMethod.GET, path = "/creeremp")
    public ModelAndView creerEmploye() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employes/creerEmploye");
        mv.addObject("prefixMatricule","M00");
        mv.addObject("employe", new RemunerationEmploye());
        mv.addObject("liste_entreprise", entrepriseRepository.findAll());
        mv.addObject("liste_grade", gradeRepository.findAll());
        mv.addObject("liste_profil_remuneration" ,profilRemunerationRepository.findAll());
        
        return mv;
    }
    
    //creation d'un nouvel employe
    @RequestMapping(method = RequestMethod.POST, path = "/creeremp")
    public ModelAndView submit(@ModelAttribute("employe") RemunerationEmploye employe) {
    	LocalDateTime heure = LocalDateTime.now();
    	employe.setPr(heure);
    	
    	remEmpRep.save(employe);

        return creerEmploye();
    }
    
    //liste des employes
    @RequestMapping(method = RequestMethod.GET, path = "/listeemp")
    public ModelAndView listerEmploye() {
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("employes/listeEmployes");
        	mav.addObject("employe", new RemunerationEmploye());
    		mav.addObject("liste_employes", remEmpRep.findAll());
    		
		return mav;
  
        
    }
   

/*
 *         for ( RemunerationEmploye liste : remEmpRep.lister()) {

 */

}
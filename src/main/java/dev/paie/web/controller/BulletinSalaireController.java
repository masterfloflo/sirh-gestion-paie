package dev.paie.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinsSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/employes")
public class BulletinSalaireController {

	@Autowired
	private PeriodeRepository peRepo;
	@Autowired
	private RemunerationEmployeRepository remEmpRep;
	@Autowired
	private BulletinsSalaireRepository buSaRepo;
	@Autowired private CalculerRemunerationService calc;
	
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creerbull")
	public ModelAndView creerBulletin() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerBulletin");
		mv.addObject("liste_employes", remEmpRep.findAll());
		mv.addObject("liste_periode", peRepo.findAll());
		mv.addObject("bulletin", new BulletinSalaire());
		mv.addObject("prefixprime", "");
		return mv;
	}

	// creation d'un nouveau bulletin
	@RequestMapping(method = RequestMethod.POST, path = "/creerbull")
	public ModelAndView submit(@ModelAttribute("bulletin") BulletinSalaire bulli) {
		
		LocalDateTime heure = LocalDateTime.now();
    	bulli.setDb(heure);
    	
		buSaRepo.save(bulli);
		return creerBulletin();

	}
	
	//liste des bulletins
    @RequestMapping(method = RequestMethod.GET, path = "/listebull")
    public ModelAndView listerBulletin() {
    	ModelAndView mav = new ModelAndView();
    	
        mav.setViewName("employes/listeBulletin");
        	mav.addObject("bulletins", new BulletinSalaire());
    		mav.addObject("liste_bulletins", buSaRepo.findAll());
    		mav.addObject("calcul", new CalculerRemunerationServiceSimple());
    		calc.calculer(buSaRepo.findAll());
		return mav;
  
        
    }
	
	
	
}

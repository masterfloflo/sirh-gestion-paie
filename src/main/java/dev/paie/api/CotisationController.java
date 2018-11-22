package dev.paie.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@RestController
public class CotisationController {

	@Autowired
	CotisationRepository cotisRepo;

	@GetMapping("/api/cotisations") // retourne la liste des cotisations au format JSON
	public ResponseEntity<List<Cotisation>> findAllCotisation() {

		List<Cotisation> allCoti = this.cotisRepo.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(allCoti);
	}

	@RequestMapping(value = "/api/cotisations/{code}", method = RequestMethod.GET) // retourne un objet Cotisation à
																					// partir du code fourni

	public ResponseEntity<?> findCotisation(@PathVariable String code) {
		Cotisation cotisa = this.cotisRepo.findByCode(code);
		if (cotisa != null) {
			return ResponseEntity.ok(this.cotisRepo.findByCode(code));
		} else {
			return ResponseEntity.badRequest().body("message : Code de cotisations non trouvé");
		}
	}
	
	// ici on creer une nouvelle cotisation dans la BDD
	@RequestMapping(value = "/api/cotisations", method = RequestMethod.POST)
	@ResponseBody
	public Cotisation creerCotisation(@RequestBody Cotisation cotis) {
		return cotisRepo.save(cotis);
	}

	//modifier une cotisation a partir de son code
	@PutMapping(value = "/api/cotisations/{code}")
	public Cotisation modifCotisation(@RequestBody Cotisation cotis, @PathVariable String code) {
		Cotisation cotisa = this.cotisRepo.findByCode(code);
		cotisa.setLibelle(cotis.getLibelle());
		cotisa.setTauxPatronal(cotis.getTauxPatronal());
		cotisa.setTauxSalarial(cotis.getTauxSalarial());
		cotisa.setImposable(cotis.getImposable());
		return cotisRepo.save(cotisa); 
		}
	//Suppression d'une cotisation par son code
	@RequestMapping (value = "/api/cotisations/{code}", method = RequestMethod.DELETE)
	public void suppCoti(@PathVariable String code) {
		cotisRepo.delete(this.cotisRepo.findByCode(code));
	}
}

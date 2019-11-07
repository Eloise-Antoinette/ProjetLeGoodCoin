package com.example.demo;


import java.util.List;

import javax.validation.Valid;
import com.example.demo.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TheGoodCoinController {

	@Autowired
	TheGoodCoinService myService;

	@RequestMapping("/")
	public String homePage (Model m, @RequestParam (name="page", defaultValue="0") int i) {
		Pageable pageWithTwoAdds = PageRequest.of(i, 2);
		Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);
		m.addAttribute("annonces", annonces.getContent());
		m.addAttribute("annonce", new Annonce());
		m.addAttribute("nbDePages", annonces.getTotalPages()-1);
		m.addAttribute("currentPage", i);
		List<Utilisateur> utilisateurs= myService.findAllUsers();
		m.addAttribute("utilisateurs", utilisateurs);
		return "index";
	}
	
	@RequestMapping("/formAnnonce")
	public ModelAndView formAnnonce() {		
		return new ModelAndView("formAnnonce", "annonce", new Annonce());
	}
		
	
	
	@RequestMapping("/formUser")
	public ModelAndView formUser() {
		return new ModelAndView("formUser", "utilisateur", new Utilisateur());
	}
	
	@RequestMapping("/formConnexion")
	public ModelAndView formConnexion() {		
		return new ModelAndView("formConnexion", "utilisateur", new Utilisateur());
	}
		
	
	
	@RequestMapping("/searchTitle")
	public String homePage (Model m, 
			@RequestParam (name="title") String title, 
			@RequestParam (name="ville") String ville,
			@RequestParam (name="description") String description,
			@Valid @ModelAttribute("annonce")final Annonce annonce, 
			final BindingResult result) {
		List<Annonce> annonces = null;
		
		if(!title.isEmpty() && !ville.isEmpty() && !description.isEmpty()) {
			annonces = myService.findAllBySoldTrueAndTitleContainsOrVilleContainsOrDescriptionContains(title, ville, description);
		} else if(!title.isEmpty() && !ville.isEmpty() && description.isEmpty()) {
			annonces = myService.findAllBySoldTrueAndTitleContainsOrVilleContains(title, ville);
		} else if(!title.isEmpty() && ville.isEmpty() && !description.isEmpty()) {
			annonces = myService.findAllBySoldTrueAndTitleContainsOrDescriptionContains(title, description);
		} else if(title.isEmpty() && ville.isEmpty() && !description.isEmpty()) {
			annonces = myService.findAllBySoldTrueAndVilleContainsOrDescriptionContains(ville, description);
		} else if(description.isEmpty() && !title.isEmpty() && ville.isEmpty()) {
			annonces = myService.findAllBySoldTrueAndTitleContains(title);
		} else if(description.isEmpty() && title.isEmpty() && !ville.isEmpty()) {
			annonces = myService.findAllBySoldTrueAndVilleContains(ville);
		} else if(!description.isEmpty() && title.isEmpty() && !ville.isEmpty()) {
			annonces = myService.findAllByDescriptionAndSoldTrue(description);	
		}
		
		List<Utilisateur> utilisateurs= myService.findAllUsers();
		m.addAttribute("utilisateurs", utilisateurs);
		m.addAttribute("annonces", annonces);
		return "index";
	}
	
// ----- AJOUTER UNE ANNONCE	
	
	@RequestMapping(value="/addAnnonce", method = RequestMethod.POST)
		public String submitAnnonce(
		@Valid @ModelAttribute("annonce")final Annonce annonce, 
		final BindingResult result, 
		final ModelMap m)
	{
		
		
		
        if (result.hasErrors()) {
        	m.addAttribute("erreur", result);
            return "formAnnonce";
        }
        
        
    myService.save(annonce);
    
    
    Pageable pageWithTwoAdds = PageRequest.of(0, 2);
	Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);	
	m.addAttribute("annonces", annonces.getContent());
	m.addAttribute("annonce", new Annonce());
	List<Utilisateur> utilisateurs= myService.findAllUsers();
	m.addAttribute("utilisateurs", utilisateurs);
	m.addAttribute("nbDePages", annonces.getTotalPages()-1);
	
	return "index";
}
	
	
// ----- AJOUTER UTILISATEUR	
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String submitUtilisateur(
	@Valid @ModelAttribute("utilisateur")final Utilisateur utilisateur, 
	final BindingResult result, 
	final ModelMap m)
{
    if (result.hasErrors()) {
    	m.addAttribute("erreur", result);
        return "formUser";
    }
    myService.save(utilisateur);
	m.addAttribute("annonce", new Annonce());
	List<Utilisateur> utilisateurs= myService.findAllUsers();
	m.addAttribute("utilisateurs", utilisateurs);
	return "index";
	}	

	
// ----- SUPPRIMER UNE ANNONCE
		
	@RequestMapping(value="/delete")
	public String deleteThisAdd(Model m, @RequestParam (name="id") int i) {

		myService.setOneSold(i, false);
		myService.save(myService.annonceRepo.findById(i).get());

	    Pageable pageWithTwoAdds = PageRequest.of(0, 2);
		Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);	
		m.addAttribute("annonces", annonces.getContent());
		m.addAttribute("annonce", new Annonce());
		List<Utilisateur> utilisateurs= myService.findAllUsers();
		m.addAttribute("utilisateurs", utilisateurs);
		m.addAttribute("nbDePages", annonces.getTotalPages()-1);
		
		return "index";
		
	}
	
// ------- SE CONNECTER
	@RequestMapping(value="/connexion")
	public String connexion(@Valid @ModelAttribute("annonce")final Utilisateur utilisateur, 
			final BindingResult result, 
			final ModelMap m) {
		m.addAttribute("utilisateurConnecté", myService.findUserByName(utilisateur.getUtilisateurName()));
		System.out.println(myService.findUserByPassword(utilisateur.getMotDePasse()).getMotDePasse());
		System.out.println(myService.findUserByName(utilisateur.getUtilisateurName()).getUtilisateurName());
		if(utilisateur.getUtilisateurName() == myService.findUserByName(utilisateur.getUtilisateurName()).getUtilisateurName() && utilisateur.getMotDePasse() == myService.findUserByPassword(utilisateur.getMotDePasse()).getMotDePasse()
	){
		
			return "connected";
		} else {
			return "connexionError";
		}

		
	}

}

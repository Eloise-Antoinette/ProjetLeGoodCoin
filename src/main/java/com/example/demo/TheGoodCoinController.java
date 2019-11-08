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

	//----------------------------------------PAGE D'ACCUEIL-------------------------------------
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

	//----------------------------------------RENVOI DES PAGES----------------
//	@RequestMapping("/formAnnonce")
//	public ModelAndView formAnnonce() {		
//		return new ModelAndView("formAnnonce", "annonce", new Annonce());
//	}
		
	@RequestMapping("/formAnnonce")
	public String formAnnonce(
			@RequestParam (name="utilisateurConnecte") String utilisateurConnecte,			
			@Valid @ModelAttribute("annonce")final Annonce annonce, 
			final BindingResult result, 
			final ModelMap m) {
		Utilisateur utilisateurConnectei = myService.findUserByName(utilisateurConnecte);
		m.addAttribute("utilisateurConnecte", utilisateurConnectei);
		m.addAttribute("annonce", new Annonce());
		return "formAnnonce";
	}
	

	
	
	@RequestMapping("/formUser")
	public ModelAndView formUser() {
		return new ModelAndView("formUser", "utilisateur", new Utilisateur());
	}
	
	
	@RequestMapping("/formConnexion")
	public ModelAndView formConnexion() {		
		return new ModelAndView("formConnexion", "utilisateur", new Utilisateur());
	}
	
	@RequestMapping("/monCompte")
	public String monCompte(Model m,
			@RequestParam (name="utilisateurConnecte") String utilisateurConnecte) {
		Utilisateur utilisateurConnectei = myService.findUserByName(utilisateurConnecte);
		m.addAttribute("utilisateurConnecte", utilisateurConnectei);
		Utilisateur utilisateur = myService.findUserByName(utilisateurConnecte);
		List<Annonce> annonces= myService.findAllByProprietaire(utilisateur.getUtilisateurId());
		System.out.println(annonces.get(0));
		m.addAttribute("annonces", annonces);
		return "monCompte";
	}
	
	
	//----------------------------------------RECHERCHE--------------------------	
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
	
	//----------------------------------------CREER UNE ANNONCE--------------------
	
	@RequestMapping(value="/addAnnonce", method = RequestMethod.POST)
		public String submitAnnonce(
		@RequestParam (name = "utilisateurConnecte") String utilisateurConnecte,
		@Valid @ModelAttribute("annonce")final Annonce annonce, 
		final BindingResult result, 
		final ModelMap m)
	{
		
		
		
        if (result.hasErrors()) {
        	m.addAttribute("erreur", result);
            return "formAnnonce";
        }
        
        
    myService.save(annonce);
    
    m.addAttribute("utilisateurConnecte", myService.findUserByName(utilisateurConnecte));
    Pageable pageWithTwoAdds = PageRequest.of(0, 2);
	Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);	
	m.addAttribute("annonces", annonces.getContent());
	m.addAttribute("annonce", new Annonce());
	List<Utilisateur> utilisateurs= myService.findAllUsers();
	m.addAttribute("utilisateurs", utilisateurs);
	m.addAttribute("nbDePages", annonces.getTotalPages()-1);
	
	return "index";
}
	
	
	//----------------------------------------CREER UTILISATEUR---------------------------
	
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

	
	//----------------------------------------SUPPRIMER UNE ANNONCE-------------------------------------
		
	@RequestMapping(value="/delete")
	public String deleteThisAdd(Model m, @RequestParam (name="id") int i, @RequestParam (name ="utilisateurConnecte") String utilisateurConnecte) {

		myService.setOneSold(i, false);
		myService.save(myService.annonceRepo.findById(i).get());

	    Pageable pageWithTwoAdds = PageRequest.of(0, 2);
		Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);
		m.addAttribute("utilisateurConnecte", myService.findUserByName(utilisateurConnecte));
		m.addAttribute("annonces", annonces.getContent());
		m.addAttribute("annonce", new Annonce());
		List<Utilisateur> utilisateurs= myService.findAllUsers();
		m.addAttribute("utilisateurs", utilisateurs);
		m.addAttribute("nbDePages", annonces.getTotalPages()-1);
		
		return "index";
		
	}
	
	//----------------------------------------ACTIVER UNE ANNONCE-------------------------------------
	
	@RequestMapping(value="/activer")
	public String activateThisAdd(Model m, @RequestParam (name="id") int i) {

		myService.setOneSold(i, true);
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
	public String connexion(@Valid @ModelAttribute("utilisateur")final Utilisateur utilisateur, 
			final BindingResult result, 
			final ModelMap m) {

		if(utilisateur == null || utilisateur.getUtilisateurName() == null || utilisateur.getMotDePasse() == null || myService.findUserByName(utilisateur.getUtilisateurName()) == null ||  myService.findUserByPassword(utilisateur.getMotDePasse()) == null) {
			return "connexionError";
		}
		else if(utilisateur.getUtilisateurName().equals( myService.findUserByName(utilisateur.getUtilisateurName()).getUtilisateurName()) 
				&& utilisateur.getMotDePasse().equals(myService.findUserByName(utilisateur.getUtilisateurName()).getMotDePasse()) ){
			m.addAttribute("utilisateurConnecte", myService.findUserByName(utilisateur.getUtilisateurName()));
			return "connected";
		
		} else {
			return "connexionError";
		}

		
	}
	
	@RequestMapping(value="/session")
	public String session(Model m, @RequestParam (name="page", defaultValue="0") int i, @RequestParam (name = "utilisateur") String utilisateurName) {
			Pageable pageWithTwoAdds = PageRequest.of(i, 2);
			Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);
			System.out.println(utilisateurName + "string request Param");
			Utilisateur utilisateurConnecte = myService.findUserByName(utilisateurName);
			System.out.println(utilisateurConnecte.getUtilisateurName() + "attribute addé");
			m.addAttribute("utilisateurConnecte", utilisateurConnecte);
			m.addAttribute("annonces", annonces.getContent());
			m.addAttribute("annonce", new Annonce());
			m.addAttribute("nbDePages", annonces.getTotalPages()-1);
			m.addAttribute("currentPage", i);
			List<Utilisateur> utilisateurs= myService.findAllUsers();
			m.addAttribute("utilisateurs", utilisateurs);
			return "index";
	}


}
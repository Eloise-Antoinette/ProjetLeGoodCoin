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
	public String homePage (Model m, @RequestParam (name="page") int i) {
		Pageable pageWithTwoAdds = PageRequest.of(i, 2);
		Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);
		m.addAttribute("annonces", annonces.getContent());
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
	
	@RequestMapping("/searchTitle")
	public String homePage (Model m, 
			@RequestParam (name="title") String title,
			@Valid @ModelAttribute("annonce")final Annonce annonce, 
			final BindingResult result) {
		List<Annonce> annonces = myService.findByTitle(title);
		List<Utilisateur> utilisateurs= myService.findAllUsers();
		m.addAttribute("utilisateurs", utilisateurs);
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
    
    
    Pageable pageWithTwoAdds = PageRequest.of(1, 2);
	Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);	
	m.addAttribute("annonces", annonces.getContent());	
	List<Utilisateur> utilisateurs= myService.findAllUsers();
	m.addAttribute("utilisateurs", utilisateurs);
	m.addAttribute("nbDePages", annonces.getTotalPages());
	
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
	List<Utilisateur> utilisateurs= myService.findAllUsers();
	m.addAttribute("utilisateurs", utilisateurs);
	return "index";
	}	

	
// ----- SUPPRIMER UNE ANNONCE
		
	@RequestMapping(value="/delete")
	public String deleteThisAdd(Model m, @RequestParam (name="id") int i) {
		System.out.println("delete");
		myService.setOneSold(i, false);
		myService.save(myService.annonceRepo.findById(i).get());
		System.out.println("delete 2 ");
		Pageable pageWithTwoAdds = PageRequest.of(i, 2);
		Page<Annonce> annonces= myService.findTrueAnnonces(pageWithTwoAdds);
		m.addAttribute("annonces", annonces.getContent());
		m.addAttribute("nbDePages", annonces.getTotalPages()-1);
		m.addAttribute("currentPage", i);
		List<Utilisateur> utilisateurs= myService.findAllUsers();
		m.addAttribute("utilisateurs", utilisateurs);
		return "index";
		
	}
	

}

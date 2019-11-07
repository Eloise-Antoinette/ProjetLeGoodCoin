package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TheGoodCoinService {

	@Autowired 
	AnnonceRepository annonceRepo;
	@Autowired
	UtilisateurRepository utilisateurRepo;

	
	
	public Page<Annonce> findTrueAnnonces(Pageable p) {

		return annonceRepo.findAllBySoldTrue(p);
		
	}
	
	public List<Utilisateur> findAllUsers() {
		return utilisateurRepo.findAll();
	}
	
	public void save(Annonce annonce) {
		annonceRepo.save(annonce);
	}

	public void save(@Valid Utilisateur utilisateur) {
		utilisateurRepo.save(utilisateur);
		
	}
	
	public void setOneSold(int i, boolean b  ) {
		annonceRepo.findById(i).get().setSold(b);
		System.out.println("setSold from repository");
	}

	public List<Annonce> findByTitleAndSoldTrue(String title) {
		return annonceRepo.findByTitleAndSoldTrue(title);
	}
	
	public List<Annonce> findAllBySoldTrueAndTitleContainsOrVilleContainsOrDescriptionContains(String title, String ville, String description){
		return annonceRepo.findAllBySoldTrueAndTitleContainsOrVilleContainsOrDescriptionContains(title, ville, description);
	}

	public List<Annonce> findAllBySoldTrueAndTitleContainsOrVilleContains(String title, String ville) {
		return annonceRepo.findAllBySoldTrueAndTitleContainsOrVilleContains(title, ville);
	}

	public List<Annonce> findAllBySoldTrueAndTitleContains(String title) {
		return annonceRepo.findAllBySoldTrueAndTitleContains(title);
	}

	public List<Annonce> findAllBySoldTrueAndVilleContains(String ville) {
		return annonceRepo.findAllBySoldTrueAndVilleContains(ville);
	}

	public List<Annonce> findAllBySoldTrueAndTitleContainsOrDescriptionContains(String title, String description) {
		return annonceRepo.findAllBySoldTrueAndTitleContainsOrDescriptionContains(title, description);
	}

	public List<Annonce> findAllBySoldTrueAndVilleContainsOrDescriptionContains(String ville, String description) {
		return annonceRepo.findAllBySoldTrueAndVilleContainsOrDescriptionContains(ville, description);
	}



	public List<Annonce> findAllByDescriptionAndSoldTrue(String description) {
		return annonceRepo.findAllBySoldTrueAndDescriptionContains(description);
	}

	public Utilisateur findUserByName(String name) {
		return utilisateurRepo.findByUtilisateurName(name);
	}

	public Utilisateur findUserByPassword(String mdp) {
		return utilisateurRepo.findByMotDePasse(mdp);
	}

}

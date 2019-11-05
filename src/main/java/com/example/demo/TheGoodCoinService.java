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

	public List<Annonce> findByTitle(String title) {
		return annonceRepo.findByTitle(title);
	}
	

}

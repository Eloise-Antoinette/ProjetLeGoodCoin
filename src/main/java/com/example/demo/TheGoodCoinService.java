package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheGoodCoinService {

	@Autowired 
	AnnonceRepository annonceRepo;
	@Autowired
	UtilisateurRepository utilisateurRepo;

	public List<Annonce> findAll() {
		return annonceRepo.findAll();
	}
	
//	public Utilisateur findByName() {
//		return utilisateurRepo.findByName();
//	}
	
}

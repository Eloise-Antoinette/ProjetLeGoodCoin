package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	public Utilisateur findByUtilisateurName(String name);
	
	public Utilisateur findByMotDePasse(String mdp);

}

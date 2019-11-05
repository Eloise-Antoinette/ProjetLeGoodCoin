package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	public int getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	public String getUtilisateurName() {
		return utilisateurName;
	}
	public void setUtilisateurName(String utilisateurName) {
		this.utilisateurName = utilisateurName;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int utilisateurId;
	protected String utilisateurName;
	protected String motDePasse;

}

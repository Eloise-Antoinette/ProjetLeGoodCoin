package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "annonce")
public class Annonce {
	
	@Id
	@GeneratedValue
	protected int annonceId;
	protected String title;
	protected String description;
	protected LocalDate postDate;
	protected int prix;
	protected int proprietaire;
	protected String ville;
	protected int codePostal;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return postDate;
	}
	public void setDate(LocalDate date) {
		this.postDate = date;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(int proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	

}

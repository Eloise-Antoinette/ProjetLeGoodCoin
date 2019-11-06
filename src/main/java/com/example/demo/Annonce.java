package com.example.demo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "annonce")
public class Annonce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int annonceId;
	@NotBlank(message = "Champ obligatoire !")
	protected String title;
	@NotBlank(message = "Champ obligatoire !")
	protected String description;
	protected Date postDate = new Date();	
// @Pattern(regexp="^(0|[1-9][0-9]*",message="prix")  
	protected Integer prix;
	protected int proprietaire;
	protected String ville;
	protected int codePostal;
	protected boolean sold = true;
	

	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;

		System.out.println("setSold from annonce");
	}
	public int getAnnonceId() {
		return annonceId;
	}
	public void setAnnonceId(int annonceId) {
		this.annonceId = annonceId;
	}	
	public Date getPostDate() {
		return postDate;
		
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
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

	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
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

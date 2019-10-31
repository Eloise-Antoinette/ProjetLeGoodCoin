package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue
	protected int utilisateurId;
	protected String utilisateurName;
	protected String motDePasse;

}

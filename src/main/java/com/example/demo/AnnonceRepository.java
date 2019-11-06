package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Integer> {

	public Page<Annonce> findAllBySoldTrue(Pageable p);
	
	public List<Annonce> findByTitleAndSoldTrue(String title);

	public List<Annonce> findAllBySoldTrueAndTitleContainsOrVilleContains(String title, String ville);

	public List<Annonce> findAllBySoldTrueAndTitleContains(String title);

	public List<Annonce> findAllBySoldTrueAndVilleContains(String ville);

	public List<Annonce> findAllBySoldTrueAndTitleContainsOrVilleContainsOrDescriptionContains(String title,
			String ville, String description);

	public List<Annonce> findAllBySoldTrueAndTitleContainsOrDescriptionContains(String title, String description);

	public List<Annonce> findAllBySoldTrueAndVilleContainsOrDescriptionContains(String ville, String description);

	public List<Annonce> findAllBySoldTrueAndDescriptionContains(String description);
	
}

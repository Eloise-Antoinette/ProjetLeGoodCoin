package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnnonceRepository extends PagingAndSortingRepository<Annonce, Integer> {

	public Page<Annonce> findAllBySoldTrue(Pageable p);
	
	public List<Annonce> findByTitle(String title);
	
}

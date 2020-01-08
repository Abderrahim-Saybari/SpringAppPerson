package com.exemple.personne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.exemple.personne.beans.Personne;

@Service
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	

}

package com.exemple.personne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.exemple.personne.beans.User;

@Service
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}

package com.ResumeMatcher.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeMatcher.space.entities.Administrateur;

@Repository
public interface AdminRepo extends JpaRepository<Administrateur, Long> {

}

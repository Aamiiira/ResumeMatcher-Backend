package com.ResumeMatcher.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeMatcher.space.entities.Candidat;

@Repository
public interface CandidatRepo extends JpaRepository<Candidat, Long> {

}

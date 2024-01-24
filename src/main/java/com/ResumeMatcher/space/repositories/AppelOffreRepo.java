package com.ResumeMatcher.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ResumeMatcher.space.entities.AppelOffre;

@Repository
public interface AppelOffreRepo extends JpaRepository<AppelOffre, Long> {

}

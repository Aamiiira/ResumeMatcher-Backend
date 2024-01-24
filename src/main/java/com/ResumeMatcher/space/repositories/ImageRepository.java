package com.ResumeMatcher.space.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ResumeMatcher.space.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	
}

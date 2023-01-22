package com.myCV.AboutMebackend.repository;

import com.myCV.AboutMebackend.entity.BackendExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendExperienceRepo extends JpaRepository<BackendExperience, Long> {
}

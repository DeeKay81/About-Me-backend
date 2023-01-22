package com.myCV.AboutMebackend.repository;

import com.myCV.AboutMebackend.entity.FrontendExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontendExperienceRepo extends JpaRepository<FrontendExperience, Long> {
}

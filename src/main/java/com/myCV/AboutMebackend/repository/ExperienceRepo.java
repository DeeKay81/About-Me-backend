package com.myCV.AboutMebackend.repository;

import com.myCV.AboutMebackend.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
}

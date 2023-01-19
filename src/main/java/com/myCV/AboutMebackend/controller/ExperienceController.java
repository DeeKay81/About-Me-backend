package com.myCV.AboutMebackend.controller;

import com.myCV.AboutMebackend.entity.Experience;
import com.myCV.AboutMebackend.repository.ExperienceRepo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Resource
    private ExperienceRepo experienceRepo;

    @PostMapping("/save")
    public String saveExperience(@RequestBody Experience experience) {
        experienceRepo.save(experience);
        return "Experience saved successfully.";
    }

    @GetMapping("/all")
    public List<Experience> getAllExperiences() {
        return experienceRepo.findAll();
    }

    @PutMapping("/update/{id}")
    public String updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        Experience updatedExperience = experienceRepo.findById(id).orElseThrow();
        updatedExperience.setFrontendSkill(experience.getFrontendSkill());
        updatedExperience.setFrontendExperience(experience.getFrontendExperience());
        updatedExperience.setBackendSkill(experience.getBackendSkill());
        updatedExperience.setBackendExperience(experience.getBackendExperience());
        experienceRepo.save(updatedExperience);
        return "Experience updated successfully.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExperience(@PathVariable Long id) {
        Experience deletedExperience = experienceRepo.findById(id).orElseThrow();
        experienceRepo.delete(deletedExperience);
        return "Experience deleted successfully.";
    }
}

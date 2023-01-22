package com.myCV.AboutMebackend.controller;

import com.myCV.AboutMebackend.entity.FrontendExperience;
import com.myCV.AboutMebackend.repository.FrontendExperienceRepo;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frontend-experience")
public class FrontendExperienceController {

    @Resource
    private FrontendExperienceRepo frontendExperienceRepo;

    @PostMapping
    public ResponseEntity saveExperience(@RequestBody FrontendExperience frontendExperience) {
        FrontendExperience savedFrontendExperience = frontendExperienceRepo.save(frontendExperience);
        return new ResponseEntity<>(savedFrontendExperience, HttpStatus.OK);
    }

    @GetMapping
    public List<FrontendExperience> getAllExperiences() {
        return frontendExperienceRepo.findAll();
    }

    @GetMapping("/{id}")
    public FrontendExperience getExperienceById(@PathVariable Long id) {
        return frontendExperienceRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateExperience(@PathVariable Long id, @RequestBody FrontendExperience frontendExperience) {
        FrontendExperience currentFrontendExperience = frontendExperienceRepo.findById(id).orElseThrow(RuntimeException::new);
        currentFrontendExperience.setFrontendSkill(frontendExperience.getFrontendSkill());
        currentFrontendExperience.setFrontendExperience(frontendExperience.getFrontendExperience());
        frontendExperienceRepo.save(currentFrontendExperience);
        return new ResponseEntity<>(currentFrontendExperience, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExperience(@PathVariable Long id) {
        frontendExperienceRepo.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}

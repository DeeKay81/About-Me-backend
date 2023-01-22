package com.myCV.AboutMebackend.controller;

import com.myCV.AboutMebackend.entity.BackendExperience;
import com.myCV.AboutMebackend.repository.BackendExperienceRepo;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backend-experience")
public class BackendExperienceController {

    @Resource
    private BackendExperienceRepo backendExperienceRepo;

    @PostMapping
    public ResponseEntity saveExperience(@RequestBody BackendExperience backendExperience) {
        BackendExperience savedBackendExperience = backendExperienceRepo.save(backendExperience);
        return new ResponseEntity<>(savedBackendExperience, HttpStatus.OK);
    }

    @GetMapping
    public List<BackendExperience> getAllExperiences() {
        return backendExperienceRepo.findAll();
    }

    @GetMapping("/{id}")
    public BackendExperience getExperienceById(@PathVariable Long id) {
        return backendExperienceRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateExperience(@PathVariable Long id, @RequestBody BackendExperience backendExperience) {
        BackendExperience currentBackendExperience = backendExperienceRepo.findById(id).orElseThrow(RuntimeException::new);
        currentBackendExperience.setBackendSkill(backendExperience.getBackendSkill());
        currentBackendExperience.setBackendExperience(backendExperience.getBackendExperience());
        backendExperienceRepo.save(currentBackendExperience);
        return new ResponseEntity<>(currentBackendExperience, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExperience(@PathVariable Long id) {
        backendExperienceRepo.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}

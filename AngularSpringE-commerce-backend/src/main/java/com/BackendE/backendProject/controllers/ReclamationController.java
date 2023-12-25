package com.BackendE.backendProject.controllers;

// ReclamationController.java (Controller)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BackendE.backendProject.models.Reclamation;
import com.BackendE.backendProject.requests.ReclamationReq;
import com.BackendE.backendProject.services.ReclamationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("reclamations")
public class ReclamationController {

    @Autowired
    private  ReclamationService reclamationService;


    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Long id) {
        Reclamation reclamation = reclamationService.getReclamationById(id);
        return reclamation != null
                ? ResponseEntity.ok(reclamation)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Reclamation> createReclamation(@RequestBody ReclamationReq reclamation) {
        Reclamation createdReclamation = reclamationService.createReclamation(reclamation);
        return new ResponseEntity<>(createdReclamation, HttpStatus.CREATED);
    }

    /*
     * @PutMapping("/{id}")
     * public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long
     * id, @RequestBody Reclamation reclamation) {
     * Reclamation updatedReclamation = reclamationService.updateReclamation(id,
     * reclamation);
     * return updatedReclamation != null
     * ? ResponseEntity.ok(updatedReclamation)
     * : ResponseEntity.notFound().build();
     * }
     * 
     * @DeleteMapping("/{id}")
     * public ResponseEntity<Void> deleteReclamation(@PathVariable Long id) {
     * reclamationService.deleteReclamation(id);
     * return ResponseEntity.noContent().build();
     * }
     */
}

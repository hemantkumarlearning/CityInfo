package com.hemant.controller;

import com.hemant.model.Landmark;
import com.hemant.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LandService landService;

    @GetMapping
    public String profile() {
        return "admin_profile";
    }

    @PostMapping
 //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Landmark> saveLandmarks(@RequestBody Landmark landmark){

        Landmark landmark1 = landService.saveLandmark(landmark);
        return ResponseEntity.status(HttpStatus.CREATED).body(landmark1);
    }

    @PutMapping("/{id}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Landmark> updateLandmark(@PathVariable Long id, @RequestBody Landmark landmark) {
        Landmark updatedLandmark = landService.updateLandmark(id, landmark);
        return ResponseEntity.ok(updatedLandmark);
    }

    @DeleteMapping("/{id}")
 //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLandmark(@PathVariable Long id) {
        landService.deleteLandmark(id);
        return ResponseEntity.noContent().build();
    }

}

package com.hemant.controller;

import com.hemant.model.Landmark;
import com.hemant.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/landmark")
public class LandController {

    @Autowired
    private LandService landService;


   @GetMapping
  // @PreAuthorize("hasRole('USER')")
    public List<Landmark> getAllLandmarks(){
        return landService.getAllLandmarks();
    }

    @GetMapping("/{id}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Landmark> getLandmarkById(@PathVariable Long id) {
        Optional<Landmark> landmark = landService.getLandmarkById(id);
        return landmark.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}

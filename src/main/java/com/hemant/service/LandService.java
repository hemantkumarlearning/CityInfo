package com.hemant.service;

import com.hemant.model.Landmark;
import com.hemant.repository.LandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandService {
    @Autowired
    private LandRepo landRepo;

    public List<Landmark> getAllLandmarks() {
        return landRepo.findAll();
    }

    public Optional<Landmark> getLandmarkById(Long id) {
        return landRepo.findById(id);
    }

    public Landmark saveLandmark(Landmark landmark) {
        return landRepo.save(landmark);
    }

    public Landmark updateLandmark(Long id, Landmark landmark) {
        landmark.setId(id); // ensure the ID is set for update
        return landRepo.save(landmark);
    }

    public void deleteLandmark(Long id) {
        landRepo.deleteById(id);
    }
}

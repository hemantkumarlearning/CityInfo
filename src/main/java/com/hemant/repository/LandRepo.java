package com.hemant.repository;

import com.hemant.model.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandRepo extends JpaRepository<Landmark, Long> {
}

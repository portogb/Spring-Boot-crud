package com.neodevs.checkurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neodevs.checkurb.model.CheckPoint;

@Repository
public interface CheckPointRepository extends JpaRepository<CheckPoint, Long>{
    
}

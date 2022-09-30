package com.neodevs.checkurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neodevs.checkurb.model.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long>{
    
}

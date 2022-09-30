package com.neodevs.checkurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neodevs.checkurb.model.Ambiente;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long>{
    
}

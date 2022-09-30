package com.neodevs.checkurb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neodevs.checkurb.model.Hospede;
import com.neodevs.checkurb.repository.HospedeRepository;

@Service
public class HospedeService {
    
    @Autowired
    private HospedeRepository hospedeRepository;

    public List<Hospede> listarTodos(){
        return hospedeRepository.findAll();
    }

    public Optional<Hospede> buscarPorId(Long id){
        return hospedeRepository.findById(id);
    }

    public Hospede adicionar(Hospede hospede){
        return hospedeRepository.save(hospede);
    }

    public void deletar(Long id){
        hospedeRepository.deleteById(id);
    }

    public Hospede atualizar(Long id, Hospede hospede){
        hospede.setId(id);
        return hospedeRepository.save(hospede);
    }
}

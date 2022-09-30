package com.neodevs.checkurb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neodevs.checkurb.model.CheckPoint;
import com.neodevs.checkurb.repository.CheckPointRepository;

@Service
public class CheckPointService {
    
    @Autowired
    private CheckPointRepository ckRepository;

    public List<CheckPoint> listarTodos(){
        return ckRepository.findAll();
    }

    public Optional<CheckPoint> buscarPorId(Long id){
        return ckRepository.findById(id);
    } 

    public CheckPoint adicionar(CheckPoint checkPoint){
        CheckPoint ck = new CheckPoint();
        ck.setHorario(ck.getHorario());
        ck.setAmbiente(ck.getAmbiente());
        ck.setHospede(ck.getHospede());
        return ckRepository.save(checkPoint);
    }

    public void deletar(Long id){
        ckRepository.deleteById(id);
    }

    public CheckPoint atualizar(Long id, CheckPoint checkPoint){
        checkPoint.setId(id);
        return ckRepository.save(checkPoint);
    }
}

package com.neodevs.checkurb.view.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neodevs.checkurb.model.Ambiente;
import com.neodevs.checkurb.model.CheckPoint;
import com.neodevs.checkurb.model.Hospede;
import com.neodevs.checkurb.service.CheckPointService;

@RestController
@RequestMapping("/checkpoints")
public class CheckPointController {
    
    @Autowired
    private CheckPointService ckService;

    @GetMapping
    public List<CheckPoint> listarTodos(){
        return ckService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CheckPoint> buscaPorId(@PathVariable Long id){
        return ckService.buscarPorId(id);
    }

    @PostMapping
    public CheckPoint adicionar(@RequestBody Calendar horario, @RequestBody Ambiente ambiente, @RequestBody Hospede hospede){
        CheckPoint ck = new CheckPoint();
        ck.setHorario(Calendar.getInstance());
        ck.setAmbiente(ambiente);
        ck.setHospede(hospede);
        return ckService.adicionar(ck);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        ckService.deletar(id);
    }

    @PutMapping("/{id}")
    public CheckPoint atualizar(@PathVariable Long id, @RequestBody CheckPoint checkPoint){
        checkPoint.setId(id);
        return ckService.atualizar(id, checkPoint);
    }
}

package com.neodevs.checkurb.view.controller;

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

import com.neodevs.checkurb.model.Hospede;
import com.neodevs.checkurb.service.HospedeService;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {
    
    @Autowired
    private HospedeService hospedeService;

    @GetMapping
    public List<Hospede> listarTodos(){
        return hospedeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Hospede> buscarPorId(@PathVariable Long id){
        return hospedeService.buscarPorId(id);
    }

    @PostMapping
    public Hospede adicionar(@RequestBody Hospede hospede){
        return hospedeService.adicionar(hospede);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        hospedeService.deletar(id);
    }

    @PutMapping("/{id}")
    public Hospede atualizar(@PathVariable Long id, @RequestBody Hospede hospede){
        return hospedeService.atualizar(id, hospede);
    }
}

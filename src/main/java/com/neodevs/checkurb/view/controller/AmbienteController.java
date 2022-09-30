package com.neodevs.checkurb.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neodevs.checkurb.service.AmbienteService;
import com.neodevs.checkurb.shared.AmbienteDto;
import com.neodevs.checkurb.view.model.AmbienteRequest;
import com.neodevs.checkurb.view.model.AmbienteResponse;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {
    
    @Autowired
    private AmbienteService ambienteService;

    @GetMapping
    public ResponseEntity<List<AmbienteResponse>> listarTodos(){
        List<AmbienteDto> ambientesDto = ambienteService.listarTodos();

        ModelMapper modelMapper = new ModelMapper();

        List<AmbienteResponse> ambienteResponse = ambientesDto.stream()
        .map(ambiente -> modelMapper.map(ambiente, AmbienteResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(ambienteResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AmbienteResponse>> buscarPorId(@PathVariable Long id){
        Optional<AmbienteDto> ambienteDto = ambienteService.buscarPorId(id);
        
        ModelMapper modelMapper = new ModelMapper();

        AmbienteResponse ambienteResponse = modelMapper
        .map(ambienteDto.get(), AmbienteResponse.class);

        return new ResponseEntity<>(Optional.of(ambienteResponse), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AmbienteResponse> adicionar(@RequestBody AmbienteRequest ambienteRequest){
        ModelMapper modelMapper = new ModelMapper();

        AmbienteDto ambienteDto = modelMapper.map(ambienteRequest, AmbienteDto.class);

        ambienteDto = ambienteService.adicionar(ambienteDto);

        AmbienteResponse ambienteResponse = modelMapper.map(ambienteDto, AmbienteResponse.class);

        return new ResponseEntity<>(ambienteResponse, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        ambienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AmbienteResponse> atualizar(@PathVariable Long id, @RequestBody AmbienteRequest ambienteRequest){
         ModelMapper modelMapper = new ModelMapper();

         AmbienteDto ambienteDto = modelMapper.map(ambienteRequest, AmbienteDto.class);

         ambienteDto = ambienteService.atualizar(id, ambienteDto);

         AmbienteResponse ambienteResponse = modelMapper.map(ambienteDto, AmbienteResponse.class);

         return new ResponseEntity<>(ambienteResponse, HttpStatus.OK);
    }
}

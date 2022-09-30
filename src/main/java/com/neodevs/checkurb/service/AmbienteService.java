package com.neodevs.checkurb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neodevs.checkurb.model.Ambiente;
import com.neodevs.checkurb.repository.AmbienteRepository;
import com.neodevs.checkurb.shared.AmbienteDto;

@Service
public class AmbienteService {
 
    @Autowired
    private AmbienteRepository ambienteRepository;

    public List<AmbienteDto> listarTodos(){
        List<Ambiente> ambientes = ambienteRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return ambientes.stream()
        .map(ambiente -> modelMapper.map(ambiente, AmbienteDto.class))
        .collect(Collectors.toList());
    }

    public Optional<AmbienteDto> buscarPorId(Long id){
        Optional<Ambiente> ambiente = ambienteRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        AmbienteDto ambienteDto = modelMapper.map(ambiente.get(), AmbienteDto.class);
        return Optional.of(ambienteDto);
    }

    public AmbienteDto adicionar(AmbienteDto ambienteDto){
        ambienteDto.setId(null);
        ModelMapper modelMapper = new ModelMapper();
        Ambiente ambiente = modelMapper.map(ambienteDto, Ambiente.class);
        ambiente = ambienteRepository.save(ambiente);
        ambienteDto.setId(ambiente.getId());
        return ambienteDto;
    }

    public void deletar(Long id){
       Optional<Ambiente> ambiente = ambienteRepository.findById(id);
       ambienteRepository.deleteById(ambiente.get().getId());
    }

    public AmbienteDto atualizar(Long id, AmbienteDto ambienteDto){
        ambienteDto.setId(id);
        ModelMapper modelMapper = new ModelMapper();
        Ambiente ambiente = modelMapper.map(ambienteDto, Ambiente.class);
        ambiente = ambienteRepository.save(ambiente);
        return ambienteDto;
    }
}

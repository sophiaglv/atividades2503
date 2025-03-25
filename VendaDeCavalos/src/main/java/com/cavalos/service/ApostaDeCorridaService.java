package com.cavalos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavalos.entities.ApostaDeCorrida;
import com.cavalos.repository.ApostaDeCorridaRepository;

@Service
public class ApostaDeCorridaService {
	private final ApostaDeCorridaRepository apostaDeCorridaRepository;
	
	@Autowired
	public ApostaDeCorridaService(ApostaDeCorridaRepository apostaDeCorridaRepository) {
		this.apostaDeCorridaRepository = apostaDeCorridaRepository;
	}
	
	public ApostaDeCorrida saveApostaDeCorrida(ApostaDeCorrida apostaDeCorrida) {
		return apostaDeCorridaRepository.save(apostaDeCorrida);
	}
	
	public ApostaDeCorrida getApostaDeCorridaById(Long id) {
		return apostaDeCorridaRepository.findById(id).orElse(null);
	}
	
	public ApostaDeCorrida alterarApostaDeCorrida(Long id, ApostaDeCorrida alterarApostaDeCorrida) {
		Optional <ApostaDeCorrida> existeApostaDeCorrida = apostaDeCorridaRepository.findById(id);
		if(existeApostaDeCorrida.isPresent()) {
			alterarApostaDeCorrida.setId(id);
			return apostaDeCorridaRepository.save(alterarApostaDeCorrida);
		}
		return null;
	}
	
	public List<ApostaDeCorrida> getAllApostaDeCorrida(){
		return apostaDeCorridaRepository.findAll();
	}
	
	public void deleteApostaDeCorrida(Long id) {
		apostaDeCorridaRepository.deleteById(id);
	}
}

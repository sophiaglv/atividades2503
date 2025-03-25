package com.cavalos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavalos.entities.Haras;
import com.cavalos.repository.HarasRepository;

@Service
public class HarasService {
	private final HarasRepository harasRepository;
	
	@Autowired
	public HarasService(HarasRepository harasRepository) {
		this.harasRepository = harasRepository;
	}
	
	public Haras saveHaras(Haras haras) {
		return harasRepository.save(haras);
	}
	
	public Haras getHarasById(Long id) {
		return harasRepository.findById(id).orElse(null);
	}
	
	public Haras alterarHaras(Long id, Haras alterarHaras) {
		Optional <Haras> existeHaras = harasRepository.findById(id);
		if(existeHaras.isPresent()) {
			alterarHaras.setId(id);
			return harasRepository.save(alterarHaras);
		}
		return null;
	}
	
	public List<Haras> getAllHaras(){
		return harasRepository.findAll();
	}
	
	public void deleteHaras(Long id) {
		harasRepository.deleteById(id);
	}
}

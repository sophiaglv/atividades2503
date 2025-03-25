package com.cavalos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavalos.entities.Cavalo;
import com.cavalos.repository.CavaloRepository;

@Service
public class CavaloService {
	private final CavaloRepository cavaloRepository;
	
	@Autowired
	public CavaloService(CavaloRepository cavaloRepository) {
		this.cavaloRepository = cavaloRepository;
	}
	
	public Cavalo saveCavalo(Cavalo cavalo) {
		return cavaloRepository.save(cavalo);
	}
	
	public Cavalo getCavaloById(Long id) {
		return cavaloRepository.findById(id).orElse(null);
	}
	
	public Cavalo alterarCavalo(Long id, Cavalo alterarCavalo) {
		Optional <Cavalo> existeCavalo = cavaloRepository.findById(id);
		if(existeCavalo.isPresent()) {
			alterarCavalo.setId(id);
			return cavaloRepository.save(alterarCavalo);
		}
		return null;
	}
	
	public List<Cavalo> getAllCavalo(){
		return cavaloRepository.findAll();
	}
	
	public void deleteCavalo(Long id) {
		cavaloRepository.deleteById(id);
	}
}

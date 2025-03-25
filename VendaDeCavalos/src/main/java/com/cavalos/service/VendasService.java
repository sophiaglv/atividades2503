package com.cavalos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavalos.entities.Vendas;
import com.cavalos.repository.VendasRepository;

@Service
public class VendasService {
	private final VendasRepository vendasRepository;
	
	@Autowired
	public VendasService(VendasRepository vendasRepository) {
		this.vendasRepository = vendasRepository;
	}
	
	public Vendas saveVendas(Vendas vendas) {
		return vendasRepository.save(vendas);
	}
	
	public Vendas getVendasById(Long id) {
		return vendasRepository.findById(id).orElse(null);
	}
	
	public Vendas alterarVendas(Long id, Vendas alterarVendas) {
		Optional <Vendas> existeVendas = vendasRepository.findById(id);
		if(existeVendas.isPresent()) {
			alterarVendas.setId(id);
			return vendasRepository.save(alterarVendas);
		}
		return null;
	}
	
	public List<Vendas> getAllVendas(){
		return vendasRepository.findAll();
	}
	
	public void deleteVendas(Long id) {
		vendasRepository.deleteById(id);
	}
}

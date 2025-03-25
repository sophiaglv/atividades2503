package com.cavalos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavalos.entities.Vendas;
import com.cavalos.service.VendasService;

@RestController
@RequestMapping("/vendas")
public class VendasController {
	private final VendasService vendasService;
	
	@Autowired
	public VendasController(VendasService vendasService) {
		this.vendasService = vendasService;
	}
	
	@PostMapping
	public Vendas createVendas(@RequestBody Vendas vendas) {
		return vendasService.saveVendas(vendas);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vendas> alterarVendas(@PathVariable Long id, @RequestBody Vendas vendas){
		Vendas alterarVendas = vendasService.alterarVendas(id, vendas);
		if(alterarVendas != null) {
			return ResponseEntity.ok(alterarVendas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public Vendas getVendas(@PathVariable Long id) {
		return vendasService.getVendasById(id);
	}
	
	@GetMapping
	public List<Vendas>getAllVendas(){
		return vendasService.getAllVendas();
	}
	
	@DeleteMapping("/{id}")
	public void deleteVendas(@PathVariable Long id) {
		vendasService.deleteVendas(id);
	}
}

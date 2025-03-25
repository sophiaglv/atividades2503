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

import com.cavalos.entities.ApostaDeCorrida;
import com.cavalos.service.ApostaDeCorridaService;

@RestController
@RequestMapping("/aposta")
public class ApostaDeCorridaController {
	private final ApostaDeCorridaService apostaDeCorridaService;
	
	@Autowired
	public ApostaDeCorridaController(ApostaDeCorridaService apostaDeCorridaService) {
		this.apostaDeCorridaService = apostaDeCorridaService;
	}
	
	@PostMapping
	public ApostaDeCorrida createApostaDeCorrida(@RequestBody ApostaDeCorrida apostaDeCorrida) {
		return apostaDeCorridaService.saveApostaDeCorrida(apostaDeCorrida);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApostaDeCorrida> alterarApostaDeCorrida(@PathVariable Long id, @RequestBody ApostaDeCorrida apostaDeCorrida){
		ApostaDeCorrida alterarApostaDeCorrida = apostaDeCorridaService.alterarApostaDeCorrida(id, apostaDeCorrida);
		if(alterarApostaDeCorrida != null) {
			return ResponseEntity.ok(alterarApostaDeCorrida);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ApostaDeCorrida getApostaDeCorrida(@PathVariable Long id) {
		return apostaDeCorridaService.getApostaDeCorridaById(id);
	}
	
	@GetMapping
	public List<ApostaDeCorrida>getAllApostaDeCorrida(){
		return apostaDeCorridaService.getAllApostaDeCorrida();
	}
	
	@DeleteMapping("/{id}")
	public void deleteApostaDeCorrida(@PathVariable Long id) {
		apostaDeCorridaService.deleteApostaDeCorrida(id);
	}
}

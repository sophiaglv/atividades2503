package com.cavalos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "apostaDeCorridas")
public class ApostaDeCorrida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "apostador")
	private String apostador;
	
	@Column (name = "cavaloApostado")
	private String cavaloApostado;
	
	@Column (name = "valorApostado")
	private double valorApostado;
	
	@Column (name = "posicaoApostada")
	private int posicaoApostada;
	
	@Column (name = "posicaoFinal")
	private int posicaoFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApostador() {
		return apostador;
	}

	public void setApostador(String apostador) {
		this.apostador = apostador;
	}

	public String getCavaloApostado() {
		return cavaloApostado;
	}

	public void setCavaloApostado(String cavaloApostado) {
		this.cavaloApostado = cavaloApostado;
	}

	public double getValorApostado() {
		return valorApostado;
	}

	public void setValorApostado(double valorApostado) {
		this.valorApostado = valorApostado;
	}

	public int getPosicaoApostada() {
		return posicaoApostada;
	}

	public void setPosicaoApostada(int posicaoApostada) {
		this.posicaoApostada = posicaoApostada;
	}

	public int getPosicaoFinal() {
		return posicaoFinal;
	}

	public void setPosicaoFinal(int posicaoFinal) {
		this.posicaoFinal = posicaoFinal;
	}
	
	
}

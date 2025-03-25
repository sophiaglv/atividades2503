package com.cavalos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cavalos.entities.Cavalo;

public interface CavaloRepository extends JpaRepository<Cavalo, Long>{

}

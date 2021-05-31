package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Equipo;
import com.repositories.EquipoRepository;

@Component
public class EquipoService {
	
	@Autowired
	EquipoRepository equipoRepo;
	
	protected EntityManager em;
	
	public EquipoService(EntityManager em) {
		this.em = em;
	}
	
	public List<Equipo> getAllEquipos(){
		List<Equipo> equipoList = new ArrayList<>();
		equipoRepo.findAll().forEach(equipoList::add);
		return equipoList;
	}
	
	public void addEquipo(Equipo equipo) {
		equipo = equipoRepo.save(equipo);
	}
	
	public Equipo selectEquipo(int id) {
		Optional<Equipo> e = equipoRepo.findById(id);
		Equipo equipo = e.orElse(null);
		return equipo;
	}
}
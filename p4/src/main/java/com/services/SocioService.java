package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Socio;
import com.repositories.SocioRepository;

@Component
public class SocioService {
	
	@Autowired
	SocioRepository socioRepo;
	
	protected EntityManager em;
	
	public SocioService(EntityManager em) {
		this.em = em;
	}
	
	public List<Socio> getAllSocios(){
		List<Socio> socioList = new ArrayList<>();
		socioRepo.findAll().forEach(socioList::add);
		return socioList;
	}
	
	public void addSocio(Socio socio) {
		socio = socioRepo.save(socio);
	}
	
	public Socio selectSocio(int id) {
		Optional<Socio> e = socioRepo.findById(id);
		Socio socio = e.orElse(null);
		return socio;
	}
}
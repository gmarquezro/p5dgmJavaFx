package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entities.Equipo;
import com.entities.Proyecto;
import com.repositories.ProyectoRepository;

@Component
public class ProyectoService {

	@Autowired
	ProyectoRepository proyectoRepo;
	
	protected EntityManager em;
	
	public ProyectoService(EntityManager em) {
		this.em = em;
	}
	
	public List<Proyecto> getAllProyectos(){
		List<Proyecto> proyectoList = new ArrayList<>();
		proyectoRepo.findAll().forEach(proyectoList::add);
		return proyectoList;
	}
	
	public Proyecto addProyecto(Proyecto proyecto) {
		proyecto = proyectoRepo.save(proyecto);
		return proyecto;
	}
	
	public Proyecto selectProyecto(int id) {
		Optional<Proyecto> e = proyectoRepo.findById(id);
		Proyecto proyecto = e.orElse(null);
		return proyecto;
	}
	
}

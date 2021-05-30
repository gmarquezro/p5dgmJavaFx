package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entities.Proyecto;
import com.repositories.ProyectoRepository;

@Service
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
}

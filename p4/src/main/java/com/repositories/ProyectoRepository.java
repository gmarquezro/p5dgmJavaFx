package com.repositories;

import com.entities.Proyecto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ProyectoRepository extends CrudRepository<Proyecto, Integer>{

}

package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int id;
	public String nombreProyecto;
	public String tipoProyecto;
	public String pais;
	public Date fechaInicio;
	public Date fechaFin;
	//public float financiacionAportada;

	
	public Proyecto (/*int id,*/ String nombreProyecto, String tipoProyecto, String pais,
			Date fechaInicio, Date fechaFin/*, float financiacionAportada*/) {
		
		//this.id = id;
		this.nombreProyecto = nombreProyecto;
		this.tipoProyecto = tipoProyecto;
		this.pais = pais;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		//this.financiacionAportada = financiacionAportada;
	
	}
	
	public Proyecto()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public String getTipoProyecto() {
		return tipoProyecto;
	}
	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/*public float getFinanciacionAportada() {
		return financiacionAportada;
	}
	public void setFinanciacionAportada(float financiacionAportada) {
		this.financiacionAportada = financiacionAportada;
	}*/

	public Proyecto GuardarProyecto() {
		return this;
	}

	public Proyecto ObtenerProyecto() {
		return this;
	}
}
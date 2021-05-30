package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idEquipo;
	private String nombre;
	private Date fechaNacimiento;
	private String direccion;
	private String telefono;
	private String delegacion;
	
	public Equipo() {
		
	}

	public Equipo(String nombre, Date fechaNacimiento, String direccion, String telefono, String delegacion) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.delegacion = delegacion;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", delegacion=" + delegacion + "]";
	}
}
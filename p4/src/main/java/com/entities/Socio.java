package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="socio")
public class Socio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idSocio;
	private String nombreSocio;
	private String direccion;
	private String telefono;
	private String delegacion;
	private String tipoCuota;
	
	
	public Socio() {
		
	}

	public Socio(String nombreSocio, String direccion, String telefono, String delegacion, String tipoCuota) {
		this.nombreSocio = nombreSocio;
		this.direccion = direccion;
		this.telefono = telefono;
		this.delegacion = delegacion;
		this.tipoCuota = tipoCuota;
			
	}

	
	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombre) {
		this.nombreSocio = nombre;
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

	public String getTipoCuota() {
		return tipoCuota;
	}

	public void setTipoCuota(String tipoCuota) {
		this.tipoCuota = tipoCuota;
	}

	
	@Override
	public String toString() {
		return "Socio [idSocio= "+ idSocio +", nombreSocio=" + nombreSocio + ", direccion=" + direccion + ", telefono=" + telefono + ", delegacion="
				+ delegacion + ", tipoCuota=" + tipoCuota + "]";
	}

	
}
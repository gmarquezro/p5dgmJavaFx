package com.controllers;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entities.Equipo;
import com.entities.Proyecto;
import com.services.EquipoService;
import com.services.ProyectoService;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


@Controller
public class MenuController implements Initializable{

	private final HostServices hostServices;
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	EquipoService equipoService;
	
	//INSERTAR EQUIPO
	
	@FXML
	public TextField nombreEquipo;
	
	@FXML
	public TextField direccionEquipo;
	
	@FXML
	public TextField telefonoEquipo;
	
	@FXML
	public TextField delegacionEquipo;
	
	@FXML
	public TextField fechaEquipo;
	
	@FXML
	public Button insertarEquipoButton;
	
	// SELECCIONAR EQUIPO
	
	// MODIFICAR EQUIPO
	
	// ELIMINAR EQUIPO
	
	MenuController(HostServices hostServices){
		this.hostServices = hostServices;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//this.button.setOnAction( actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
		this.insertarEquipoButton.setOnAction( actionEvent -> insertarEquipo());
	}
	
	public void createProyecto()
	{
		try {
			Proyecto p = new Proyecto("Soy la chini loko","Importante","Italia",new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1995"),new SimpleDateFormat("dd/MM/yyyy").parse("13/08/1997")/*,financiacionAportadaFloat*/);
			proyectoService.addProyecto(p);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertarEquipo()
	{
		String nombre = nombreEquipo.getText().toString();
		String fecha = fechaEquipo.getText().toString();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} 
		catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		String direccion = direccionEquipo.getText().toString();
		String telefono = telefonoEquipo.getText().toString();
		String delegacion = delegacionEquipo.getText().toString();
		Equipo e = new Equipo(nombre,fechaNacimiento, direccion, telefono, delegacion); 
		equipoService.addEquipo(e);
		
	}
	
}
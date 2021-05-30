package com.controllers;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entities.Proyecto;
import com.services.ProyectoService;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


@Controller
public class MenuController implements Initializable{

	private final HostServices hostServices;
	
	@Autowired
	ProyectoService proyectoService;
	
	@FXML
	public Button button;
	
	@FXML
	public Label label;
	
	MenuController(HostServices hostServices){
		this.hostServices = hostServices;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//this.button.setOnAction( actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
		this.button.setOnAction( actionEvent -> createProyecto());
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
	
}
package com.controllers;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entities.Equipo;
import com.entities.Proyecto;
import com.repositories.EquipoRepository;
import com.repositories.ProyectoRepository;
import com.services.EquipoService;
import com.services.ProyectoService;

import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;


@Controller
public class MenuController implements Initializable{
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	EquipoService equipoService;
	
	@Autowired
	EquipoRepository equipoRepo;
	
	@Autowired
	ProyectoRepository proyectoRepo;
	
/*
    ______            _           
   / ____/___ ___  __(_)___  ____ 
  / __/ / __ `/ / / / / __ \/ __ \
 / /___/ /_/ / /_/ / / /_/ / /_/ /
/_____/\__, /\__,_/_/ .___/\____/ 
         /_/       /_/           
 */
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
	@FXML
	public TextField selectEquipoField;
	@FXML
	public Button selectEquipoButton;
	@FXML
	public TableView<Equipo> equipoTable;
	@FXML
	public TableColumn<Equipo, String> idEquipoColumn;
	@FXML
	public TableColumn<Equipo, String> nombreEquipoColumn;
	@FXML
	public TableColumn<Equipo, String> fechaEquipoColumn;
	@FXML
	public TableColumn<Equipo, String> telefonoEquipoColumn;
	@FXML
	public TableColumn<Equipo, String> direccionEquipoColumn;
	@FXML
	public TableColumn<Equipo, String> delegacionEquipoColumn;
	ObservableList<Equipo> equipoList = FXCollections.observableArrayList();
	
	// MODIFICAR EQUIPO
	@FXML
	public TextField idEquipoUpdate;
	@FXML
	public TextField nombreEquipoUpdate;
	@FXML
	public TextField direccionEquipoUpdate;
	@FXML
	public TextField telefonoEquipoUpdate;
	@FXML
	public TextField delegacionEquipoUpdate;
	@FXML
	public TextField fechaEquipoUpdate;
	@FXML
	public Button equipoUpdateButton;
	
	// ELIMINAR EQUIPO
	@FXML
	public TextField idEquipoEliminar;
	@FXML
	public Button deleteEquipoButton;
	
/*	   ____                             __      
	   / __ \_________  __  _____  _____/ /_____ 
	  / /_/ / ___/ __ \/ / / / _ \/ ___/ __/ __ \
	 / ____/ /  / /_/ / /_/ /  __/ /__/ /_/ /_/ /
	/_/   /_/   \____/\__, /\___/\___/\__/\____/ 
	                 /____/    
*/
	
		//INSERTAR PROYECTO
		@FXML
		public TextField nombreProyecto;	
		@FXML
		public TextField tipoProyecto;
		@FXML
		public TextField pais;
		@FXML
		public TextField fechaInicio;
		@FXML
		public TextField fechaFin;
		@FXML
		public Button insertProyectoButton;
	
		// SELECCIONAR PROYECTO
		@FXML
		public TextField selectProyectoField;
		@FXML
		public Button selectProyectoButton;
		@FXML
		public TableView<Proyecto> proyectoTable;
		@FXML
		public TableColumn<Equipo, String> idProyectoColumn;
		@FXML
		public TableColumn<Equipo, String> nombreProyectoColumn;
		@FXML
		public TableColumn<Equipo, String> tipoProyectoColumn;
		@FXML
		public TableColumn<Equipo, String> paisColumn;
		@FXML
		public TableColumn<Equipo, String> fechaInicioColumn;
		@FXML
		public TableColumn<Equipo, String> fechaFinColumn;

		ObservableList<Proyecto> proyectoList = FXCollections.observableArrayList();
		
		// MODIFICAR PROYECTO
		@FXML
		public TextField idProyectoUpdate;
		@FXML
		public TextField nombreProyectoUpdate;	
		@FXML
		public TextField tipoProyectoUpdate;
		@FXML
		public TextField paisUpdate;
		@FXML
		public TextField fechaInicioUpdate;
		@FXML
		public TextField fechaFinUpdate;
		@FXML
		public Button modificarProyectoButton;
	
		// ELIMINAR PROYECTO
		@FXML
		public TextField idProyectoEliminar;
		@FXML
		public Button deleteProyectoButton;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//this.button.setOnAction( actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
		this.insertarEquipoButton.setOnAction( actionEvent -> insertarEquipo());
		this.selectEquipoButton.setOnAction( actionEvent -> selectEquipo());
		this.equipoUpdateButton.setOnAction( actionEvent -> updateEquipo());
		this.deleteEquipoButton.setOnAction( actionEvent -> deleteEquipo());
		
		this.insertProyectoButton.setOnAction( actionEvent -> insertarProyecto());
		this.selectProyectoButton.setOnAction( actionEvent -> selectProyecto());
		this.modificarProyectoButton.setOnAction( actionEvent -> updateProyecto());
		this.deleteProyectoButton.setOnAction( actionEvent -> deleteProyecto());
	}
	

	//EQUIPO TAB FUNCTIONS
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
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Insertar miembro de equipo");
		a1.setHeaderText("Operación realizada con éxito!");
		a1.setContentText("El miembro de equipo ha sido guardado correctamente");
		a1.showAndWait();
	}
	
	public void selectEquipo()
	{
		int id = Integer.parseInt(selectEquipoField.getText().toString());
		Equipo e = equipoService.selectEquipo(id);
		if(e == null) {
			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
			a1.setTitle("Seleccionar miembro de equipo");
			a1.setHeaderText("Operación fallida!");
			a1.setContentText("El miembro de equipo no existe.");
			a1.showAndWait();
		}
		else {
			equipoList.add(e);
			System.out.print(e);
			idEquipoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("id"));
			nombreEquipoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("nombre"));
			fechaEquipoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("fechaNacimiento".toString()));
			telefonoEquipoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("telefono"));
			direccionEquipoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("direccion"));
			delegacionEquipoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("delegacion"));
			equipoTable.setItems(equipoList);
		}
	}
	
	public void updateEquipo()
	{
		int id = Integer.parseInt(selectEquipoField.getText().toString());
		Equipo e = equipoService.selectEquipo(id);
		String nombre = nombreEquipoUpdate.getText().toString();
		String fecha = fechaEquipoUpdate.getText().toString();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} 
		catch (ParseException a) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		String telefono = telefonoEquipoUpdate.getText().toString();
		String direccion = direccionEquipoUpdate.getText().toString();
		String delegacion = delegacionEquipoUpdate.getText().toString();
		e.setNombre(nombre);
		e.setFechaNacimiento(fechaNacimiento);
		e.setTelefono(telefono);
		e.setDireccion(direccion);
		e.setDelegacion(delegacion);
		equipoService.addEquipo(e);
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Modificar miembro de equipo");
		a1.setHeaderText("Operación realizada con éxito!");
		a1.setContentText("El miembro de equipo ha sido modificado correctamente");
		a1.showAndWait();
	}
	
	public void deleteEquipo()
	{
		int id = Integer.parseInt(selectEquipoField.getText().toString());
		equipoRepo.deleteById(id);
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Eliminar miembro de equipo");
		a1.setHeaderText("Operación realizada con éxito!");
		a1.setContentText("El miembro de equipo ha sido eliminado correctamente");
		a1.showAndWait();
	}

	//PROYECTO TAB FUNCTIONS
	public void insertarProyecto()
	{
		String nombreProyectoString = nombreProyecto.getText().toString();
		String tipoProyectoString = tipoProyecto.getText().toString();
		String fechaInicioString = fechaInicio.getText().toString();
		String fechaFinString = fechaFin.getText().toString();
		String paisString = pais.getText().toString();
		Date fechaInicioDate = null;
		Date fechaFinDate = null;
		try {
			fechaInicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicioString);
			fechaFinDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinString);
		} 
		catch (ParseException e) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		
		

		Proyecto e = new Proyecto(nombreProyectoString,tipoProyectoString, paisString, fechaInicioDate, fechaFinDate); 
		proyectoService.addProyecto(e);
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Insertar proyecto");
		a1.setHeaderText("Operación realizada con éxito!");
		a1.setContentText("El proyecto ha sido guardado correctamente");
		a1.showAndWait();
	}

	public void selectProyecto()
	{
		int id = Integer.parseInt(selectProyectoField.getText().toString());
		Proyecto e = proyectoService.selectProyecto(id);
		if(e == null) {
			Alert a1 = new Alert(Alert.AlertType.INFORMATION);
			a1.setTitle("Seleccionar proyecto");
			a1.setHeaderText("Operación fallida!");
			a1.setContentText("El proyecto no existe.");
			a1.showAndWait();
		}
		else {
			proyectoList.add(e);
			System.out.print(e);
			idProyectoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("id"));
			nombreProyectoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("nombreProyecto"));
			tipoProyectoColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("tipoProyecto"));			
			paisColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("pais"));
			fechaInicioColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("fechaInicio".toString()));
			fechaFinColumn.setCellValueFactory(new PropertyValueFactory<Equipo, String>("fechaFin".toString()));
			proyectoTable.setItems(proyectoList);
		}
	}
	
	public void updateProyecto()
	{
		int id = Integer.parseInt(idProyectoUpdate.getText().toString());
		Proyecto e = proyectoService.selectProyecto(id);
		String nombreProyectoString = nombreProyectoUpdate.getText().toString();
		String tipoProyectoString = tipoProyectoUpdate.getText().toString();
		String fechaInicioString = fechaInicioUpdate.getText().toString();
		String fechaFinString = fechaFinUpdate.getText().toString();
		String paisString = paisUpdate.getText().toString();
		Date fechaInicioDate = null;
		Date fechaFinDate = null;
		try {
			fechaInicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicioString);
			fechaFinDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinString);
		} 
		catch (ParseException ex) {
			System.out.println("ParseException occured: formato de fecha incorrecto");
		}
		e.setNombreProyecto(nombreProyectoString);
		e.setTipoProyecto(tipoProyectoString);
		e.setPais(paisString);
		e.setFechaInicio(fechaInicioDate);;
		e.setFechaFin(fechaFinDate);;
		proyectoService.addProyecto(e);
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Modificar proyecto");
		a1.setHeaderText("Operación realizada con éxito!");
		a1.setContentText("El proyecto ha sido modificado correctamente");
		a1.showAndWait();
	}
	
	public void deleteProyecto()
	{
		int id = Integer.parseInt(idProyectoEliminar.getText().toString());
		proyectoRepo.deleteById(id);
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Eliminar proyecto");
		a1.setHeaderText("Operación realizada con éxito!");
		a1.setContentText("El proyecto ha sido eliminado correctamente");
		a1.showAndWait();
	}
}
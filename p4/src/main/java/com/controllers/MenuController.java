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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//this.button.setOnAction( actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
		this.insertarEquipoButton.setOnAction( actionEvent -> insertarEquipo());
		this.selectEquipoButton.setOnAction( actionEvent -> selectEquipo());
		this.equipoUpdateButton.setOnAction( actionEvent -> updateEquipo());
		this.deleteEquipoButton.setOnAction( actionEvent -> deleteEquipo());
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
}
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;

import javafx.beans.property.SimpleStringProperty;

import javafx.collections.ObservableList;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import javafx.stage.Stage;

import model.Persona;



import javafx.event.ActionEvent;

public class TbPersonasController implements Initializable{

    @FXML
    private Button btnAgregarPersona;

    @FXML
    private TableView<Persona> tbViewPersonas;

    @FXML
    private TableColumn<Persona, String> tbColNombre;

    @FXML
    private TableColumn<Persona, String> tbColApellidos;

    @FXML
    private TableColumn<Persona, Integer> tbColEdad;
    
    private NuevaPersonaController newPersonaWindow;
    
    private static Image ICONO = new Image(Main.class.getResourceAsStream("/img/agenda.png"));
    
    @FXML
    void aniadirPersona(ActionEvent event) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DatosPersonasAgregar.fxml"));
			Parent root = loader.load();
			/* Le dice a la nueva ventana cual es su ventana padre */
			newPersonaWindow = loader.getController();
			newPersonaWindow.setParent(this);
			
			Stage agregarStage = new Stage();
			agregarStage.setScene(new Scene(root));
			agregarStage.getIcons().add(ICONO);
			agregarStage.setTitle("Nueva Persona");
			agregarStage.showAndWait();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
    
    /*
     * Añade la informacion de la ventana DatosPersonasAgregarController a la tabla
     * */
    public void devolverPersona(Persona person) {
    	ObservableList<Persona> obLstPersonas = tbViewPersonas.getItems();
    	obLstPersonas.add(person);
        tbViewPersonas.setItems(obLstPersonas);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tbColNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
        
		tbColApellidos.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getApellido()));
        
		tbColEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
	}

}


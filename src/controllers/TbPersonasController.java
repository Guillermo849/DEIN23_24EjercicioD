package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Pos;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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

    @FXML
    void aniadirPersona(ActionEvent event) {
    	
		Image icono = new Image(Main.class.getResourceAsStream("/img/agenda.png"));
    	
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DatosPersonasAgregar.fxml"));
			Parent root = loader.load();
			Stage agregarStage = new Stage();
			agregarStage.setScene(new Scene(root));
			agregarStage.getIcons().add(icono);
			agregarStage.setTitle("Nueva Persona");
			agregarStage.show();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
    	/*
    	 * Si algunos de los TextFields está vacio entonces saltará una Ventana 
    	 * 	de Error con los campos NULL
    	 * */
//    	if (tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfEdad.getText().isEmpty()) {
//    		Alert alertWindows = new Alert(Alert.AlertType.ERROR);
//    		
//    		Stage stage = (Stage) alertWindows.getDialogPane().getScene().getWindow();
//    		stage.getIcons().add(icono);
//    		
//    		alertWindows.setHeaderText(null);
//    		String mensaje = "";
//			if (tfNombre.getText().isEmpty()){
//				mensaje += "El campo Nombre es Obligatorio \n";
//			}
//			if (tfApellidos.getText().isEmpty()) {
//				mensaje += "El campo Apellidos es Obligatorio \n";
//			}
//			if (tfEdad.getText().isEmpty()) {
//				mensaje += "El campo Edad es Obligatorio \n";
//			}
//			if (!tfEdad.getText().matches("[0-9]*")) {
//				mensaje += "El campo Edad debe ser númerico \n";
//			}
//			
//			alertWindows.setContentText(mensaje);
//    		alertWindows.showAndWait();
//    	} else {
//    	/*
//    	 * Añadirá la persona a la tabla
//    	 * */
//    		Persona persona = new Persona(tfNombre.getText(),
//	    			tfApellidos.getText(),
//	                Integer.parseInt(tfEdad.getText()));
//	        	
//	    	ObservableList<Persona> obLstPersonas = tbViewPersonas.getItems();
//	    	obLstPersonas.add(persona);
//	        tbViewPersonas.setItems(obLstPersonas);
//	        
//	       /* Saltará una ventana de Información que
//	        * 	indicará que se ha añadido la persona
//	        * */
//	        Alert infoWindow = new Alert(Alert.AlertType.INFORMATION);
//	        
//	        Stage stage = (Stage) infoWindow.getDialogPane().getScene().getWindow();
//    		stage.getIcons().add(icono);
//	        
//	        infoWindow.setHeaderText(null);
//	        infoWindow.setContentText("Persona agregada correctamente");
//	        infoWindow.showAndWait();
//    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tbColNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
        
		tbColApellidos.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getApellido()));
        
		tbColEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
	}

}


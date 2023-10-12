
package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Persona;

public class NuevaPersonaController {
	
	private TbPersonasController mainController;
	
	@FXML
    private BorderPane idBorderPane;
	
    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfApellidos;

    @FXML
    private TextField tfEdad;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;
    
    public void setParent(TbPersonasController parent) {
    	this.mainController = parent;
    }

    @FXML
    void cancelar(ActionEvent event) {
    	
    }

    @FXML
    void guardarPersona(ActionEvent event) {
    	
    	Image icono = new Image(Main.class.getResourceAsStream("/img/agenda.png"));
    	
    	/*
    	 * Si algunos de los TextFields está vacio entonces saltará una Ventana 
    	 * 	de Error con los campos NULL
    	 * */
    	if (tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() || tfEdad.getText().isEmpty()) {
    		Alert alertWindows = new Alert(Alert.AlertType.ERROR);
    		
    		Stage stage = (Stage) alertWindows.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(icono);
    		
    		alertWindows.setHeaderText(null);
    		String mensaje = "";
			if (tfNombre.getText().isEmpty()){
				mensaje += "El campo Nombre es Obligatorio \n";
			}
			if (tfApellidos.getText().isEmpty()) {
				mensaje += "El campo Apellidos es Obligatorio \n";
			}
			if (tfEdad.getText().isEmpty()) {
				mensaje += "El campo Edad es Obligatorio \n";
			}
			if (!tfEdad.getText().matches("[0-9]*")) {
				mensaje += "El campo Edad debe ser númerico \n";
			}
			
			alertWindows.setContentText(mensaje);
    		alertWindows.showAndWait();
    	} else {
    	/*
    	 * Devolverá la información de la persona a la tabla de la ventana padre
    	 * */
    		Persona persona = new Persona(tfNombre.getText(),
	    			tfApellidos.getText(),
	                Integer.parseInt(tfEdad.getText()));
    		
    		mainController.devolverPersona(persona);
    		
    		// Una vez guardada la persona se cerrara la ventana
    		Node n = (Node) event.getSource();
    		
    		Stage stage = (Stage) n.getScene().getWindow();
    		
    		stage.close();
    		
    	}
    	
    }

}

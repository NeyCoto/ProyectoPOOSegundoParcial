
package ec.edu.espol.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class InicioController implements Initializable {

    @FXML
    private Label label;
    

    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

}

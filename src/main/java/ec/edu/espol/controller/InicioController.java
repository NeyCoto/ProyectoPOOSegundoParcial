
package ec.edu.espol.controller;

import ec.edu.espol.proyectofinal.App;
import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.getSHA;
import static ec.edu.espol.util.Util.toHexString;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class InicioController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField correoLogIn;
    @FXML
    private TextField passwordLogIn;
    @FXML
    private Button logInBoton;
    @FXML
    private Button signUpBoton;
    @FXML
    private Text emailError;
    @FXML
    private Text passwordError;
    

    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 

    @FXML
    private void logIn(MouseEvent event){
        String correo = correoLogIn.getText();
        String clave = passwordLogIn.getText();
        emailError.setText("");
        passwordError.setText("");
        if(!Util.correoInFile(correo, "data/db/compradores.ser") && !Util.correoInFile(correo, "data/db/vendedores.ser")){
            emailError.setText("Correo no registrado");
        }
        else if(!Util.validacionClave(clave, "data/db/claveHashCompradores.ser") && !Util.validacionClave(clave, "data/db/claveHashVendedores.ser")){
            passwordError.setText("Clave incorrecta");
        
        }
        else
            try{

                FXMLLoader fxmlloader = App.loadFXMLLoader("Aplicacion");  
                App.setRoot(fxmlloader);
                AplicacionController ac = fxmlloader.getController();  
                ac.Comprobar(correo);
            }
            catch(IOException ex){
                Alert a = new Alert(AlertType.ERROR, "No se pudo abrir el archivo fxml");
                a.show();
            }    
    }

    
    @FXML
    private void signUp(MouseEvent event) {
        try{
                FXMLLoader fxmlloader = App.loadFXMLLoader("SignUp");
                App.setRoot(fxmlloader);
                SignUpController suc = fxmlloader.getController();
                System.out.println(suc);
            }
            catch(IOException ex){
            }
        
    }
    
    
    
    

}

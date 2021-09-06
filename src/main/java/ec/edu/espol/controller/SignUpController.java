
package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.proyectofinal.App;
import ec.edu.espol.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class SignUpController implements Initializable {

    @FXML
    private ImageView Back;
    @FXML
    private TextField nombres;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField correo;
    @FXML
    private TextField organizacion;
    @FXML
    private TextField clave;
    @FXML
    private Button registroBoton;
    @FXML
    private CheckBox vendedorOption;
    @FXML
    private CheckBox compradorOption;
    @FXML
    private Text errorTexto;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void regresar(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = App.loadFXMLLoader("inicio");
            App.setRoot(fxmlloader);
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void appReady(MouseEvent event) {
        String nombre = nombres.getText();
        String apellido = apellidos.getText();
        String organization = organizacion.getText();
        String password = clave.getText();
        String correu = correo.getText();
        Boolean vendedor = vendedorOption.isSelected();
        Boolean comprador = compradorOption.isSelected();
        errorTexto.setText("");
        if(!nombre.isEmpty() && !apellido.isEmpty() && !organization.isEmpty() && !password.isEmpty() && !correu.isEmpty()){
            
            if(Util.validacionCorreo(correu)){
                
                if((comprador && vendedor) == true){
                    
                    if(!Util.correoInFile(correu, "data/db/compradores.ser") && !Util.correoInFile(correu, "data/db/vendedores.ser")){
                        int id2 = Util.nextID("data/db/compradores.ser");
                        Comprador c = new Comprador(id2,nombre,apellido,correu,organization,password);            
                        ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/compradores.ser");
                        usuarios2.add(c); 
                        c.saveFile("data/db/compradores.ser",usuarios2);
                        Util.crearArchivoHash(usuarios2, "data/db/claveHashCompradores.ser"); 


                        int id = Util.nextID("data/db/vendedores.ser");
                        Vendedor v = new Vendedor(id,nombre,apellido,correu,organization,password);
                        ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                        usuarios.add(v);       
                        v.saveFile("data/db/vendedores.ser", usuarios);  
                        Util.crearArchivoHash(usuarios, "data/db/claveHashVendedores.ser");
                        try{
                            FXMLLoader fxmlloader = App.loadFXMLLoader("Aplicacion");
                            App.setRoot(fxmlloader);
                            AplicacionController ac = fxmlloader.getController();
                            ac.Comprobar(correu);
                            System.out.println(ac);
                        }
                        catch(IOException ex){
                            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el archivo fxml");
                            a.show();
                        } 
                    }
                    else
                        errorTexto.setText("Correo ya registrado");      
                }
                
                else if(vendedor == true){
                    if(!Util.correoInFile(correu, "data/db/vendedores.ser")){
                        int id = Util.nextID("data/db/vendedores.ser");
                        Vendedor v = new Vendedor(id,nombre,apellido,correu,organization,password);
                        ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                        usuarios.add(v);       
                        v.saveFile("data/db/vendedores.ser", usuarios);           
                        Util.crearArchivoHash(usuarios, "data/db/claveHashVendedores.ser"); 
                        try{
                            FXMLLoader fxmlloader = App.loadFXMLLoader("Aplicacion");
                            App.setRoot(fxmlloader);
                            AplicacionController ac = fxmlloader.getController();
                            ac.Comprobar(correu);
                            System.out.println(ac);
                        }
                        catch(IOException ex){
                            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el archivo fxml");
                            a.show();
                        }         
                    }
                    else
                        errorTexto.setText("Correo ya registrado");

                }
                
                else if(comprador == true){
                    if(!Util.correoInFile(correu, "data/db/compradores.ser")){
                        int id = Util.nextID("data/db/compradores.ser");
                        Comprador c = new Comprador(id,nombre,apellido,correu,organization,password);
                        ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/compradores.ser");
                        usuarios.add(c);
                        c.saveFile("data/db/compradores.ser",usuarios);
                        Util.crearArchivoHash(usuarios, "data/db/claveHashCompradores.ser");
                        try{
                            FXMLLoader fxmlloader = App.loadFXMLLoader("Aplicacion");
                            App.setRoot(fxmlloader);
                            AplicacionController ac = fxmlloader.getController();
                            ac.Comprobar(correu);
                            System.out.println(ac);
                        }
                        catch(IOException ex){
                            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el archivo fxml");
                            a.show();
                        } 
                    }
                    else
                        errorTexto.setText("Correo ya registrado");           
                }
                
                else
                    errorTexto.setText("No eligio el tipo de Usuario");  
                
            }
            else
                errorTexto.setText("Correo no valido");  
            
        }
        else
            errorTexto.setText("Complete todos los requisitos");  
    }
    
   
    
    
    
}

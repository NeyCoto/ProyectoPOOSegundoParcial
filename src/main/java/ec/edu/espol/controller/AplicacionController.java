package ec.edu.espol.controller;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.proyectofinal.App;
import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class AplicacionController implements Initializable {

    @FXML
    private Pane betterMovePane;
    @FXML
    private Button perfilBoton;

    @FXML
    private Button registrarVehiculoBoton;
    @FXML
    private Button aceptarOfertasBoton;
    @FXML
    private Button comprarBoton;
    private static final String Not_Hoover_Button = "-fx-background-color:#9C2B27";
    private static final String Hoover_Button = "-fx-background-color:#1c0403";
    @FXML
    private VBox viibox1;

    private String correo;
    @FXML
    private Label label;

    @FXML
    private Text nombre;
    @FXML
    private Text apellidos;
    @FXML
    private Text correoE;
    @FXML
    private Text organizacion;
    @FXML
    private Text clave;
    @FXML
    private Text rol;
    @FXML
    private VBox perfilMenu;
    @FXML
    private Pane pruebaPane;

    @FXML
    private TextField contraseñaActual;
    @FXML
    private TextField nuevaContraseña;
    @FXML
    private TextField nuevaContraseña2;
    @FXML
    private Text userRol;
    @FXML
    private CheckBox vendedorCheck;
    @FXML
    private CheckBox compradorCheck;
    @FXML
    private Text elegirRolError;
    @FXML
    private VBox cambioVbox;
    @FXML
    private Text faltaTexto;
    @FXML
    private Pane pruebaPane1;
    @FXML
    private Pane menu;
    @FXML
    private Pane carro;
    @FXML
    private Pane moto;
    @FXML
    private Pane camioneta;

    @FXML
    private TextField placa;
    @FXML
    private TextField marca;
    @FXML
    private TextField modelo;
    @FXML
    private TextField tipoMotor;
    @FXML
    private TextField anio;
    @FXML
    private TextField recorrido;
    @FXML
    private TextField color;
    @FXML
    private TextField tipoCombustible;
    @FXML
    private TextField vidrios;
    @FXML
    private TextField transmision;
    @FXML
    private TextField precio;
    @FXML
    private Button agregarImg;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ListView listview;
    @FXML
    private Button registrar;
    @FXML
    private Text errorT;
    @FXML
    private Text textoError;
    @FXML
    private Text eTexto;
    @FXML
    private Button registrarCamioneta;
    @FXML
    private Pane comprarPane;
    @FXML
    private TextField txtTipoV;
    @FXML
    private TextField txtRecMax;
    @FXML
    private TextField txtRecMin;
    @FXML
    private TextField txtAnoMax;
    @FXML
    private TextField txtAnoMin;
    @FXML
    private TextField txtPrecioMax;
    @FXML
    private TextField txtPrecioMin;
    @FXML
    private Text txtAnuncio;
    @FXML
    private Text txtAnuncio1;

    public static ArrayList<Vehiculo> listFiltrados = new ArrayList<>();

    public int iterador = 0;
    @FXML
    private Pane ofertarInfoPane;
    @FXML
    private Button btnAnteriorObj;
    @FXML
    private Text txtTitulo;
    @FXML
    private ImageView imgVehiculoInfo;
    @FXML
    private TextField txtPrecioBoxOfertar;
    @FXML
    private Text textRealizado;
    @FXML
    private Button btnSiguienteObj;

    @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
    }

    public void Comprobar(String correo) {
        if (Util.correoInFile(correo, "data/db/compradores.ser") && Util.correoInFile(correo, "data/db/vendedores.ser")) {

        } else if (Util.correoInFile(correo, "data/db/compradores.ser")) {
            viibox1.getChildren().remove(this.registrarVehiculoBoton);
            viibox1.getChildren().remove(this.aceptarOfertasBoton);
        } else if (Util.correoInFile(correo, "data/db/vendedores.ser")) {
            viibox1.getChildren().remove(this.comprarBoton);
        }
        this.correo = correo;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (Node b : viibox1.getChildren()) {
            b.setStyle(Not_Hoover_Button);
            b.setOnMouseEntered(di -> {
                b.setStyle(Hoover_Button);
            });
            b.setOnMouseExited(di -> {
                b.setStyle(Not_Hoover_Button);
            });
        }

    }

    @FXML
    private void regresar(MouseEvent event) {
        pruebaPane.toFront();

    }

    @FXML
    private void perfil(MouseEvent event) {
        if (Util.correoInFile(this.correo, "data/db/compradores.ser") && Util.correoInFile(this.correo, "data/db/vendedores.ser")) {
            ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/compradores.ser");
            Usuario u = Util.searchBycorreo(this.correo, usuarios);
            perfilMenu.toFront();
            nombre.setText(u.getNombres());
            apellidos.setText(u.getApellidos());
            correoE.setText(u.getCorreo_elec());
            organizacion.setText(u.getOrganizacion());
            clave.setText(u.getClave());
            rol.setText("Comprador y Vendedor");

        } else if (Util.correoInFile(correo, "data/db/compradores.ser")) {
            ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/compradores.ser");
            Usuario u = Util.searchBycorreo(this.correo, usuarios);
            Label l = new Label(u.getNombres() + u.getApellidos() + u.getCorreo_elec() + u.getOrganizacion() + u.getClave());
            perfilMenu.toFront();
            nombre.setText(u.getNombres());
            apellidos.setText(u.getApellidos());
            correoE.setText(u.getCorreo_elec());
            organizacion.setText(u.getOrganizacion());
            clave.setText(u.getClave());
            rol.setText("Comprador");

        } else if (Util.correoInFile(correo, "data/db/vendedores.ser")) {
            ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/vendedores.ser");
            Usuario u = Util.searchBycorreo(this.correo, usuarios2);
            perfilMenu.toFront();
            nombre.setText(u.getNombres());
            apellidos.setText(u.getApellidos());
            correoE.setText(u.getCorreo_elec());
            organizacion.setText(u.getOrganizacion());
            clave.setText(u.getClave());
            rol.setText("Vendedor");

        }
    }

    @FXML
    private void aceptarOfertas(MouseEvent event) {
        pruebaPane1.toFront();

    }

    @FXML
    private void comprarVehiculo(MouseEvent event) {
        //pruebaPane.toFront();
        comprarPane.toFront();

    }

    @FXML
    private void editarPerfil(MouseEvent event) {
        cambioVbox.toFront();
        userRol.setText(this.rol.getText());
        elegirRolError.setText("");
        faltaTexto.setText("");
        contraseñaActual.setText("");
        nuevaContraseña.setText("");
        nuevaContraseña2.setText("");
        vendedorCheck.setSelected(false);
        compradorCheck.setSelected(false);
    }

    @FXML
    private void cambioUser(MouseEvent event) {
        elegirRolError.setText("");
        faltaTexto.setText("");
        String contraseñActual = contraseñaActual.getText();
        String contraseñaNueva = nuevaContraseña.getText();
        String contraseñaNueva2 = nuevaContraseña2.getText();
        Boolean vendedor = vendedorCheck.isSelected();
        Boolean comprador = compradorCheck.isSelected();

        if (vendedor == false && comprador == false) {
            elegirRolError.setText("Debe seleccionar al menos un rol");
        } else {
            //CAMBIO DE CONTRASEÑA
            if (!contraseñActual.isEmpty() || !contraseñaNueva.isEmpty() || !contraseñaNueva2.isEmpty()) {
                String rolActual = this.rol.getText();
                if (rolActual.equals("Comprador")) {
                    ArrayList<Usuario> compradores = Usuario.readFile_usuario("data/db/compradores.ser");
                    Usuario u = Util.searchBycorreo(this.correo, compradores);
                    //System.out.println(compradores); //OJOOOOOOO
                    if (u.getClave().equals(contraseñActual)) {
                        if (contraseñaNueva.equals(contraseñaNueva2) && !contraseñaNueva.equals(contraseñActual) && !contraseñaNueva.isEmpty()) {
                            compradores.remove(u);
                            int idnuevo = 1;
                            for (Usuario compradors : compradores) {
                                compradors.setId(idnuevo);
                                idnuevo++;
                            }
                            //System.out.println(compradores); //OJOOOOOOO
                            u.setClave(contraseñaNueva);
                            int newID = compradores.size();
                            u.setId(newID + 1);
                            compradores.add(u);
                            //System.out.println(compradores); //OJOOOOOOO
                            Comprador c = new Comprador(1, "e", "e", "e", "e", "e");
                            c.saveFile("data/db/compradores.ser", compradores);
                            Util.crearArchivoHash(compradores, "data/db/claveHashCompradores.ser");
                            cambiarDeRol(vendedor, comprador);

                        } else {
                            faltaTexto.setText("Contraseñas incorrectas");
                        }
                    } else {
                        faltaTexto.setText("Contraseña Actual incorrecta");
                    }

                } else if (rolActual.equals("Vendedor")) {
                    ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                    Usuario u = Util.searchBycorreo(this.correo, usuarios);
                    //System.out.println(usuarios); //OJOOOOOOO
                    if (u.getClave().equals(contraseñActual)) {
                        if (contraseñaNueva.equals(contraseñaNueva2) && !contraseñaNueva.equals(contraseñActual) && !contraseñaNueva.isEmpty()) {
                            usuarios.remove(u);
                            int idnuevo = 1;
                            for (Usuario compradors : usuarios) {
                                compradors.setId(idnuevo);
                                idnuevo++;
                            }
                            //System.out.println(usuarios); //OJOOOOOOO
                            u.setClave(contraseñaNueva);
                            int newID = usuarios.size();
                            u.setId(newID + 1);
                            usuarios.add(u);
                            //System.out.println(usuarios); //OJOOOOOOO
                            Vendedor v = new Vendedor(1, "e", "e", "e", "e", "e");
                            v.saveFile("data/db/vendedores.ser", usuarios);
                            Util.crearArchivoHash(usuarios, "data/db/claveHashVendedores.ser");
                            cambiarDeRol(vendedor, comprador);

                        } else {
                            faltaTexto.setText("Contraseñas incorrectas");
                        }

                    } else {
                        faltaTexto.setText("Contraseña Actual incorrecta");
                    }

                } else if (rolActual.equals("Comprador y Vendedor")) {

                    ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/compradores.ser");
                    Usuario u = Util.searchBycorreo(this.correo, usuarios);
                    //System.out.println(usuarios); //OJOOOOOOO
                    if (u.getClave().equals(contraseñActual)) {
                        if (contraseñaNueva.equals(contraseñaNueva2) && !contraseñaNueva.equals(contraseñActual) && !contraseñaNueva.isEmpty()) {
                            usuarios.remove(u);
                            int idnuevo = 1;
                            for (Usuario compradors : usuarios) {
                                compradors.setId(idnuevo);
                                idnuevo++;
                            }
                            //System.out.println(usuarios); //OJOOOOOOO
                            u.setClave(contraseñaNueva);
                            int newID = usuarios.size();
                            u.setId(newID + 1);
                            usuarios.add(u);
                            //System.out.println(usuarios); //OJOOOOOOO
                            Comprador c = new Comprador(1, "e", "e", "e", "e", "e");
                            c.saveFile("data/db/compradores.ser", usuarios);
                            Util.crearArchivoHash(usuarios, "data/db/claveHashCompradores.ser");

                        } else {
                            faltaTexto.setText("Contraseñas incorrectas");
                        }
                    } else {
                        faltaTexto.setText("Contraseña Actual incorrecta");
                    }

                    //vendedor
                    ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/vendedores.ser");
                    Usuario u2 = Util.searchBycorreo(this.correo, usuarios2);
                    //System.out.println(usuarios2); //OJOOOOOOO
                    if (u2.getClave().equals(contraseñActual)) {
                        if (contraseñaNueva.equals(contraseñaNueva2) && !contraseñaNueva.equals(contraseñActual) && !contraseñaNueva.isEmpty()) {
                            usuarios2.remove(u2);
                            int idnuevo2 = 1;
                            for (Usuario compradors2 : usuarios2) {
                                compradors2.setId(idnuevo2);
                                idnuevo2++;
                            }
                            //System.out.println(usuarios2); //OJOOOOOOO
                            u2.setClave(contraseñaNueva);
                            int newID = usuarios2.size();
                            u.setId(newID + 1);
                            usuarios2.add(u2);
                            //System.out.println(usuarios2); //OJOOOOOOO
                            Vendedor v = new Vendedor(1, "e", "e", "e", "e", "e");
                            v.saveFile("data/db/vendedores.ser", usuarios2);
                            Util.crearArchivoHash(usuarios2, "data/db/claveHashVendedores.ser");
                            cambiarDeRol(vendedor, comprador);
                        } else {
                            faltaTexto.setText("Contraseñas incorrectas");
                        }
                    } else {
                        faltaTexto.setText("Contraseña Actual incorrecta");
                    }
                }
            } else {
                cambiarDeRol(vendedor, comprador);
            }
        }
    }

    public void cambiarDeRol(Boolean vendedor, Boolean comprador) {
        //CAMBIAR ROL
        //COMPRADOR Y VENDEDOR
        String rolActual = this.rol.getText();

        if ((comprador && vendedor) == true) {
            if (rolActual.equals("Comprador")) {
                ArrayList<Usuario> usuarios1 = Usuario.readFile_usuario("data/db/compradores.ser");
                //System.out.println(usuarios1); //OJOOOOOOO
                Usuario u = Util.searchBycorreo(this.correo, usuarios1);
                int id = Util.nextID("data/db/vendedores.ser");
                Vendedor v = new Vendedor(id, u.getNombres(), u.getApellidos(), u.getCorreo_elec(), u.getOrganizacion(), u.getClave());
                ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/vendedores.ser");
                //System.out.println(usuarios2); //OJOOOOOOO
                usuarios2.add(v);
                //System.out.println(usuarios2); //OJOOOOOOO
                v.saveFile("data/db/vendedores.ser", usuarios2);
                Util.crearArchivoHash(usuarios2, "data/db/claveHashVendedores.ser");
                viibox1.getChildren().add(this.registrarVehiculoBoton);
                viibox1.getChildren().add(this.aceptarOfertasBoton);
                rol.setText("Comprador y Vendedor");

            } else if (rolActual.equals("Vendedor")) {
                ArrayList<Usuario> usuarios1 = Usuario.readFile_usuario("data/db/vendedores.ser");
                //System.out.println(usuarios1); //OJOOOOOOO
                Usuario u = Util.searchBycorreo(this.correo, usuarios1);
                int id = Util.nextID("data/db/compradores.ser");
                Comprador c = new Comprador(id, u.getNombres(), u.getApellidos(), u.getCorreo_elec(), u.getOrganizacion(), u.getClave());
                ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/compradores.ser");
                //System.out.println(usuarios2); //OJOOOOOOO
                usuarios2.add(c);
                //System.out.println(usuarios2); //OJOOOOOOO
                c.saveFile("data/db/compradores.ser", usuarios2);
                Util.crearArchivoHash(usuarios2, "data/db/claveHashCompradores.ser");
                viibox1.getChildren().add(this.comprarBoton);
                rol.setText("Comprador y Vendedor");
            }

        } // VENDEDOR
        else if (comprador == true) {
            if (rolActual.equals("Vendedor")) {
                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                //System.out.println(usuarios); //OJOOOOOOO
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                usuarios.remove(u);
                //System.out.println(usuarios); //OJOOOOOOO
                int idd = 1;
                for (Usuario usu : usuarios) {
                    usu.setId(idd);
                    idd++;
                }
                //System.out.println(usuarios); //OJOOOOOOO
                int id = Util.nextID("data/db/compradores.ser");
                Comprador c = new Comprador(id, u.getNombres(), u.getApellidos(), u.getCorreo_elec(), u.getOrganizacion(), u.getClave());
                c.saveFile("data/db/vendedores.ser", usuarios);
                Util.crearArchivoHash(usuarios, "data/db/claveHashVendedores.ser");

                //añadir comprador
                ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/compradores.ser");
                //System.out.println(usuarios2); //OJOOOOOOO
                usuarios2.add(c);
                //System.out.println(usuarios2); //OJOOOOOOO
                c.saveFile("data/db/compradores.ser", usuarios2);
                Util.crearArchivoHash(usuarios2, "data/db/claveHashCompradores.ser");

                viibox1.getChildren().remove(this.registrarVehiculoBoton);
                viibox1.getChildren().remove(this.aceptarOfertasBoton);
                viibox1.getChildren().add(this.comprarBoton);
                rol.setText("Comprador");

            } else if (rolActual.equals("Comprador y Vendedor")) {
                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                //System.out.println(usuarios); //OJOOOOOOO
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                usuarios.remove(u);
                //System.out.println(usuarios); //OJOOOOOOO
                int idd = 1;
                for (Usuario usu : usuarios) {
                    usu.setId(idd);
                    idd++;
                }
                //System.out.println(usuarios); //OJOOOOOOO
                Vendedor v = new Vendedor(1, "e", "e", "e", "e", "e");
                v.saveFile("data/db/vendedores.ser", usuarios);
                Util.crearArchivoHash(usuarios, "data/db/claveHashVendedores.ser");
                viibox1.getChildren().remove(this.registrarVehiculoBoton);
                viibox1.getChildren().remove(this.aceptarOfertasBoton);
                rol.setText("Comprador");
            }

        } else if (vendedor == true) {
            if (rolActual.equals("Comprador")) {
                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/compradores.ser");
                //System.out.println(usuarios); //OJOOOOOOO                
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                usuarios.remove(u);
                //System.out.println(usuarios); //OJOOOOOOO
                int idd = 1;
                for (Usuario usu : usuarios) {
                    usu.setId(idd);
                    idd++;
                }
                //System.out.println(usuarios); //OJOOOOOOO
                int id = Util.nextID("data/db/vendedores.ser");
                Vendedor v = new Vendedor(id, u.getNombres(), u.getApellidos(), u.getCorreo_elec(), u.getOrganizacion(), u.getClave());
                v.saveFile("data/db/compradores.ser", usuarios);
                Util.crearArchivoHash(usuarios, "data/db/claveHashCompradores.ser");
                //añadiendo nuevo 
                ArrayList<Usuario> usuarios2 = Usuario.readFile_usuario("data/db/vendedores.ser");
                //System.out.println(usuarios2); //OJOOOOOOO
                usuarios2.add(v);
                //System.out.println(usuarios2); //OJOOOOOOO
                v.saveFile("data/db/vendedores.ser", usuarios2);
                Util.crearArchivoHash(usuarios2, "data/db/claveHashVendedores.ser");
                viibox1.getChildren().remove(this.comprarBoton);
                viibox1.getChildren().add(this.registrarVehiculoBoton);
                viibox1.getChildren().add(this.aceptarOfertasBoton);
                rol.setText("Vendedor");

            } else if (rolActual.equals("Comprador y Vendedor")) {
                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/compradores.ser");
                //System.out.println(usuarios); //OJOOOOOOO
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                usuarios.remove(u);
                //System.out.println(usuarios); //OJOOOOOOO
                int idd = 1;
                for (Usuario usu : usuarios) {
                    usu.setId(idd);
                    idd++;
                }
                //System.out.println(usuarios); //OJOOOOOOO
                Vendedor v = new Vendedor(1, "e", "e", "e", "e", "e");
                v.saveFile("data/db/compradores.ser", usuarios);
                Util.crearArchivoHash(usuarios, "data/db/claveHashCompradores.ser");
                viibox1.getChildren().remove(this.comprarBoton);
                rol.setText("Vendedor");
            }
        }
        pruebaPane.toFront();
    }

    @FXML
    private void enviarCorreo(MouseEvent event) {
        Util.enviarConGMail("thevelika@hotmail.com", "bettermove593ec@gmail.com", "hola", "Este es el cuerpo", "123espol");

    }

    @FXML
    private void registrarVehiculo(MouseEvent event) {
        menu.toFront();
        errorT.setText("");
        textoError.setText("");
        eTexto.setText("");
        placa.setText("");
        marca.setText("");
        modelo.setText("");
        tipoMotor.setText("");
        anio.setText("");
        recorrido.setText("");
        color.setText("");
        tipoCombustible.setText("");
        vidrios.setText("");
        transmision.setText("");
        precio.setText("");

    }

    @FXML
    private void registroCarro(MouseEvent event) {
        carro.toFront();

        /*
        ScrollPane scrollPane = new ScrollPane();
        ListView listView = new ListView();
        scrollPane.setLayoutX(100);
        scrollPane.setLayoutY(240);
        listView.setMinWidth(350);
        listView.setMinHeight(50);
        scrollPane.setMinWidth(350);
        scrollPane.setMinHeight(50);
        listView.setMaxWidth(350);
        listView.setMaxHeight(50);
        scrollPane.setMaxWidth(350);
        scrollPane.setMaxHeight(50);
        carro.getChildren().add(scrollPane);
        scrollPane.setContent(listView);
        Button agregarImg = new Button("Agregar Imagen");
        agregarImg.setLayoutX(100);
        agregarImg.setLayoutY(200);
        carro.getChildren().add(agregarImg);
         */
        agregarImg.setOnMouseClicked((MouseEvent e2) -> {
            listview.getItems().clear();
            FileChooser seleccionarArchivo = new FileChooser();
            File selectedFile = seleccionarArchivo.showOpenDialog(null);
            if (selectedFile != null) {
                listview.getItems().add(selectedFile.getName());
                Image imagen = new Image(selectedFile.getAbsolutePath());
            }
        });
        registrar.setOnMouseClicked((MouseEvent e3) -> {
            if (!placa.getText().isEmpty() && !marca.getText().isEmpty() && !modelo.getText().isEmpty() && !tipoMotor.getText().isEmpty() && !anio.getText().isEmpty()
                    && !recorrido.getText().isEmpty() && !color.getText().isEmpty() && !tipoCombustible.getText().isEmpty() && !vidrios.getText().isEmpty()
                    && !transmision.getText().isEmpty() && !precio.getText().isEmpty()) {

                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                int id = Util.nextIDVehiculo("vehiculos.ser");
                Vehiculo v = new Vehiculo(id, placa.getText(), marca.getText(), modelo.getText(), tipoMotor.getText(),
                        Integer.parseInt(anio.getText()), Double.parseDouble(recorrido.getText()), color.getText(), tipoCombustible.getText(), Integer.parseInt(vidrios.getText()), transmision.getText(),
                        Double.parseDouble(precio.getText()), u.getId(), null);
                guardarVehiculo(v, placa.getText(), carro);
            } else {
                errorT.setText("Complete todos los requisitos");

            }
        });
    }

    @FXML
    private void registroMoto(MouseEvent event) {
        moto.toFront();
        textoError.setText("");
        TextField placa = new TextField("Placa");
        placa.setLayoutX(25);
        placa.setLayoutY(15);
        moto.getChildren().add(placa);
        TextField marca = new TextField("Marca");
        marca.setLayoutX(265);
        marca.setLayoutY(15);
        moto.getChildren().add(marca);
        TextField modelo = new TextField("Modelo");
        modelo.setLayoutX(25);
        modelo.setLayoutY(45);
        moto.getChildren().add(modelo);
        TextField tipoMotor = new TextField("Tipo de Motor");
        tipoMotor.setLayoutX(265);
        tipoMotor.setLayoutY(45);
        moto.getChildren().add(tipoMotor);
        TextField anio = new TextField("Año");
        anio.setLayoutX(25);
        anio.setLayoutY(75);
        moto.getChildren().add(anio);
        TextField recorrido = new TextField("Recorrido");
        recorrido.setLayoutX(265);
        recorrido.setLayoutY(75);
        moto.getChildren().add(recorrido);
        TextField color = new TextField("Color");
        color.setLayoutX(25);
        color.setLayoutY(105);
        moto.getChildren().add(color);
        TextField tipoCombustible = new TextField("Tipo de Combustible");
        tipoCombustible.setLayoutX(265);
        tipoCombustible.setLayoutY(105);
        moto.getChildren().add(tipoCombustible);
        TextField precio = new TextField("Precio");
        precio.setLayoutX(265);
        precio.setLayoutY(165);
        moto.getChildren().add(precio);
        ScrollPane scrollPane = new ScrollPane();
        ListView listView = new ListView();
        scrollPane.setLayoutX(100);
        scrollPane.setLayoutY(240);
        listView.setMinWidth(350);
        listView.setMinHeight(50);
        scrollPane.setMinWidth(350);
        scrollPane.setMinHeight(50);
        listView.setMaxWidth(350);
        listView.setMaxHeight(50);
        scrollPane.setMaxWidth(350);
        scrollPane.setMaxHeight(50);
        moto.getChildren().add(scrollPane);
        scrollPane.setContent(listView);
        Button agregarImg = new Button("Agregar Imagen");
        agregarImg.setLayoutX(100);
        agregarImg.setLayoutY(200);
        moto.getChildren().add(agregarImg);
        agregarImg.setOnMouseClicked((MouseEvent e2) -> {
            listView.getItems().clear();
            FileChooser seleccionarArchivo = new FileChooser();
            File selectedFile = seleccionarArchivo.showOpenDialog(null);
            if (selectedFile != null) {
                listView.getItems().add(selectedFile.getName());
                Image imagen = new Image(selectedFile.getAbsolutePath());
            }
        });
        Button registrar = new Button("Registrar");
        registrar.setLayoutX(130);
        registrar.setLayoutY(350);
        moto.getChildren().add(registrar);
        registrar.setOnMouseClicked((MouseEvent e3) -> {
            if (!placa.getText().isEmpty() && !marca.getText().isEmpty() && !modelo.getText().isEmpty() && !tipoMotor.getText().isEmpty() && !anio.getText().isEmpty()
                    && !recorrido.getText().isEmpty() && !color.getText().isEmpty() && !tipoCombustible.getText().isEmpty()
                    && !precio.getText().isEmpty()) {

                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                int id = Util.nextIDVehiculo("vehiculos.ser");
                Vehiculo v = new Vehiculo(id, placa.getText(), marca.getText(), modelo.getText(), tipoMotor.getText(),
                        Integer.parseInt(anio.getText()), Double.parseDouble(recorrido.getText()), color.getText(), tipoCombustible.getText(),
                        Double.parseDouble(precio.getText()), u.getId(), null);
                guardarVehiculo(v, placa.getText(), carro);
            } else {
                textoError.setText("Complete todos los requisitos");

            }
        });
    }

    @FXML
    private void registroCamioneta(MouseEvent event) {
        camioneta.toFront();
        TextField placa2 = new TextField("Placa");
        placa2.setLayoutX(25);
        placa2.setLayoutY(15);
        camioneta.getChildren().add(placa2);
        TextField marca2 = new TextField("Marca");
        marca2.setLayoutX(265);
        marca2.setLayoutY(15);
        camioneta.getChildren().add(marca2);
        TextField modelo2 = new TextField("Modelo");
        modelo2.setLayoutX(25);
        modelo2.setLayoutY(45);
        camioneta.getChildren().add(modelo2);
        TextField tipoMotor2 = new TextField("Tipo de Motor");
        tipoMotor2.setLayoutX(265);
        tipoMotor2.setLayoutY(45);
        camioneta.getChildren().add(tipoMotor2);
        TextField anio2 = new TextField("Año");
        anio2.setLayoutX(25);
        anio2.setLayoutY(75);
        camioneta.getChildren().add(anio2);
        TextField recorrido2 = new TextField("Recorrido");
        recorrido2.setLayoutX(265);
        recorrido2.setLayoutY(75);
        camioneta.getChildren().add(recorrido2);
        TextField color2 = new TextField("Color");
        color2.setLayoutX(25);
        color2.setLayoutY(105);
        camioneta.getChildren().add(color2);
        TextField tipoCombustible2 = new TextField("Tipo de Combustible");
        tipoCombustible2.setLayoutX(265);
        tipoCombustible2.setLayoutY(105);
        camioneta.getChildren().add(tipoCombustible2);
        TextField vidrios2 = new TextField("Vidrios");
        vidrios2.setLayoutX(25);
        vidrios2.setLayoutY(135);
        camioneta.getChildren().add(vidrios2);
        TextField transmision2 = new TextField("Transmisión");
        transmision2.setLayoutX(265);
        transmision2.setLayoutY(135);
        camioneta.getChildren().add(transmision2);
        TextField traccion = new TextField("Tracción");
        traccion.setLayoutX(25);
        traccion.setLayoutY(165);
        camioneta.getChildren().add(traccion);
        TextField precio2 = new TextField("Precio");
        precio2.setLayoutX(265);
        precio2.setLayoutY(165);
        camioneta.getChildren().add(precio2);
        ScrollPane scrollPane2 = new ScrollPane();
        ListView listView = new ListView();
        scrollPane2.setLayoutX(100);
        scrollPane2.setLayoutY(240);
        listView.setMinWidth(350);
        listView.setMinHeight(50);
        scrollPane2.setMinWidth(350);
        scrollPane2.setMinHeight(50);
        listView.setMaxWidth(350);
        listView.setMaxHeight(50);
        scrollPane2.setMaxWidth(350);
        scrollPane2.setMaxHeight(50);
        camioneta.getChildren().add(scrollPane2);
        scrollPane2.setContent(listView);
        Button agregarImg2 = new Button("Agregar Imagen");
        agregarImg2.setLayoutX(100);
        agregarImg2.setLayoutY(200);
        camioneta.getChildren().add(agregarImg2);
        agregarImg2.setOnMouseClicked((MouseEvent e2) -> {
            listView.getItems().clear();
            FileChooser seleccionarArchivo = new FileChooser();
            File selectedFile = seleccionarArchivo.showOpenDialog(null);
            if (selectedFile != null) {
                listView.getItems().add(selectedFile.getName());
                Image imagen = new Image(selectedFile.getAbsolutePath());
            }
        });

        registrarCamioneta.setOnMouseClicked((MouseEvent e3) -> {
            if (!placa2.getText().isEmpty() && !marca2.getText().isEmpty() && !modelo2.getText().isEmpty() && !tipoMotor2.getText().isEmpty() && !anio2.getText().isEmpty()
                    && !recorrido2.getText().isEmpty() && !color2.getText().isEmpty() && !tipoCombustible2.getText().isEmpty() && !traccion.getText().isEmpty()
                    && !precio2.getText().isEmpty()) {

                ArrayList<Usuario> usuarios = Usuario.readFile_usuario("data/db/vendedores.ser");
                Usuario u = Util.searchBycorreo(this.correo, usuarios);
                int id = Util.nextIDVehiculo("vehiculos.ser");
                Vehiculo v = new Vehiculo(id, placa2.getText(), marca2.getText(), modelo2.getText(), tipoMotor2.getText(),
                        Integer.parseInt(anio2.getText()), Double.parseDouble(recorrido2.getText()), color2.getText(), tipoCombustible2.getText(), Integer.parseInt(vidrios2.getText()),
                        transmision2.getText(), traccion.getText(),
                        Double.parseDouble(precio2.getText()), u.getId(), null);
            } else {
                eTexto.setText("Complete todos los requisitos");

            }
        });
    }

    public void guardarVehiculo(Vehiculo vehiculo, String placa, Pane pane) {
        ArrayList<Vehiculo> vehiculos = Vehiculo.readFile("vehiculos.ser");
        ArrayList<String> placas = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (!placas.contains(v.getPlaca())) {
                placas.add(v.getPlaca());
            }
        }
        if (!placas.contains(placa)) {
            vehiculos.add(vehiculo);
            System.out.println(vehiculos);
            Vehiculo.saveFile("vehiculos.ser", vehiculos);
            errorT.setText("Registro con Exito");
            textoError.setText("Registro con Exito");
            eTexto.setText("Registro con Exito");

        } else {
            errorT.setText("Esta placa ya existe");
            textoError.setText("Esta placa ya existe");
            eTexto.setText("Esta placa ya existe");
        }

    }

    @FXML
    private void btnBuscar(ActionEvent event) {

        ArrayList<Vehiculo> l1 = Vehiculo.readFile("data/db/vehiculos.ser");

        boolean errores = false;
        try {
            if (!txtTipoV.getText().isBlank()) {
                l1 = Vehiculo.searchByTipo(l1, txtTipoV.getText());
                System.out.println("txtTipoV");
            }
        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException ex) {
            //l1 = Vehiculo.searchByTipo(listTemp, "carro");
            errores = true;
        }
        try {
            if (!txtPrecioMax.getText().isBlank()) {
                l1 = Vehiculo.searchByPrecio(l1, Integer.valueOf(txtPrecioMax.getText()), Integer.valueOf(txtPrecioMin.getText()));
                System.out.println("txtPrecioMax)");

            }
        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException ex) {
            errores = true;
        }

        try {
            if (!txtAnoMax.getText().isBlank()) {
                l1 = Vehiculo.searchByPrecio(l1, Integer.valueOf(txtAnoMax.getText()), Integer.valueOf(txtAnoMin.getText()));
                System.out.println("txtAnoMax)");
            }
        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException ex) {
            errores = true;

        }
        try {
            if (!txtRecMax.getText().isBlank()) {
                l1 = Vehiculo.searchByPrecio(l1, Integer.valueOf(txtRecMax.getText()), Integer.valueOf(txtRecMin.getText()));
                System.out.println("txtRecMax)");

            }
        } catch (IndexOutOfBoundsException | NullPointerException | NumberFormatException ex) {
            errores = true;
        }

        System.out.println(l1.size());

        if (txtTipoV.getText().isBlank()) {
            txtAnuncio1.setText("Rellenar tipo de tipo de vehiculo");
        } else if (l1.size() == 0) {
            txtAnuncio1.setText("No hay datos para mostrar segun las especificaciones");

        } else if (errores == true) {
            txtAnuncio1.setText("Ingrese datos validos");

        } else {
            ofertarInfoPane.toFront();
            txtRecMax.setText("");
            txtRecMin.setText("");
            txtAnuncio1.setText("");
            txtAnoMax.setText("");
            txtAnoMin.setText("");
            txtPrecioMax.setText("");
            txtPrecioMin.setText("");
            txtTipoV.setText("");
        }

        listFiltrados = l1;
        txtTitulo.setText(listFiltrados.get(iterador).getMarca());
        try {
            InputStream input = new FileInputStream("data/imagenes/" + listFiltrados.get(iterador).getImagen());
            Image img = new Image(input, 50, 50, true, true);
            imgVehiculoInfo.setImage(img);
        } catch (NullPointerException | IOException ex) {
            imgVehiculoInfo = new ImageView();
            System.out.println("fallo");
        }
        /*
        for (Vehiculo vehiculo : l1) {
            System.out.println(vehiculo.getTipo_combustible());
        }
         */
 /*System.out.println(l1.size());
        listFiltrados = listTemp;
        btnAnteriorObj.setVisible(false);

        
         */
    }

    @FXML
    private void btnAnteriorV(ActionEvent event) {
        System.out.println("ec.edu.espol.controller.AplicacionController.btnAnteriorV()");
        textRealizado.setText("");
        if (iterador > 0) {
            iterador--;
            txtTitulo.setText(listFiltrados.get(iterador).getMarca());
            try {
                InputStream input = new FileInputStream("data/imagenes/" + listFiltrados.get(iterador).getImagen());
                Image img = new Image(input, 50, 50, true, true);
                imgVehiculoInfo.setImage(img);
            } catch (NullPointerException | IOException ex) {
                imgVehiculoInfo = new ImageView();
                System.out.println("fallo");
            }
        }
        if (iterador == 0) {
            btnAnteriorObj.setVisible(false);
            btnSiguienteObj.setVisible(true);

        }
    }

    @FXML
    private void btnofertarBox(ActionEvent event) {
        try {
            ArrayList<Oferta> listaOfertas = Oferta.readFile("data/db/ofertas.ser");
            System.out.println("a");
            Oferta of = new Oferta(5, 2, 5, Double.valueOf(txtPrecioBoxOfertar.getText()));
            System.out.println("b");

            listaOfertas.add(of);
            Oferta.saveFile("data/db/ofertas.ser", listaOfertas);
            System.out.println("c");

            txtPrecioBoxOfertar.setText("");
            textRealizado.setText("Oferta Realizada!");
        } catch (Exception e) {
            e.printStackTrace();
            textRealizado.setText("Ingresa un dato valido");
        }
    }

    @FXML
    private void btnSiguienteV(ActionEvent event) {
        System.out.println("ec.edu.espol.controller.AplicacionController.btnSiguienteV()");

        textRealizado.setText("");

        if (iterador < listFiltrados.size() - 1) {
            iterador++;
            txtTitulo.setText(listFiltrados.get(iterador).getMarca());
            try {
                InputStream input = new FileInputStream("data/imagenes/" + listFiltrados.get(iterador).getImagen());
                Image img = new Image(input, 50, 50, true, true);
                imgVehiculoInfo.setImage(img);
            } catch (NullPointerException | IOException ex) {
                imgVehiculoInfo = new ImageView();
                System.out.println("fallo");
            }
        }

        if (iterador == listFiltrados.size() - 1) {
            btnSiguienteObj.setVisible(false);
            btnAnteriorObj.setVisible(true);

        }
    }

}

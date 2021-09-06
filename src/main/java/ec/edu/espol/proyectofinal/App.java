package ec.edu.espol.proyectofinal;

import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.util.Util;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        scene = new Scene(loadFXML("inicio"), 771, 462);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Function to change scene 1
    public static void setRoot(FXMLLoader fxmlloader) throws IOException {
        scene.setRoot(fxmlloader.load());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // Function to change scene 2
    public static FXMLLoader loadFXMLLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    public static void main(String[] args) {

        /*
        ArrayList<Vehiculo> veh = new ArrayList<>();

        veh.add(new Vehiculo(5, "DEF", "Kia", "bomnito", "motor bomnito", 2002, 10500, "rojito", "Ecopais", 5, "Buena transmisión", "Tiene tracción", 10500, 3, "kiarojo.jpg"));
        veh.add(new Vehiculo(6, "GHI", "Chevrolet", "bien bomnito", "motor bueno", 2020, 105.6, "verdecito", "agua", 15675, 7, "chevroletverde.jpg"));
        veh.add(new Vehiculo(9, "JKL", "Chayomi", "Mi Mix", "Snapdragon", 2010, 35, "Gris", "Electricidad", 3, "Transmisión", 10500, 15, "chayomigris.jpg"));

        Vehiculo.saveFile("data/db/vehiculos.ser", veh);
        ArrayList<Oferta> listaOfertas = new ArrayList<>();
        Oferta of = new Oferta(5, 2, 5, 2);
        listaOfertas.add(of);
        Oferta.saveFile("data/db/ofertas.ser", listaOfertas);

        ArrayList<Usuario> vendedores = new ArrayList<>();
        Vendedor v = new Vendedor(1, "Danny", "Burneo", "dannyburneo2002@hotmail.com", "Espol", "Patitofeo123");
        vendedores.add(v);
        v.saveFile("data/db/vendedores.ser", vendedores);
        Util.crearArchivoHash(vendedores, "claveHashVendedores.ser");

        ArrayList<Usuario> compradores = new ArrayList<>();
        Comprador c = new Comprador(1, "Velika", "Ruso", "thevelika@hotmail.com", "Discord", "Laguayabita777");
        compradores.add(c);
        c.saveFile("data/db/compradores.ser", compradores);
        Util.crearArchivoHash(compradores, "data/db/claveHashCompradores.ser");

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo v2 = new Vehiculo(9, "JKL", "Chayomi", "Mi Mix", "Snapdragon", 2010, 35, "Gris", "Electricidad", 3, "Transmisión", 10500, 15, "chayomigris.jpg");
        vehiculos.add(v2);
        Vehiculo.saveFile("data/db/vehiculos.ser", vehiculos);
         */
        launch();
    }

}

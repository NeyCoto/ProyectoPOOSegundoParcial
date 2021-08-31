module ec.edu.espol.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyectofinal to javafx.fxml;
    opens ec.edu.espol.controller to javafx.fxml;
    exports ec.edu.espol.proyectofinal;
    exports ec.edu.espol.controller;
}

package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CargarBaseDatosController implements Initializable {
    private IController controller;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new Controller();

        try {
            this.controller.restartDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
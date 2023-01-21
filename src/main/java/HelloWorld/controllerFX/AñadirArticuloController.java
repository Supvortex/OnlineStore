package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AñadirArticuloController implements Initializable {

    private IController controller;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPvp;
    @FXML
    private TextField txtGastosEnvio;
    @FXML
    private TextField txtTiempoEnvio;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.controller = new Controller();

    }

    @FXML
    public void onClickAceptar(ActionEvent event) {
        Articulo articulo = new Articulo();
        ObservableList<Articulo> obs = FXCollections.observableArrayList();
        try {
            articulo.setCodigo(txtCodigo.getText());
            articulo.setDescripcion(txtDescripcion.getText());
            articulo.setPvp(Float.parseFloat(txtPvp.getText()));
            articulo.setGastoEnvio(Float.parseFloat(txtGastosEnvio.getText()));
            articulo.setTiempoEnvio(Integer.parseInt(txtTiempoEnvio.getText()));

            if (this.controller.anadirArticulo(articulo)) {
                System.out.println("Se ha añadido el articulo: " + articulo.toString() + "\n");
                obs.add(articulo);
            } else {
                System.out.println("No se ha añadido el articulo\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
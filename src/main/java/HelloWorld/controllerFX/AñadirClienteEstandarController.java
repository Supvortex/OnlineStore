package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClienteEstandar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AñadirClienteEstandarController implements Initializable {

    private IController controller;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDomicilio;
    @FXML
    private TextField txtNif;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new Controller();
    }

    @FXML
    public void onClickAceptar(ActionEvent event) {
        ObservableList<Cliente> obs = FXCollections.observableArrayList();
        ClienteEstandar clienteEstandar = new ClienteEstandar();
        try {
            clienteEstandar.setEmail(txtEmail.getText());
            clienteEstandar.setNombre(txtNombre.getText());
            clienteEstandar.setDomicilio(txtDomicilio.getText());
            clienteEstandar.setNif(txtNif.getText());

            if (this.controller.anadirCliente(clienteEstandar)) {
                obs.add(clienteEstandar);
                System.out.println("Se ha añadido el cliente: " + clienteEstandar.toString() + "\n");
            } else {
                System.out.println("No se ha añadido el cliente\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el cliente.\n");
        }
    }

}
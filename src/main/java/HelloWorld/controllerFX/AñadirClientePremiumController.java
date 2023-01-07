package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClientePremium;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AñadirClientePremiumController implements Initializable {

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
        ClientePremium clientePremium = new ClientePremium();
        try {
            clientePremium.setEmail(txtEmail.getText());
            clientePremium.setNombre(txtNombre.getText());
            clientePremium.setDomicilio(txtDomicilio.getText());
            clientePremium.setNif(txtNif.getText());

            if (this.controller.anadirCliente(clientePremium)) {
                obs.add(clientePremium);
                System.out.println("Se ha añadido el cliente premium: " + clientePremium.toString() + "\n");
            } else {
                System.out.println("No se ha añadido el cliente premium\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el cliente premium.\n");
        }
    }

}
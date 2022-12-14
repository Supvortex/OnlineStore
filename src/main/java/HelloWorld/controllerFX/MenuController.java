package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class MenuController {

    private IController controller;
    @FXML
    private Label labelBaseDatosCargada;

    public MenuController(){
        this.controller = new Controller();
    }
    @FXML
    protected void onClickAbrirGestionArticulos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/gestionArticulos-view.fxml"));
        Parent root = loader.load();
        GestionArticulosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Gestión de artículos");
        stage.show();
    }

    @FXML
    protected void onClickGestionClientes() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/gestionClientes-view.fxml"));
        Parent root = loader.load();
        GestionClientesController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Gestión de clientes");
        stage.show();
    }

    @FXML
    protected void onClickGestionPedidos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/gestionPedidos-view.fxml"));
        Parent root = loader.load();
        GestionPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Gestión de pedidos");
        stage.showAndWait();
    }

    @FXML
    protected void onClickCargarBaseDatos() throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/cargarBaseDatos-view.fxml"));
        Parent root = loader.load();
        CargarBaseDatosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cargar base de datos");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MostrarArticulosController implements Initializable {

    private IController controller;

    @FXML
    private TableColumn<Articulo, String> colCodigo;
    @FXML
    private TableColumn<Articulo, String> colDescripcion;
    @FXML
    private TableColumn<Articulo, Float> colPvp;
    @FXML
    private TableColumn<Articulo, Float> colGastos;
    @FXML
    private TableColumn<Articulo, Integer> colTiempo;
    @FXML
    private TableView<Articulo> tblArticulos;

    public MostrarArticulosController() {
        this.controller = new Controller();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPvp.setCellValueFactory(new PropertyValueFactory("pvp"));
        this.colGastos.setCellValueFactory(new PropertyValueFactory("gastoEnvio"));
        this.colTiempo.setCellValueFactory(new PropertyValueFactory("tiempoEnvio"));

        ObservableList<Articulo> listArticulos = null;
        try {
            listArticulos = getArticulos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblArticulos.setItems(listArticulos);

    }

    public ObservableList<Articulo> getArticulos() throws SQLException {

        ObservableList<Articulo> obs = FXCollections.observableArrayList();
        if (this.controller.mostrarArticulos().size() > 0) {
            for (Articulo miArticulo : this.controller.mostrarArticulos()) {
                obs.add(miArticulo);
            }
        } else {
            System.out.println("No existen articulos en el sistema.");
        }

        return obs;
    }



}

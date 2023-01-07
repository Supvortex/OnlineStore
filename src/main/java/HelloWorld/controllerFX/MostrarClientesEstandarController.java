package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MostrarClientesEstandarController implements Initializable {

    private IController controller;

    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colDomicilio;
    @FXML
    private TableColumn<Cliente, String> colNif;
    @FXML
    private TableColumn<Cliente, String> colCorreo;
    @FXML
    private TableView<Cliente> tblEstandar;
    @FXML
    private Button btnVolver;

    public MostrarClientesEstandarController() {
        this.controller = new Controller();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colDomicilio.setCellValueFactory(new PropertyValueFactory("domicilio"));
        this.colNif.setCellValueFactory(new PropertyValueFactory("nif"));
        this.colCorreo.setCellValueFactory(new PropertyValueFactory("email"));

        ObservableList<Cliente> listcliente = null;
        try {
            listcliente = getClientes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblEstandar.setItems(listcliente);

    }

    public ObservableList<Cliente> getClientes() throws SQLException {

        ObservableList<Cliente> obs = FXCollections.observableArrayList();
        if (this.controller.mostrarClientesEstandard().size() > 0) {
            for (Cliente cliente : this.controller.mostrarClientesEstandard()) {
                obs.add(cliente);
            }
        } else {
            System.out.println("No existen articulos en el sistema.");
        }

        return obs;
    }

    @FXML
    protected void onClickVolver(ActionEvent event){
        Stage stage = (Stage)btnVolver.getScene().getWindow();
        stage.close();
    }

}

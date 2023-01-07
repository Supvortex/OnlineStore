package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.Pedido;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MostrarPedidosEnviadosController implements Initializable {

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
    private TableColumn<Pedido, String> colNumeroPedido;
    @FXML
    private TableColumn<Pedido, LocalDateTime> colFechaHora;
    @FXML
    private TableColumn<Pedido, String> colNifPedido;
    @FXML
    private TableColumn<Pedido, String> colNombrePedido;
    @FXML
    private TableColumn<Pedido, String> colCodigoArticulo;
    @FXML
    private TableColumn<Pedido, String> colDescripcionArticulo;
    @FXML
    private TableColumn<Pedido, Integer> colCantidad;
    @FXML
    private TableColumn<Pedido, Float> colPrecio;
    @FXML
    private TableColumn<Pedido, Float> colGastosEnvio;
    @FXML
    private TableColumn<Pedido, Float> colTotal;
    @FXML
    private TableView<Pedido> tblPedidos;
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TextField labelEmail;
    @FXML
    private Button btnVolver;

    public MostrarPedidosEnviadosController() {
        this.controller = new Controller();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colNombre.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getNombre()));
        this.colDomicilio.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getDomicilio()));
        this.colNif.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getNif()));
        this.colCorreo.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getEmail()));

        ObservableList<Cliente> listcliente = null;
        try {
            listcliente = getClientes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblClientes.setItems(listcliente);

    }

    public ObservableList<Pedido> getPedidos() throws SQLException {

        ObservableList<Pedido> obs = FXCollections.observableArrayList();
        String resp = labelEmail.getText();

        if (this.controller.mostrarPedidosEnviados(resp).size()>0){
            for (Pedido miPedido : this.controller.mostrarPedidosEnviados(resp)) {
                obs.add(miPedido);
            }
        } else {
            System.out.println("No existen pedidos enviados en el sistema.");
        }

        return obs;
    }

    public ObservableList<Cliente> getClientes() throws SQLException {

        ObservableList<Cliente> obs = FXCollections.observableArrayList();
        if (this.controller.mostrarClientes().size() > 0) {
            for (Cliente cliente : this.controller.mostrarClientes()) {
                obs.add(cliente);
            }
        } else {
            System.out.println("No existen articulos en el sistema.");
        }

        return obs;
    }

    @FXML
    protected void onClickBuscarPedido() throws IOException, SQLException {
        this.colNumeroPedido.setCellValueFactory(new PropertyValueFactory("numPedido"));
        this.colFechaHora.setCellValueFactory(new PropertyValueFactory("fechaHora"));
        this.colNifPedido.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getCliente().getNif()));
        this.colNombrePedido.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getCliente().getNombre()));
        this.colCodigoArticulo.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getArticulo().getCodigo()));
        this.colDescripcionArticulo.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getArticulo().getDescripcion()));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colPrecio.setCellValueFactory(data ->  new SimpleObjectProperty<>(data.getValue().getArticulo().getPvp()));
        this.colGastosEnvio.setCellValueFactory(data ->  new SimpleObjectProperty(data.getValue().getArticulo().getGastoEnvio()));
        this.colTotal.setCellValueFactory(data ->  new SimpleObjectProperty(data.getValue().getArticulo().getGastoEnvio()));

        ObservableList<Pedido> listPedidos= null;
        try {
            listPedidos = getPedidos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblPedidos.setItems(listPedidos);
        getPedidos();
    }

    @FXML
    protected void onClickVolver(ActionEvent event){
        Stage stage = (Stage)btnVolver.getScene().getWindow();
        stage.close();
    }
}

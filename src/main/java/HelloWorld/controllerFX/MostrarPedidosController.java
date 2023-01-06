package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.*;
import HelloWorld.modelo.Pedido;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class MostrarPedidosController implements Initializable {

    private IController controller;

    @FXML
    private TableColumn<Pedido, String> colNumeroPedido;
    @FXML
    private TableColumn<Pedido, LocalDateTime> colFechaHora;
    @FXML
    private TableColumn<Pedido, String> colNif;
    @FXML
    private TableColumn<Pedido, String> colNombre;
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

    public MostrarPedidosController() {
        this.controller = new Controller();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        this.colNumeroPedido.setCellValueFactory(new PropertyValueFactory("numPedido"));
        this.colFechaHora.setCellValueFactory(new PropertyValueFactory("fechaHora"));
        this.colNif.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getCliente().getNif()));
        this.colNombre.setCellValueFactory(data ->  new SimpleStringProperty(data.getValue().getCliente().getNombre()));
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

    }

    public ObservableList<Pedido> getPedidos() throws SQLException {

        ObservableList<Pedido> obs = FXCollections.observableArrayList();
        Lista<Pedido> pedidoLista = this.controller.mostrarPedidos();


        if (pedidoLista.size()>0){
            for (Pedido miPedido : pedidoLista) {
                obs.add(miPedido);
            }
        } else {
            System.out.println("No existen pedidos en el sistema.");
        }

        return obs;
    }
}

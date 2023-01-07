package HelloWorld.controllerFX;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AñadirPedidoController implements Initializable {

    private IController controller;
    @FXML
    private TextField txtNumeroPedido;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtCodigoArticulo;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TableColumn<Cliente, String> colNombreCli;
    @FXML
    private TableColumn<Cliente, String> colDomicilioCli;
    @FXML
    private TableColumn<Cliente, String> colNifCli;
    @FXML
    private TableColumn<Cliente, String> colCorreoCli;
    @FXML
    private TableColumn<Articulo, String> colCodigoArt;
    @FXML
    private TableColumn<Articulo, String> colDescripcionArt;
    @FXML
    private TableColumn<Articulo, Float> colPvpArt;
    @FXML
    private TableColumn<Articulo, Float> colGastosArt;
    @FXML
    private TableColumn<Articulo, Integer> colTiempoArt;
    @FXML
    private TableView<Articulo> tblArticulos;
    @FXML
    private TableView<Cliente> tblClientes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.controller = new Controller();

        mostrarClientes();
        mostrarArticulos();
    }

    private void mostrarArticulos(){
        this.colCodigoArt.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colDescripcionArt.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPvpArt.setCellValueFactory(new PropertyValueFactory("pvp"));
        this.colGastosArt.setCellValueFactory(new PropertyValueFactory("gastoEnvio"));
        this.colTiempoArt.setCellValueFactory(new PropertyValueFactory("tiempoEnvio"));

        ObservableList<Articulo> listArticulos = null;
        try {
            listArticulos = getArticulos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblArticulos.setItems(listArticulos);
    }

    private void mostrarClientes() {
        this.colNombreCli.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colDomicilioCli.setCellValueFactory(new PropertyValueFactory("domicilio"));
        this.colNifCli.setCellValueFactory(new PropertyValueFactory("nif"));
        this.colCorreoCli.setCellValueFactory(new PropertyValueFactory("email"));

        ObservableList<Cliente> listcliente = null;
        try {
            listcliente = getClientes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tblClientes.setItems(listcliente);
    }

    private ObservableList<Cliente> getClientes() throws SQLException {
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
    public void onClickAceptar(ActionEvent event) {
        Pedido pedido = new Pedido();
        try {
            pedido.setNumPedido(txtNumeroPedido.getText());
            pedido.setCliente(controller.getClienteWithID(txtCorreo.getText()));
            pedido.setArticulo(controller.getArticuloWithCode(txtCodigoArticulo.getText()));
            pedido.setCantidad(Integer.parseInt(txtCantidad.getText()));
            pedido.setFechaHora(LocalDateTime.now());

            if (this.controller.anadirPedido(pedido)) {
                System.out.println("Se ha añadido el pedido: " + pedido.toString() + "\n");
            } else {
                System.out.println("El numero de pedido ya existe.\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el pedido.\n");
        }
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
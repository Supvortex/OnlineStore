package HelloWorld.controllerFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


public class GestionPedidosController {

    @FXML
    private Button btnVolver;

    @FXML
    protected void onClickAñadirPedido() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirPedido.fxml"));
        Parent root = loader.load();
        AñadirPedidoController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Añadir pedido");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickEliminarPedido() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/eliminarPedido.fxml"));
        Parent root = loader.load();
        EliminarPedidoController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Eliminar pedido");
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarPedidos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarPedidos.fxml"));
        Parent root = loader.load();
        MostrarPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mostrar pedidos");
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarEnviados() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarEnviados.fxml"));
        Parent root = loader.load();
        MostrarPedidosEnviadosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mostrar pedidos enviados");
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarPendientes() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarPendientes.fxml"));
        Parent root = loader.load();
        MostrarPedidosPendientesController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Mostrar pedidos pendientes");
        stage.showAndWait();
    }
    @FXML
    protected void onClickVolver(ActionEvent event){
        Stage stage = (Stage)btnVolver.getScene().getWindow();
        stage.close();
    }
}
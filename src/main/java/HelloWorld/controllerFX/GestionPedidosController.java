package HelloWorld.controllerFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class GestionPedidosController {

    @FXML
    protected void onClickAñadirPedido() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirPedido.fxml"));
        Parent root = loader.load();
        GestionPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickEliminarPedido() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/eliminarPedido.fxml"));
        Parent root = loader.load();
        GestionPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarPedidos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarPedidos.fxml"));
        Parent root = loader.load();
        GestionPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarEnviados() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarEnviados.fxml"));
        Parent root = loader.load();
        GestionPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarPendientes() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarPendientes.fxml"));
        Parent root = loader.load();
        GestionPedidosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
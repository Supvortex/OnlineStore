package HelloWorld.controllerFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class GestionClientesController {

    @FXML
    protected void onClickAñadirClientesEstandar() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirClienteEstandar.fxml"));
        Parent root = loader.load();
        AñadirClienteEstandarController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickAñadirClientesPremium() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirClientePremium.fxml"));
        Parent root = loader.load();
        AñadirClientePremiumController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarClientes() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarClientes.fxml"));
        Parent root = loader.load();
        MostrarClientesController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarEstandar() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarEstandar.fxml"));
        Parent root = loader.load();
        MostrarClientesEstandarController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarPremium() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarPremium.fxml"));
        Parent root = loader.load();
        MostrarClientesPremiumController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }


//
}
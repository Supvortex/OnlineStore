package HelloWorld.controllerFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class GestionArticulosController {

    @FXML
    protected void onClickAñadirArticulos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirArticulos.fxml"));
        Parent root = loader.load();
        GestionArticulosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarArticulos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarArticulos.fxml"));
        Parent root = loader.load();
        GestionArticulosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }
}

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
import java.sql.SQLException;

public class GestionArticulosController {
    @FXML
    private Button btnVolver;

    @FXML
    protected void onClickAñadirArticulos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirArticulos.fxml"));
        Parent root = loader.load();
        AñadirArticuloController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Añadir artículo");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onClickMostrarArticulos() throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/mostrarArticulos.fxml"));
        Parent root = loader.load();
        MostrarArticulosController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Mostrar artículos");
        stage.setScene(scene);
        stage.showAndWait();

    }

    @FXML
    protected void onClickVolver(ActionEvent event){
        Stage stage = (Stage)btnVolver.getScene().getWindow();
        stage.close();
    }
}

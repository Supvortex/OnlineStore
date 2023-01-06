package HelloWorld.controllerFX;
import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.Articulo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class GestionArticulosController {

    @FXML
    protected void onClickAñadirArticulos() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/añadirArticulos.fxml"));
        Parent root = loader.load();
        AñadirArticuloController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
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

        stage.setScene(scene);
        stage.showAndWait();

    }

}

package HelloWorld.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;


public class OnlineStore extends Application {
    public static void main(String[] args) throws SQLException {

         //GestionOS gestion = new GestionOS();
         //gestion.inicio();

        //CON LAUNCH SE ABRE EL MENU
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineStore.class.getResource("/vista/menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("OnlineStore");
        stage.setScene(scene);
        stage.show();


    }
}
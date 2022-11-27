package modelo;
import HelloWorld.modelo.dao.Conexion;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestConexion {
    @Test
    void TestConexionCreated() throws SQLException {
        Conexion con = new Conexion();
    }

}


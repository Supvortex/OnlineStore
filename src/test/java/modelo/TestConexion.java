package modelo;
import HelloWorld.modelo.dao.Conexion;
import HelloWorld.modelo.dao.IConexion;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestConexion {
    @Test
    void TestConexionCreated() throws SQLException {
        IConexion con = new Conexion();
    }

}


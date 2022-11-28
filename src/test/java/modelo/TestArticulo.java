package modelo;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Pedido;
import HelloWorld.modelo.dao.Conexion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TestArticulo {
    @Test
    void whenAddArticleThenArticleIsAdded() throws SQLException {
        Conexion con = new Conexion();
        con.restartDatabase();
        Assertions.assertTrue(con.obtenerArticulo().size() == 6);
        con.cerrarConexion();
    }
    @Test
    void WhenAddArticuloThenArticuloIsAdded() throws SQLException {
        Conexion con = new Conexion();
        con.restartDatabase();
        Articulo articulo = new Articulo();
        articulo.setCodigo("30");
        articulo.setDescripcion("Cuchillo");
        articulo.setPvp(15.0f);
        articulo.setGastoEnvio(4.0f);
        articulo.setTiempoEnvio(60);
        Assertions.assertTrue(con.anadirArticulo(articulo));
        con.cerrarConexion();
    }
}
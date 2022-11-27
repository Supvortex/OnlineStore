package modelo;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.dao.Conexion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class TestCliente {
    @Test
    void whenAsksForEstandarClientsThenReturnsTwo() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerClientesEstandar().size() == 2);
        con.cerrarConexion();
    }
    @Test
    void whenAsksForPremiumClientsThenReturnsOne() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerClientesPremium().size() == 1);
        con.cerrarConexion();
    }
    /*@Test
    void whenAddClienEstandartThenClientEstandarIsAdded() throws SQLException {
        ClienteEstandar clienteestandar = new ClienteEstandar();
        clienteestandar.setEmail("TestMail@edu.com");
        clienteestandar.setNombre("Testi Test");
        clienteestandar.setDomicilio("Calle Testillo");
        clienteestandar.setNif("221487621T");
        Conexion con = new Conexion();
        Integer membersCount = con.obtenerClientesEstandar().size();
        con.addClienteEstandar(clienteestandar);
        Assertions.assertTrue(con.obtenerClientesEstandar().size() == membersCount + 1);
        con.cerrarConexion();
    }*/
}

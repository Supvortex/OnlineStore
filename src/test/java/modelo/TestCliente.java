package modelo;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.ClientePremium;
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
    @Test
    void whenAsksForClientWithIdThenReturnsClient() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerClienteEmail("Armandoguerra@uoc.edu").getEmail().equals("Armandoguerra@uoc.edu"));
        Assertions.assertTrue(con.obtenerClienteEmail("Armandoguerra@uoc.edu") instanceof ClientePremium);
        con.cerrarConexion();
    }
    @Test
    void whenAsksForArticuloWithCodeThenReturnArticulo() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerArticuloConCod("015").getDescripcion().equals("sarten"));
        con.cerrarConexion();
    }
    @Test
    void whenAddClienEstandartThenClientEstandarIsAdded() throws SQLException {
        ClienteEstandar clienteestandar = new ClienteEstandar();
        clienteestandar.setEmail("TestMail@uoc.edu");
        clienteestandar.setNombre("Testi Test");
        clienteestandar.setDomicilio("Calle Testillo");
        clienteestandar.setNif("221487621T");
        Conexion con = new Conexion();
        Integer membersCount = con.obtenerClientesEstandar().size();
        boolean resultado = con.addClienteEstandar(clienteestandar);
        Assertions.assertTrue(con.obtenerClientesEstandar().size() == membersCount + 1);
        con.cerrarConexion();
    }
    @Test
    void whenAddClienPremiumThenClientPremiumIsAdded() throws SQLException {
        ClientePremium clientepremium = new ClientePremium();
        clientepremium.setEmail("TestMail@uoc.edu2");
        clientepremium.setNombre("Testi Test2");
        clientepremium.setDomicilio("Calle Testillo2");
        clientepremium.setNif("221487621T2");
        Conexion con = new Conexion();
        Integer membersCount = con.obtenerClientesPremium().size();
        boolean resultado = con.addClientePremium(clientepremium);
        Assertions.assertTrue(con.obtenerClientesPremium().size() == membersCount + 1);
        con.cerrarConexion();
    }
}

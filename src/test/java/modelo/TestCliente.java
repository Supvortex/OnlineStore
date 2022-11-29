package modelo;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.ClientePremium;
import HelloWorld.modelo.dao.Conexion;
import HelloWorld.modelo.dao.IConexion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;

public class TestCliente {
    private static IConexion con;

    @BeforeAll
    static void init(){
        con = new Conexion();

    }
    @BeforeEach
    public void restart() throws SQLException {
        this.con.restartDatabase();
    }
    @Test
    void whenAsksForEstandarClientsThenReturnsTwo() throws SQLException {
        Assertions.assertTrue(con.obtenerClientesEstandar().size() == 2);
    }
    @Test
    void whenAsksForPremiumClientsThenReturnsOne() throws SQLException {
        Assertions.assertTrue(con.obtenerClientesPremium().size() == 2);
    }
    @Test
    void whenAsksForClientWithIdThenReturnsClient() throws SQLException {
        Assertions.assertTrue(con.obtenerClienteEmail("Armandoguerra@uoc.edu").getEmail().equals("Armandoguerra@uoc.edu"));
        Assertions.assertTrue(con.obtenerClienteEmail("Armandoguerra@uoc.edu") instanceof ClientePremium);
    }
    @Test
    void whenAsksForArticuloWithCodeThenReturnArticulo() throws SQLException {
        Assertions.assertTrue(con.obtenerArticuloConCod("015").getDescripcion().equals("sarten"));
    }
    @Test
    void whenAddClienEstandartThenClientEstandarIsAdded() throws SQLException {
        ClienteEstandar clienteestandar = new ClienteEstandar();
        clienteestandar.setEmail("TestMail@uoc.edu");
        clienteestandar.setNombre("Testi Test");
        clienteestandar.setDomicilio("Calle Testillo");
        clienteestandar.setNif("221487621T");
        Integer membersCount = con.obtenerClientesEstandar().size();
        boolean resultado = con.addClienteEstandar(clienteestandar);
        Assertions.assertTrue(con.obtenerClientesEstandar().size() == membersCount + 1);
    }
    @Test
    void whenAddClienPremiumThenClientPremiumIsAdded() throws SQLException {
        ClientePremium clientepremium = new ClientePremium();
        clientepremium.setEmail("TestMail@uoc.edu2");
        clientepremium.setNombre("Testi Test2");
        clientepremium.setDomicilio("Calle Testillo2");
        clientepremium.setNif("221487621T2");
        Integer membersCount = con.obtenerClientesPremium().size();
        boolean resultado = con.addClientePremium(clientepremium);
        Assertions.assertTrue(con.obtenerClientesPremium().size() == membersCount + 1);
    }
}

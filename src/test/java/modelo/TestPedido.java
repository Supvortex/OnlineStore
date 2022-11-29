package modelo;

import HelloWorld.modelo.*;
import HelloWorld.modelo.dao.Conexion;
import HelloWorld.modelo.dao.Dao;
import HelloWorld.modelo.dao.IConexion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TestPedido {
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
    void WhenAskForPedidoThenWeReceivePedidoList() throws SQLException {
        Assertions.assertTrue(con.obtenerPedidos().size() > 0);
    }
    @Test
    void WhenAddPedidoThenPedidoIsAdded() throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setNumPedido("05");
        pedido.setCantidad(3);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setCliente(con.obtenerClienteEmail("Augustinstoy@uoc.edu"));
        pedido.setArticulo(con.obtenerArticuloConCod("020"));
        Assertions.assertTrue(con.anadirPedido(pedido));
    }
    @Test
    void WhenCheckIfPedidoExistThenReturnBoolean() throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setNumPedido("02");
        pedido.setCantidad(3);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setCliente(con.obtenerClienteEmail("Augustinstoy@uoc.edu"));
        pedido.setArticulo(con.obtenerArticuloConCod("020"));
        Assertions.assertTrue(con.pedidoExiste(pedido));
    }
    @Test
    void WhenPedidoIsReceivedThenIsCanceled() throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setNumPedido("04");
        pedido.setCantidad(3);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setCliente(con.obtenerClienteEmail("Augustinstoy@uoc.edu"));
        pedido.setArticulo(con.obtenerArticuloConCod("020"));
        Assertions.assertTrue(con.cancelarPedido(pedido));
    }
    @Test
    void WhenNumpedidoIsSentThenPedidoIsReceived() throws SQLException {
        Assertions.assertTrue(con.obtenerPedidosConId("04").getNumPedido().equals("04"));
    }
    @Test
    void WhenEmailIsSentThenPedidosAreReceived() throws SQLException {
        Assertions.assertTrue(con.obtenerPedidoConCliente("EvaFina@uoc.edu").size() > 0);
    }
}

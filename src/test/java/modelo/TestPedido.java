package modelo;

import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClientePremium;
import HelloWorld.modelo.Pedido;
import HelloWorld.modelo.dao.Conexion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TestPedido {
    @Test
    void WhenAskForPedidoThenWeReceivePedidoList() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerPedidos().size() > 0);
        con.cerrarConexion();
    }
    @Test
    void WhenAddPedidoThenPedidoIsAdded() throws SQLException {
        Conexion con = new Conexion();
        Pedido pedido = new Pedido();
        pedido.setNumPedido("05");
        pedido.setCantidad(3);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setCliente(con.obtenerClienteEmail("Augustinstoy@uoc.edu"));
        pedido.setArticulo(con.obtenerArticuloConCod("020"));
        Assertions.assertTrue(con.anadirPedido(pedido));
        con.cerrarConexion();
    }
    @Test
    void WhenCheckIfPedidoExistThenReturnBoolean() throws SQLException {
        Conexion con = new Conexion();
        Pedido pedido = new Pedido();
        pedido.setNumPedido("02");
        pedido.setCantidad(3);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setCliente(con.obtenerClienteEmail("Augustinstoy@uoc.edu"));
        pedido.setArticulo(con.obtenerArticuloConCod("020"));
        Assertions.assertTrue(con.pedidoExiste(pedido));
        con.cerrarConexion();
    }
    @Test
    void WhenPedidoIsReceivedThenIsCanceled() throws SQLException {
        Conexion con = new Conexion();
        Pedido pedido = new Pedido();
        pedido.setNumPedido("04");
        pedido.setCantidad(3);
        pedido.setFechaHora(LocalDateTime.now());
        pedido.setCliente(con.obtenerClienteEmail("Augustinstoy@uoc.edu"));
        pedido.setArticulo(con.obtenerArticuloConCod("020"));
        Assertions.assertTrue(con.cancelarPedido(pedido));
        con.cerrarConexion();
    }
    @Test
    void WhenNumpedidoIsSentThenPedidoIsReceived() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerPedidosConId("05").getNumPedido().equals("05"));
        con.cerrarConexion();
    }
    @Test
    void WhenEmailIsSentThenPedidosAreReceived() throws SQLException {
        Conexion con = new Conexion();
        Assertions.assertTrue(con.obtenerPedidoConCliente("EvaFina@uoc.edu").size() > 0);
        con.cerrarConexion();
    }
}

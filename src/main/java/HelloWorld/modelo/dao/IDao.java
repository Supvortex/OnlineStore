package HelloWorld.modelo.dao;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.Pedido;

import java.sql.SQLException;

public interface IDao {

    Boolean restartDatabase() throws SQLException;

    Boolean anadirPedido(Pedido pedido) throws SQLException;

    Boolean cancelarPedido(Pedido numPedido);

    Lista<Pedido> mostrarPedidos () throws SQLException;

    Boolean anadirCliente (Cliente cliente) throws SQLException;

    Lista<Cliente> mostrarClientes () throws SQLException;

    Lista<Cliente> mostrarClientesPrem () throws SQLException;

    Lista<Cliente> mostrarClientesEstandar() throws SQLException;

    Boolean anadirArticulo(Articulo articulo) throws SQLException;

    Lista<Articulo> mostrarArticulos() throws SQLException;

    Pedido getPedidoConNumPedido(String numPedido) throws SQLException;

    Lista<Pedido> mostrarPedidosPendientes(String cliente) throws SQLException;

    Lista<Pedido> mostrarPedidosEnviados(String cliente) throws SQLException;

    Cliente getClienteWithID(String emailParam) throws SQLException;

    Articulo getArticuloWithCode(String codeParam) throws SQLException;

    Pedido getPedidoWithNumPedido(String numPedidoParam) throws SQLException;

    Boolean estaEnviado(Pedido pedidoParam);

}

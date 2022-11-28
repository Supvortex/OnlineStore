package HelloWorld.controlador;

import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.Pedido;

import java.sql.SQLException;

public interface IController {

    Boolean anadirPedido(Pedido pedido) throws SQLException;

    Lista<Pedido> mostrarPedidos () throws SQLException;

    Boolean cancelarPedido(String numPedido) throws SQLException;

    Lista<Pedido> mostrarPedidosPendientes(String cliente) throws SQLException;

    Lista<Pedido> mostrarPedidosEnviados(String cliente) throws SQLException;

    Boolean anadirCliente(Cliente cliente) throws SQLException;

    Lista<Cliente> mostrarClientes() throws SQLException;

    Lista<Cliente> mostrarClientesEstandard() throws SQLException;

    Lista<Cliente> mostrarClientesPremium() throws SQLException;

    Boolean anadirArticulo(Articulo articulo) throws SQLException;

    Lista<Articulo> mostrarArticulos() throws SQLException;

    Cliente getClienteWithID(String emailParam) throws SQLException;

    Articulo getArticuloWithCode(String codeParam) throws SQLException;

    Pedido getPedidoWithNumPedido(String numPedidoParam) throws SQLException;

}
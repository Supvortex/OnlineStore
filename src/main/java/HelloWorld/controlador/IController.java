package HelloWorld.controlador;

import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import java.util.List;

// METODOS INTERFACE

public interface IController {

Boolean anadirPedido(Pedido pedido);

List<Pedido> mostrarPedidos ();

Boolean cancelarPedido(String numPedido);

List<Pedido> mostrarPedidosPendientes(String cliente);

List<Pedido> mostrarPedidosEnviados(String cliente);

Boolean anadirCliente(Cliente cliente);

List<Cliente> mostrarClientes();

List<Cliente> mostrarClientesEstandard();

List<Cliente> mostrarClientesPremium();

Boolean anadirArticulo(Articulo articulo);

List<Articulo> mostrarArticulos();

Cliente getClienteWithID(String emailParam);

Articulo getArticuloWithCode(String codeParam);

Pedido getPedidoWithNumPedido(String numPedidoParam);

}
package HelloWorld.controlador;

import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import java.util.List;

// METODOS INTERFACE

public interface IController {

void añadirPedido(Pedido pedido);

void cancelarPedido(Pedido numPedido);

List<Pedido> mostrarPedidosPendientes(String cliente);

List<Pedido> mostrarPedidosEnviados(String cliente);

void añadirCliente(Cliente cliente);

List<Cliente> mostrarClientes();

List<Cliente> mostrarClientesEstandard();

List<Cliente> mostrarClientesPremium();

void añadirArticulo(Articulo articulo);

List<Articulo> mostrarArticulos();










}
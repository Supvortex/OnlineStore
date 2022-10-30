package HelloWorld.controlador;

import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.Pedido;
public interface IController {

    Boolean anadirPedido(Pedido pedido);

    Lista<Pedido> mostrarPedidos ();

    Boolean cancelarPedido(String numPedido);

    Lista<Pedido> mostrarPedidosPendientes(String cliente);

    Lista<Pedido> mostrarPedidosEnviados(String cliente);

    Boolean anadirCliente(Cliente cliente);

    Lista<Cliente> mostrarClientes();

    Lista<Cliente> mostrarClientesEstandard();

    Lista<Cliente> mostrarClientesPremium();

    Boolean anadirArticulo(Articulo articulo);

    Lista<Articulo> mostrarArticulos();

    Cliente getClienteWithID(String emailParam);

    Articulo getArticuloWithCode(String codeParam);

    Pedido getPedidoWithNumPedido(String numPedidoParam);

}
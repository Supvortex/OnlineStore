package HelloWorld.modelo.dao;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.Pedido;

public interface IDao {

    Boolean anadirPedido(Pedido pedido);

    Boolean cancelarPedido(Pedido numPedido);

    Lista<Pedido> mostrarPedidos ();

    Boolean anadirCliente (Cliente cliente);

    Lista<Cliente> mostrarClientes ();

    Lista<Cliente> mostrarClientesPrem ();

    Lista<Cliente> mostrarClientesEstandar();

    Boolean anadirArticulo(Articulo articulo);

    Lista<Articulo> mostrarArticulos();

    Pedido getPedidoConNumPedido(String numPedido);

    Lista<Pedido> mostrarPedidosPendientes(String cliente);

    Lista<Pedido> mostrarPedidosEnviados(String cliente);

    Cliente getClienteWithID(String emailParam);

    Articulo getArticuloWithCode(String codeParam);

    Pedido getPedidoWithNumPedido(String numPedidoParam);

    Boolean estaEnviado(Pedido pedidoParam);

}

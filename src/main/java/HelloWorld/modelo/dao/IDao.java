package HelloWorld.modelo.dao;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import java.util.List;

public interface IDao {

    Boolean anadirPedido(Pedido pedido);

    Boolean cancelarPedido(Pedido numPedido);

    List<Pedido> mostrarPedidos ();

    Boolean anadirCliente (Cliente cliente);

    List<Cliente> mostrarClientes ();

    List<Cliente> mostrarClientesPrem ();

    List<Cliente> mostrarClientesEstandar();

    Boolean anadirArticulo(Articulo articulo);

    List<Articulo> mostrarArticulos();

    Pedido getPedidoConNumPedido(String numPedido);

    List<Pedido> mostrarPedidosPendientes(String cliente);

    List<Pedido> mostrarPedidosEnviados(String cliente);

    Cliente getClienteWithID(String emailParam);

    Articulo getArticuloWithCode(String codeParam);

    Pedido getPedidoWithNumPedido(String numPedidoParam);

    Boolean estaEnviado(Pedido pedidoParam);

}

package HelloWorld.modelo.dao;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import java.util.List;

public interface IDao {

    void anadirPedido(Pedido pedido);

    void cancelarPedido(Pedido numPedido);

    List<Pedido> mostrarPedidos ();

    void anadirCliente (Cliente cliente);

    List<Cliente> mostrarClientes ();

    List<Cliente> mostrarClientesPrem ();

    List<Cliente> mostrarClientesEstandar();

    void anadirArticulo(Articulo articulo);

    List<Articulo> mostrarArticulos();

}

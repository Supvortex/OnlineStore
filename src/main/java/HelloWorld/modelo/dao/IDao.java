package HelloWorld.modelo.dao;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Pedido;
import java.util.List;

public interface IDao {

    void anadirPedido(Pedido pedido);

    void cancelarPedido(Pedido numPedido);

    List<Pedido> mostrarPedidos (Cliente cliente, Boolean enviado );

    void anadirCliente (Cliente cliente);

    void clienteExiste (Cliente cliente);

    List<Cliente> mostrarClientes ();

    List<Cliente> mostrarClientesPrem (Boolean esPremium );

    void anadirArticulo(Articulo articulo);

    void hayArticulo(Articulo articulo);

    List<Articulo> mostrarArticulos();

}

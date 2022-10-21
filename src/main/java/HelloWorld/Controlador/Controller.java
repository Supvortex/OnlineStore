package HelloWorld.Controlador;
import HelloWorld.Modelo.Articulo;
import HelloWorld.Modelo.Cliente;
import HelloWorld.Modelo.Dao.Dao;
import HelloWorld.Modelo.Pedido;
import java.util.List;
public class Controller {
    private Dao dao;
    public Controller(){
        dao = new Dao();
}
//METODOS
    void anadirPedido(Pedido pedido){
        this.dao.anadirPedido(pedido);
    }
    void cancelarPedido(String numPedido){
        if(this.dao.getPedidoConNumPedido(numPedido) != null){
            this.dao.cancelarPedido(this.dao.getPedidoConNumPedido(numPedido));
        }
    }
    List<Pedido> mostrarPedidosPendientes(String cliente){
        return this.dao.mostrarPedidosPendientes(cliente);
    }
    List<Pedido> mostrarPedidosEnviados(String cliente){
        return  this.dao.mostrarPedidosEnviados(cliente);
    }
    void añadirCliente(Cliente cliente) {
        this.dao.anadirCliente(cliente);
    }
    List<Cliente> mostrarClientes(){
        return this.dao.mostrarClientes();
    }
    List<Cliente> mostrarClientesEstandard(){
        return this.dao.mostrarClientes();
    }
    List<Cliente> mostrarClientesPremium(){
        return this.dao.mostrarClientesPrem();
    }
    void añadirArticulo(Articulo articulo){
        this.dao.anadirArticulo(articulo);
    }
    List<Articulo> mostrarArticulos(){
        return this.dao.mostrarArticulos();
    }
}
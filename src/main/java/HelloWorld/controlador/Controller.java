package HelloWorld.controlador;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.dao.Dao;
import HelloWorld.modelo.Pedido;
import HelloWorld.modelo.dao.IDao;
public class Controller implements IController  {
    private IDao dao;
    public Controller(){
        dao = new Dao();
}
    public Boolean anadirPedido(Pedido pedido){
        return this.dao.anadirPedido(pedido);
    }
    public Boolean cancelarPedido(String numPedido){
        return this.dao.cancelarPedido(this.dao.getPedidoConNumPedido(numPedido));
    }
    public Lista<Pedido> mostrarPedidos (){
        return this.dao.mostrarPedidos();
    }
    public Lista<Pedido> mostrarPedidosPendientes(String cliente){
        return this.dao.mostrarPedidosPendientes(cliente);
    }
    public Lista<Pedido> mostrarPedidosEnviados(String cliente){
        return  this.dao.mostrarPedidosEnviados(cliente);
    }
    public Boolean anadirCliente(Cliente cliente) {
        return this.dao.anadirCliente(cliente);
    }
    public Lista<Cliente> mostrarClientes(){
        return this.dao.mostrarClientes();
    }
    public Lista<Cliente> mostrarClientesEstandard(){
        return this.dao.mostrarClientesEstandar();
    }
    public Lista<Cliente> mostrarClientesPremium(){
        return this.dao.mostrarClientesPrem();
    }
    public Boolean anadirArticulo(Articulo articulo){
        return this.dao.anadirArticulo(articulo);
    }
    public Lista<Articulo> mostrarArticulos(){
        return this.dao.mostrarArticulos();
    }
    public Cliente getClienteWithID(String emailParam){
        return this.dao.getClienteWithID(emailParam);
    }
    public Articulo getArticuloWithCode(String codeParam){
        return this.dao.getArticuloWithCode(codeParam);
    }
    public Pedido getPedidoWithNumPedido(String numPedidoParam) {
        return this.dao.getPedidoWithNumPedido(numPedidoParam);
    }



}
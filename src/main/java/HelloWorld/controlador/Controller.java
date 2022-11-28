package HelloWorld.controlador;
import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.dao.Dao;
import HelloWorld.modelo.Pedido;
import HelloWorld.modelo.dao.IDao;

import java.sql.SQLException;

public class Controller implements IController  {
    private IDao dao;
    public Controller(){
        dao = new Dao();
}
    public Boolean anadirPedido(Pedido pedido) throws SQLException {
        return this.dao.anadirPedido(pedido);
    }
    public Boolean cancelarPedido(String numPedido) throws SQLException {
        return this.dao.cancelarPedido(this.dao.getPedidoConNumPedido(numPedido));
    }
    public Lista<Pedido> mostrarPedidos () throws SQLException {
        return this.dao.mostrarPedidos();
    }
    public Lista<Pedido> mostrarPedidosPendientes(String cliente) throws SQLException {
        return this.dao.mostrarPedidosPendientes(cliente);
    }
    public Lista<Pedido> mostrarPedidosEnviados(String cliente) throws SQLException {
        return  this.dao.mostrarPedidosEnviados(cliente);
    }
    public Boolean anadirCliente(Cliente cliente) throws SQLException {
        return this.dao.anadirCliente(cliente);
    }
    public Lista<Cliente> mostrarClientes() throws SQLException {
        return this.dao.mostrarClientes();
    }
    public Lista<Cliente> mostrarClientesEstandard() throws SQLException {
        return this.dao.mostrarClientesEstandar();
    }
    public Lista<Cliente> mostrarClientesPremium() throws SQLException {
        return this.dao.mostrarClientesPrem();
    }
    public Boolean anadirArticulo(Articulo articulo) throws SQLException {
        return this.dao.anadirArticulo(articulo);
    }
    public Lista<Articulo> mostrarArticulos() throws SQLException {
        return this.dao.mostrarArticulos();
    }
    public Cliente getClienteWithID(String emailParam) throws SQLException {
        return this.dao.getClienteWithID(emailParam);
    }
    public Articulo getArticuloWithCode(String codeParam) throws SQLException {
        return this.dao.getArticuloWithCode(codeParam);
    }
    public Pedido getPedidoWithNumPedido(String numPedidoParam) throws SQLException {
        return this.dao.getPedidoWithNumPedido(numPedidoParam);
    }



}
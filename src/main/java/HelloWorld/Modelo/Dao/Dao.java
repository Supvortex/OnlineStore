package HelloWorld.Modelo.Dao;

import HelloWorld.Modelo.Articulo;
import HelloWorld.Modelo.Cliente;
import HelloWorld.Modelo.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    List<Pedido> pedidos;
    List<Cliente> clientes;
    List<Articulo> articulos;

    public Dao() {
        this.pedidos = new ArrayList<Pedido>();
        this.clientes = new ArrayList<Cliente>();
        this.articulos = new ArrayList<Articulo>();
    }
    void anadirPedido(Pedido pedido){
        //TODO
    }
    void cancelarPedido(Pedido numPedido){
        //TODO
    }
    List<Pedido> mostrarPedidos (Cliente cliente, Boolean enviado ){
        List<Pedido> pedidos = new ArrayList<Pedido>();
        //TODO
        return pedidos;
    }
    void anadirCliente (Cliente cliente){
        //TODO
    }
    void clienteExiste (Cliente cliente){
        //TODO
    }
    List<Cliente> mostrarClientes (){
        List<Cliente> clientes = new ArrayList<Cliente>();
        //TODO
        return clientes;
    }
    List<Cliente> mostrarClientesPrem (Boolean esPremium ){
        List<Cliente> clientesPrem = new ArrayList<Cliente>();
        //TODO
        return clientesPrem;
    }
    void anadirArticulo(Articulo articulo){
        //TODO
    }
    List<Articulo> mostrarArticulos(){
        List<Articulo> articulos = new ArrayList<Articulo>();
        //TODO
        return articulos;
    }
    private Boolean esCancelable(Pedido pedido){
        Boolean cancelable = false;
        //TODO Nota- si es cancelable, es que no está enviado
        return cancelable;
    }
    private Boolean estaEnviado(Pedido pedido){
        return !esCancelable(pedido);
    }
    private Boolean hayArticulo(Articulo articulo){
        Boolean existeArticulo = false;
        //TODO
        return existeArticulo;
    }
}

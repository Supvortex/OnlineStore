package HelloWorld.Controlador;

import HelloWorld.Modelo.Articulo;
import HelloWorld.Modelo.Cliente;
import HelloWorld.Modelo.Pedido;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Controller {

    //VARIABLES

    List<Cliente> clientes ;
    List<Articulo> articulos;
    List<Pedido> pedidos;

    //CONSTRUCTOR

    public Controller(){
        this.clientes = new ArrayList<>();
        this.articulos = new ArrayList<>();
        this.pedidos = new ArrayList<>();

}


//METODOS


    void añadirPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }


    void cancelarPedido(Pedido numPedido){
        if (esCancelable(numPedido) == true) {
            this.pedidos.remove(numPedido);
        }
    }


    List<Pedido> mostrarPedidosPendientes(String cliente){

        List<Pedido> pedidosPendientes = new ArrayList<>();
        for (Pedido p: this.pedidos) {
            if(p.getCliente().getEmail() == cliente){
                if (Duration.between(p.getFechaHora().toLocalDate(), LocalDateTime.now().toLocalDate()).getSeconds() < (p.getArticulo().getTiempoEnvio() * 60)) {
                   pedidosPendientes.add(p);
                }
            }
        }
        return  pedidosPendientes;
    }


    List<Pedido> mostrarPedidosEnviados(String cliente){

        List<Pedido> pedidosEnviados = new ArrayList<>();
        for (Pedido p: this.pedidos) {
            if(p.getCliente().getEmail() == cliente){
                if (estaEnviado(p) ){
                    pedidosEnviados.add(p);
                }
            }
        }
        return  pedidosEnviados;
    }


    void añadirCliente(Cliente cliente){
        this.clientes.add(cliente);
    }


    List<Cliente> mostrarClientes(){
        return this.clientes;
    }


    List<Cliente> mostrarClientesEstandard(){
        List<Cliente> cEstandard = new ArrayList<>();
        for(Cliente c : this.clientes) {
           if( c.getPrem() == false ){
               cEstandard.add(c);
           }
        }
        return cEstandard;
    }


    List<Cliente> mostrarClientesPremium(){
        List<Cliente> cPremium = new ArrayList<>();
        for(Cliente c : this.clientes){
            if(c.getPrem() == true){
                cPremium.add(c);
            }
        }
        return cPremium;
    }


    void añadirArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }

    List<Articulo> mostrarArticulos(){
        return this.articulos;
    }


    private Boolean esCancelable(Pedido pedido) {
        if (Duration.between(pedido.getFechaHora().toLocalDate(), LocalDateTime.now().toLocalDate()).getSeconds() > (pedido.getArticulo().getTiempoEnvio() * 60)) {
            return false;
        } else {
            return true;
        }
    }


    private Boolean estaEnviado(Pedido pedido) {
        return !esCancelable(pedido);
    }

}
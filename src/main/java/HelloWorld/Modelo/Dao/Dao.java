package HelloWorld.Modelo.Dao;
import HelloWorld.Modelo.*;

import java.time.Duration;
import java.time.LocalDateTime;
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

    public void anadirPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void cancelarPedido(Pedido pedido) {
        if (esCancelable(pedido) == true) {
            this.pedidos.remove(pedido);
        }
    }

    public Pedido getPedidoConNumPedido(String numPedido){
        for (Pedido myPedido : this.pedidos) {
            if (myPedido.getNumPedido().equals(numPedido)) {
                return myPedido;
            }
        }
        return null;
    }

    public List<Pedido> mostrarPedidos() {
        return this.pedidos;
    }
    public List<Pedido> mostrarPedidosEnviados(String cliente) {
        List<Pedido> pedidosEnviados = new ArrayList<Pedido>();
        for (Pedido myPedido : this.pedidos) {
            if (!esCancelable(myPedido) && myPedido.getCliente().getEmail().equals(cliente)) {
                pedidosEnviados.add(myPedido);
            }
        }
        return pedidosEnviados;
    }
    public List<Pedido> mostrarPedidosPendientes(String cliente) {
        List<Pedido> pedidosPendientes = new ArrayList<Pedido>();
        for (Pedido myPedido : this.pedidos) {
            if (esCancelable(myPedido) && myPedido.getCliente().getEmail().equals(cliente)) {
                pedidosPendientes.add(myPedido);
            }
        }
        return pedidosPendientes;
    }

    public void anadirCliente(Cliente cliente) {
        if (!clienteExiste(cliente)) {
            this.clientes.add(cliente);
        }
    }
    public Boolean clienteExiste(Cliente cliente) {
        for (Cliente myCliente : this.clientes) {
            if (cliente.getEmail().equals(myCliente.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public List<Cliente> mostrarClientes() {
        return this.clientes;
    }

    public List<Cliente> mostrarClientesPrem() {
        List<Cliente> clientesPrem = new ArrayList<Cliente>();
        for (Cliente myCliente : this.clientes) {
            if (myCliente instanceof ClientePremium) {
                //((ClientePremium) myCliente).descuentoEnv(); clase hija al castear la clase padre para acceder a los datos de la clase heredada "ClienteXXX".
                clientesPrem.add(myCliente);
            }
        }
        return clientesPrem;
    }
    public List<Cliente> mostrarClientesEstandar() {
        List<Cliente> clientesEstandar = new ArrayList<Cliente>();
        for (Cliente myCliente : this.clientes) {
            if (myCliente instanceof ClienteEstandar) {
                clientesEstandar.add(myCliente);
            }
        }
        return clientesEstandar;
    }

    public void anadirArticulo(Articulo articulo) {
        if (!hayArticulo(articulo)) {
            this.articulos.add(articulo);
        }
    }

    public List<Articulo> mostrarArticulos() {
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

    private Boolean hayArticulo(Articulo articulo) {
        for (Articulo myArticulo : this.articulos) {
            if (articulo.getCodigo().equals(myArticulo.getCodigo())) {
                return true;
            }
        }
        return false;
    }
}

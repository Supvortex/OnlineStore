package HelloWorld.Modelo.Dao;
import HelloWorld.Modelo.Articulo;
import HelloWorld.Modelo.Cliente;
import HelloWorld.Modelo.Pedido;
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

    void anadirPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    void cancelarPedido(Pedido pedido) {
        if (esCancelable(pedido) == true) {
            this.pedidos.remove(pedido);
        }
    }

    List<Pedido> mostrarPedidos() {
        return this.pedidos;
    }

    void anadirCliente(Cliente cliente) {
        if (!clienteExiste(cliente)) {
            this.clientes.add(cliente);
        }
    }

    Boolean clienteExiste(Cliente cliente) {
        for (Cliente myCliente : this.clientes) {
            if (cliente.getEmail().equals(myCliente.getEmail())) {
                return true;
            }
        }
        return false;
    }

    List<Cliente> mostrarClientes() {
        return this.clientes;
    }

    List<Cliente> mostrarClientesPrem() {
        List<Cliente> clientesPrem = new ArrayList<Cliente>();
        for (Cliente myCliente : this.clientes) {
            if (myCliente.getPrem()) {
                clientesPrem.add(myCliente);
            }
        }
        return clientesPrem;
    }

    void anadirArticulo(Articulo articulo) {
        if (!hayArticulo(articulo)) {
            this.articulos.add(articulo);
        }
    }

    List<Articulo> mostrarArticulos() {
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

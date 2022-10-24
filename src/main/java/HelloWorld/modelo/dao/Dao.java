package HelloWorld.modelo.dao;
import HelloWorld.modelo.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao{

    private List<Pedido> pedidos;
    private List<Cliente> clientes;
    private List<Articulo> articulos;

    public Dao() {
        this.pedidos = new ArrayList<Pedido>();
        this.clientes = new ArrayList<Cliente>();
        this.articulos = new ArrayList<Articulo>();
    }

    public Boolean anadirPedido(Pedido pedido) {
        if (pedidoExiste(pedido) == false) {
            this.pedidos.add(pedido);
            return true;
        }
        return false;
    }

    public Boolean pedidoExiste(Pedido pedidoParam) {
        for (Pedido pedidoActual : this.pedidos) {
            if (pedidoActual.getNumPedido().equals(pedidoParam.getNumPedido())) {
                return true;
            }
        }
        return false;
    }

    public Boolean cancelarPedido(Pedido pedido) {
        if (esCancelable(pedido) == true) {
            this.pedidos.remove(pedido);
            return true;
        }
        return false;
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

    public Boolean anadirCliente(Cliente cliente) {
        if (!clienteExiste(cliente)) {
            this.clientes.add(cliente);
            return true;
        }
        return false;
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

    public Boolean anadirArticulo(Articulo articulo) {
        if (!hayArticulo(articulo)) {
            this.articulos.add(articulo);
            return true;
        }
        return false;
    }

    public List<Articulo> mostrarArticulos() {
        return this.articulos;
    }

    private Boolean esCancelable(Pedido pedidoParam) {
     return !pedidoParam.pedidoEnviado();
    }

    private Boolean estaEnviado(Pedido pedidoParam) {
        return pedidoParam.pedidoEnviado();
    }

    private Boolean hayArticulo(Articulo articulo) {
        for (Articulo myArticulo : this.articulos) {
            if (articulo.getCodigo().equals(myArticulo.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public Cliente getClienteWithID(String emailParam) {
        for (Cliente myCliente : this.clientes) {
            if (myCliente.getEmail().equals(emailParam)) {
                return myCliente;
            }
        }
        return null;
    }

    public Articulo getArticuloWithCode(String codeParam) {
        for (Articulo myArticulo : this.articulos) {
            if (myArticulo.getCodigo().equals(codeParam)) {
                return myArticulo;
            }
        }
        return null;
    }

    public Pedido getPedidoWithNumPedido(String numPedidoParam) {
        for (Pedido myPedido : this.pedidos) {
            if (myPedido.getNumPedido().equals(numPedidoParam)) {
                return myPedido;
            }
        }
        return null;
    }
}

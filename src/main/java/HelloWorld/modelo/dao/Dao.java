package HelloWorld.modelo.dao;
import HelloWorld.modelo.*;

public class Dao implements IDao{
    private Lista<Pedido> pedidos;
    private Lista<Cliente> clientes;
    private Lista<Articulo> articulos;
    public Dao() {
        this.pedidos = new Lista<Pedido>();
        this.clientes = new Lista<Cliente>();
        this.articulos = new Lista<Articulo>();
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
    public Lista<Pedido> mostrarPedidos() {
        return this.pedidos;
    }
    public Lista<Pedido> mostrarPedidosEnviados(String cliente) {
        Lista<Pedido> pedidosEnviados = new Lista<Pedido>();
        for (Pedido myPedido : this.pedidos) {
            if (!esCancelable(myPedido) && myPedido.getCliente().getEmail().equals(cliente)) {
                pedidosEnviados.add(myPedido);
            }
        }
        return pedidosEnviados;
    }
    public Lista<Pedido> mostrarPedidosPendientes(String cliente) {
        Lista<Pedido> pedidosPendientes = new Lista<Pedido>();
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
    public Lista<Cliente> mostrarClientes() {
        return this.clientes;
    }
    public Lista<Cliente> mostrarClientesPrem() {
        Lista<Cliente> clientesPrem = new Lista<Cliente>();
        for (Cliente myCliente : this.clientes) {
            if (myCliente instanceof ClientePremium) {
                clientesPrem.add(myCliente);
            }
        }
        return clientesPrem;
    }
    public Lista<Cliente> mostrarClientesEstandar() {
        Lista<Cliente> clientesEstandar = new Lista<Cliente>();
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
    public Lista<Articulo> mostrarArticulos() {
        return this.articulos;
    }
    private Boolean esCancelable(Pedido pedidoParam) {
     return !pedidoParam.pedidoEnviado();
    }
    public Boolean estaEnviado(Pedido pedidoParam) {
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

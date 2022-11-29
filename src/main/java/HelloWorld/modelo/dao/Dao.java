package HelloWorld.modelo.dao;
import HelloWorld.modelo.*;
import java.sql.SQLException;

public class Dao implements IDao {
    private Conexion conexion;

    public Dao() {
        conexion = new Conexion();
    }

    public Boolean restartDatabase() throws SQLException {
        return conexion.restartDatabase();
    }

    public Boolean anadirPedido(Pedido pedido) throws SQLException {
        return conexion.anadirPedido(pedido);
    }

    public Boolean pedidoExiste(Pedido pedidoParam) throws SQLException {
        if (conexion.obtenerPedidosConId(pedidoParam.getNumPedido()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean cancelarPedido(Pedido pedido) {
        if (esCancelable(pedido) == true) {
            conexion.cancelarPedido(pedido);
            return true;
        }
        return false;
    }

    public Pedido getPedidoConNumPedido(String numPedido) throws SQLException {
        return conexion.obtenerPedidosConId(numPedido);
    }

    public Lista<Pedido> mostrarPedidos() throws SQLException {
        return conexion.obtenerPedidos();
    }

    public Lista<Pedido> mostrarPedidosEnviados(String cliente) throws SQLException {
        Lista<Pedido> pedidosEnviados = new Lista<Pedido>();
        for (Pedido myPedido : conexion.obtenerPedidoConCliente(cliente)) {
            if (!esCancelable(myPedido)) {
                pedidosEnviados.add(myPedido);
            }
        }
        return pedidosEnviados;
    }

    public Lista<Pedido> mostrarPedidosPendientes(String cliente) throws SQLException {
        Lista<Pedido> pedidosPendientes = new Lista<Pedido>();
        Lista<Pedido> pedidos = conexion.obtenerPedidoConCliente(cliente);
        for (Pedido myPedido : conexion.obtenerPedidoConCliente(cliente)) {
            if (esCancelable(myPedido)) {
                pedidosPendientes.add(myPedido);
            }
        }
        return pedidosPendientes;
    }

    public Boolean anadirCliente(Cliente cliente) throws SQLException {
        if (cliente instanceof ClienteEstandar) {
            return conexion.addClienteEstandar((ClienteEstandar) cliente);
        } else {
            return conexion.addClientePremium((ClientePremium) cliente);
        }
    }

    public Boolean clienteExiste(Cliente cliente) throws SQLException {
        if (conexion.obtenerClienteEmail(cliente.getEmail()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Lista<Cliente> mostrarClientes() throws SQLException {
        Lista<Cliente> clientes = new Lista<Cliente>();
        clientes.addAll(conexion.obtenerClientesEstandar());
        clientes.addAll(conexion.obtenerClientesPremium());
        return clientes;
    }

    public Lista<Cliente> mostrarClientesPrem() throws SQLException {
        return conexion.obtenerClientesPremium();
    }

    public Lista<Cliente> mostrarClientesEstandar() throws SQLException {
        return conexion.obtenerClientesEstandar();
    }

    public Boolean anadirArticulo(Articulo articulo) throws SQLException {
        return conexion.anadirArticulo(articulo);
    }

    public Lista<Articulo> mostrarArticulos() throws SQLException {
        return conexion.obtenerArticulo();
    }

    private Boolean esCancelable(Pedido pedidoParam) {
        return !pedidoParam.pedidoEnviado();
    }

    public Boolean estaEnviado(Pedido pedidoParam) {
        return pedidoParam.pedidoEnviado();
    }

    private Boolean hayArticulo(Articulo articulo) throws SQLException {
        if (conexion.obtenerArticuloConCod(articulo.getCodigo()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Cliente getClienteWithID(String emailParam) throws SQLException {
        return conexion.obtenerClienteEmail(emailParam);
    }

    public Articulo getArticuloWithCode(String codeParam) throws SQLException {
        return conexion.obtenerArticuloConCod(codeParam);
    }

    public Pedido getPedidoWithNumPedido(String numPedidoParam) throws SQLException {
        return conexion.obtenerPedidosConId(numPedidoParam);
    }
}

package HelloWorld.modelo.dao;
import HelloWorld.modelo.*;
import org.hibernate.SessionFactory;

import java.sql.SQLException;

public class Dao implements IDao {
    private IConexion conexion;

    private ArticuloDao articuloDao;
    private PedidoDao pedidoDao;
    private ClienteDao clienteDao;
    private ClienteEstandarDao clienteEstandarDao;
    private ClientePremiumDao clientePremiumDao;

    public Dao() {
        conexion = new Conexion();
        this.articuloDao = new ArticuloDao();
        this.pedidoDao = new PedidoDao();
        this.clienteDao = new ClienteDao();
        this.clienteEstandarDao = new ClienteEstandarDao();
        this.clientePremiumDao = new ClientePremiumDao();
    }

    public Boolean restartDatabase() throws SQLException {
        return conexion.restartDatabase();
    }

    public Boolean anadirPedido(Pedido pedido) throws SQLException {
        try{
            pedidoDao.create(pedido);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    public Boolean pedidoExiste(Pedido pedidoParam) throws SQLException {
        if (pedidoDao.find(pedidoParam.getNumPedido()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean cancelarPedido(Pedido pedido) {
        if (esCancelable(pedido) == true) {
            pedidoDao.remove(pedido);
            return true;
        }
        return false;
    }

    public Pedido getPedidoConNumPedido(String numPedido) throws SQLException {
        return pedidoDao.findbyid(numPedido);
    }

    public Lista<Pedido> mostrarPedidos() throws SQLException {
        return pedidoDao.findAll();
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
        for (Pedido myPedido : conexion.obtenerPedidoConCliente(cliente)) {
            if (esCancelable(myPedido)) {
                pedidosPendientes.add(myPedido);
            }
        }
        return pedidosPendientes;
    }

    public Boolean anadirCliente(Cliente cliente) throws SQLException {
        try {
            this.clienteDao.create(cliente);
            return true;
        } catch (Exception ex){
            return false;
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
            clientes.addAll(this.clienteDao.findAll());
            return clientes;
    }

    public Lista<Cliente> mostrarClientesPrem() throws SQLException {

        Lista<Cliente> clientesPrem = new Lista<Cliente>();
        clientesPrem.addAll(this.clientePremiumDao.findAll2());
        return clientesPrem;
    }

    public Lista<Cliente> mostrarClientesEstandar() throws SQLException {
        Lista<Cliente> clientesEst = new Lista<Cliente>();
        clientesEst.addAll(this.clienteEstandarDao.findAll2());
        return clientesEst;
    }

    public Boolean anadirArticulo(Articulo articulo) throws SQLException {
        try {
            articuloDao.create(articulo);
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    public Lista<Articulo> mostrarArticulos() throws SQLException {

        Lista<Articulo> articuloLista = new Lista<>();
        articuloLista.addAll(this.articuloDao.findAll());
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
        return this.pedidoDao.findbyid(numPedidoParam);
    }
}

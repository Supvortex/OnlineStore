package HelloWorld.modelo.dao;

import HelloWorld.modelo.*;

import java.sql.SQLException;

public interface IConexion {

    boolean restartDatabase() throws SQLException;

    Lista<Cliente> obtenerClientesEstandar()throws SQLException;

    Lista<Cliente> obtenerClientesPremium() throws SQLException;

    boolean addClienteEstandar(ClienteEstandar clienteEstandar) throws SQLException;

    boolean addClientePremium(ClientePremium clientePremium) throws SQLException;

    Cliente obtenerClienteEmail(String clienteEmail) throws SQLException;

    boolean anadirArticulo(Articulo articulo) throws SQLException;

    Lista<Articulo> obtenerArticulo() throws SQLException;

    Articulo obtenerArticuloConCod(String codArticulo) throws SQLException;

    boolean pedidoExiste(Pedido pedido) throws SQLException;

    boolean cancelarPedido(Pedido pedido);

    boolean anadirPedido(Pedido pedido) throws SQLException;

    Lista<Pedido> obtenerPedidos() throws SQLException;

    Pedido obtenerPedidosConId(String numPedido) throws SQLException;

    Lista<Pedido> obtenerPedidoConCliente(String clienteemail) throws SQLException;

    void cerrarConexion() throws SQLException;

}

package modelo;

import HelloWorld.modelo.*;
import HelloWorld.modelo.dao.Dao;
import HelloWorld.modelo.dao.IDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;


public class TestDao {

    private static Cliente cliente;
    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Cliente cliente3;
    private static Cliente cliente4;
    private static Articulo articulo;
    private static Articulo articulo1;
    private static Articulo articulo2;
    private static Articulo articulo3;
    private static IDao dao;
    private static Pedido pedido1;
    private static Pedido pedido2;

    private static final String N_NAME = "JoseLopez";
    private static final String N_PEDIDO = "12234";
    private static final String N2_PEDIDO = "1255";
    private static final String A_DESCRIPCION = "caja azul";
    private static final Integer P_CANTIDAD = 2;

    @BeforeAll
    static void init(){
        dao = new Dao();
        cliente = new ClienteEstandar("JLLB@gmail.com", N_NAME, "C/Pelusa", "44455566N");
        cliente1 = new ClientePremium("CC@gmail.com", "Carlos", "C/Casa", "5554442V");
        cliente2 = new ClientePremium("PP@gmail.com", "Pedro", "C/cabra", "5421242Z");
        cliente3 = new ClientePremium("Guapisimo@gmail.com", "Luis", "C/cabraloca", "5421242Z");
        cliente4 = new ClienteEstandar("jonnhy@gmail.com", "Jonny", "C/cabriola", "5421242Z");
        articulo = new Articulo("02154", A_DESCRIPCION, 25.5f, 7.5f, 50);
        articulo1 = new Articulo("32345", "caja rosa", 24.5f, 7.5f, 60);
        articulo2 = new Articulo("013", "espejo", 40f, 15f, 50);
        articulo3 = new Articulo("010", "tenedor", 4.5f, 40f, 60);
        pedido1 = new Pedido(N_PEDIDO, cliente2 ,  articulo3,  P_CANTIDAD , LocalDateTime.now());
        pedido2 = new Pedido(N2_PEDIDO, cliente2 ,  articulo2,  1 , LocalDateTime.now().minusMinutes(55));
    }
    @BeforeEach
    public void restart() throws SQLException {
        this.dao.restartDatabase();
    }
    @Test
    void whenAddClientThenClientAdded() throws SQLException {
        this.dao.anadirCliente(this.cliente3);
        Assertions.assertTrue(this.dao.mostrarClientes().size() == 5);
        Assertions.assertTrue(this.dao.getClienteWithID(this.cliente3.getEmail()).getNombre().equals("Luis"));
        this.dao.mostrarClientes().clear();
    }
    @Test
    void whenAddSameClientTwiceThenOnlyOneIsAdded() throws SQLException {
        this.dao.anadirCliente(this.cliente3);
        this.dao.anadirCliente(this.cliente3);
        Assertions.assertTrue(this.dao.mostrarClientes().size() == 5);
        this.dao.mostrarClientes().clear();
    }

    @Test
    void whenAddPremiumAndEstandarClientsThenShowPremClientsReturnsTwo() throws SQLException {
        this.dao.anadirCliente(this.cliente3);
        this.dao.anadirCliente(this.cliente4);
        Assertions.assertTrue(this.dao.mostrarClientesPrem().size() == 3);
        this.dao.mostrarClientes().clear();
    }

    @Test
    void whenAddPremiumAndEstandarClientsThenShowEstandarClientsReturnsOne() throws SQLException {
        this.dao.anadirCliente(this.cliente3);
        this.dao.anadirCliente(this.cliente4);
        Assertions.assertTrue(this.dao.mostrarClientesEstandar().size() == 3);
        this.dao.mostrarClientes().clear();
    }
    @Test
    void whenAddArticlesThenRecoverTwoArticles() throws SQLException {
        this.dao.anadirArticulo(this.articulo);
        this.dao.anadirArticulo(this.articulo1);
        Assertions.assertTrue(this.dao.mostrarArticulos().size() == 8);
        this.dao.mostrarArticulos().clear();
    }
    @Test
    void whenAddArticleTwiceThenOnlyOneAdded() throws SQLException {
        this.dao.anadirArticulo(this.articulo);
        this.dao.anadirArticulo(this.articulo);
        Assertions.assertTrue(this.dao.mostrarArticulos().size() == 7);
        this.dao.mostrarArticulos().clear();
    }

    @Test
    void whenGetPedidoThenItGetsCorrectPedido() throws SQLException {
        this.dao.anadirPedido(this.pedido1);
        this.dao.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.dao.mostrarPedidos().size() == 5);
        Assertions.assertTrue(this.dao.getPedidoConNumPedido(N_PEDIDO).getNumPedido().equals(N_PEDIDO));
        this.dao.mostrarPedidos().clear();
    }
    @Test
    void whenPedidoIdIsWrongOrNonCancelableThenGetNullOrFalse() throws SQLException {
        Assertions.assertNull(this.dao.getPedidoConNumPedido(N_PEDIDO));
        Assertions.assertFalse(this.dao.cancelarPedido(pedido2));
        Assertions.assertTrue(this.dao.estaEnviado(pedido2));
    }

    @Test
    void whenAddPedidoThenIsCancelable() throws SQLException {
        this.dao.anadirPedido(this.pedido1);
        this.dao.anadirPedido(this.pedido2);
        this.dao.cancelarPedido(this.pedido1);
        Assertions.assertTrue(this.dao.mostrarPedidos().size() == 5);
        Assertions.assertTrue(this.dao.getPedidoConNumPedido(N2_PEDIDO).getNumPedido().equals(N2_PEDIDO));
        this.dao.mostrarPedidos().clear();
    }
    @Test
    void whenAddPedidoThenIsPending() throws SQLException {
        this.dao.anadirPedido(this.pedido1);
        this.dao.anadirPedido(this.pedido2);
        Assertions.assertTrue(this.dao.mostrarPedidosPendientes(this.cliente2.getEmail()).size() == 1);
        Assertions.assertTrue(this.dao.mostrarPedidosEnviados(this.cliente2.getEmail()).size() == 1);
        this.dao.mostrarPedidos().clear();
    }
    @Test
    void whenGetNombreClienteThenGetCorrectCliente() throws SQLException {
        this.dao.anadirCliente(this.cliente);
        Assertions.assertTrue(this.dao.getClienteWithID(cliente.getEmail()).getNombre().equals(N_NAME));
        Assertions.assertNull(this.dao.getClienteWithID(cliente3.getEmail()));
        this.dao.mostrarClientes().clear();
    }
    @Test
    void whenGetArticleCodeThenGetCorrectArticle() throws SQLException {
        this.dao.anadirArticulo(this.articulo);
        Assertions.assertTrue(this.dao.getArticuloWithCode(articulo.getCodigo()).getDescripcion().equals(A_DESCRIPCION));
        Assertions.assertNull(this.dao.getArticuloWithCode(articulo1.getCodigo()));
        this.dao.mostrarArticulos().clear();
    }
    @Test
    void whenGetNumPedidoThenGetCorrectPedido() throws SQLException {
        this.dao.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.dao.getPedidoWithNumPedido(pedido1.getNumPedido()).getCantidad().equals(P_CANTIDAD));
        Assertions.assertNull(this.dao.getPedidoWithNumPedido(pedido2.getNumPedido()));
        this.dao.mostrarPedidos().clear();
    }
}
package modelo;

import HelloWorld.modelo.*;
import HelloWorld.modelo.dao.Dao;
import HelloWorld.modelo.dao.IDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;


public class TestDao {

    private static Cliente cliente;
    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Articulo articulo;
    private static Articulo articulo1;
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
        articulo = new Articulo("02154", A_DESCRIPCION, 25.5f, 7.5f, 50);
        articulo1 = new Articulo("32345", "caja rosa", 24.5f, 7.5f, 60);
        pedido1 = new Pedido(N_PEDIDO, cliente ,  articulo,  P_CANTIDAD , LocalDateTime.now());
        pedido2 = new Pedido(N2_PEDIDO, cliente ,  articulo,  1 , LocalDateTime.now().minusMinutes(51));
    }
    @Test
    void whenAddClientThenClientAdded() {
        this.dao.anadirCliente(this.cliente);
        Assertions.assertTrue(this.dao.mostrarClientes().size() > 0);
        Assertions.assertTrue(this.dao.mostrarClientes().get(0).getNombre().equals(N_NAME));
        this.dao.mostrarClientes().clear();
    }
    @Test
    void whenAddSameClientTwiceThenOnlyOneIsAdded() {
        this.dao.anadirCliente(this.cliente);
        this.dao.anadirCliente(this.cliente);
        Assertions.assertTrue(this.dao.mostrarClientes().size() == 1);
        this.dao.mostrarClientes().clear();
    }

    @Test
    void whenAddPremiumAndEstandarClientsThenShowPremClientsReturnsTwo() {
        this.dao.anadirCliente(this.cliente1);
        this.dao.anadirCliente(this.cliente2);
        this.dao.anadirCliente(this.cliente);
        Assertions.assertTrue(this.dao.mostrarClientesPrem().size() == 2);
        this.dao.mostrarClientes().clear();
    }

    @Test
    void whenAddPremiumAndEstandarClientsThenShowEstandarClientsReturnsOne() {
        this.dao.anadirCliente(this.cliente1);
        this.dao.anadirCliente(this.cliente2);
        this.dao.anadirCliente(this.cliente);
        Assertions.assertTrue(this.dao.mostrarClientesEstandar().size() == 1);
        this.dao.mostrarClientes().clear();
    }
    @Test
    void whenAddArticlesThenRecoverTwoArticles() {
        this.dao.anadirArticulo(this.articulo);
        this.dao.anadirArticulo(this.articulo1);
        Assertions.assertTrue(this.dao.mostrarArticulos().size() == 2);
        this.dao.mostrarArticulos().clear();
    }
    @Test
    void whenAddArticleTwiceThenOnlyOneAdded() {
        this.dao.anadirArticulo(this.articulo);
        this.dao.anadirArticulo(this.articulo);
        Assertions.assertTrue(this.dao.mostrarArticulos().size() == 1);
        this.dao.mostrarArticulos().clear();
    }

    @Test
    void whenGetPedidoThenItGetsCorrectPedido() {
        this.dao.anadirPedido(this.pedido1);
        this.dao.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.dao.mostrarPedidos().size() == 1);
        Assertions.assertTrue(this.dao.getPedidoConNumPedido(N_PEDIDO).getNumPedido().equals(N_PEDIDO));
        this.dao.mostrarPedidos().clear();
    }
    @Test
    void whenPedidoIdIsWrongOrNonCancelableThenGetNullOrFalse() {
        Assertions.assertNull(this.dao.getPedidoConNumPedido(N_PEDIDO));
        Assertions.assertFalse(this.dao.cancelarPedido(pedido2));
        Assertions.assertTrue(this.dao.estaEnviado(pedido2));
    }

    @Test
    void whenAddPedidoThenIsCancelable() {
        this.dao.anadirPedido(this.pedido1);
        this.dao.anadirPedido(this.pedido2);
        this.dao.cancelarPedido(this.pedido1);
        Assertions.assertTrue(this.dao.mostrarPedidos().size() == 1);
        Assertions.assertTrue(this.dao.getPedidoConNumPedido(N2_PEDIDO).getNumPedido().equals(N2_PEDIDO));
        this.dao.mostrarPedidos().clear();
    }
    @Test
    void whenAddPedidoThenIsPending() {
        this.dao.anadirPedido(this.pedido1);
        this.dao.anadirPedido(this.pedido2);
        Assertions.assertTrue(this.dao.mostrarPedidosPendientes(this.cliente.getEmail()).size() == 1);
        Assertions.assertTrue(this.dao.mostrarPedidosEnviados(this.cliente.getEmail()).size() == 1);
        this.dao.mostrarPedidos().clear();
    }
    @Test
    void whenGetNombreClienteThenGetCorrectCliente() {
        this.dao.anadirCliente(this.cliente);
        Assertions.assertTrue(this.dao.getClienteWithID(cliente.getEmail()).getNombre().equals(N_NAME));
        Assertions.assertNull(this.dao.getClienteWithID(cliente2.getEmail()));
        this.dao.mostrarClientes().clear();
    }
    @Test
    void whenGetArticleCodeThenGetCorrectArticle() {
        this.dao.anadirArticulo(this.articulo);
        Assertions.assertTrue(this.dao.getArticuloWithCode(articulo.getCodigo()).getDescripcion().equals(A_DESCRIPCION));
        Assertions.assertNull(this.dao.getArticuloWithCode(articulo1.getCodigo()));
        this.dao.mostrarArticulos().clear();
    }
    @Test
    void whenGetNumPedidoThenGetCorrectPedido() {
        this.dao.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.dao.getPedidoWithNumPedido(pedido1.getNumPedido()).getCantidad().equals(P_CANTIDAD));
        Assertions.assertNull(this.dao.getPedidoWithNumPedido(pedido2.getNumPedido()));
        this.dao.mostrarPedidos().clear();
    }
}
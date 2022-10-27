package modelo;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TestController {
    private static IController controller;
    private static Cliente cliente;
    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Articulo articulo;
    private static Articulo articulo1;
    private static Pedido pedido1;
    private static Pedido pedido2;
    private static final String N_NAME = "JoseLopez";
    private static final String N_PEDIDO = "12234";
    private static final String N2_PEDIDO = "1255";
    private static final String A_DESCRIPCION = "caja azul";
    private static final Integer P_CANTIDAD = 2;

    @BeforeAll
    static void init(){
        controller = new Controller();
        cliente = new ClienteEstandar("JLLB@gmail.com", N_NAME, "C/Pelusa", "44455566N");
        cliente1 = new ClientePremium("CC@gmail.com", "Carlos", "C/Casa", "5554442V");
        cliente2 = new ClientePremium("PP@gmail.com", "Pedro", "C/cabra", "5421242Z");
        articulo = new Articulo("02154", A_DESCRIPCION, 25.5f, 7.5f, 50);
        articulo1 = new Articulo("32345", "caja rosa", 24.5f, 7.5f, 60);
        pedido1 = new Pedido(N_PEDIDO, cliente ,  articulo,  P_CANTIDAD , LocalDateTime.now());
        pedido2 = new Pedido(N2_PEDIDO, cliente ,  articulo,  1 , LocalDateTime.now().minusMinutes(51));
    }

    @Test
    void whenGetPedidoThenItGetsCorrectPedido() {
        this.controller.anadirPedido(this.pedido1);
        this.controller.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.controller.mostrarPedidos().size() == 1);
        Assertions.assertTrue(this.controller.getPedidoWithNumPedido(N_PEDIDO).getNumPedido().equals(N_PEDIDO));
        this.controller.mostrarPedidos().clear();
    }
    @Test
    void WhenCancelPedidoThenIsTrue() {
        this.controller.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.controller.cancelarPedido(N_PEDIDO));
        this.controller.mostrarPedidos().clear();
    }
    @Test
    void whenAddPedidoThenIsPending() {
        this.controller.anadirPedido(this.pedido1);
        this.controller.anadirPedido(this.pedido2);
        Assertions.assertTrue(this.controller.mostrarPedidosPendientes(this.cliente.getEmail()).size() == 1);
        Assertions.assertTrue(this.controller.mostrarPedidosEnviados(this.cliente.getEmail()).size() == 1);
        this.controller.mostrarPedidos().clear();
    }
    @Test
    void whenAddPremiumAndEstandarClientsThenShowEstandarClientsReturnsOne() {
        this.controller.anadirCliente(this.cliente1);
        this.controller.anadirCliente(this.cliente2);
        this.controller.anadirCliente(this.cliente);
        Assertions.assertTrue(this.controller.mostrarClientesEstandard().size() == 1);
        Assertions.assertTrue(this.controller.mostrarClientesPremium().size() == 2);
        this.controller.mostrarClientes().clear();
    }
    @Test
    void whenAddArticlesThenRecoverTwoArticles() {
        this.controller.anadirArticulo(this.articulo);
        this.controller.anadirArticulo(this.articulo1);
        Assertions.assertTrue(this.controller.mostrarArticulos().size() == 2);
        this.controller.mostrarArticulos().clear();
    }
    @Test
    void whenGetNombreClienteThenGetCorrectCliente() {
        this.controller.anadirCliente(this.cliente);
        Assertions.assertTrue(this.controller.getClienteWithID(cliente.getEmail()).getNombre().equals(N_NAME));
        Assertions.assertNull(this.controller.getClienteWithID(cliente2.getEmail()));
        this.controller.mostrarClientes().clear();
    }
    @Test
    void whenGetArticleCodeThenGetCorrectArticle() {
        this.controller.anadirArticulo(this.articulo);
        Assertions.assertTrue(this.controller.getArticuloWithCode(articulo.getCodigo()).getDescripcion().equals(A_DESCRIPCION));
        Assertions.assertNull(this.controller.getArticuloWithCode(articulo1.getCodigo()));
        this.controller.mostrarArticulos().clear();
    }
}

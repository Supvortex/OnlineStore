package modelo;

import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TestController {
    private static IController controller;
    private static Cliente cliente;
    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Cliente cliente3;
    private static Articulo articulo;
    private static Articulo articulo1;
    private static Articulo articulo2;
    private static Articulo articulo3;
    private static Pedido pedido1;
    private static Pedido pedido2;
    private static Pedido pedido3;
    private static final String N_NAME = "Agustin Stoy";
    private static final String N_PEDIDO = "12234";
    private static final String N2_PEDIDO = "1255";
    private static final String A_DESCRIPCION = "tenedor";
    private static final Integer P_CANTIDAD = 2;

    @BeforeAll
    static void init(){
        controller = new Controller();
        cliente = new ClienteEstandar("Augustinstoy@uoc.edu", "Agustin Stoy", "Calle chaon lamaca", "776544144");
        cliente1 = new ClientePremium("Armandoguerra@uoc.edu", "Armando Guerra", "Calle conflicto", "477614544");
        cliente2 = new ClientePremium("PP@gmail.com", "Pedro", "C/cabra", "5421242Z");
        cliente3= new ClienteEstandar("Guaperas@gmail.com", "Jaime", "C/cabra", "5421242Z");
        articulo = new Articulo("010", A_DESCRIPCION, 4.5f, 4f, 60);
        articulo1 = new Articulo("013", "espejo", 40f, 15f, 60);
        articulo2 = new Articulo("055", "peine", 4.5f, 4f, 60);
        articulo3 = new Articulo("02", "Guante", 40f, 15f, 60);
        pedido1 = new Pedido(N_PEDIDO, cliente ,  articulo,  P_CANTIDAD , LocalDateTime.now());
        pedido2 = new Pedido(N2_PEDIDO, cliente ,  articulo,  1 , LocalDateTime.now().minusMinutes(51));
        pedido3 = new Pedido("250", cliente1,  articulo1, 5, LocalDateTime.now());
    }

    @BeforeEach
    public void restart() throws SQLException {
        this.controller.restartDatabase();
    }

    @Test
    void whenGetPedidoThenItGetsCorrectPedido() throws SQLException {
        this.controller.anadirPedido(this.pedido3);
        Assertions.assertTrue(this.controller.mostrarPedidos().size() == 5);
        Assertions.assertTrue(this.controller.getPedidoWithNumPedido("250").getNumPedido().equals("250"));
        this.controller.mostrarPedidos().clear();
    }
    /*@Test
    void WhenCancelPedidoThenIsTrue() throws SQLException {
        this.controller.anadirPedido(this.pedido1);
        Assertions.assertTrue(this.controller.cancelarPedido(N_PEDIDO));
        this.controller.mostrarPedidos().clear();
    }*/
    @Test
    void whenAddPedidoThenIsPending() throws SQLException {
        this.controller.anadirPedido(this.pedido3);
        Assertions.assertTrue(this.controller.mostrarPedidosPendientes(this.cliente1.getEmail()).size() == 1);
        Assertions.assertTrue(this.controller.mostrarPedidosEnviados(this.cliente1.getEmail()).size() == 1);
        this.controller.mostrarPedidos().clear();
    }
    @Test
    void whenAddPremiumAndEstandarClientsThenShowEstandarClientsReturnsOne() throws SQLException {
        this.controller.anadirCliente(this.cliente3);
        Assertions.assertTrue(this.controller.mostrarClientesEstandard().size() == 3);
        Assertions.assertTrue(this.controller.mostrarClientesPremium().size() == 2);
        this.controller.mostrarClientes().clear();
    }
    @Test
    void whenAddArticlesThenRecoverTwoArticles() throws SQLException {
        this.controller.anadirArticulo(this.articulo2);
        this.controller.anadirArticulo(this.articulo3);
        Assertions.assertTrue(this.controller.mostrarArticulos().size() == 8);
        this.controller.mostrarArticulos().clear();
    }
    @Test
    void whenGetNombreClienteThenGetCorrectCliente() throws SQLException {
        this.controller.anadirCliente(this.cliente3);
        Assertions.assertTrue(this.controller.getClienteWithID(cliente3.getEmail()).getNombre().equals("Jaime"));
        Assertions.assertNull(this.controller.getClienteWithID("miemail@gamail.com"));
        this.controller.mostrarClientes().clear();
    }
    @Test
    void whenGetArticleCodeThenGetCorrectArticle() throws SQLException {
        this.controller.anadirArticulo(this.articulo2);
        Assertions.assertTrue(this.controller.getArticuloWithCode(articulo2.getCodigo()).getDescripcion().equals("peine"));
        Assertions.assertNull(this.controller.getArticuloWithCode(articulo3.getCodigo()));
        this.controller.mostrarArticulos().clear();
    }
}

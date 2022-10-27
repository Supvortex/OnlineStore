package modelo;

import HelloWorld.constants.CostConstants;
import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestModel {


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
    void WhenCreateStandarClientThenGetProperties() {
        Assertions.assertEquals(CostConstants.CLIENTE_ESTANDAR,cliente.tipoCliente());
        Assertions.assertEquals(CostConstants.COSTE_ANUAL_ESTANDAR,cliente.calcAnual());
        Assertions.assertEquals(CostConstants.DTO_ENVIO_ESTANDAR,cliente.descuentoEnv());
    }
    @Test
    void WhenCreatePremiumClientThenGetProperties() {
        Assertions.assertEquals(CostConstants.CLIENTE_PREMIUM,cliente1.tipoCliente());
        Assertions.assertEquals(CostConstants.COSTE_ANUAL_PREM,cliente1.calcAnual());
        Assertions.assertEquals(CostConstants.DTO_ENVIO_PREM,cliente1.descuentoEnv());
    }
}
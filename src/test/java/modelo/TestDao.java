package modelo;

import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.ClientePremium;
import HelloWorld.modelo.dao.Dao;
import HelloWorld.modelo.dao.IDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDao {

    private static Cliente cliente;
    private static Cliente cliente1;
    private static Cliente cliente2;
    private static Articulo articulo;
    private static Articulo articulo1;
    private static IDao dao;

    private static final String N_NAME = "JoseLopez";

    @BeforeAll
    static void init(){
        dao = new Dao();
        cliente = new ClienteEstandar("JLLB@gmail.com", N_NAME, "C/Pelusa", "44455566N");
        cliente1 = new ClientePremium("CC@gmail.com", "Carlos", "C/Casa", "5554442V");
        cliente2 = new ClientePremium("PP@gmail.com", "Pedro", "C/cabra", "5421242Z");
        articulo = new Articulo("02154", "caja azul", 25.5, 7.5, 50);
        articulo1 = new Articulo("32345", "caja rosa", 24.5, 7.5, 60);

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
}

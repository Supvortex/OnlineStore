package HelloWorld.modelo.dao;

import HelloWorld.modelo.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conexion implements IConexion {
    private Connection conexion;
    private String url = "jdbc:mysql://localhost/";
    private String dbname = "OnlineStore";
    private String driver = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "HelloworldTeam";

    public Conexion() {
        try{
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión realizada");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean restartDatabase() throws SQLException {
        Statement st = this.conexion.createStatement();
        try{
            st.executeUpdate(StaticQueries.DROPDATABASE);
            st.executeUpdate(StaticQueries.DROPSCHEMADB);
            st.executeUpdate(StaticQueries.CREATEDB);
            st.executeUpdate(StaticQueries.CREATETABLECLIENTEDB);
            st.executeUpdate(StaticQueries.CREATETABLECLIENTESTDB);
            st.executeUpdate(StaticQueries.CREATETABLECLIENTEPREM);
            st.executeUpdate(StaticQueries.CREATETABLEARTICULO);
            st.executeUpdate(StaticQueries.CREATETABLEPEDIDO);
            st.executeUpdate(StaticQueries.INSERTCLIENTESDB);
            st.executeUpdate(StaticQueries.INSERTCLIENTESDB2);
            st.executeUpdate(StaticQueries.INSERTCLIENTESDB3);
            st.executeUpdate(StaticQueries.INSERTCLIENTESDB4);
            st.executeUpdate(StaticQueries.INSERTCLIENTEPREMDB);
            st.executeUpdate(StaticQueries.INSERTCLIENTEPREMDB2);
            st.executeUpdate(StaticQueries.INSERTCLIENTEESTDB);
            st.executeUpdate(StaticQueries.INSERTCLIENTEESTDB2);
            st.executeUpdate(StaticQueries.INSERTARTICULODB);
            st.executeUpdate(StaticQueries.INSERTARTICULODB2);
            st.executeUpdate(StaticQueries.INSERTARTICULODB3);
            st.executeUpdate(StaticQueries.INSERTARTICULODB4);
            st.executeUpdate(StaticQueries.INSERTARTICULODB5);
            st.executeUpdate(StaticQueries.INSERTARTICULODB6);
            st.executeUpdate(StaticQueries.INSERTPEDIDODB);
            st.executeUpdate(StaticQueries.INSERTPEDIDODB2);
            st.executeUpdate(StaticQueries.INSERTPEDIDODB3);
            st.executeUpdate(StaticQueries.INSERTPEDIDODB7);
            st.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            st.close();
            return false;
        }
    }
    public Lista<Cliente> obtenerClientesEstandar() throws SQLException {
        Lista<Cliente> clientes = new Lista<Cliente>();
        String query = "SELECT cliente.*, clienteestandar.clienteEmail FROM onlinestore.cliente, onlinestore.clienteestandar\n" +
                "WHERE cliente.email = clienteestandar.clienteEmail;";
        Statement st = this.conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            Cliente cliente = new ClienteEstandar();
            cliente.setEmail(rs.getString("email"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setDomicilio(rs.getString("domicilio"));
            cliente.setNif(rs.getString("nif"));
            clientes.add(cliente);
        }
        rs.close();
        st.close();
        return clientes;
    }
    public Lista<Cliente> obtenerClientesPremium() throws SQLException {
        Lista<Cliente> clientes = new Lista<Cliente>();
        String query = "SELECT cliente.*, clientepremium.clienteEmail FROM onlinestore.cliente, onlinestore.clientepremium\n" +
                "WHERE cliente.email = clientepremium.clienteEmail;";
        Statement st = this.conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            Cliente cliente = new ClientePremium();
            cliente.setEmail(rs.getString("email"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setDomicilio(rs.getString("domicilio"));
            cliente.setNif(rs.getString("nif"));
            clientes.add(cliente);
        }
        rs.close();
        st.close();
        return clientes;
    }
    public boolean addClienteEstandar(ClienteEstandar clienteEstandar) throws SQLException {
        try{
            String query = "INSERT INTO onlinestore.cliente (email,nombre,domicilio,nif) VALUES ('" + clienteEstandar.getEmail() + "', '" + clienteEstandar.getNombre() + "', '" + clienteEstandar.getDomicilio() + "', '" + clienteEstandar.getNif() + "');";
            PreparedStatement st = this.conexion.prepareStatement(query);
            st.executeUpdate(query);
            query = "INSERT INTO onlinestore.clienteestandar" + " VALUES ('" + clienteEstandar.getEmail() + "');";
            st = this.conexion.prepareStatement(query);
            st.executeUpdate(query);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean addClientePremium(ClientePremium clientePremium) throws SQLException {
        try{
            String query = "INSERT INTO onlinestore.cliente (email,nombre,domicilio,nif) VALUES ('" + clientePremium.getEmail() + "', '" + clientePremium.getNombre() + "', '" + clientePremium.getDomicilio() + "', '" + clientePremium.getNif() + "');";
            PreparedStatement st = this.conexion.prepareStatement(query);
            st.executeUpdate(query);
            query = "INSERT INTO onlinestore.clientepremium" + " VALUES ('" + clientePremium.getEmail() + "');";
            st = this.conexion.prepareStatement(query);
            st.executeUpdate(query);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Cliente obtenerClienteEmail(String clienteEmail) throws SQLException {
        ClientePremium cliente;
        boolean isPremium = false;
        String query = "select * from onlinestore.clientepremium\n" +
                "where clientepremium.clienteEmail = '" + clienteEmail + "';";
        PreparedStatement st = this.conexion.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            // premium
            isPremium = true;
        }
        query = "select * from onlinestore.cliente\n" +
                "where cliente.email = '" + clienteEmail + "';";
        st = this.conexion.prepareStatement(query);
        rs = st.executeQuery(query);

        if(rs.next()){
            //existe cliente
            if(isPremium){
                ClientePremium clientePremium = new ClientePremium();
                clientePremium.setEmail(clienteEmail);
                clientePremium.setDomicilio(rs.getString("domicilio"));
                clientePremium.setNombre(rs.getString("nombre"));
                clientePremium.setNif(rs.getString("nif"));
                rs.close();
                st.close();
                return clientePremium;
            }else{
                ClienteEstandar clienteEstandar = new ClienteEstandar();
                clienteEstandar.setEmail(clienteEmail);
                clienteEstandar.setDomicilio(rs.getString("domicilio"));
                clienteEstandar.setNombre(rs.getString("nombre"));
                clienteEstandar.setNif(rs.getString("nif"));
                rs.close();
                st.close();
                return clienteEstandar;
            }
        }else{
            //no existe el cliente
            rs.close();
            st.close();
            return null;
        }
    }


    public boolean anadirArticulo(Articulo articulo) throws SQLException {
        String query = "INSERT INTO onlinestore.articulo (codigo,descripcion,pvp,gastoenvio,tiempoenvio) VALUES ('" + articulo.getCodigo() + "'," +
                " '" + articulo.getDescripcion() + "', '" + articulo.getPvp() + "', '" + articulo.getGastoEnvio() + "', '" + articulo.getTiempoEnvio() + "');";
        PreparedStatement st = this.conexion.prepareStatement(query);
        try{
            st.executeUpdate(query);
            st.close();
            return true;
        }catch (Exception e){
            st.close();
            return false;
        }
    }

    /*public boolean anadirArticulo(Articulo articulo){

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Articulo.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            Articulo articulos = new Articulo();
            session.beginTransaction();

            session.getTransaction().commit();

            sessionFactory.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/


    public Lista<Articulo> obtenerArticulo() throws SQLException{
        Lista<Articulo> articulos = new Lista<Articulo>();
        String query = "select * from onlinestore.articulo";
        Statement st = this.conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            Articulo articulo = new Articulo();
            articulo.setCodigo(rs.getString("codigo"));
            articulo.setDescripcion(rs.getString("descripcion"));
            articulo.setPvp(rs.getFloat("pvp"));
            articulo.setGastoEnvio(rs.getFloat("gastoenvio"));
            articulo.setTiempoEnvio(rs.getInt("tiempoenvio"));
            articulos.add(articulo);
        }
        rs.close();
        st.close();
        return articulos;
    }
    public Articulo obtenerArticuloConCod(String codArticulo) throws SQLException {
        Articulo articulo = new Articulo();
        String query = "select * from onlinestore.articulo\n" +
                "where articulo.codigo = '" + codArticulo + "';";
        PreparedStatement st = this.conexion.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            // Existe articulo
            articulo.setCodigo(codArticulo);
            articulo.setDescripcion(rs.getString("descripcion"));
            articulo.setPvp(rs.getFloat("pvp"));
            articulo.setGastoEnvio(rs.getFloat("gastoenvio"));
            articulo.setTiempoEnvio(rs.getInt("tiempoenvio"));
            rs.close();
            st.close();
            return articulo;
        }else{
            //No existe articulo
            rs.close();
            st.close();
            return null;
        }
    }
    public boolean pedidoExiste(Pedido pedido) throws SQLException {
        String query = "SELECT * FROM onlinestore.pedido WHERE numpedido = '" + pedido.getNumPedido() + "';";
        Statement st = this.conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        if(rs.next()){
            //Pedido existe
            rs.close();
            st.close();
            return true;
        }else{
            rs.close();
            st.close();
            return false;
        }
    }
    public boolean cancelarPedido(Pedido pedido) {
        String query = "DELETE FROM onlinestore.pedido WHERE pedido.numpedido =  '" + pedido.getNumPedido() + "';";
        try{
            Statement st = this.conexion.createStatement();
            st.executeUpdate(query);
            st.close();
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public boolean anadirPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO onlinestore.pedido (numpedido,cantidad,fechahora,clienteemail,articulocod) VALUES ('" + pedido.getNumPedido() + "'," +
                " '" + pedido.getCantidad() + "', '" + pedido.getFechaHora() + "', '" + pedido.getCliente().getEmail() + "', '" + pedido.getArticulo().getCodigo() + "');";
        PreparedStatement st = this.conexion.prepareStatement(query);
        try{
            st.executeUpdate(query);
            st.close();
            return true;
        }catch (Exception e){
            st.close();
            return false;
        }
    }
    public Lista<Pedido> obtenerPedidos() throws SQLException {
        Lista<Pedido> pedidos = new Lista<Pedido>();
        String query = "select * from onlinestore.pedido";
        Statement st = this.conexion.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            Pedido pedido = new Pedido();
            pedido.setNumPedido(rs.getString("numpedido"));
            pedido.setCantidad(rs.getInt("cantidad"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            pedido.setFechaHora(LocalDateTime.parse(rs.getString("fechahora"),formatter));
            pedido.setCliente(obtenerClienteEmail(rs.getString("clienteemail")));
            pedido.setArticulo(obtenerArticuloConCod(rs.getString("articulocod")));
            pedidos.add(pedido);
        }
        rs.close();
        st.close();
        return pedidos;
    }
    public Pedido obtenerPedidosConId(String numPedido) throws SQLException {
        Pedido pedido = new Pedido();
        String query = "select * from onlinestore.pedido\n" +
                "where pedido.numpedido = '" + numPedido + "';";
        PreparedStatement st = this.conexion.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            // Existe pedido
            pedido.setNumPedido(numPedido);
            pedido.setCantidad(rs.getInt("cantidad"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            pedido.setFechaHora(LocalDateTime.parse(rs.getString("fechahora"),formatter));
            pedido.setCliente(obtenerClienteEmail(rs.getString("clienteemail")));
            pedido.setArticulo(obtenerArticuloConCod(rs.getString("articulocod")));
            rs.close();
            st.close();
            return pedido;
        }else{
            //No existe pedido
            rs.close();
            st.close();
            return null;
        }
    }
    public Lista<Pedido> obtenerPedidoConCliente(String clienteemail) throws SQLException {

        Lista<Pedido> pedidos = new Lista<Pedido>();
        String query = "select * from onlinestore.pedido\n" +
                "where pedido.clienteemail = '" + clienteemail + "';";
        PreparedStatement st = this.conexion.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        while(rs.next()) {
            Pedido pedido = new Pedido();
            pedido.setNumPedido(rs.getString("numpedido"));
            pedido.setCantidad(rs.getInt("cantidad"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            pedido.setFechaHora(LocalDateTime.parse(rs.getString("fechahora"),formatter));
            pedido.setCliente(obtenerClienteEmail(rs.getString("clienteemail")));
            pedido.setArticulo(obtenerArticuloConCod(rs.getString("articulocod")));
            pedidos.add(pedido);
        }
        rs.close();
        st.close();
        return pedidos;
    }
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
}

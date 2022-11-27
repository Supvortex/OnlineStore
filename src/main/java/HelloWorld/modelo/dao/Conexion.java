package HelloWorld.modelo.dao;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.ClientePremium;
import HelloWorld.modelo.Lista;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.net.StandardSocketOptions;
import java.sql.*;

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
    /*public void addClienteEstandar(ClienteEstandar clienteEstandar) throws SQLException {
        try{
            String query = "INSERT INTO onlinestore.cliente (email, nombre, domicilio, nif) VALUES "
                    + " (?,?,?,?);";
            PreparedStatement st = this.conexion.prepareStatement(query);
            st.setString(1, clienteEstandar.getEmail());
            st.setString(2, clienteEstandar.getNombre());
            st.setString(3, clienteEstandar.getDomicilio());
            st.setString(4, clienteEstandar.getNif());
            st.executeUpdate(query);
            query = "INSERT INTO onlinestore.clienteestandar VALUES (?);";
            st = this.conexion.prepareStatement(query);
            st.setString(1, clienteEstandar.getEmail());
            st.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

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
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    //crea una funcion que obtenga todos los clientes ej- getclients,
    // que devuelva 1 lista con todos los clientes, tanto premium como standar

}

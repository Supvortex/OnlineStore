package HelloWorld.modelo.dao;

import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.Lista;

import java.sql.SQLException;

public interface IConexion {
    Lista<Cliente> obtenerClientesEstandar()throws SQLException;
}

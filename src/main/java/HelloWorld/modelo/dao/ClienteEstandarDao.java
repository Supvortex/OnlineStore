package HelloWorld.modelo.dao;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.Lista;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

import java.util.List;


public class ClienteEstandarDao extends AbstractDao<ClienteEstandar> {

    public ClienteEstandarDao () {
        super(ClienteEstandar.class);
    }

    public Lista<Cliente> findAll2() {
        String sql = String.format("SELECT cliente.*, clienteestandar.clienteEmail FROM onlinestore.cliente, onlinestore.clienteestandar\n" +
                "WHERE cliente.email = clienteestandar.clienteEmail;");

        return EjecuteQueryEstandar(sql, ClienteEstandar.class);

    }

}

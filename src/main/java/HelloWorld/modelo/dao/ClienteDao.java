package HelloWorld.modelo.dao;

import HelloWorld.modelo.Cliente;
import org.hibernate.Session;


public class ClienteDao extends AbstractDao<Cliente> {

    public ClienteDao () {
        super(Cliente.class);
    }

}

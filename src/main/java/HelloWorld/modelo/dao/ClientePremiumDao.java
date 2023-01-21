package HelloWorld.modelo.dao;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClientePremium;
import HelloWorld.modelo.Lista;

public class ClientePremiumDao extends AbstractDao<ClientePremium> {

    public ClientePremiumDao () {
        super(ClientePremium.class);
    }

    public Lista<Cliente> findAll2() {
        String sql = String.format("SELECT cliente.*, clientepremium.clienteEmail FROM onlinestore.cliente, onlinestore.clientepremium\n" +
                "WHERE cliente.email = clientepremium.clienteEmail;");

        return EjecuteQueryPremium(sql, ClientePremium.class);

    }
}
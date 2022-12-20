package HelloWorld.modelo.dao;
import HelloWorld.modelo.Cliente;
import HelloWorld.modelo.ClienteEstandar;
import HelloWorld.modelo.Lista;
import HelloWorld.modelo.Pedido;
import org.hibernate.Session;


public class PedidoDao extends AbstractDao<Pedido> {

    public PedidoDao () {
        super(Pedido.class);
    }

    public Pedido findbyid(String numPedido) {
        String query = "select * from onlinestore.pedido where pedido.numpedido = '" + numPedido + "';";

        return EjecuteQueryFindPedido(query);

    }
}
package HelloWorld.modelo.dao;

import HelloWorld.modelo.Pedido;


public class PedidoDao extends AbstractDao<Pedido> {

    public PedidoDao () {
        super(Pedido.class);
    }

    public Pedido findbyid(String numPedido) {
        String query = "select * from onlinestore.pedido where pedido.numpedido = '" + numPedido + "';";

        return EjecuteQueryFindPedido(query);

    }
}
package HelloWorld.modelo.dao;

import HelloWorld.modelo.Articulo;
import org.hibernate.Session;


public class ArticuloDao extends AbstractDao<Articulo> {

    public ArticuloDao () {
        super(Articulo.class);
    }

}

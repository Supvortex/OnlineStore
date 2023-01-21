package HelloWorld.modelo.dao;
import HelloWorld.modelo.Articulo;
import javax.persistence.EntityManager;

public class ArticuloDao extends AbstractDao<Articulo> {

    public ArticuloDao (EntityManager entityManager) {
        super(Articulo.class, entityManager);
    }

}
package HelloWorld;

import HelloWorld.modelo.Articulo;
import HelloWorld.modelo.dao.ArticuloDao;

import javax.persistence.EntityManager;

public class AppLauncher {

    public static void main(String[] args) {


        //ApplicationContext context = ApplicationContext.getInstance();
        EntityManager entityManager = ApplicationContext.getCurrentSession();

        ArticuloDao dao = new ArticuloDao(entityManager);

        Articulo userEntity = new Articulo("18", "cuchilloCreate", 1.1f, 2.2f, 50);
        dao.create(userEntity);

        dao.close();
        entityManager.close();
        //context.closeEntityManager();
    }
}
package HelloWorld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {

    private EntityManagerFactory entityManagerFactory;

    private static ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager() {
        entityManagerFactory.close();
    }

    public static EntityManager getCurrentSession() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;

    }

}
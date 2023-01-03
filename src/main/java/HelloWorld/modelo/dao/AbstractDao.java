package HelloWorld.modelo.dao;

import HelloWorld.modelo.*;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public abstract class AbstractDao<T> {

    private Class<T> entityClass;
    private SessionFactory sessionFactory;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.sessionFactory = new Configuration().addAnnotatedClass(Articulo.class).addAnnotatedClass(Cliente.class).addAnnotatedClass(ClientePremium.class).addAnnotatedClass(ClienteEstandar.class).addAnnotatedClass(Pedido.class).configure("hibernate.cfg.xml").buildSessionFactory();
    }

    protected Session getSession() {
        if (this.sessionFactory.isOpen()) {
            return this.sessionFactory.getCurrentSession();
        }
        return this.sessionFactory.openSession();
    }

    public void create(T entity) {
        getSession().getTransaction().begin();
        getSession().persist(entity);
        getSession().getTransaction().commit();
        close();
    }


    public void edit(T entity) {
        getSession().getTransaction().begin();
        getSession().merge(entity);
        getSession().getTransaction().commit();
        close();
    }

    public void remove(T entity) {
        Session session = getSession();

        session.getTransaction().begin();
        session.remove(entity);
        session.getTransaction().commit();
        close();
    }

    public T find(Object id) {
        getSession().beginTransaction();
        T item = getSession().find(entityClass, id);
        close();
        return item;
    }

    public Lista<T> findAll() {
        getSession().beginTransaction();
        CriteriaQuery<T> cq = (CriteriaQuery<T>) getSession().getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        Lista<T> tLista = new Lista<>();
        List<T> listarecibida = getSession().createQuery(cq).getResultList();
        for (T item: listarecibida){
            tLista.add(item);
        }
        close();
        return tLista;
    }

    public Lista<Cliente> EjecuteQueryPremium(String query, Class classe){
       Session session = getSession();
       session.beginTransaction();
       Lista<Cliente> tLista = new Lista<>();
       List<ClientePremium> clienteLista = session.createNativeQuery(query, ClientePremium.class).stream().toList();
        for (Cliente cliente: clienteLista){
            tLista.add(cliente);
        }
       session.getTransaction().commit();
       session.close();
       return tLista;
    }

    public Lista<Cliente> EjecuteQueryEstandar(String query, Class classe){
        Session session = getSession();
        session.beginTransaction();
        Lista<Cliente> tLista = new Lista<>();
        List<ClienteEstandar> clienteLista = session.createNativeQuery(query, ClienteEstandar.class).stream().toList();
        for (Cliente cliente: clienteLista){
            tLista.add(cliente);
        }
        session.getTransaction().commit();
        session.close();
        return tLista;
    }

    public Pedido EjecuteQueryFindPedido(String query){
        //getSession().getTransaction().begin();
        //Session session = getSession();
        getSession().beginTransaction();
        List<Pedido> pedido = getSession().createNativeQuery(query, Pedido.class).stream().toList();
        getSession().close();
        return pedido.get(0);
    }

    public void close() {
        this.sessionFactory.getCurrentSession().close();
    }

}

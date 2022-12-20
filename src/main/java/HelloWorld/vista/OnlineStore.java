package HelloWorld.vista;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import HelloWorld.modelo.*;
import HelloWorld.modelo.dao.ArticuloDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class OnlineStore {
    public static void main(String[] args) throws SQLException {
        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }
}
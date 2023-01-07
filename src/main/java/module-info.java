module HelloWorld{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.persistence;
    requires java.naming;
    requires javafx.base;


    opens HelloWorld.vista to javafx.fxml;
    opens HelloWorld.modelo to org.hibernate.orm.core, javafx.base;
    exports HelloWorld.vista;
    exports HelloWorld.controllerFX;
    opens HelloWorld.controllerFX to javafx.fxml;


}
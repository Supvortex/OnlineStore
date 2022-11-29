package HelloWorld.modelo.dao;

public class StaticQueries {
    static final String DROPDATABASE = "DROP TABLE IF EXISTS onlinestore.pedido, onlinestore.articulo, onlinestore.clienteestandar, onlinestore.clientepremium, onlinestore.cliente;";
    static final String DROPSCHEMADB = "DROP SCHEMA IF EXISTS onlinestore;";
    static final String CREATEDB = "CREATE DATABASE onlinestore;";
    static final String CREATETABLECLIENTEDB = "CREATE TABLE onlinestore.cliente (email VARCHAR(255) NOT NULL, nombre VARCHAR(255), domicilio VARCHAR(255), nif VARCHAR(255), PRIMARY KEY (email));";
    static final String CREATETABLECLIENTESTDB = "CREATE TABLE onlinestore.clienteestandar(clienteEmail VARCHAR(255),FOREIGN KEY (clienteemail) REFERENCES cliente(email),PRIMARY KEY (clienteEmail));";
    static final String CREATETABLECLIENTEPREM = "CREATE TABLE onlinestore.clientepremium(clienteEmail VARCHAR(255),FOREIGN KEY (clienteemail) REFERENCES cliente(email),PRIMARY KEY (clienteEmail));";
    static final String CREATETABLEARTICULO = "CREATE TABLE onlinestore.articulo(codigo VARCHAR(255),descripcion VARCHAR(255),pvp FLOAT,gastoenvio FLOAT,tiempoenvio INT,PRIMARY KEY (codigo));";
    static final String CREATETABLEPEDIDO = "CREATE TABLE onlinestore.pedido (numpedido VARCHAR(255),cantidad INT,fechahora DATETIME,clienteemail VARCHAR(255),articulocod VARCHAR(255),PRIMARY KEY (numpedido),FOREIGN KEY (clienteemail) REFERENCES cliente(email),FOREIGN KEY (articulocod) REFERENCES articulo(codigo));";
    static final String INSERTCLIENTESDB = "INSERT INTO onlinestore.cliente VALUES ('EvaFina@uoc.edu', 'Eva Finaz', 'Calle segura', '746544471');";
    static final String INSERTCLIENTESDB2 = "INSERT INTO onlinestore.cliente VALUES ('Augustinstoy@uoc.edu', 'Agustin Stoy', 'Calle chaon lamaca', '776544144')";
    static final String INSERTCLIENTESDB3 = "INSERT INTO onlinestore.cliente VALUES ('Armandoguerra@uoc.edu', 'Armando Guerra', 'Calle conflicto', '477614544')";
    static final String INSERTCLIENTESDB4 = "INSERT INTO onlinestore.cliente VALUES ('PP@gmail.com', 'Pedro', 'C/cabra', '5421242Z')";
    static final String INSERTCLIENTEPREMDB = "INSERT INTO onlinestore.clientepremium VALUES ('Armandoguerra@uoc.edu');";
    static final String INSERTCLIENTEPREMDB2 = "INSERT INTO onlinestore.clientepremium VALUES ('PP@gmail.com');";
    static final String INSERTCLIENTEESTDB = "INSERT INTO onlinestore.clienteestandar VALUES ('EvaFina@uoc.edu');";
    static final String INSERTCLIENTEESTDB2 = "INSERT INTO onlinestore.clienteestandar VALUES ('Augustinstoy@uoc.edu');";
    static final String INSERTARTICULODB = "INSERT INTO onlinestore.articulo VALUES ('010', 'tenedor', 4.5, 4.0, 60);";
    static final String INSERTARTICULODB2 = "INSERT INTO onlinestore.articulo VALUES ('020', 'plato', 6.0, 4.0, 60);";
    static final String INSERTARTICULODB3 = "INSERT INTO onlinestore.articulo VALUES ('015', 'sarten', 30.0, 4.0, 60);";
    static final String INSERTARTICULODB4 = "INSERT INTO onlinestore.articulo VALUES ('017', 'silla', 55.0, 15.0, 80);";
    static final String INSERTARTICULODB5 = "INSERT INTO onlinestore.articulo VALUES ('016', 'cama', 250.0, 25.0, 80);";
    static final String INSERTARTICULODB6 = "INSERT INTO onlinestore.articulo VALUES ('013', 'espejo', 40.0, 15.0, 60);";
    static final String INSERTPEDIDODB = "INSERT INTO onlinestore.pedido VALUES ('01', 6, '2022-11-25 16:22', 'EvaFina@uoc.edu','010');";
    static final String INSERTPEDIDODB2 = "INSERT INTO onlinestore.pedido VALUES ('02', 6, '2022-11-23 11:52','EvaFina@uoc.edu','020');";
    static final String INSERTPEDIDODB3 = "INSERT INTO onlinestore.pedido VALUES ('03', 4, '2022-11-22 19:21','Armandoguerra@uoc.edu','017');";
    static final String INSERTPEDIDODB7 = "INSERT INTO onlinestore.pedido VALUES ('04', 1, '2022-11-21 14:12','Augustinstoy@uoc.edu','016');";
}
package HelloWorld.vista;
import HelloWorld.controlador.Controller;
import HelloWorld.controlador.IController;
import HelloWorld.modelo.*;
import HelloWorld.modelo.dao.Conexion;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
public class GestionOS {
        private IController controller;
        public GestionOS() {
            this.controller = new Controller();
            Scanner teclado = new Scanner(System.in);
        }
            public void inicio() throws SQLException {
            boolean salir = false;
            char opcion;
            do {
                System.out.println("1. Gestión Articulos");
                System.out.println("2. Gestión Clientes");
                System.out.println("3. Gestión Pedidos");
                System.out.println("4. Cargar Base de Datos");
                System.out.println("0. Salir");
                opcion = pedirOpcion();
                switch (opcion) {
                    case '1':
                        gestionArticulos();
                        break;
                    case '2':
                        gestionClientes();
                        break;
                    case '3':
                        gestionPedidos();
                        break;
                    case '4':
                        Conexion con = new Conexion();
                        con.restartDatabase();
                        System.out.print("Se ha cargado la base de datos correctamente.\n");
                        break;
                    case '0':
                        salir = true;
                }
            } while (!salir);
        }
        char pedirOpcion(){
            String resp;
            Scanner teclado = new Scanner(System.in);
            System.out.print("Elige una opción: ");
            resp = teclado.nextLine();
            if (resp.isEmpty()) {
                resp = " ";
            }
            return resp.charAt(0);
        }
        void gestionArticulos() throws SQLException {
            boolean salir = false;
            do {
                System.out.println("[ Gestión Articulos ]");
                System.out.println("1. Añadir Articulos");
                System.out.println("2. Mostrar Articulos");
                System.out.println("0. Volver");
                char opcion = pedirOpcion();
                switch (opcion) {
                    case '1':
                        addArticulo();
                        break;
                    case '2':
                        showArticulo();
                        break;
                    case '0':
                        salir = true;
                }
            } while (!salir);
        }
    void addArticulo() {
        String resp;
        Scanner teclado = new Scanner(System.in);
        Articulo articulo = new Articulo();
        try {
            System.out.println("[ Añadir Articulos ]");
            System.out.println("Introduce Codigo:");
            articulo.setCodigo(teclado.nextLine());
            System.out.println("Introduce Descripcion:");
            articulo.setDescripcion(teclado.nextLine());
            System.out.println("Introduce PVP:");
            articulo.setPvp(Float.parseFloat(teclado.nextLine()));
            System.out.println("Introduce Gastos Envio:");
            articulo.setGastoEnvio(Float.parseFloat(teclado.nextLine()));
            System.out.println("Introduce Tiempo Envio:");
            articulo.setTiempoEnvio(Integer.parseInt(teclado.nextLine()));

            if (this.controller.anadirArticulo(articulo)) {
                System.out.println("Se ha añadido el articulo: " + articulo.toString() + "\n");
            } else {
                System.out.println("No se ha añadido el articulo\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el articulo.\n");
        }
    }
    void showArticulo() throws SQLException {

        if (this.controller.mostrarArticulos().size()>0){
            for (Articulo miArticulo : this.controller.mostrarArticulos()) {
                System.out.println(miArticulo.toString() + "\n");
            }
        } else {
            System.out.println("No existen articulos en el sistema.");
        }
    }
    void gestionClientes() throws SQLException {
        boolean salir = false;
        do {
            System.out.println("[ Gestión Clientes ]");
            System.out.println("1. Añadir Clientes Estandar");
            System.out.println("2. Añadir Clientes Premium");
            System.out.println("3. Mostrar Clientes");
            System.out.println("4. Mostrar Clientes Estandar");
            System.out.println("5. Mostrar Clientes Premium");
            System.out.println("0. Volver");
            char opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    addClientsStandard();
                    break;
                case '2':
                    addClientsPremium();
                    break;
                case '3':
                    showClients();
                    break;
                case '4':
                    showClientsStandard();
                    break;
                case '5':
                    showClientsPremium();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    void addClientsStandard() {
        String resp;
        Scanner teclado = new Scanner(System.in);
        ClienteEstandar clienteEstandar = new ClienteEstandar();
        try {
            System.out.println("[ Añadir Cliente Estandar ]");
            System.out.println("Introduce Email:");
            clienteEstandar.setEmail(teclado.nextLine());
            System.out.println("Introduce Nombre:");
            clienteEstandar.setNombre(teclado.nextLine());
            System.out.println("Introduce Domicilio:");
            clienteEstandar.setDomicilio(teclado.nextLine());
            System.out.println("Introduce NIF:");
            clienteEstandar.setNif((teclado.nextLine()));

            if (this.controller.anadirCliente(clienteEstandar)) {
                System.out.println("Se ha añadido el cliente: " + clienteEstandar.toString() + "\n");
            } else {
                System.out.println("No se ha añadido el cliente\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el cliente.\n");
        }
    }
    void addClientsPremium() {
        String resp;
        Scanner teclado = new Scanner(System.in);
        ClientePremium clientePremium = new ClientePremium();
        try {
            System.out.println("[ Añadir Cliente Premium ]");
            System.out.println("Introduce Email:");
            clientePremium.setEmail(teclado.nextLine());
            System.out.println("Introduce Nombre:");
            clientePremium.setNombre(teclado.nextLine());
            System.out.println("Introduce Domicilio:");
            clientePremium.setDomicilio(teclado.nextLine());
            System.out.println("Introduce NIF:");
            clientePremium.setNif((teclado.nextLine()));

            if (this.controller.anadirCliente(clientePremium)) {
                System.out.println("Se ha añadido el cliente: " + clientePremium.toString() + "\n");
            } else {
                System.out.println("No se ha añadido el cliente\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el cliente.\n");
        }
    }
    void showClients() throws SQLException {

        if (this.controller.mostrarClientes().size()>0){
            for (Cliente miCliente : this.controller.mostrarClientes()) {
                System.out.println(miCliente.toString() + "\n");
            }
        } else {
            System.out.println("No existen clientes en el sistema.");
        }

    }
    void showClientsStandard() throws SQLException {

        if (this.controller.mostrarClientesEstandard().size()>0){
            for (Cliente miCliente : this.controller.mostrarClientesEstandard()) {
                System.out.println(((ClienteEstandar)miCliente).toString() + "\n");
            }
        } else {
            System.out.println("No existen clientes Estandar en el sistema.");
        }

    }
    void showClientsPremium() throws SQLException {

        if (this.controller.mostrarClientesPremium().size()>0){
            for (Cliente miCliente : this.controller.mostrarClientesPremium()) {
                System.out.println(((ClientePremium)miCliente).toString() + "\n");
            }
        } else {
            System.out.println("No existen clientes Premium en el sistema.");
        }

    }
    void gestionPedidos() throws SQLException {
        boolean salir = false;
        do {
            System.out.println("[ Gestión Pedidos ]");
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostrar Pedidos");
            System.out.println("4. Mostrar Pedidos Enviados");
            System.out.println("5. Mostrar Pedidos Pendientes");
            System.out.println("0. Volver");
            char opcion = pedirOpcion();
            switch (opcion) {
                case '1':
                    addPedido();
                    break;
                case '2':
                    deletePedido();
                    break;
                case '3':
                    showPedido();
                    break;
                case '4':
                    showPedidoEnviado();
                    break;
                case '5':
                    showPedidoPendiente();
                    break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }
    void addPedido() {
        Scanner teclado = new Scanner(System.in);
        Pedido pedido = new Pedido();
        try {
            System.out.println("[ Añadir Pedido ]");
            System.out.println("Introduce Numero Pedido:");
            pedido.setNumPedido(teclado.nextLine());
            showClients();
            System.out.println("Introduce Email de Cliente:");
            pedido.setCliente(controller.getClienteWithID(teclado.nextLine()));
            showArticulo();
            System.out.println("Introduce Codigo del Articulo:");
            pedido.setArticulo(controller.getArticuloWithCode(teclado.nextLine()));
            System.out.println("Introduce Cantidad:");
            pedido.setCantidad(Integer.parseInt(teclado.nextLine()));
            pedido.setFechaHora(LocalDateTime.now());
            System.out.println("Fecha y Hora del Pedido: " + LocalDateTime.now().toString());

            if (this.controller.anadirPedido(pedido)) {
                System.out.println("Se ha añadido el pedido: " + pedido.toString() + "\n");
            } else {
                System.out.println("El numero de pedido ya existe.\n");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un ERROR, no se añadira el pedido.\n");
        }
    }
    void showPedido() throws SQLException {
        if (this.controller.mostrarPedidos().size()>0){
            for (Pedido miPedido : this.controller.mostrarPedidos()) {
                System.out.println(miPedido.toString() + "\n");
            }
        } else {
            System.out.println("No existen pedidos en el sistema.");
        }

    }
    void deletePedido() throws SQLException {
        Scanner teclado = new Scanner(System.in);
        showPedido();
        System.out.println("Introduce Numero Pedido a Cancelar:");
        Pedido pedido = controller.getPedidoWithNumPedido(teclado.nextLine());
        if (controller.cancelarPedido(pedido.getNumPedido())){
            System.out.println("Se ha cancelado correctamente: " + pedido.getNumPedido() + "\n");
        } else {
            System.out.println("Se ha producido un ERROR, el pedido no existe.\n");
        }
    }
    void showPedidoEnviado() throws SQLException {
        String resp;
        Scanner teclado = new Scanner(System.in);
        showClients();
        System.out.println("Introduce Email de Cliente:");
        resp = teclado.nextLine();

        if (this.controller.mostrarPedidosEnviados(resp).size()>0){
            for (Pedido miPedido : this.controller.mostrarPedidosEnviados(resp)) {
                System.out.println(miPedido.toString() + "\n");
            }
        } else {
            System.out.println("No existen pedidos enviados en el sistema.");
        }

    }

    void showPedidoPendiente() throws SQLException {
        String resp;
        Scanner teclado = new Scanner(System.in);
        showClients();
        System.out.println("Introduce Email de Cliente:");
        resp = teclado.nextLine();

        if (this.controller.mostrarPedidosPendientes(resp).size()>0){
            for (Pedido miPedido : this.controller.mostrarPedidosPendientes(resp)) {
                System.out.println(miPedido.toString() + "\n");
            }
        } else {
            System.out.println("No existen pedidos pendientes en el sistema.");
        }

    }

}


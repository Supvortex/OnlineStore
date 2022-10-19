package HelloWorld.Vista;

import HelloWorld.Controlador.Controller;
import java.util.Scanner;

public class GestionOS {
        private Controller controller;
        Scanner teclado = new Scanner(System.in);
        public GestionOS() {
            controller = new Controller();
        }
            public void inicio() {
            boolean salir = false;
            char opcion;
            do {
                System.out.println("1. Gestión Articulos");
                System.out.println("2. Gestión Clientes");
                System.out.println("3. Gestión Pedidos");
                System.out.println("0. Salir");
                opcion = pedirOpcion();
                switch (opcion) {
                    case '1':
                        // TODO
                        break;
                    case '2':
                        // TODO
                        break;
                    case '3':
                        // TODO
                        break;
                    case '0':
                        salir = true;
                }
            } while (!salir);
        }
        char pedirOpcion(){
            String resp;
            teclado = new Scanner(System.in);
            System.out.print("Elige una opción: ");
            resp = teclado.nextLine();
            if (resp.isEmpty()) {
                resp = " ";
            }
            return resp.charAt(0);
        }
    }

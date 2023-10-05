/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maroc
 */
import java.util.Scanner;

public class Main {

    private static UsuarioService usuarioService = new UsuarioService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el '\n' que queda pendiente

            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    depositarDinero();
                    break;
                case 3:
                    retirarDinero();
                    break;
                case 4:
                    transferirDinero();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        System.out.println("Gracias por usar la aplicación.");
    }

    private static void agregarUsuario() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        System.out.print("¿Es administrador? (si/no): ");
        boolean isAdmin = scanner.nextLine().equalsIgnoreCase("si");

        System.out.println(usuarioService.agregarUsuario(username, password, isAdmin));
    }

    private static void depositarDinero() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese monto a depositar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();  // Consumir el '\n' que queda pendiente

        System.out.println(usuarioService.depositar(username, monto));
    }

    private static void retirarDinero() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese monto a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();  // Consumir el '\n' que queda pendiente

        System.out.println(usuarioService.retirar(username, monto));
    }

    private static void transferirDinero() {
        System.out.print("Ingrese nombre de usuario remitente: ");
        String remitente = scanner.nextLine();

        System.out.print("Ingrese nombre de usuario destinatario: ");
        String destinatario = scanner.nextLine();

        System.out.print("Ingrese monto a transferir: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();  // Consumir el '\n' que queda pendiente

        System.out.println(usuarioService.transferir(remitente, destinatario, monto));
    }
}

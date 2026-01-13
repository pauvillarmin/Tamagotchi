package org.example;

import java.util.Scanner; // Importante para leer del teclado [cite: 72]

public class Main {
    public static void main(String[] args) {
        // Llamamos al menú y guardamos la opción para probar
        int opcion = menuPrincipal();
        System.out.println("Has elegido la opción: " + opcion);
    }

    // Ejercicio 5: Método para mostrar el menú y validar la opción
    private static int menuPrincipal() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ TAMAGOTCHI ---");
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("-------------");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción del menú: ");

            opcion = teclado.nextInt();

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción no valida. Inténtalo de nuevo.");
            }
        } while (opcion < 0 || opcion > 4);

        return opcion;
    }
}

package org.example;

import java.util.Scanner;

public class Main {
    // Actividad 6: Variables con valor inicial 6
    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menuPrincipal();

            // Si elige 1, mostramos el estado
            if (opcion == 1) {
                mostrarEstado();
            }
        } while (opcion != 0);
        System.out.println("¡Hasta pronto!");
    }

    private static int menuPrincipal() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- MENU TAMAGOTCHI ---");
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    // Actividad 6: Método para mostrar el estado y el dibujo
    private static void mostrarEstado() {
        System.out.println("\n========================");
        System.out.println("   ESTADO ACTUAL");
        System.out.println("========================");
        System.out.println("Saciedad: " + saciedad);
        System.out.println("Energia: " + energia);
        System.out.println("Diversion: " + diversion);
        System.out.println("\n   ( ^_^)  <-- ¡Hola!");
        System.out.println("   <)   )> ");
        System.out.println("    /  \\  ");
        System.out.println("========================");
    }
}
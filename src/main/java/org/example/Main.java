package org.example;

import java.util.Scanner;

public class Main {

    // Actividad 6: Variables con valor inicial 6
    static int saciedad = 6;
    static int energia = 6;
    static int diversion = 6;

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = menuPrincipal();

            if (opcion == 1) {
                mostrarEstado();
            }
            // NUEVO: Llamadas a los métodos que has creado
            else if (opcion == 2) {
                comer();
            } else if (opcion == 3) {
                jugar();
            } else if (opcion == 4) {
                dormir();
            } else if (opcion == 5) { // NUEVA OPCIÓN
                darCaramelito();
            }

        } while (opcion != 0);

        System.out.println("¡Hasta pronto!");
    }

    // ================================
    // MENÚ PRINCIPAL (Ejercicio 5)
    // ================================
    private static int menuPrincipal() {
        int opcion;

        do {
            System.out.println("\n--- MENU TAMAGOTCHI ---");
            System.out.println("1. Estado");
            System.out.println("2. Comer");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("5. Dar caramelito"); // NUEVO
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            if (opcion < 0 || opcion > 5) {  //CAMBIADO DE 4 A 5
                System.out.println("Opción no válida");
            }

        } while (opcion < 0 || opcion > 5);  // CAMBIADO DE 4 A 5

        return opcion;
    }

    // ================================
    // MOSTRAR ESTADO (Ejercicio 6)
    // ================================
    private static void mostrarEstado() {

        System.out.println("\n========================");

        // FIN DEL JUEGO
        if (saciedad == 0 || energia == 0 || diversion == 0) {
            System.out.println("(x_x) :( Game Over ):");
            System.out.println("/|_|\\");
            System.out.println(" | |");
        }

        // HAMBRIENTO
        else if (saciedad <= 4) {
            System.out.println("(• •︵ ) ¡Tengo hambre! 🍗");
            System.out.println("/|x|\\");
            System.out.println(" | |");
        }

        // CANSADO
        else if (energia <= 4) {
            System.out.println("(-_-) Zzz");
            System.out.println("/|_|\\");
            System.out.println(" | |");
        }

        // TRISTE
        else if (diversion <= 4) {
            System.out.println("(-︵-) Estoy aburrido");
            System.out.println("/|_|\\ ¡Juega conmigo!");
            System.out.println(" / \\");
        }

        // CONTENTO
        else {
            System.out.println("(•‿•) ¡Estoy feliz!");
            System.out.println("/|_|\\");
            System.out.println(" | |");
        }

        System.out.println("------------------------");
        System.out.println("Saciedad: " + saciedad);
        System.out.println("Energía: " + energia);
        System.out.println("Diversión: " + diversion);
        System.out.println("========================");
    }
    // OPCIÓN 2: COMER (Balance ajustado)
    private static void comer() {
        if (saciedad < 10) {
            saciedad += 2;          // Comer sube saciedad pero no tanto
            if (saciedad > 10) saciedad = 10;

            diversion -= 1;         // Comer baja un poco la diversión
            if (diversion < 0) diversion = 0;

            System.out.println("He comido. Saciedad ahora: " + saciedad + ", diversión: " + diversion);

            mostrarEstado();
        } else {
            System.out.println("No tengo hambre");
        }
    }

    // OPCIÓN 3: JUGAR (Balance ajustado)
    private static void jugar() {
        if (diversion < 10) {
            diversion += 3;          // Jugar sube diversión
            if (diversion > 10) diversion = 10;

            saciedad -= 2;           // Jugar gasta algo de saciedad
            if (saciedad < 0) saciedad = 0;

            energia -= 1;            // Jugar gasta algo de energía
            if (energia < 0) energia = 0;

            System.out.println("\n[Acción] ¡Te has divertido jugando!");
            mostrarEstado();
        } else {
            System.out.println("\nAhora no me apetece jugar");
        }
    }

    // OPCIÓN 4: DORMIR (Balance ajustado)
    private static void dormir() {
        if (energia < 10) {
            energia += 4;            // Dormir recupera más energía
            if (energia > 10) energia = 10;

            saciedad -= 2;           // Dormir consume algo de comida
            if (saciedad < 0) saciedad = 0;

            diversion -= 1;          // Dormir gasta un poco de diversión
            if (diversion < 0) diversion = 0;

            System.out.println("\n[Acción] El Tamagotchi ha dormido un poco.");
            mostrarEstado();
        } else {
            System.out.println("\nNo tengo sueño");
        }
    }

    // OPCIÓN 5: NUEVA FUNCIONALIDAD (Ejercicio 16)
    private static void darCaramelito() {
        System.out.println("\n[Acción] ¡Le das un caramelo! Está eufórico.");

        diversion = 10; // Sube la diversión al máximo

        saciedad -= 1;  // Baja un poco la saciedad (hambre)
        if (saciedad < 0) saciedad = 0;

        energia -= 1;   // El subidón de azúcar cansa un poco
        if (energia < 0) energia = 0;

        mostrarEstado();
    }
}
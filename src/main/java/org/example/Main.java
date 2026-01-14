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
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción no válida");
            }

        } while (opcion < 0 || opcion > 4);

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
    // OPCIÓN 2: COMER (Ejercicio 8)
    private static void comer() {
        if (saciedad < 10) {
            saciedad += 3; // Corregido: antes era 5, ahora es 3
            if (saciedad > 10) saciedad = 10;  // Limitar al máximo 10
            diversion -= 1;
            if (diversion < 0) diversion = 0;   // No valores negativos

            System.out.println("He comido. Saciedad ahora: " + saciedad + ", diversión: " + diversion);

            // Corregido: Se nos olvidó mostrar el estado después de actualizar
            mostrarEstado();
        } else {
            System.out.println("No tengo hambre");
        }
    }
    // OPCIÓN 3: JUGAR (Ejercicio 10)
    private static void jugar() {
        if (diversion < 10) {
            // Aumentar diversión en 3 (máximo 10)
            diversion += 3;
            if (diversion > 10) {
                diversion = 10;
            }

            // Disminuir saciedad y energía en 1
            saciedad -= 1;
            energia -= 1;

            // Mostrar el estado después de jugar
            mostrarEstado();
        } else {
            System.out.println("Ahora no me apetece jugar");
        }
    }
    //OPCIÓN 4: DORMIR (Ejercicio 11)
    private static void dormir() {
        if (energia < 10) {
            energia += 3;
            if (energia > 10) {
                energia = 10;
            }

            saciedad -= 3;
            diversion -= 2;

            mostrarEstado();
        } else {
            System.out.println("No tengo sueño");
        }
    }
}
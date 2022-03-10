/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlev1;

import java.util.Scanner;

/**
 *
 * @author RAFAEL TRECEÑO RODRÍGUEZ (rafa13o - rafaeltreceno.es)
 */
public class ControlEv1 {

    static Scanner miEscaner;
    static int meta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ganador;

        miEscaner = new Scanner(System.in);
        meta = solicitarMeta();
        System.out.println("Meta en: " + meta);

        ganador = avanzar();
        System.out.println("Caballo ganador: "+ganador);
    }

    /**
     * Se pide un nombre por teclado.
     * La meta se recoge por la suma del número ASCII del nombre que se pasa por teclado
     * @return El sumatorio de los ASCII
     */
    public static int solicitarMeta() {
        int sumatorio = 0;
        
        System.out.print("Nombre de usuario: ");
        String nombre = miEscaner.nextLine();

        // Voy sumando letra a letra su código
        for (int i = 0; i < nombre.length(); i++) {
            int asciiLetra = (int) nombre.charAt(i);
            sumatorio = sumatorio + asciiLetra;
        }

        return sumatorio;
    }

    /**
     * Algoritmo que permite avanzar, de forma aleatoria, a los caballos
     * @return 1: Gana el caballo 1; 2: Gana el caballo 2; -1 Hubo un error
     */
    public static int avanzar() {
        String caballo1 = "", caballo2 = "";
        do {
            try {
                // Creo un número aleatorio para que corran de diferente manera cada vez
                int aleatorio = (int) (Math.random() * 10); 
                // Si el número es menor de 5, corre el caballo 1. Sino, corre el caballo 2
                if (aleatorio < 5) { 
                    caballo1 += "1";
                } else {
                    caballo2 += "2";
                }
                System.out.println(caballo1 + "\n" + caballo2 + "\n"); // Imprimo como van los caballos
                if (caballo1.length() == meta) {
                    return 1; // El caballo ganador es el 1
                } else if (caballo2.length() == meta) {
                    return 2; // El caballo ganador es el 2
                }
                Thread.sleep(500); //Paro medio segundo para que se vea bien el avance
            } catch (InterruptedException ex) {
                return -1; // Hubo un error y por eso se devuelve -1
            }
        } while (caballo1.length() < meta || caballo2.length() < meta); // Se repite hasta que uno gana
        return -1; // Hubo un error y por eso se devuelve -e
    }
}

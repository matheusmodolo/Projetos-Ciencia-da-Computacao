/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.Scanner;

/**
 *
 * @author nmmat
 */
public class Count {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();

        int N = a.length();
        int R = 256;
        int count[] = new int[R + 1];
        char b[] = new char[N];

        for (int i = 0; i < b.length; i++) {
            b[i] = a.charAt(i);
        }

        char alfabeto[] = new char[R + 1];
        int tamanhoL = 0;
        int q = 0;

        for (int i = 0; i < N; i++) {
            boolean existe = false;
            for (int j = i - 1; j > -1; j--) {
                if (b[i] == b[j]) {
                    existe = true;
                }
            }
            if (existe == false) {
                alfabeto[q] = b[i];
                tamanhoL++;
                q++;
            }
        }

        int frequencia[] = new int[tamanhoL];
        int acumulado = 0;
        for (int i = 0; i < frequencia.length; i++) {
            frequencia[i] = 0;
        }

        for (int i = 0; i < tamanhoL; i++) {
            for (int j = 0; j < N; j++) {
                if (alfabeto[i] == b[j]) {
                    frequencia[i]++;
                }
            }
        }

        for (int i = 0; i < frequencia.length; i++) {
            acumulado += frequencia[i];
        }

        System.out.print(" Alfabeto: ");
        System.out.println(alfabeto);

        System.out.println(" Frequencia:");
        for (int i = 0; i < frequencia.length; i++) {
            System.out.println("    " + alfabeto[i] + " = " + frequencia[i]);
        }
        System.out.println(" Acumulado: " + acumulado);
        
        sc.close();
    }
}

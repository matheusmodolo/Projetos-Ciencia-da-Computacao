/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author nmmat
 */
public class LSD {

    public static void main(String[] args) {
        
        String[] ex = {"dab", "add", "cab", "fad", "fee", "bad", "dad", "bee",
            "fed", "bed", "ebb", "ace"};
        StdOut.println("\nStrings desordenadas:");

        for (int i = 0; i < ex.length; i++) {
            StdOut.println(ex[i]);
        }

        StdOut.println("\nStrings ordenadas:");

        sort(ex, 3);

        for (int i = 0; i < ex.length; i++) {
            StdOut.println(ex[i]);
        }
    }

    public static void sort(String[] a, int W) {
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
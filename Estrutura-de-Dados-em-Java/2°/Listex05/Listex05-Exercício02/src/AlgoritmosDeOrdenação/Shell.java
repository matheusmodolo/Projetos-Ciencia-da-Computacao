/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosDeOrdenação;

import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author nmmat
 */
public class Shell {

    /**
     * @param args the command line arguments
     */
    public static void sort(Comparable[] a) {

        int n = a.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                Insertion.sort(a);
                for (int j = 1; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                    imprimir(a);
                }
            }
            h = h / 3;
        }
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println("");
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void imprimir(Comparable[] a) {
        StdOut.print("\nArray desordenado =\t     ");
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}
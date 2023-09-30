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
public class MSD {

    public static void main(String[] args) {

        String[] ex = {"dab", "add", "cab", "fad", "fee", "bad", "dad", "bee",
            "fed", "bed", "ebb", "ace"};

        StdOut.println("\nStrings desordenadas:");

        for (int i = 0; i < ex.length; i++) {
            StdOut.println(ex[i]);
        }

        sort(ex);

        StdOut.println("\nStrings ordenadas:");

        for (int i = 0; i < ex.length; i++) {
            StdOut.println(ex[i]);
        }
    }

    public static void sort(String[] a) {
        String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
        int R = 256;
        if (hi <= lo) {
            return;
        }
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }
}
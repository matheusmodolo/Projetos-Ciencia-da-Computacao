package AlgoritmosDeOrdenação;

import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author nmmat
 */
public class Selection {

    /**
     * @param args the command line arguments
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println("");
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            imprimir(a);
            exch(a, i, min);
        }
    }

    private static void imprimir(Comparable[] a) {
        StdOut.print("\nArray desordenado =\t     ");
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}

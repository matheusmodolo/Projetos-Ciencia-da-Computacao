package Program;

import Ordenação.Merge;
import Ordenação.Merge1;
import Ordenação.Merge2;
import Ordenação.MergeBU;
import Ordenação.Quick;
import Ordenação.Quick1;
import Ordenação.Quick2;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author nmmat
 */
public class Main {

    public static void main(String[] args) {
        Comparable a[] = new Comparable[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        String s = "MERGESORT";
        int n = s.length();
        String[] c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\na) Merge Sort()\nArray de inteiros gerado: ");
        Merge.show(a);
        System.out.println("Array de inteiros ordenado:");
        Merge.sort(a);
        Merge.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
        
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        s = "MERGESORTMELHORIA1";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\nb) Merge Sort - Melhoria 1()\nArray de inteiros gerado: ");
        Merge1.show(a);
        System.out.println("Array de inteiros ordenado:");
        Merge1.sort(a);
        Merge1.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
        
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        s = "MERGESORTMELHORIA2";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\nc) Merge Sort - Melhoria 2()\nArray de inteiros gerado: ");
        Merge2.show(a);
        System.out.println("Array de inteiros ordenado:");
        Merge2.sort(a);
        Merge2.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
        
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        s = "BOTTOMUPMERGESORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\nd) Bottom-Up Merge Sort()\nArray de inteiros gerado: ");
        MergeBU.show(a);
        System.out.println("Array de inteiros ordenado:");
        MergeBU.sort(a);
        MergeBU.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
        
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        s = "QUICKSORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\ne) Quick Sort()\nArray de inteiros gerado: ");
        Quick.show(a);
        System.out.println("Array de inteiros ordenado:");
        Quick.sort(a);
        Quick.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
        
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        s = "QUICKSORTMELHORIA1";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\nf) Quick Sort - Melhoria 1()\nArray de inteiros gerado: ");
        Quick1.show(a);
        System.out.println("Array de inteiros ordenado:");
        Quick1.sort(a);
        Quick1.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
        
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        s = "QUICKSORTMELHORIA2";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        System.out.println("\ng) Quick Sort - Melhoria 2()\nArray de inteiros gerado: ");
        Quick2.show(a);
        System.out.println("Array de inteiros ordenado:");
        Quick2.sort(a);
        Quick2.show(a);
        System.out.println("String: ");
        Merge.show(c);
        System.out.println("String ordenada: ");
        Merge.sort(c);
        Merge.show(c);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import AlgoritmosDeOrdenação.Insertion;
import AlgoritmosDeOrdenação.Merge;
import AlgoritmosDeOrdenação.MergeBU;
import AlgoritmosDeOrdenação.Quick;
import AlgoritmosDeOrdenação.Selection;
import AlgoritmosDeOrdenação.Shell;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import java.lang.String;

/**
 *
 * @author nmmat
 */
public class Main {

    public static void main(String[] args) {
        Comparable a[] = new Comparable[10];
        Comparable b[] = new Comparable[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
            b[i] = a[i];
        }

        String s = "SELECTIONSORT";
        int n = s.length();
        String[] c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }

        //a) Selection Sort()
        System.out.println("\na) Selection Sort()\nArray de inteiros gerado: ");
        Selection.show(a);
        System.out.print("Ordenando o Array de inteiros:");
        Selection.sort(a);
        System.out.print("\nArray de inteiros ordenado = ");
        Selection.show(a);
        System.out.println("String: ");
        Selection.show(c);
        System.out.print("Ordenando a String:");
        Selection.sort(c);
        System.out.print("\nString ordenada =\t     ");
        Selection.show(c);

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        s = "INSERTIONSORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        //b) Insertion Sort()
        System.out.println("\nb) Insertion Sort()\nArray de inteiros gerado anteriormente: ");
        Insertion.show(a);
        System.out.print("Ordenando o Array de inteiros:");
        Insertion.sort(a);
        System.out.print("\nArray de inteiros ordenado = ");
        Insertion.show(a);
        System.out.println("String: ");
        Selection.show(c);
        System.out.print("Ordenando a String:");
        Selection.sort(c);
        System.out.print("\nString ordenada =\t     ");
        Selection.show(c);

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        s = "SHELLSORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        //c) Shell Sort()
        System.out.println("\nc) Shell Sort()\nArray de inteiros gerado anteriormente: ");
        Shell.show(a);
        System.out.print("Ordenando o Array de inteiros:");
        Shell.sort(a);
        System.out.print("\nArray de inteiros ordenado = ");
        Shell.show(a);
        System.out.println("String: ");
        Selection.show(c);
        System.out.print("Ordenando a String:");
        Selection.sort(c);
        System.out.print("\nString ordenada =\t     ");
        Selection.show(c);

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        s = "MERGESORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        //d) Merge Sort
        System.out.println("\nd) Merge Sort()\nArray de inteiros gerado anteriormente: ");
        Merge.show(a);
        System.out.print("Ordenando o Array de inteiros:");
        Merge.sort(a);
        System.out.print("\nArray de inteiros ordenado = ");
        Merge.show(a);
        System.out.println("String: ");
        Selection.show(c);
        System.out.print("Ordenando a String:");
        Selection.sort(c);
        System.out.print("\nString ordenada =\t     ");
        Selection.show(c);

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        s = "BOTTOMUPMERGESORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        //e) Bottom-Up Merge Sort()
        System.out.println("\ne) Bottom-Up Merge Sort()\nArray de inteiros gerado anteriormente: ");
        MergeBU.show(a);
        System.out.print("Ordenando o Array de inteiros:");
        MergeBU.sort(a);
        System.out.print("\nArray de inteiros ordenado = ");
        MergeBU.show(a);
        System.out.println("String: ");
        Selection.show(c);
        System.out.print("Ordenando a String:");
        Selection.sort(c);
        System.out.print("\nString ordenada =\t     ");
        Selection.show(c);

        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        s = "QUICKSHORT";
        n = s.length();
        c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = s.substring(i, i + 1);
        }
        //f) Quick Sort()
        System.out.println("\nf) Quick Sort()\nArray de inteiros gerado anteriormente: ");
        Quick.show(a);
        System.out.print("Ordenando o Array de inteiros:");
        Quick.sort(a);
        System.out.print("\nArray de inteiros ordenado = ");
        Quick.show(a);
        System.out.println("String: ");
        Selection.show(c);
        System.out.print("Ordenando a String:");
        Selection.sort(c);
        System.out.print("\nString ordenada =\t     ");
        Selection.show(c);
        System.out.println();
    }
}

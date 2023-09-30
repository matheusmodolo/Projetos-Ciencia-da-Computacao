package Program;

import OrdenaçãoElementar.Insertion;
import OrdenaçãoElementar.Selection;
import OrdenaçãoElementar.Shell;
import OrdenaçãoElementar.Shuffle;
import edu.princeton.cs.algs4.StdRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        System.out.println("\nSELECTION SORT\nArray de inteiros gerado: ");
        Selection.show(a);
        System.out.println("\nArray de inteiros ordenado:");
        Selection.sort(a);
        Selection.show(a);
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        System.out.println("\n\nINSERTION SORT\nArray de inteiros gerado:");
        Insertion.show(a);
        System.out.println("\nArray de inteiros ordenado:");
        Insertion.sort(a);
        Insertion.show(a);
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        System.out.println("\n\nSHELL SORT\nArray de inteiros gerado:");
        Shell.show(a);
        System.out.println("\nArray de inteiros ordenado:");
        Shell.sort(a);
        Shell.show(a);
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        System.out.println("\n\nSHUFFLE\nArray de inteiros gerado:");
        Shuffle.show(a);
        System.out.println("\nArray de inteiros embaralhado:");
        Shuffle.shuffle(a);
        Shuffle.show(a);
        System.out.println("\n");
    }
}
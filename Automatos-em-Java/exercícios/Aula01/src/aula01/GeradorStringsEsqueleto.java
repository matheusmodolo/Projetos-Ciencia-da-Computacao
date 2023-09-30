/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author David
 */
public class GeradorStringsEsqueleto {

    public static void main(String[] args) {
        int k = 3;
        char[] a = { '0', '1' };
        testeGerarStringsK( k, a );
        testeGerarStringsAteK( k, a );
        
    }

    public static List<String> gerarStringsK(int k, char... a)
            throws IllegalArgumentException {

        if (k < 0) {
            throw new IllegalArgumentException("comprimento negativo");
        }

        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("alfabeto vazio");
        }

        List<String> s = new ArrayList<>();

        // implementação...
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                for (char c : a) {
                    s.add(String.valueOf(c));
                }
            } else {
                List<String> n = new ArrayList<>(s);
                s.clear();
                for (char c : a) {
                    for (String nn : n) {
                        s.add(nn + c);
                    }
                }

            }

        }
        Collections.sort(s);

        return s;

    }

    public static List<String> gerarStringsAteK(int k, char... a) throws IllegalArgumentException {

        if (k < 0) {
            throw new IllegalArgumentException("comprimento negativo");
        }

        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("alfabeto vazio");
        }

        List<String> s = new ArrayList<>();

        // implementação...
        
        for(int i = 1; i <= k; i++){
            s.addAll(gerarStringsK(i, a));
        }
        
        return s;

    }

    private static void testeGerarStringsK(int k, char... a) throws IllegalArgumentException {

        for (int i = 0; i <= k; i++) {

            if (i == 0) {
                System.out.println("\u03A3^0 = {\u03B5}");
            } else {

                System.out.printf("\u03A3^%d = {", i);
                boolean primeiro = true;

                for (String s : gerarStringsK(i, a)) {
                    if (!primeiro) {
                        System.out.print(", ");
                    }
                    System.out.print(s);
                    primeiro = false;
                }

                System.out.print("}");
                System.out.println();

            }

        }

    }

    private static void testeGerarStringsAteK(int k, char... a) throws IllegalArgumentException {

        System.out.print("\u03A3*  = {\u03B5, ");

        for (String s : gerarStringsAteK(k, a)) {
            System.out.print(s);
            System.out.print(", ");
        }

        System.out.print("...}");
        System.out.println();

    }

}

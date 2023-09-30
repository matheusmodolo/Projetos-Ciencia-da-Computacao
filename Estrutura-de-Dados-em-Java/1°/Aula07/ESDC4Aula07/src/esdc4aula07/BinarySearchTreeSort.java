/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula07;

/**
 * Ordenação usando árvore binária de busca.
 *
 * @author Prof. Dr. David Buzatto
 */
public class BinarySearchTreeSort {

    public static <Type extends Comparable<Type>> void sort(Integer[] array) {

        BinarySearchTreeDupKeys arvore = new BinarySearchTreeDupKeys();

        for (int i = 0; i < array.length; i++) {
            arvore.put(array[i]);
        }
        String[] aux = new String[10];
        aux = ((arvore.toString()).replaceAll(" <- root", "")).split("\n");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(aux[i]);
        }
    }
}
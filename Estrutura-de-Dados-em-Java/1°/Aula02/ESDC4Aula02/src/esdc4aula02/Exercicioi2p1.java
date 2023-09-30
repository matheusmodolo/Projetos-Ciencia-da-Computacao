/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula02;

import aesd.esdc4.ds.implementations.LinkedStack;
import aesd.esdc4.ds.interfaces.Stack;

/**
 * Resolução do Exercício i2.1
 *
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p1 {

    /**
     * Verifica se uma expressão composta por pares de símbolos arbitrários está
     * balanceada.
     *
     * @param expression A expressão a ser verificada.
     * @param pairs Um conjunto de caracteres em que cada dois representam um
     * par de caracteres usados na verificação.
     * @return Se a expressão está balanceada.
     * @throws IllegalArgumentException Caso os pares forem fornecidos de forma
     * errada, ou seja, se houver uma quantidade ímpar de elementos, faltando
     * assim a dupla de fechamento de um par.
     */
    public static boolean isBalanced(String expression, char... pairs)
            throws IllegalArgumentException {

        // implementação
        Stack<Character> stack = new LinkedStack<>();
        for (char c : expression.toCharArray()) {
            for (int i = 0; i <= pairs.length - 2; i += 2) {
                if (c == pairs[i]) {
                    stack.push(c);
                    break;
                }
                if (c == pairs[i + 1]) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();

    }
}

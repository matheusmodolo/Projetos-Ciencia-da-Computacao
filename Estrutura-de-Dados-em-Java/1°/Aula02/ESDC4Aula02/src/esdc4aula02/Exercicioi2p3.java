/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula02;

import aesd.esdc4.ds.implementations.LinkedStack;
import static esdc4aula02.Exercicioi2p2.infixToPostfix;
import static esdc4aula02.Exercicioi2p2.isOperand;
import static esdc4aula02.Exercicioi2p2.isOperator;
import static esdc4aula02.Exercicioi2p2.prefixToPostfix;

/**
 * Resolução do Exercício i2.3
 *
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p3 {

    /**
     * Avalia uma expressão aritmética fornecida em qualquer forma (pré-fixada,
     * infixada ou pós-fixada), gerando o resultado. As operações de adição,
     * subtração, multiplicação e divisão devem ser suportadas.
     *
     * @param expression Expressão a ser avaliada.
     * @return O valor obtido após o cômputo da expressão.
     * @throws IllegalArgumentException Caso a expressão fornecida seja
     * inválida, do ponto de vista estrutural, como ter um valor não numérico
     * onde um é esperado, bem como o uso de caracteres ou operações não
     * suportadas.
     */
    public static double evaluate(String expression) throws IllegalArgumentException {

        // implementação
        LinkedStack<String> pilha = new LinkedStack();
        String aux;
        for (String s : expression.split("\\s+")) {
            pilha.push(s);
        }

        if (isOperand(pilha.peek())) {
            aux = pilha.pop();

            if (isOperand(pilha.peek())) {
                pilha.push(aux);
                expression = prefixToPostfix(expression);

            } else if (isOperator(pilha.peek())) {
                pilha.push(aux);
                expression = infixToPostfix(expression);
            }
        }

        LinkedStack<Double> pilha2 = new LinkedStack<>();
        double op1;
        double op2;

        for (String token : expression.split("\\s+")) {

            switch (token) {

                case "+":
                    op2 = pilha2.pop();
                    op1 = pilha2.pop();
                    pilha2.push(op1 + op2);
                    break;

                case "-":
                    op2 = pilha2.pop();
                    op1 = pilha2.pop();
                    pilha2.push(op1 - op2);
                    break;

                case "*":
                    op2 = pilha2.pop();
                    op1 = pilha2.pop();
                    pilha2.push(op1 * op2);
                    break;

                case "/":
                    op2 = pilha2.pop();
                    op1 = pilha2.pop();
                    pilha2.push(op1 / op2);
                    break;

                default:
                    pilha2.push(Double.parseDouble(token));
                    break;

            }
        }

        return pilha2.peek();

    }
}

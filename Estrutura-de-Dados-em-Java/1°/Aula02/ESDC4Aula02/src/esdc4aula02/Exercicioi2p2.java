/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula02;

import aesd.esdc4.ds.implementations.ResizingArrayStack;

/**
 * Resolução do Exercício i2.2
 *
 * @author Prof. Dr. David Buzatto
 */
public class Exercicioi2p2 {

    /**
     * Converte uma expressão aritmética pré-fixada para infixada.
     *
     * Algoritmo: Processe a expressão pré-fixada em ordem inversa (direita para
     * esquerda); Se o token for um operando, empilhe-o Se o token for um
     * operador, desempilhe dois operandos da pilha Crie uma string concatenando
     * na forma: string = (operando1 + operador + operando2)
     *
     * E empilhe essa String de volta à pilha. Repita até o fim da expressão
     * pré-fixada.
     *
     * A expressão infixada estará no topo da pilha.
     *
     * @param prefix A expressão pré-fixada.
     * @return A expressão infixada correspondente.
     * @throws IllegalArgumentException Caso a expressão seja inválida.
     */
    public static String prefixToInfix(String prefix) throws IllegalArgumentException {

        // implementação
        ResizingArrayStack<String> pilha1 = new ResizingArrayStack();
        String[] s = prefix.split("\\s+");

        for (int i = s.length - 1; i >= 0; i--) {
            if (isOperand(s[i])) {
                pilha1.push(s[i]);
            } else if (isOperator(s[i])) {

                switch (s[i]) {
                    case "+":
                        pilha1.push("( " + pilha1.pop() + " + " + pilha1.pop() + " )");
                        break;

                    case "-":
                        pilha1.push("( " + pilha1.pop() + " - " + pilha1.pop() + " )");
                        break;

                    case "*":
                        pilha1.push("( " + pilha1.pop() + " * " + pilha1.pop() + " )");
                        break;

                    case "/":
                        pilha1.push("( " + pilha1.pop() + " / " + pilha1.pop() + " )");
                        break;
                }
            }
        }
        return pilha1.peek();
    }

    /**
     * Converte uma expressão aritmética pré-fixada para pós-fixada.
     *
     * Algoritmo: Processe a expressão pré-fixada em ordem inversa (direita para
     * esquerda); Se o token for um operando, empilhe-o Se o token for um
     * operador, desempilhe dois operandos da pilha Crie uma string concatenando
     * na forma: string = operando1 + operando2 + operador
     *
     * E empilhe essa String de volta à pilha. Repita até o fim da expressão
     * pré-fixada.
     *
     * A expressão pós-fixada estará no topo da pilha.
     *
     * @param prefix A expressão pré-fixada.
     * @return A expressão pós-fixada correspondente.
     * @throws IllegalArgumentException Caso a expressão seja inválida.
     */
    public static String prefixToPostfix(String prefix) throws IllegalArgumentException {

        // implementação
        ResizingArrayStack<String> pilha1 = new ResizingArrayStack();
        String[] s = prefix.split("\\s+");

        for (int i = s.length - 1; i >= 0; i--) {
            if (isOperand(s[i])) {
                pilha1.push(s[i]);
            } else if (isOperator(s[i])) {

                switch (s[i]) {
                    case "+":
                        pilha1.push(pilha1.pop() + " " + pilha1.pop() + " +");
                        break;

                    case "-":
                        pilha1.push(pilha1.pop() + " " + pilha1.pop() + " -");
                        break;

                    case "*":
                        pilha1.push(pilha1.pop() + " " + pilha1.pop() + " *");
                        break;

                    case "/":
                        pilha1.push(pilha1.pop() + " " + pilha1.pop() + " /");
                        break;
                }

            }
        }
        return pilha1.peek();

    }

    /**
     * Converte uma expressão aritmética pós-fixada para infixada.
     *
     * Algoritmo: Processe a expressão pós-fixada da esquerda para a direita; Se
     * o token for um operando, empilhe-o Se o token for um operador, desempilhe
     * dois operandos da pilha Crie uma string concatenando na forma: string =
     * (operando2 + operador + operando1)
     *
     * E empilhe essa String de volta à pilha. Repita até o fim da expressão
     * pré-fixada.
     *
     * A expressão infixada estará no topo da pilha.
     *
     * @param postfix A expressão pós-fixada.
     * @return A expressão infixada correspondente.
     * @throws IllegalArgumentException Caso a expressão seja inválida.
     */
    public static String postfixToInfix(String postfix) throws IllegalArgumentException {

        // implementação
        ResizingArrayStack<String> pilha1 = new ResizingArrayStack();
        String[] s = postfix.split("\\s+");
        String temp;

        for (String r : s) {
            if (isOperand(r)) {
                pilha1.push(r);
            } else if (isOperator(r)) {

                switch (r) {
                    case "+":
                        temp = pilha1.pop();
                        pilha1.push("( " + pilha1.pop() + " + " + temp + " )");
                        break;

                    case "-":
                        temp = pilha1.pop();
                        pilha1.push("( " + pilha1.pop() + " - " + temp + " )");
                        break;

                    case "*":
                        temp = pilha1.pop();
                        pilha1.push("( " + pilha1.pop() + " * " + temp + " )");
                        break;

                    case "/":
                        temp = pilha1.pop();
                        pilha1.push("( " + pilha1.pop() + " / " + temp + " )");
                        break;
                }
            }
        }
        return pilha1.peek();

    }

    /**
     * Converte uma expressão aritmética pós-fixada para pré-fixada.
     *
     * Algoritmo: Processe a expressão pós-fixada da esquerda para a direita; Se
     * o token for um operando, empilhe-o Se o token for um operador, desempilhe
     * dois operandos da pilha Crie uma string concatenando na forma: string =
     * operador + operando2 + operando1
     *
     * E empilhe essa String de volta à pilha. Repita até o fim da expressão
     * pós-fixada.
     *
     * A expressão pré-fixada estará no topo da pilha.
     *
     * @param postfix A expressão pós-fixada.
     * @return A expressão pré-fixada correspondente.
     * @throws IllegalArgumentException Caso a expressão seja inválida.
     */
    public static String postfixToPrefix(String postfix) throws IllegalArgumentException {

        // implementação
        ResizingArrayStack<String> pilha1 = new ResizingArrayStack();
        String[] s = postfix.split("\\s+");
        String temp;

        for (int i = 0; i < s.length; i++) {
            if (isOperand(s[i])) {
                pilha1.push(s[i]);
            } else if (isOperator(s[i])) {

                switch (s[i]) {
                    case "+":
                        temp = pilha1.pop();
                        pilha1.push("+ " + pilha1.pop() + " " + temp);
                        break;

                    case "-":
                        temp = pilha1.pop();
                        pilha1.push("- " + pilha1.pop() + " " + temp);
                        break;

                    case "*":
                        temp = pilha1.pop();
                        pilha1.push("* " + pilha1.pop() + " " + temp);
                        break;

                    case "/":
                        temp = pilha1.pop();
                        pilha1.push("/ " + pilha1.pop() + " " + temp);
                        break;
                }
            }
        }
        return pilha1.peek();

    }

    /**
     * Converte uma expressão aritmética infixada para pré-fixada.
     *
     * Algoritmo: Basta fazer a conversão de infixada para pós-fixada e então
     * converter de pós-fixada para pré-fixada.
     *
     * @param infix A expressão infixada.
     * @return A expressão pré-fixada correspondente.
     * @throws IllegalArgumentException Caso a expressão seja inválida.
     */
    public static String infixToPrefix(String infix) throws IllegalArgumentException {

        // implementação
        return postfixToPrefix(infixToPostfix(infix));

    }

    /**
     * Converte uma expressão aritmética infixada para pós-fixada.
     *
     * Algoritmo: Processe a expressão infixada da esquerda para a direita; Se o
     * token for um operando, concatene-o à expressão pós-fixada que está sendo
     * gerada; Se o token for um parênteses esquerdo, empilhe-o Se o token for
     * um parênteses direito: Enquanto a pilha não estiver vazia e o topo da
     * pilha não for um parênteses esquerdo, desempilhe o topo e concatene-o à
     * expressão pós-fixada que está sendo gerada; Após o enquanto, desempilhe o
     * topo da pilha. Se o token for um operador: Enquanto a pilha não estiver
     * vazia e a precedência do token for menor ou igual à precedência do topo
     * da pilha, desempilhe o topo. Se o que foi desempilhado for um operador,
     * concatene-o à expressão pós-fixada que está sendo gerada; Após o
     * enquanto, empilhe o token.
     *
     * Após o processamento de todos os tokens, é preciso lidar com o que sobrou
     * na pilha. Sendo assim:
     *
     * Enquanto a pilha não estiver vazia: Desempilhe o topo da pilha e, se ele
     * for um parênteses esquerdo, a expressão é inválida, então lance uma
     * exceção do tipo IllegalArgumentException. Caso contrário, verifique se o
     * que foi desempilhado é um operador. Se for, concatene-o à expressão
     * pós-fixada que está sendo gerada;
     *
     * A expressão pós estará pronta na estrutura em que você está armazenando
     * sua geração.
     *
     * @param infix A expressão infixada.
     * @return A expressão pós-fixada correspondente.
     * @throws IllegalArgumentException Caso a expressão seja inválida.
     */
    public static String infixToPostfix(String infix) throws IllegalArgumentException {

        // implementação
        ResizingArrayStack<String> pilha1 = new ResizingArrayStack();
        StringBuilder s = new StringBuilder();
        String aux1;
        String aux2;

        for (String r : infix.split("\\s+")) {
            if (isOperand(r)) {
                s.append(r).append(" ");
            } else if (isLeftParenthesis(r)) {
                pilha1.push(r);
            } else if (isRightParenthesis(r)) {

                while (!pilha1.isEmpty() && !isLeftParenthesis(pilha1.peek())) {
                    s.append(pilha1.pop()).append(" ");
                }

                pilha1.pop();
            } else if (isOperator(r)) {

                while (!pilha1.isEmpty() && getPrecedence(r) <= getPrecedence(pilha1.peek())) {
                    aux1 = pilha1.pop();

                    if (isOperator(aux1)) {
                        s.append(aux1).append(" ");
                    }
                }

                pilha1.push(r);
            }
        }

        while (!pilha1.isEmpty()) {

            aux2 = pilha1.pop();

            if (isLeftParenthesis(aux2)) {
                throw new IllegalArgumentException();
            } else if (isOperator(aux2)) {
                s.append(aux2).append(" ");
            }
        }
        return s.toString().trim();

    }

    /**
     * Verifica se um token é um parênteses esquerdo.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um parênteses esquerdo, falso caso
     * contrário.
     */
    public static boolean isLeftParenthesis(char token) {
        return token == '(';
    }

    /**
     * Verifica se um token é um parênteses esquerdo.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um parênteses esquerdo, falso caso
     * contrário.
     */
    public static boolean isLeftParenthesis(String token) {
        return isLeftParenthesis(token.charAt(0));
    }

    /**
     * Verifica se um token é um parênteses direito.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um parênteses direito, falso caso
     * contrário.
     */
    public static boolean isRightParenthesis(char token) {
        return token == ')';
    }

    /**
     * Verifica se um token é um parênteses direito.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um parênteses direito, falso caso
     * contrário.
     */
    public static boolean isRightParenthesis(String token) {
        return isRightParenthesis(token.charAt(0));
    }

    /**
     * Verifica se um token é um operando.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um operando, falso caso contrário.
     */
    public static boolean isOperand(char token) {
        return token >= '0' && token <= '9'/* || 
               token >= 'A' && token <= 'Z' ||
               token >= 'a' && token <= 'z'*/;
    }

    /**
     * Verifica se um token é um operando.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um operando, falso caso contrário.
     */
    public static boolean isOperand(String token) {
        return isOperand(token.charAt(0));
    }

    /**
     * Verifica se um token é um operador.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um operador, falso caso contrário.
     */
    public static boolean isOperator(char token) {
        switch (token) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    /**
     * Verifica se um token é um operador.
     *
     * @param token Token a ser verificado.
     * @return Verdadeiro caso o token seja um operador, falso caso contrário.
     */
    public static boolean isOperator(String token) {
        return isOperator(token.charAt(0));
    }

    /**
     * Obtém a precedência de um operador.
     *
     * @param operator Operador a ser verificado.
     * @return O valor da precedência do operador testado.
     */
    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }

    /**
     * Obtém a precedência de um operador.
     *
     * @param operator Operador a ser verificado.
     * @return O valor da precedência do operador testado.
     */
    public static int getPrecedence(String operator) {
        return getPrecedence(operator.charAt(0));
    }

}

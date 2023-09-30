/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

/**
 * Testes da classe DFA.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TestesDFA {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        
        System.out.println( "Exemplo 1:" );
        System.out.println( "L = { x01y | x e y são quaisquer strings de 0's e 1's }\n" );
        testesExemplo1();
        
        System.out.println();
        System.out.println( "Exemplo 2:" );
        System.out.println( "L = { 0^i \u2228 1^j | i > 0 é par e j > 0 é ímpar }\n" );
        testesExemplo2();
        
    }
    
    private static void testesExemplo1() {
        
        DFA dfa = new DFA();
        int q0 = dfa.addState( true, false );
        int q1 = dfa.addState( false, false );
        int q2 = dfa.addState( false, true );
        
        dfa.addTransition( q0, q1, '0' );
        dfa.addTransition( q0, q0, '1' );
        
        dfa.addTransition( q1, q1, '0' );
        dfa.addTransition( q1, q2, '1' );
        
        dfa.addTransition( q2, q2, '0' );
        dfa.addTransition( q2, q2, '1' );
        
        System.out.println( "DFA:" );
        System.out.println( dfa );
        
        System.out.println( "\nVerificações:" );
        
        String[] stringsTeste = {
            "01",
            "11010",
            "100011",
            "",
            "0",
            "111000",
            "111a000",
        };
        
        for ( String string : stringsTeste ) {
            System.out.printf( "\t%s %s L(A)\n", 
                    string.length() == 0 ? "\u03B5" : string, 
                    dfa.accepts( string ) ? "\u2208" : "\u2209" );
        }
        
    }
    
    private static void testesExemplo2() {
        
        DFA dfa = new DFA();
        int q0 = dfa.addState( true, false );
        int q1 = dfa.addState( false, false );
        int q2 = dfa.addState( false, true );
        int q3 = dfa.addState( false, false );
        int q4 = dfa.addState( false, true );
        int q5 = dfa.addState( false, false );
        
        dfa.addTransition( q0, q1, '0' );
        dfa.addTransition( q0, q4, '1' );
        
        dfa.addTransition( q1, q2, '0' );
        
        dfa.addTransition( q2, q3, '0' );
        
        dfa.addTransition( q3, q2, '0' );
        
        dfa.addTransition( q4, q5, '1' );
        
        dfa.addTransition( q5, q4, '1' );
        
        System.out.println( "DFA:" );
        System.out.println( dfa );
        
        System.out.println( "\nVerificações:" );
        
        String[] stringsTeste = {
            "00", 
            "0000", 
            "000000", 
            "1", 
            "111", 
            "11111",
            "",
            "0", 
            "000", 
            "11", 
            "1111", 
            "0101", 
            "1010",
            "11111a"
        };
        
        for ( String string : stringsTeste ) {
            System.out.printf( "\t%s %s L(A)\n", 
                    string.length() == 0 ? "\u03B5" : string, 
                    dfa.accepts( string ) ? "\u2208" : "\u2209" );
        }
        
    }
    
}

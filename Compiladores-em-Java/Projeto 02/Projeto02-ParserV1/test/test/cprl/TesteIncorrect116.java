/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static test.cprl.TestUtils.testar;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class TesteIncorrect116 {
    
    @Test
    public void testeIncorrect116() throws IOException, FileNotFoundException {
        
        testar( "TesteIncorrect_116",
                "../examples/Incorrect/CPRL0/Incorrect_116.cprl",
                "../examples/Incorrect/CPRL0/Incorrect_116-ParserV1-Results.txt" );
        
    }
    
}

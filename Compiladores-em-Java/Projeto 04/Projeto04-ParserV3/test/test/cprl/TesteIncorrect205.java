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
public class TesteIncorrect205 {
    
    @Test
    public void testeIncorrect205() throws IOException, FileNotFoundException {
        
        testar( "TesteIncorrect_205",
                "../examples/Incorrect/Subprograms/Incorrect_205.cprl",
                "../examples/Incorrect/Subprograms/Incorrect_205-ParserV3-Results.txt" );
        
    }
    
}

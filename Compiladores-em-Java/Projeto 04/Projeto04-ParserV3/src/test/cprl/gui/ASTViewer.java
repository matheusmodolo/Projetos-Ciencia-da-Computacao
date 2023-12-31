/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.cprl.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.compiler.InternalCompilerException;
import edu.citadel.compiler.Source;
import edu.citadel.cprl.Parser;
import edu.citadel.cprl.ast.AST;
import edu.citadel.cprl.ast.Program;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import test.cprl.gui.visitor.XMLArvoreVisitor;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class ASTViewer extends javax.swing.JFrame {

    private String[] sources = new String[] {
        "../examples/Incorrect/CPRL0/Incorrect_101.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_102.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_103.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_104.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_105.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_106.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_107.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_108.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_109.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_110.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_111.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_112.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_113.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_114.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_115.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_116.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_117.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_118.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_119.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_120.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_121.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_122.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_123.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_124.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_125.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_126.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_127.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_128.cprl",
        "../examples/Incorrect/CPRL0/Incorrect_129.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_201.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_202.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_203.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_204.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_205.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_206.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_207.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_208.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_209.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_210.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_211.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_212.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_213.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_214.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_215.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_216.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_217.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_218.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_219.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_220.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_221.cprl",
        "../examples/Incorrect/Subprograms/Incorrect_222.cprl",
        "../examples/Incorrect/Arrays/Incorrect_301.cprl",
        "../examples/Incorrect/Arrays/Incorrect_302.cprl",
        "../examples/Incorrect/Arrays/Incorrect_303.cprl",
        "../examples/Incorrect/Arrays/Incorrect_304.cprl",
        "../examples/Incorrect/Arrays/Incorrect_305.cprl"
    };
    
    /**
     * Creates new form JanelaVisualizacaoArvore
     */
    public ASTViewer() {
        initComponents();
        comboSource.setModel( new javax.swing.DefaultComboBoxModel<String>(sources));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnParse = new javax.swing.JButton();
        lblSource = new javax.swing.JLabel();
        comboSource = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AST Viewer");

        btnParse.setText("Parse and Build!");
        btnParse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParseActionPerformed(evt);
            }
        });

        lblSource.setText("Source Code File:");

        comboSource.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "a", "b", "c" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnParse))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSource)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSource, 0, 466, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSource)
                    .addComponent(comboSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnParse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParseActionPerformed
        
        try {
            
            File f = new File( comboSource.getModel().getSelectedItem().toString() );
            FileReader fileReader = null;

            fileReader = new FileReader( f, StandardCharsets.UTF_8 );

            System.out.println( "Parsing " + f.getName() + "..." );

            Source source = new Source( fileReader );
            edu.citadel.cprl.Scanner scanner = new edu.citadel.cprl.Scanner( source );
            Parser parser = new Parser( scanner );
            boolean ok = true;

            Program program = null;

            try {

                program = parser.parseProgram();

                if ( ErrorHandler.getInstance().errorsExist() ) {
                    System.out.println( "Errors detected in " + f.getName() + " -- parsing terminated." );
                    ok = false;
                }

            } catch ( IllegalStateException e ) {
                ok = false;
            } catch ( InternalCompilerException e ) {
                ok = false;
            }

            if ( ok ) {
                System.out.println( "Parsing complete." );
            }

            PrintWriter pw = new PrintWriter( new File( "ast.xml" ) );
            XMLArvoreVisitor xav = new XMLArvoreVisitor();
            
            if ( program != null ) {
                program.accept( xav );
                pw.write( xav.getXMLArvore() );
            } else {
                pw.write( "" );
            }
            
            pw.close();

            ErrorHandler.getInstance().resetErrorCount();
            AST.resetCurrentLabelNum();
            fileReader.close();

            if ( program != null ) {
                new JDTreeView( this, true ).setVisible( true );
            } else {
                
            }
        
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
        
    }//GEN-LAST:event_btnParseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        
        FlatDarkLaf.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ASTViewer().setVisible( true );
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnParse;
    private javax.swing.JComboBox<String> comboSource;
    private javax.swing.JLabel lblSource;
    // End of variables declaration//GEN-END:variables
}

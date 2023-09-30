package edu.citadel.cprl.ast;

import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Symbol;
import edu.citadel.cprl.Token;
import edu.citadel.cprl.Type;
import test.cprl.gui.visitor.Visitor;

/**
 * The abstract syntax tree node for a constant declaration.
 */
public class ConstDecl extends InitialDecl {

    private Token literal;

    /**
     * Construct a ConstDecl with its identifier, type, and literal.
     */
    public ConstDecl( Token identifier, Type constType, Token literal ) {
        super( identifier, constType );
        this.literal = literal;
    }

    public Token getLiteral() {
        return literal;
    }

    @Override
    public void accept( Visitor v ) {
        v.visitConcreteElementConstDecl( this );
    }
    
    @Override
    public void checkConstraints() {
        // ...
    }
    
}

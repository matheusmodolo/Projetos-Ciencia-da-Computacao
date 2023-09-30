package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.cprl.Type;

import java.util.List;

/**
 * The abstract syntax tree node for a writeln statement.
 */
public class WritelnStmt extends OutputStmt {

    /**
     * Construct a writeln statement with the list of expressions.
     */
    public WritelnStmt(List<Expression> expressions) {
        super(expressions);
    }

    // inherited checkConstraints() method is sufficient
    @Override
    public void emit() throws CodeGenException {

        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        List<Expression> exprs = getExpressions();
        for (Expression expr : exprs) {
            if (expr != null) {

                expr.emit();

                Type exprType = expr.getType();

                if (exprType == Type.Integer) {
                    emit("PUTINT");
                } else if (exprType == Type.Boolean) {
                    emit("PUTBYTE");
                } else if (exprType == Type.Char) {
                    emit("PUTCH");
                } else if (exprType == Type.String) {
                    emit("PUTSTR");
                } else {
                    throw new CodeGenException(expr.getPosition(), "Invalid type.");
                }

            }
        }
        emit("PUTEOL");
        // </editor-fold>
    }
}

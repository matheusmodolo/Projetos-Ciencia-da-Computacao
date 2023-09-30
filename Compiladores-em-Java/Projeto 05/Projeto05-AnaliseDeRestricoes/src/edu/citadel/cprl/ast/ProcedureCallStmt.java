package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.cprl.Token;
import java.util.Iterator;

import java.util.List;

/**
 * The abstract syntax tree node for a procedure call statement.
 */
public class ProcedureCallStmt extends Statement {

    private Token procId;
    private List<Expression> actualParams;
    private ProcedureDecl procDecl;

    /*
     * Construct a procedure call statement with its name token, the
     * list of actual parameters being passed as part of the call,
     * and a reference to the declaration of the procedure being called.
     */
    public ProcedureCallStmt(Token procId,
            List<Expression> actualParams,
            ProcedureDecl procDecl) {

        this.procId = procId;
        this.actualParams = actualParams;
        this.procDecl = procDecl;

    }

    public Token getProcId() {
        return procId;
    }

    public List<Expression> getActualParams() {
        return actualParams;
    }

    public ProcedureDecl getProcDecl() {
        return procDecl;
    }

    @Override
    public void checkConstraints() {

        // Regra de Tipo: a quantidade de argumentos (actual parameters)
        // precisa ser a mesma da quantidade de parâmetros formais e cada par
        // deve ter o mesmo tipo.
        // Regra Variada: se um parâmetro formal é um parâmetro var, então o
        // argumento deve ser um valor nomeado, não uma expressão arbitrária.
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {

            if (actualParams.size() != procDecl.getFormalParams().size()) {
                String errorMsg = "Incorrect number of actual parameters.";
                throw error(procDecl.getPosition(), errorMsg);
            }

            for (int i = 0; i < actualParams.size(); i++) {
                actualParams.get(i).checkConstraints();
            }

            Iterator<Expression> it1 = actualParams.listIterator();
            Iterator<ParameterDecl> it2 = procDecl.getFormalParams().iterator();

            while (it1.hasNext()) {

                Expression ex = it1.next();
                ParameterDecl pr = it2.next();

                if (!matchTypes(ex.getType(), pr.getType())) {
                    String errorMsg = "Parameter type mismatch.";
                    throw error(ex.getPosition(), errorMsg);
                }

                if (pr.isVarParam()) {
                    if (!(ex instanceof NamedValue)) {
                        String errorMsg = "Expression for a var parameter must be a variable.";
                        throw error(ex.getPosition(), errorMsg);
                    }
                }

            }
        } catch (ConstraintException e) {
            ErrorHandler.getInstance().reportError(e);
        }
        // </editor-fold>
    }

    @Override
    public void emit() throws CodeGenException {
        // ...
    }
}

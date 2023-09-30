package edu.citadel.cprl.ast;

import edu.citadel.compiler.CodeGenException;
import edu.citadel.compiler.ConstraintException;
import edu.citadel.compiler.ErrorHandler;
import edu.citadel.compiler.Position;
import edu.citadel.cprl.ArrayType;
import edu.citadel.cprl.ScopeLevel;
import edu.citadel.cprl.Type;

import java.util.List;

/**
 * The abstract syntax tree node for a variable, which is any named variable
 * that can appear on the left hand side of an assignment statement.
 */
public class Variable extends Expression {

    private NamedDecl decl;
    private List<Expression> indexExprs;   // index expressions for an array;
    // empty if the variable is not an array

    /**
     * Construct a variable with a reference to its declaration, its position,
     * and a list of index expressions.
     */
    public Variable(NamedDecl decl, Position position, List<Expression> indexExprs) {
        super(decl.getType(), position);
        this.decl = decl;
        this.indexExprs = indexExprs;
    }

    /**
     * Construct a variable that corresponds to a named value.
     */
    public Variable(NamedValue nv) {
        this(nv.getDecl(), nv.getPosition(), nv.getIndexExprs());
    }

    /**
     * Returns the declaration for this variable.
     */
    public NamedDecl getDecl() {
        return decl;
    }

    /**
     * Returns the list of index expressions for an array. Returns an empty list
     * if the variable is not an array variable.
     */
    public List<Expression> getIndexExprs() {
        return indexExprs;
    }

    @Override
    public void checkConstraints() {

        // Regra de Tipo: o tipo deve ser Integer, Boolean, Char ou um tipo de 
        // array definido pelo usuário.
        // Para tipos de arrays:
        // Regra de Tipo: Cada expressão de índice deve ser do tipo Integer.
        // Regra Variada: O uso de expressões nos índices são permitidas apenas
        // em variáveis de tipos de array.
        try {

            assert decl instanceof SingleVarDecl || decl instanceof ParameterDecl :
                    "Declaration is not a variable.";

            for (Expression expr : indexExprs) {

                expr.checkConstraints();

                // check that the variable's type is an array type
                if (getType() instanceof ArrayType) {
                    // Applying the index effectively changes the
                    // variable's type to the element type of the array
                    ArrayType type = (ArrayType) getType();
                    setType(type.getElementType());
                } else {
                    String errorMsg = "Index expression not allowed; not an array.";
                    throw error(expr.getPosition(), errorMsg);
                }

                // check that the type of the index expression is Integer
                if (expr.getType() != Type.Integer) {
                    String errorMsg = "Index expression must have type Integer.";
                    throw error(expr.getPosition(), errorMsg);
                }

            }

        } catch (ConstraintException e) {
            ErrorHandler.getInstance().reportError(e);
        }

    }

    @Override
    public void emit() throws CodeGenException {

        if (decl instanceof ParameterDecl && ((ParameterDecl) decl).isVarParam()) {
            // address of actual parameter is value of var parameter
            emit("LDLADDR " + decl.getRelAddr());
            emit("LOADW");
        } else if (decl.getScopeLevel() == ScopeLevel.PROGRAM) {
            emit("LDGADDR " + decl.getRelAddr());
        } else {
            emit("LDLADDR " + decl.getRelAddr());
        }

        // Para um array, nesse ponto o endereço base do array está no topo da
        // pilha. Você precisa substituí-lo pela soma: endereço base + offset
        // ...
        // Dica Importante: ao se aplicar um índice, você deve gerar código
        // baseado no tipo do elemento.
        // Itere pelas expressões de índices
        // Fora do laço declare
        // Type declType = decl.getType();
        // Dentro do laço, logo no topo, faça o cast de declType para uma variável
        // com nome de arrayType (do tipo ArrayType).
        // Ao invés de emitir código baseado em getType().getSize(), emita com
        // base em arrayType.getElementType().getSize().
        // No fim do laço, configure declType como arrayType.getElementType().
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        if (indexExprs.size() > 0) {
            Type declType = decl.getType();
            for (int i = 0; i < indexExprs.size(); i++) {
                ArrayType arrayType = (ArrayType) declType;
                indexExprs.get(i).emit();
                emit("LDCINT " + arrayType.getElementType().getSize());
                emit("MUL");
                emit("ADD");
                declType = arrayType.getElementType();
            }
        }
        // </editor-fold>
    }
}

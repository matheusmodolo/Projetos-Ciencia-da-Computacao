package edu.citadel.cprl;

import edu.citadel.compiler.Position;
import edu.citadel.compiler.ParserException;
import edu.citadel.compiler.InternalCompilerException;
import edu.citadel.compiler.ErrorHandler;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import static edu.citadel.cprl.FirstFollowSets.*;
import edu.citadel.cprl.ast.*;

/**
 * This class uses recursive descent to perform syntax analysis of the CPRL
 * source language.
 */
public class Parser {

    private Scanner scanner;
    private IdTable idTable;
    private LoopContext loopContext;
    private SubprogramContext subprogramContext;

    /**
     * Constrói um analisador sintático (parser) com um scanner especificado.
     */
    public Parser(Scanner scanner) {

        this.scanner = scanner;
        this.idTable = new IdTable();
        this.loopContext = new LoopContext();
        this.subprogramContext = new SubprogramContext();
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * program = declarativePart statementPart "." .
     */
    public Program parseProgram() throws IOException {

        try {

            DeclarativePart declPart = parseDeclarativePart();
            StatementPart stmtPart = parseStatementPart();
            match(Symbol.dot);
            match(Symbol.EOF);
            return new Program(declPart, stmtPart);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("program"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * declarativePart = initialDecls subprogramDecls .
     */
    public DeclarativePart parseDeclarativePart() throws IOException {

        List<InitialDecl> initialDecls = parseInitialDecls();
        List<SubprogramDecl> subprogDecls = parseSubprogramDecls();

        return new DeclarativePart(initialDecls, subprogDecls);
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * initialDecls = ( initialDecl )* .
     */
    public List<InitialDecl> parseInitialDecls() throws IOException {

        List<InitialDecl> initialDecls = new ArrayList<>();

        while (scanner.getSymbol().isInitialDeclStarter()) {

            InitialDecl decl = parseInitialDecl();

            if (decl instanceof VarDecl) {
                VarDecl varDecl = (VarDecl) decl;
                for (SingleVarDecl singleVarDecl : varDecl.getSingleVarDecls()) {
                    initialDecls.add(singleVarDecl);
                }
            } else {
                initialDecls.add(decl);
            }
        }

        return initialDecls;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * initialDecl = constDecl | arrayTypeDecl | varDecl .
     */
    public InitialDecl parseInitialDecl() throws IOException {

        // código do parser esperado para o Projeto 03
        /*if ( scanner.getSymbol() == Symbol.constRW ) {
            parseConstDecl();
        } else if ( scanner.getSymbol() == Symbol.typeRW ) {
            parseArrayTypeDecl();
        } else if ( scanner.getSymbol() == Symbol.varRW ) {
            parseVarDecl();
        } else {
            throw internalError( "Invalid initial decl." );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        if (scanner.getSymbol() == Symbol.constRW) {
            return parseConstDecl();
        } else if (scanner.getSymbol() == Symbol.typeRW) {
            return parseArrayTypeDecl();
        } else if (scanner.getSymbol() == Symbol.varRW) {
            return parseVarDecl();
        } else {
            throw internalError("Invalid initial decl.");
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * constDecl = "const" constId ":=" literal ";" .
     */
    public ConstDecl parseConstDecl() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.constRW );
            
            if ( scanner.getSymbol() == Symbol.identifier ) {
                idTable.add( scanner.getToken(), IdType.constantId );
                match( Symbol.identifier );
            }
            
            match( Symbol.assign );
            
            if ( scanner.getSymbol().isLiteral() ) {
                matchCurrentSymbol();
            } else {
                throw error( "Invalid literal expression." );
            }
            
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "constDecl" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        ConstDecl constDecl = null;
        int cont = 0;
        try {
            match(Symbol.constRW);
            Token operator = scanner.getToken();
            if (scanner.getSymbol() == Symbol.identifier) {
                match(Symbol.identifier);
            }
            match(Symbol.assign);
            Type typeName = null;

            Token literal = scanner.getToken();
            if (scanner.getSymbol().isLiteral()) {
                typeName = typeName.Integer;
                matchCurrentSymbol();
            } else {
                cont = 1;
                typeName = typeName.UNKNOWN;
                literal = null;
                constDecl = new ConstDecl(operator, typeName, literal);
                idTable.add(constDecl);
                throw error("Invalid literal expression.");
            }

            match(Symbol.semicolon);

            constDecl = new ConstDecl(operator, typeName, literal);
            idTable.add(constDecl);

            return constDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("constDecl"));
            if (cont == 0) {
                return null;
            } else {
                return constDecl;
            }
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa as regras gramaticais abaixo:
     *
     * literal = intLiteral | charLiteral | stringLiteral | booleanLiteral .
     * booleanLiteral = "true" | "false" .
     */
    public Token parseLiteral() throws IOException {

        try {

            if (scanner.getSymbol().isLiteral()) {
                Token literal = scanner.getToken();
                matchCurrentSymbol();
                return literal;
            } else {
                throw error("Invalid literal expression.");
            }

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("literal"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * varDecl = "var" identifiers ":" typeName ";" .
     */
    public VarDecl parseVarDecl() throws IOException {

        try {

            match(Symbol.varRW);
            List<Token> identifiers = parseIdentifiers();
            match(Symbol.colon);
            Type typeName = parseTypeName();
            match(Symbol.semicolon);

            VarDecl varDecl = new VarDecl(identifiers, typeName, idTable.getScopeLevel());

            for (SingleVarDecl decl : varDecl.getSingleVarDecls()) {
                idTable.add(decl);
            }

            return varDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("varDecl"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * identifiers = identifier ( "," identifier )* .
     *
     * @return uma lista de tokens do tipo identificador. Retorna uma lista
     * vazia caso a análise falhe.
     */
    public List<Token> parseIdentifiers() throws IOException {

        try {

            List<Token> identifiers = new ArrayList<>();
            Token idToken = scanner.getToken();
            match(Symbol.identifier);
            identifiers.add(idToken);

            while (scanner.getSymbol() == Symbol.comma) {
                matchCurrentSymbol();
                idToken = scanner.getToken();
                match(Symbol.identifier);
                identifiers.add(idToken);
            }

            return identifiers;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("identifiers"));
            return Collections.emptyList();
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * arrayTypeDecl = "type" typeId "=" "array" "[" intConstValue "]" "of"
     * typeName ";" .
     */
    public ArrayTypeDecl parseArrayTypeDecl() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.typeRW );
            
            List<Token> identifiers = parseIdentifiers();

            for ( Token identifier : identifiers ) {
                idTable.add( identifier, IdType.arrayTypeId );
            }
            
            match( Symbol.equals );
            match( Symbol.arrayRW );
            match( Symbol.leftBracket );
            
            if ( scanner.getSymbol() == Symbol.intLiteral ) {
                matchCurrentSymbol();
            } else {
                throw error( "Invalid constant." );
            }
            
            match( Symbol.rightBracket );
            match( Symbol.ofRW );
            parseTypeName();
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "arrayTypeDecl" ) );
        }*/
 /* Dica: Se parseConstValue() returnar um valor null, crie um token 
         * "boneco" para o ConstValue evitando assim erros adicionais associados 
         * à NullPointerException. Por exemplo:
         * new ConstValue( new Token( Symbol.intLiteral, scanner.getPosition(), "0" ) );
         */
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        ArrayTypeDecl arrayTypeDecl = null;
        int cont = 0;
        try {
            Type typeName = null;

            match(Symbol.typeRW);

            Token operator = scanner.getToken();
            if (scanner.getSymbol() == Symbol.identifier) {
                match(Symbol.identifier);
            }

            match(Symbol.equals);
            match(Symbol.arrayRW);
            match(Symbol.leftBracket);

            ConstValue numElements = new ConstValue(new Token(Symbol.intLiteral, scanner.getPosition(), "0"));

            if (scanner.getSymbol() == Symbol.intLiteral) {
                numElements = new ConstValue(new Token(Symbol.intLiteral, scanner.getPosition(), scanner.getToken().toString()));
                matchCurrentSymbol();
            } else {
                cont = 1;
                Position arrayPosition = scanner.getPosition();
                match(Symbol.rightBracket);
                match(Symbol.ofRW);
                typeName = parseTypeName();
                match(Symbol.semicolon);
                arrayTypeDecl = new ArrayTypeDecl(operator, typeName, numElements);
                idTable.add(arrayTypeDecl);
                throw error(arrayPosition, "Invalid constant.");
            }

            match(Symbol.rightBracket);
            match(Symbol.ofRW);
            typeName = parseTypeName();
            match(Symbol.semicolon);

            arrayTypeDecl = new ArrayTypeDecl(operator, typeName, numElements);
            idTable.add(arrayTypeDecl);

            return arrayTypeDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("arrayTypeDecl"));
            if (cont == 0) {
                return null;
            } else {
                return arrayTypeDecl;
            }
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * typeName = "Integer" | "Boolean" | "Char" | typeId .
     */
    public Type parseTypeName() throws IOException {

        Type type = Type.UNKNOWN;

        try {

            if (scanner.getSymbol() == Symbol.IntegerRW) {
                type = Type.Integer;
                matchCurrentSymbol();
            } else if (scanner.getSymbol() == Symbol.BooleanRW) {
                type = Type.Boolean;
                matchCurrentSymbol();
            } else if (scanner.getSymbol() == Symbol.CharRW) {
                type = Type.Char;
                matchCurrentSymbol();
            } else if (scanner.getSymbol() == Symbol.identifier) {

                Token typeId = scanner.getToken();
                matchCurrentSymbol();
                Declaration decl = idTable.get(typeId);

                if (decl != null) {
                    if (decl instanceof ArrayTypeDecl) {
                        type = decl.getType();
                    } else {
                        throw error(typeId.getPosition(), "Identifier \""
                                + typeId + "\" is not a valid type name.");
                    }
                } else {
                    throw error(typeId.getPosition(), "Identifier \""
                            + typeId + "\" has not been declared.");
                }

            } else {
                throw error("Invalid type name.");
            }

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("typeName"));
        }

        return type;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * subprogramDecls = ( subprogramDecl )* .
     */
    public List<SubprogramDecl> parseSubprogramDecls() throws IOException {

        // código do parser esperado para o Projeto 03
        /*while ( scanner.getSymbol().isSubprogramDeclStarter() ) {
            parseSubprogramDecl();
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        List<SubprogramDecl> subprogDecls = new ArrayList<>();

        while (scanner.getSymbol().isSubprogramDeclStarter()) {
            SubprogramDecl decl = parseSubprogramDecl();
            subprogDecls.add(decl);
        }

        return subprogDecls;
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * subprogramDecl = procedureDecl | functionDecl .
     */
    public SubprogramDecl parseSubprogramDecl() throws IOException {

        // código do parser esperado para o Projeto 03
        /*if ( scanner.getSymbol() == Symbol.procedureRW ) {
            parseProcedureDecl();
        } else if ( scanner.getSymbol() == Symbol.functionRW ) {
            parseFunctionDecl();
        } else {
            throw internalError( "Invalid subprogram decl." );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        if (scanner.getSymbol() == Symbol.procedureRW) {
            return parseProcedureDecl();
        } else if (scanner.getSymbol() == Symbol.functionRW) {
            return parseFunctionDecl();
        } else {
            throw internalError("Invalid subprogram decl.");
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * procedureDecl = "procedure" procId ( formalParameters )? "is"
     * initialDecls statementPart procId ";" .
     */
    public ProcedureDecl parseProcedureDecl() throws IOException {

        try {

            match(Symbol.procedureRW);
            Token procId = scanner.getToken();
            match(Symbol.identifier);
            ProcedureDecl procDecl = new ProcedureDecl(procId);
            idTable.add(procDecl);
            idTable.openScope();

            if (scanner.getSymbol() == Symbol.leftParen) {
                procDecl.setFormalParams(parseFormalParameters());
            }

            match(Symbol.isRW);
            procDecl.setInitialDecls(parseInitialDecls());

            subprogramContext.beginSubprogramDecl(procDecl);
            procDecl.setStatementPart(parseStatementPart());
            subprogramContext.endSubprogramDecl();
            idTable.closeScope();

            Token procId2 = scanner.getToken();
            match(Symbol.identifier);

            if (!procId.getText().equals(procId2.getText())) {
                throw error(procId2.getPosition(), "Procedure name mismatch.");
            }

            match(Symbol.semicolon);

            return procDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("procedureDecl"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * functionDecl = "function" funcId ( formalParameters )? "return" typeName
     * "is" initialDecls statementPart funcId ";" .
     */
    public FunctionDecl parseFunctionDecl() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.functionRW );
            Token funcId = scanner.getToken();
            match( Symbol.identifier );
            idTable.add( funcId, IdType.functionId );
            idTable.openScope();
            
            if ( scanner.getSymbol() == Symbol.leftParen ) {
                parseFormalParameters();
            }
            
            match( Symbol.returnRW );
            
            parseTypeName();
            
            match( Symbol.isRW );
            parseInitialDecls();
            parseStatementPart();
            idTable.closeScope();

            Token procId2 = scanner.getToken();
            match( Symbol.identifier );

            if ( !funcId.getText().equals( procId2.getText() ) ) {
                throw error( procId2.getPosition(), "Function name mismatch." );
            }

            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "functionDecl" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            match(Symbol.functionRW);
            Token funcId = scanner.getToken();
            match(Symbol.identifier);
            FunctionDecl funcDecl = new FunctionDecl(funcId);
            idTable.add(funcDecl);
            idTable.openScope();

            if (scanner.getSymbol() == Symbol.leftParen) {
                funcDecl.setFormalParams(parseFormalParameters());
            }

            match(Symbol.returnRW);

            Type typeName = parseTypeName();
            funcDecl.setType(typeName);

            match(Symbol.isRW);
            funcDecl.setInitialDecls(parseInitialDecls());
            subprogramContext.beginSubprogramDecl(funcDecl);
            funcDecl.setStatementPart(parseStatementPart());
            subprogramContext.endSubprogramDecl();
            idTable.closeScope();

            Token procId2 = scanner.getToken();
            match(Symbol.identifier);

            if (!funcId.getText().equals(procId2.getText())) {
                throw error(procId2.getPosition(), "Function name mismatch.");
            }

            match(Symbol.semicolon);

            return funcDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("functionDecl"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * formalParameters = "(" parameterDecl ( "," parameterDecl )* ")" .
     */
    public List<ParameterDecl> parseFormalParameters() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.leftParen );
            
            parseParameterDecl();
            
            while ( scanner.getSymbol() == Symbol.comma ) {
                matchCurrentSymbol();
                parseParameterDecl();
            }
            
            match( Symbol.rightParen );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "formalParameters" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            match(Symbol.leftParen);
            List<ParameterDecl> parameterDecl = new ArrayList<>();

            parameterDecl.add(parseParameterDecl());

            while (scanner.getSymbol() == Symbol.comma) {
                matchCurrentSymbol();
                parameterDecl.add(parseParameterDecl());
            }

            match(Symbol.rightParen);

            return parameterDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("formalParameters"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * parameterDecl = ( "var" )? paramId ":" typeName .
     */
    public ParameterDecl parseParameterDecl() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            if ( scanner.getSymbol() == Symbol.varRW ) {
                matchCurrentSymbol();
            }
            
            Token paramId = scanner.getToken();
            match( Symbol.identifier );
            idTable.add( paramId, IdType.variableId );
            
            match( Symbol.colon );
            
            parseTypeName();
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "parameterDecl" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            boolean isVarParam = false;
            if (scanner.getSymbol() == Symbol.varRW) {
                matchCurrentSymbol();
                isVarParam = true;
            }

            Token paramId = scanner.getToken();
            match(Symbol.identifier);

            match(Symbol.colon);

            Type typeName = parseTypeName();

            idTable.getScopeLevel();

            ParameterDecl paramDecl = new ParameterDecl(paramId, typeName, isVarParam);
            idTable.add(paramDecl);
            return paramDecl;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("parameterDecl"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * statementPart = "begin" statements "end" .
     */
    public StatementPart parseStatementPart() throws IOException {

        try {
            match(Symbol.beginRW);
            List<Statement> statements = parseStatements();
            match(Symbol.endRW);
            return new StatementPart(statements);
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("statementPart"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * statements = ( statement )* .
     */
    public List<Statement> parseStatements() throws IOException {

        // código do parser esperado para o Projeto 03
        /*while ( scanner.getSymbol().isStmtStarter() ) {
            parseStatement();
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        List<Statement> statements = new ArrayList<>();

        while (scanner.getSymbol().isStmtStarter()) {
            Statement stmt = parseStatement();
            statements.add(stmt);
        }
        return statements;
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * statement = assignmentStmt | ifStmt | loopStmt | exitStmt | readStmt |
     * writeStmt | writelnStmt | procedureCallStmt | returnStmt .
     */
    public Statement parseStatement() throws IOException {

        // assume que scanner.getSymbol() pode iniciar uma instrução
        assert scanner.getSymbol().isStmtStarter() : "Invalid statement.";

        // código do parser esperado para o Projeto 03
        /*try {
            
            if ( scanner.getSymbol() == Symbol.exitRW ) {
                parseExitStmt();
            } else if ( scanner.getSymbol() == Symbol.identifier ) {
                
                IdType idType = idTable.get( scanner.getToken() );
                
                if ( idType == null ) {
                    String errorMsg = "Identifier \"" + scanner.getToken() + 
                                      "\" has not been declared.";
                    throw error( scanner.getToken().getPosition(), errorMsg );
                } else if ( idType == IdType.variableId ) {
                    parseAssignmentStmt();
                } else if ( idType == IdType.procedureId ) {
                    parseProcedureCallStmt();
                } else if ( idType == IdType.constantId ) {
                    String errorMsg = "Identifier \"" + scanner.getToken() + 
                                      "\" cannot start a statement.";
                    throw error( scanner.getToken().getPosition(), errorMsg );
                }

            } else if ( scanner.getSymbol() == Symbol.ifRW ) {
                parseIfStmt();
            } else if ( scanner.getSymbol() == Symbol.loopRW ) {
                parseLoopStmt();
            } else if ( scanner.getSymbol() == Symbol.whileRW ) {
                parseLoopStmt();
            } else if ( scanner.getSymbol() == Symbol.readRW ) {
                parseReadStmt();
            } else if ( scanner.getSymbol() == Symbol.writeRW ) {
                parseWriteStmt();
            } else if ( scanner.getSymbol() == Symbol.writelnRW ) {
                parseWritelnStmt();
            } else if ( scanner.getSymbol() == Symbol.returnRW ) {
                parseReturnStmt();
            } else {
                throw internalError( "Invalid statement." );
            }
        
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            scanner.advanceTo( Symbol.semicolon );
            recover( FOLLOW_SETS.get( "statement" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            if (scanner.getSymbol() == Symbol.exitRW) {
                return parseExitStmt();
            } else if (scanner.getSymbol() == Symbol.identifier) {

                Declaration decl = idTable.get(scanner.getToken());

                if (decl == null) {
                    String errorMsg = "Identifier \"" + scanner.getToken()
                            + "\" has not been declared.";
                    throw error(scanner.getToken().getPosition(), errorMsg);
                } else if (decl instanceof NamedDecl) {
                    return parseAssignmentStmt();
                } else if (decl instanceof ProcedureDecl) {
                    return parseProcedureCallStmt();
                } else if (decl instanceof ConstDecl) {
                    String errorMsg = "Identifier \"" + scanner.getToken()
                            + "\" cannot start a statement.";
                    throw error(scanner.getToken().getPosition(), errorMsg);
                } else {
                    String errorMsg = "Identifier \"" + scanner.getToken()
                            + "\" has not been declared.";
                    throw error(scanner.getToken().getPosition(), errorMsg);
                }
                // return parseAssignmentStmt();

            } else if (scanner.getSymbol() == Symbol.ifRW) {
                return parseIfStmt();
            } else if (scanner.getSymbol() == Symbol.loopRW) {
                return parseLoopStmt();
            } else if (scanner.getSymbol() == Symbol.whileRW) {
                return parseLoopStmt();
            } else if (scanner.getSymbol() == Symbol.readRW) {
                return parseReadStmt();
            } else if (scanner.getSymbol() == Symbol.writeRW) {
                return parseWriteStmt();
            } else if (scanner.getSymbol() == Symbol.writelnRW) {
                return parseWritelnStmt();
            } else if (scanner.getSymbol() == Symbol.returnRW) {
                return parseReturnStmt();
            } else {
                String errorMsg = "Invalid statement.";
                throw error(scanner.getToken().getPosition(), errorMsg);
            }
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            scanner.advanceTo(Symbol.semicolon);
            recover(FOLLOW_SETS.get("statement"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * assignmentStmt = variable ":=" expression ";" .
     */
    public AssignmentStmt parseAssignmentStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            parseVariable();
            
            try {
                
                match( Symbol.assign );
                
            } catch ( ParserException e ) {
                
                if ( scanner.getSymbol() == Symbol.equals ) {
                    ErrorHandler.getInstance().reportError( e );
                    matchCurrentSymbol();  // tratar "=" como ":="
                                           // nesse contexto
                } else {
                    throw e;
                }
                
            }
            
            parseExpression();
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "assignmentStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {

            Variable variable = parseVariable();
            Position assignPosition = scanner.getPosition();
            try {

                match(Symbol.assign);

            } catch (ParserException e) {

                if (scanner.getSymbol() == Symbol.equals) {
                    ErrorHandler.getInstance().reportError(e);
                    matchCurrentSymbol();  // tratar "=" como ":="
                    // nesse contexto
                } else {
                    throw e;
                }
            }

            Expression expr = parseExpression();
            match(Symbol.semicolon);

            return new AssignmentStmt(variable, expr, assignPosition);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("assignmentStmt"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * ifStmt = "if" booleanExpr "then" statements ( "elsif" booleanExpr "then"
     * statements )* ( "else" statements )? "end" "if" ";" .
     */
    public IfStmt parseIfStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.ifRW );
            parseExpression();
            match( Symbol.thenRW );
            
            parseStatements();
            
            while ( scanner.getSymbol() == Symbol.elsifRW ) {
                match( Symbol.elsifRW );
                parseExpression();
                match( Symbol.thenRW );
                parseStatements();
            }
            
            if ( scanner.getSymbol() == Symbol.elseRW ) {
                match( Symbol.elseRW );
                parseStatements();
            }
        
            match( Symbol.endRW );
            match( Symbol.ifRW );
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "ifStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            List<ElsifPart> elsifParts = new ArrayList<>();
            List<Statement> elseStmts = new ArrayList<>();
            match(Symbol.ifRW);
            Expression booleanExpr = parseExpression();
            match(Symbol.thenRW);
            List<Statement> thenStmts = parseStatements();

            while (scanner.getSymbol() == Symbol.elsifRW) {
                parseStatement();
                match(Symbol.elsifRW);
                parseExpression();
                match(Symbol.thenRW);
                parseStatements();
            }

            if (scanner.getSymbol() == Symbol.elseRW) {
                match(Symbol.elseRW);
                Statement stmt = parseStatement();
                elseStmts.add(stmt);
            }

            match(Symbol.endRW);
            match(Symbol.ifRW);
            match(Symbol.semicolon);

            IfStmt ifStmt = new IfStmt(booleanExpr, thenStmts, elsifParts, elseStmts);

            return ifStmt;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("ifStmt"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * loopStmt = ( "while" booleanExpr )? "loop" statements "end" "loop" ";" .
     */
    public LoopStmt parseLoopStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            if ( scanner.getSymbol() == Symbol.whileRW ) {
                matchCurrentSymbol();
                parseExpression();
            }

            match( Symbol.loopRW );
            parseStatements();

            match( Symbol.endRW );
            match( Symbol.loopRW );
            match( Symbol.semicolon );
        
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "loopStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            Expression booleanExpr = null;
            if (scanner.getSymbol() == Symbol.whileRW) {
                matchCurrentSymbol();
                booleanExpr = parseExpression();
            }

            match(Symbol.loopRW);
            LoopStmt loopStmt = new LoopStmt();
            loopStmt.setWhileExpr(booleanExpr);
            loopContext.beginLoop(loopStmt);
            loopStmt.setStatements(parseStatements());
            parseStatements();
            loopContext.endLoop();

            match(Symbol.endRW);
            match(Symbol.loopRW);
            match(Symbol.semicolon);

            return loopStmt;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("loopStmt"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * exitStmt = "exit" ( "when" booleanExpr )? ";" .
     */
    public ExitStmt parseExitStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.exitRW );
            
            if ( scanner.getSymbol() == Symbol.whenRW ) {
                matchCurrentSymbol();
                parseExpression();
            }
            
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "exitStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            Position exitPosition = scanner.getPosition();
            match(Symbol.exitRW);

            Expression whenExpr = null;

            if (scanner.getSymbol() == Symbol.whenRW) {
                matchCurrentSymbol();
                whenExpr = parseExpression();
            }

            match(Symbol.semicolon);

            LoopStmt loopStmt = loopContext.getLoopStmt();
            if (loopStmt == null) {
                throw error(exitPosition,
                        "Exit statement is not nested within a loop.");
            }
            return new ExitStmt(whenExpr, loopStmt);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("exitStmt"));
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * readStmt = "read" variable ";" .
     */
    public ReadStmt parseReadStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.readRW );
            parseVariableExpr();
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "readStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {

            match(Symbol.readRW);
            ReadStmt readStmt = new ReadStmt(parseVariableExpr());
            match(Symbol.semicolon);
            return readStmt;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("readStmt"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * writeStmt = "write" expressions ";" .
     */
    public WriteStmt parseWriteStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.writeRW );
            parseExpressions();
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "writeStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {

            match(Symbol.writeRW);
            List<Expression> expressions = parseExpressions();
            match(Symbol.semicolon);

            return new WriteStmt(expressions);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("writeStmt"));
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * expressions = expression ( "," expression )* .
     */
    public List<Expression> parseExpressions() throws IOException {

        // código do parser esperado para o Projeto 03
        /*parseExpression();
        
        while ( scanner.getSymbol() == Symbol.comma ) {
            matchCurrentSymbol();
            parseExpression();
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        List<Expression> expressions = new ArrayList<>();
        expressions.add(parseExpression());

        while (scanner.getSymbol() == Symbol.comma) {
            matchCurrentSymbol();
            expressions.add(parseExpression());
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        return expressions;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * writelnStmt = "writeln" ( expressions )? ";" .
     */
    public WritelnStmt parseWritelnStmt() throws IOException {

        try {

            match(Symbol.writelnRW);

            List<Expression> expressions;
            if (scanner.getSymbol().isExprStarter()) {
                expressions = parseExpressions();
            } else {
                expressions = Collections.emptyList();
            }

            match(Symbol.semicolon);

            return new WritelnStmt(expressions);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("writelnStmt"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * procedureCallStmt = procId ( actualParameters )? ";" .
     */
    public ProcedureCallStmt parseProcedureCallStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.identifier );
            
            if ( scanner.getSymbol().isExprStarter() ) {
                parseActualParameters();
            }
            
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "procedureCallStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {

            Token procId = scanner.getToken();
            match(Symbol.identifier);

            List<Expression> actualParams = null;

            if (scanner.getSymbol().isExprStarter()) {
                actualParams = parseActualParameters();
            }

            match(Symbol.semicolon);

            Declaration decl = idTable.get(procId);

            ProcedureDecl procedureDecl = (ProcedureDecl) decl;

            return new ProcedureCallStmt(procId, actualParams, procedureDecl);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("procedureCallStmt"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * actualParameters = "(" expressions ")" .
     */
    public List<Expression> parseActualParameters() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.leftParen );
            parseExpressions();
            match( Symbol.rightParen );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "actualParameters" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            match(Symbol.leftParen);
            List<Expression> listExp = parseExpressions();
            match(Symbol.rightParen);

            return listExp;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("actualParameters"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * returnStmt = "return" ( expression )? ";" .
     */
    public ReturnStmt parseReturnStmt() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.returnRW );
            
            if ( scanner.getSymbol().isExprStarter() ) {
                parseExpression();
            }
            
            match( Symbol.semicolon );
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "returnStmt" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            Position returnPosition = scanner.getPosition();
            Expression parseExpression = null;

            match(Symbol.returnRW);

            if (scanner.getSymbol().isExprStarter()) {
                parseExpression = parseExpression();
            } else if (idTable.getScopeLevel() != ScopeLevel.SUBPROGRAM) {
                throw error(returnPosition,
                        "Return statement is not nested within a subprogram.");
            }

            match(Symbol.semicolon);
            SubprogramDecl subprogramDecl = subprogramContext.getSubprogramDecl();
            return new ReturnStmt(subprogramDecl, parseExpression, returnPosition);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("returnStmt"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * variable = ( varId | paramId ) ( "[" expression "]" )* .
     *
     * Esse método auxiliar provê uma lógica comum aos métodos parseVariable() e
     * parseNamedValue(). Esse método não lida com quaisquer exceções geradas
     * pelo parser (ParseException), lançando-as ao método chamador para que
     * possam ser manipuladas apropriadamente.
     *
     * @throws ParserException se a análise falhar.
     * @see #parseVariable()
     * @see #parseNamedValue()
     */
    public Variable parseVariableExpr() throws IOException, ParserException {

        Token idToken = scanner.getToken();
        match(Symbol.identifier);
        Declaration decl = idTable.get(idToken);

        if (decl == null) {

            String errorMsg = "Identifier \"" + idToken
                    + "\" has not been declared.";
            throw error(idToken.getPosition(), errorMsg);

        } else if (!(decl instanceof NamedDecl)) {

            String errorMsg = "Identifier \"" + idToken
                    + "\" is not a variable.";
            throw error(idToken.getPosition(), errorMsg);

        }

        NamedDecl namedDecl = (NamedDecl) decl;
        List<Expression> indexExprs = new ArrayList<>();

        while (scanner.getSymbol() == Symbol.leftBracket) {
            matchCurrentSymbol();
            indexExprs.add(parseExpression());
            match(Symbol.rightBracket);
        }

        return new Variable(namedDecl, idToken.getPosition(), indexExprs);
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * variable = ( varId | paramId ) ( "[" expression "]" )* .
     */
    public Variable parseVariable() throws IOException {

        try {
            return parseVariableExpr();
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("variable"));
            return null;
        }
    }

    /**
     * Analisa as regras gramaticais abaixo:
     *
     * expression = relation ( logicalOp relation )* . logicalOp = "and" | "or"
     * .
     */
    public Expression parseExpression() throws IOException {

        Expression expr = parseRelation();

        while (scanner.getSymbol().isLogicalOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression expr2 = parseRelation();
            expr = new LogicalExpr(expr, operator, expr2);
        }

        return expr;
    }

    /**
     * Analisa as regras gramaticais abaixo:
     *
     * relation = simpleExpr ( relationalOp simpleExpr )? . relationalOp = "=" |
     * "!=" | "<" | "<=" | ">" | ">=" .
     */
    public Expression parseRelation() throws IOException {

        // código do parser esperado para o Projeto 03
        /*parseSimpleExpr();
        
        if ( scanner.getSymbol().isRelationalOperator() ) {
            matchCurrentSymbol();
            parseSimpleExpr();
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        Expression expr = parseSimpleExpr();

        if (scanner.getSymbol().isRelationalOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression simpleExpr = parseSimpleExpr();
            expr = new RelationalExpr(expr, operator, simpleExpr);

        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        return expr;
    }

    /**
     * Analisa as regras gramaticais abaixo:
     *
     * simpleExpr = ( addingOp )? term ( addingOp term )* . addingOp = "+" | "-"
     * .
     */
    public Expression parseSimpleExpr() throws IOException {

        // código do parser esperado para o Projeto 03
        /*if ( scanner.getSymbol().isAddingOperator() ) {
            matchCurrentSymbol();
        }
        
        parseTerm();
        
        while ( scanner.getSymbol().isAddingOperator() ) {
            matchCurrentSymbol();
            parseTerm();
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        Expression expr;

        if (scanner.getSymbol().isAddingOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression operand = parseTerm();
            expr = new NegationExpr(operator, operand);
        } else {
            expr = parseTerm();
        }

        while (scanner.getSymbol().isAddingOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression termExpr = parseTerm();
            expr = new AddingExpr(expr, operator, termExpr);
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        return expr;
    }

    /**
     * Analisa as regras gramaticais abaixo:
     *
     * term = factor ( multiplyingOp factor )* . multiplyingOp = "*" | "/" |
     * "mod" .
     */
    public Expression parseTerm() throws IOException {

        // código do parser esperado para o Projeto 03
        /*parseFactor();
        
        while ( scanner.getSymbol().isMultiplyingOperator() ) {
            matchCurrentSymbol();
            parseFactor();
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        Expression expr = parseFactor();
        while (scanner.getSymbol().isMultiplyingOperator()) {
            Token operator = scanner.getToken();
            matchCurrentSymbol();
            Expression factorExpr = parseFactor();
            expr = new MultiplyingExpr(expr, operator, factorExpr);
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        return expr;
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * factor = "not" factor | constValue | namedValue | functionCall | "("
     * expression ")" .
     */
    public Expression parseFactor() throws IOException {

        try {

            Expression expr;

            if (scanner.getSymbol() == Symbol.notRW) {

                Token operator = scanner.getToken();
                matchCurrentSymbol();
                Expression factorExpr = parseFactor();
                expr = new NotExpr(operator, factorExpr);

            } else if (scanner.getSymbol().isLiteral()) {

                // lida com literais de constantes separadamente dos
                // identificadores de constantes
                expr = parseConstValue();

            } else if (scanner.getSymbol() == Symbol.identifier) {

                // lida com os identificadores baseando-se se eles foram
                // declarados como variáveis, constantes ou funções.
                Token idToken = scanner.getToken();
                Declaration decl = idTable.get(idToken);

                if (decl != null) {
                    if (decl instanceof ConstDecl) {
                        expr = parseConstValue();
                    } else if (decl instanceof NamedDecl) {
                        expr = parseNamedValue();
                    } else if (decl instanceof FunctionDecl) {
                        expr = parseFunctionCall();
                    } else {
                        throw error("Identifier \"" + scanner.getToken()
                                + "\" is not valid as an expression.");
                    }
                } else {
                    throw error("Identifier \"" + scanner.getToken()
                            + "\" has not been declared.");
                }

            } else if (scanner.getSymbol() == Symbol.leftParen) {
                matchCurrentSymbol();
                expr = parseExpression();
                match(Symbol.rightParen);
            } else {
                throw error("Invalid expression.");
            }

            return expr;

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("factor"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * constValue = literal | constId .
     */
    public ConstValue parseConstValue() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            if ( scanner.getSymbol().isLiteral() ) {
                parseLiteral();
            } else if ( scanner.getSymbol() == Symbol.identifier ) {
                matchCurrentSymbol();
            } else {
                throw error( "Invalid constant." );
            }
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "constValue" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {

            if (scanner.getSymbol().isLiteral()) {
                Token idToken = parseLiteral();
                return new ConstValue(idToken);

            } else if (scanner.getSymbol() == Symbol.identifier) {
                Token idToken = scanner.getToken();

                matchCurrentSymbol();

                Declaration decl = idTable.get(idToken);

                ConstDecl constDecl = (ConstDecl) decl;

                return new ConstValue(idToken, constDecl);
            } else {
                throw error("Invalid constant.");
            }

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("constValue"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;

    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * namedValue = variable .
     */
    public NamedValue parseNamedValue() throws IOException {

        try {
            Variable variableExpr = parseVariableExpr();
            return new NamedValue(variableExpr);
        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("namedValue"));
            return null;
        }
    }

    /**
     * Analisa a regra gramatical abaixo:
     *
     * functionCall = funcId ( actualParameters )? .
     */
    public FunctionCall parseFunctionCall() throws IOException {

        // código do parser esperado para o Projeto 03
        /*try {
            
            match( Symbol.identifier );
            
            if ( scanner.getSymbol().isExprStarter() ) {
                parseActualParameters();
            }
            
        } catch ( ParserException e ) {
            ErrorHandler.getInstance().reportError( e );
            recover( FOLLOW_SETS.get( "functionCall" ) );
        }*/
        // <editor-fold defaultstate="collapsed" desc="Implementação">
        // sua implementação aqui
        try {
            Token funcId = scanner.getToken();

            match(Symbol.identifier);
            List<Expression> actualParams;

            if (scanner.getSymbol().isExprStarter()) {
                actualParams = parseActualParameters();
            } else {
                actualParams = Collections.emptyList();
            }

            Declaration decl = idTable.get(funcId);

            FunctionDecl functionDecl = (FunctionDecl) decl;

            return new FunctionCall(funcId, actualParams, functionDecl);

        } catch (ParserException e) {
            ErrorHandler.getInstance().reportError(e);
            recover(FOLLOW_SETS.get("functionCall"));
            return null;
        }
        // </editor-fold>
        /* a linha abaixo está presente apenas para evitar erros
         * ela deve ser modificada para que o seja feito o que é esperado
         * seja inserindo-a em outra posição etc.
         */
        //return null;
    }

    /**
     * *************************************************************************
     * Métodos utilitários de análise *
     * ************************************************************************
     */
    /**
     * Verifica se o símbolo atual do scanner é o símbolo esperado. Se for,
     * avança o scanner. Caso contrário, lança uma ParserException.
     */
    private void match(Symbol expectedSymbol) throws IOException, ParserException {

        if (scanner.getSymbol() == expectedSymbol) {
            scanner.advance();
        } else {
            String errorMsg = "Expecting \"" + expectedSymbol
                    + "\" but found \"" + scanner.getToken()
                    + "\" instead.";
            throw error(errorMsg);
        }
    }

    /**
     * Avança o scanner. Esse método representa uma correspondência
     * incondicional com o símbolo atual do scanner.
     */
    private void matchCurrentSymbol() throws IOException {
        scanner.advance();
    }

    /**
     * Avança o scanner até que o símbolo atual seja um dos símbolos
     * especificados no array de símbolos seguidores (follow).
     */
    private void recover(Symbol[] followers) throws IOException {
        scanner.advanceTo(followers);
    }

    /**
     * Cria uma ParserException com a mensagem especificada e a posição corrente
     * do scanner.
     */
    private ParserException error(String errMsg) {
        return new ParserException(scanner.getPosition(), errMsg);
    }

    /**
     * Cria uma ParserException especificando a posição atual do scanner e a
     * mensagem do erro.
     */
    private ParserException error(Position errPos, String errMsg) {
        return new ParserException(errPos, errMsg);
    }

    /**
     * Cria uma InternalCompilerException especificando a posição atual do
     * scanner e a mensagem do erro.
     */
    private InternalCompilerException internalError(String message) {
        return new InternalCompilerException(scanner.getPosition(), message);
    }
}

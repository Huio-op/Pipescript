grammar Pipescript;

/*---------------- COMPILER INTERNALS ----------------*/

@header
{
    import java.util.Map;
    import java.util.LinkedHashMap;
}

@members
{
    Map<String, Integer> memory = new LinkedHashMap<String, Integer>();
    Integer counter = 1;
    Integer ifCounter = 1;

    public static void emit(String s) {
	    System.out.println(s);
    }

    public static void main(String[] args) throws Exception
    {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        PipescriptLexer lexer = new PipescriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PipescriptParser parser = new PipescriptParser(tokens);
        parser.program();
    }
}

/*---------------- LEXER RULES ----------------*/

PLUS          : '+' ;
MINUS         : '-' ;
TIMES         : '*' ;
OVER          : '/' ;
OPEN_C        : '{' ;
CLOSE_C       : '}' ;
OPEN_B        : '[' ;
CLOSE_B       : ']' ;
OPEN_P        : '(' ;
CLOSE_P       : ')' ;
PIPE          : '|' ;
ATTRIB        : '<<' ;
EQUAL         : 'is' ;
DIFFER        : 'not' ;
LESSER        : 'lt' ;
LESSER_EQUAL  : 'lte' ;
GREATER       : 'gt' ;
GREATER_EQUAL : 'gte' ;
FUNC          : 'fun '[a-zA-Z]+ ('|'|' |') ;
//MAIN          : 'function' ;
PRINT         : 'text' ;
IF            : 'if' ;
ELSE          : 'else' ;
WHILE         : 'while' ;
COMMA         : ',' ;
SEMICOLON     : ';' ;
VAR           : [a-zA-Z]+ ;
NUM           : '0'..'9'+ ;
STRING        : '"' ~["]* '"' ;
NL            : ('\r')? '\n' ;
WS            : [ \t\r]+ -> skip ; // skip spaces and tabs

/*---------------- PARSER RULES ----------------*/

program
    :  main
    ;

main
    :
        FUNC OPEN_C
            {
                System.out.println(".source Output.j");
                System.out.println(".class  public Output");
                System.out.println(".super  java/lang/Object\n");
                System.out.println(".method public <init>()V");
                System.out.println("aload_0");
                System.out.println("invokenonvirtual java/lang/Object/<init>()V");
                System.out.println("return");
                System.out.println(".end method\n");
                System.out.println(".method public static main([Ljava/lang/String;)V\n");
            }
        (statement) * CLOSE_C NL
            {
                System.out.println("return");
                System.out.println(".limit stack 50");
                System.out.println(".limit locals 50");
                System.out.println(".end method");
            }
    ;

statement
    :
        NL                    |
        call_function         |
        statement_if          |
        statement_else        |
        statement_while       |
        assignment
    ;

statement_if
    :
        { Integer tempIf = ifCounter++; }
        IF PIPE expression op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression
            {

             emit(($op.type == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            }

        OPEN_C NL (statement)* CLOSE_C NL
            { emit("NOT_IF_" + tempIf + ": "); }
    ;

statement_else
    :
        { Integer tempIfElse = ifCounter++; }
        IF PIPE expression op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression
            { emit(($op.type == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); }

        OPEN_C NL (statement) *
            { emit("goto END_IF_ELSE_" + tempIfElse + " ; "); }

        CLOSE_C ELSE OPEN_C NL
            { emit("NOT_IF_" + tempIfElse + ": "); }

        (statement) * CLOSE_C NL
            { emit("END_IF_ELSE_" + tempIfElse + ": "); }
    ;

statement_while
    :
        { Integer tempWhile = ifCounter++;
          emit("START_WHILE_" + tempWhile + ": ");
        }
        WHILE PIPE expression op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression
            { emit(($op.type == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); }

        OPEN_C NL (statement)*
            { emit("goto START_WHILE_" + tempWhile + " ; "); }

        CLOSE_C NL
            { emit("END_WHILE_" + tempWhile + ": "); }
    ;

function_printInteger
    :
        PRINT PIPE
            { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }

        expression
            { System.out.println("invokevirtual java/io/PrintStream/println(I)V\n"); }
    ;

function_printString
    :
        PRINT PIPE
            { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }

        STRING { System.out.println("ldc " + $STRING.text); }
            { System.out.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"); }
    ;

call_function
    :
        (function_printInteger       |
        function_printString)
        SEMICOLON
    ;

assignment
    :
        VAR ATTRIB ( expression | call_function )
    	{
    	    if (!memory.containsKey($VAR.text)) memory.put($VAR.text, counter++);
            System.out.println("istore " + memory.get($VAR.text));
        } SEMICOLON
    ;

expression
    :
        term ( op = ( PLUS | MINUS ) term
            { System.out.println(($op.type == PLUS) ? "iadd" : "isub"); }
        )*
    ;

term
    :
        factor ( op = ( TIMES | OVER ) factor
             { System.out.println(($op.type == TIMES) ? "imul" : "idiv"); }
        )*
    ;

factor
    :
        NUM
        { System.out.println("ldc " + $NUM.text); } |

        VAR
    	{
    	    Integer v = memory.get($VAR.text);
            if (v != null)  System.out.println("iload " + v.intValue());
            else System.err.println("undefined variable " + $VAR.text);
    	} |

        VAR OPEN_B NUM CLOSE_B
        {
            Integer v = memory.get($VAR.text);
            if (v != null)  System.out.println("aload " + v.intValue());
            else System.err.println("undefined variable " + $VAR.text);
            System.out.println("ldc " + $NUM.text);
            System.out.println("iaload");
        } |

        OPEN_P expression CLOSE_P
    ;

grammar Pipescript;

/*---------------- COMPILER INTERNALS ----------------*/

@header
{
    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;
}

@members
{
    Map<String, List<Var>> memory = new LinkedHashMap<String, List<Var>>();
    Map<String, Integer> stackCounter = new LinkedHashMap<String, Integer>();
    Integer counter = 1;
    Integer ifCounter = 1;

    public static class Var {
        public String name;
        public String type;
        public Integer stackPos;

        public Var (String name, String type, Integer stack) {
            this.name = name;
            this.type = type;
            this.stackPos = stack;
        }

        public boolean isOnStack() {
            if (stackPos != null) {
                return false;
            }
            return true;
        }

        public Integer getStackPos() {
            return stackPos;
        }

        public String toString() {
            return "{" + this.name + ", " + this.type + ", " + this.stackPos + "}";
        }
    }

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
DIV           : '/' ;
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
FUNC          : 'fun' ;
MAIN          : 'main' ;
PRINT         : 'text' ;
IF            : 'if' ;
ELSE          : 'else' ;
WHILE         : 'while' ;
COMMA         : ',' ;
SEMICOLON     : ';' ;
VAR           : [a-zA-Z]+ ~[type | FUNC] ;
NUM           : '0'..'9'+ ;
STRING        : '"' ~["]* '"' ;
NL            : ('\r')? '\n' ;
WS            : [ \t\r]+ -> skip ; // skip spaces and tabs
INT_VAR       : 'int' ;
DOUBLE_VAR    : 'double' ;
STRING_VAR    : 'str' ;
CHAR_VAR      : 'char' ;
BOOL_VAR      : 'bool' ;
VOID_VAR      : 'void' ;
NULL_VAR      : 'null' ;

/*---------------- PARSER RULES ----------------*/

program
    :  main (NL)* (function)*
    ;

main
    :
        FUNC MAIN PIPE OPEN_C
            {
                if (!stackCounter.containsKey("main")) stackCounter.put("main", 0);

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
        (statement["main"]) * CLOSE_C NL
            {
                System.out.println("return");
                System.out.println(".limit stack 50");
                System.out.println(".limit locals 50");
                System.out.println(".end method");
            }
    ;

function
    :
        FUNC VAR PIPE OPEN_C
            {
                if (!stackCounter.containsKey($VAR.text)) stackCounter.put($VAR.text, 0);
                System.out.println(".method public static "+ $VAR.text +"([Ljava/lang/String;)V\n");
            }
        (statement[$VAR.text]) * CLOSE_C NL
            {
                System.out.println("return");
                System.out.println(".limit stack 50");
                System.out.println(".limit locals 50");
                System.out.println(".end method");
            }
    ;

statement [String funcName]
    :
        NL                          |
        call_function[funcName]     |
        statement_if[funcName]      |
        statement_else[funcName]    |
        statement_while[funcName]   |
        assignment[funcName]
    ;

statement_if [String funcName]
    :
        { Integer tempIf = ifCounter++; }
        IF PIPE expression[funcName] op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression[funcName]
            {

             emit(($op.type == EQUAL)            ? "    if_icmpne NOT_IF_" + tempIf + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIf + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge NOT_IF_" + tempIf + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIf + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple NOT_IF_" + tempIf + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIf + " ; " : "");            }

        OPEN_C NL (statement[funcName])* CLOSE_C NL
            { emit("NOT_IF_" + tempIf + ": "); }
    ;

statement_else [String funcName]
    :
        { Integer tempIfElse = ifCounter++; }
        IF PIPE expression[funcName] op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression[funcName]
            { emit(($op.type == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); }

        OPEN_C NL (statement[funcName]) *
            { emit("goto END_IF_ELSE_" + tempIfElse + " ; "); }

        CLOSE_C ELSE OPEN_C NL
            { emit("NOT_IF_" + tempIfElse + ": "); }

        (statement[funcName]) * CLOSE_C NL
            { emit("END_IF_ELSE_" + tempIfElse + ": "); }
    ;

statement_while [String funcName]
    :
        { Integer tempWhile = ifCounter++;
          emit("START_WHILE_" + tempWhile + ": ");
        }
        WHILE PIPE expression[funcName] op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression[funcName]
            { emit(($op.type == EQUAL)           ? "    if_icmpne END_WHILE_" + tempWhile + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq END_WHILE_" + tempWhile + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge END_WHILE_" + tempWhile + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt END_WHILE_" + tempWhile + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple END_WHILE_" + tempWhile + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt END_WHILE_" + tempWhile + " ; " : ""); }

        OPEN_C NL (statement[funcName])*
            { emit("goto START_WHILE_" + tempWhile + " ; "); }

        CLOSE_C NL
            { emit("END_WHILE_" + tempWhile + ": "); }
    ;

function_printInteger [String funcName]
    :
        PRINT PIPE
            { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }

        expression[funcName]
            { System.out.println("invokevirtual java/io/PrintStream/println(I)V\n"); }
    ;

function_printString
    :
        PRINT PIPE
            { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }

        STRING { System.out.println("ldc " + $STRING.text); }
            { System.out.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"); }
    ;

call_function [String funcName]
    :
        (function_printInteger[funcName] |
        function_printString)
        SEMICOLON
    ;

assignment [String funcName]
    :
        (op = INT_VAR | BOOL_VAR | CHAR_VAR | DOUBLE_VAR | STRING_VAR | VOID_VAR | NULL_VAR) VAR ATTRIB ( exp = expression[funcName] )
    	{
    	    List<Var> vars = memory.get(funcName);
            if (vars == null) {
                vars = new ArrayList<>();
            }
    	    boolean containsVar = vars.stream().anyMatch(var -> var.name.equals($VAR.text));
    	    if (!containsVar) {
                Integer stackCount = stackCounter.get(funcName);
    	        Var newVar = new Var($VAR.text, $op.text, stackCount);
    	        stackCounter.put(funcName, stackCount++);
                vars.add(newVar);
                memory.put(funcName, vars);
    	    }

    	    final Var currentVar = memory.get(funcName)
    	        .stream().filter(var -> var.name.equals($VAR.text)).findFirst().get();

    	    switch($op.type) {
    	        case INT_VAR:
    	        case CHAR_VAR:
    	            System.out.println("istore " + currentVar.stackPos);
                    break;
                case BOOL_VAR:
    	            System.out.println("bstore " + currentVar.stackPos);
                    break;
                case DOUBLE_VAR:
    	            System.out.println("dstore " + currentVar.stackPos);
                    break;
                default:
                    System.err.println("undefined variable " + $VAR.text);
            }
        } SEMICOLON
    ;

expression [String funcName]
    :
        term[funcName] ( op = ( PLUS | MINUS ) term[funcName]
            { System.out.println(($op.type == PLUS) ? "iadd" : "isub"); }
        )*
    ;

term [String funcName]
    :
        factor[funcName] ( op = ( TIMES | DIV ) factor[funcName]
             { System.out.println(($op.type == TIMES) ? "imul" : "idiv"); }
        )*
    ;

factor [String funcName]
    :
        NUM
        { System.out.println("ldc " + $NUM.text); } |

        VAR
    	{
    	    Var var = memory.get(funcName)
    	        .stream().filter(v -> v.name.equals($VAR.text)).findFirst().get();
            if (var != null)  System.out.println("iload " + var.stackPos);
            else System.err.println("undefined variable " + $VAR.text);
    	} |

        VAR OPEN_B NUM CLOSE_B
        {
            Var var = memory.get(funcName)
                	        .stream().filter(v -> v.name.equals($VAR.text)).findFirst().get();
            if (var != null)  System.out.println("aload " + var.stackPos);
            else System.err.println("undefined variable " + $VAR.text);
            System.out.println("ldc " + $NUM.text);
            System.out.println("iaload");
        } |

        OPEN_P expression[funcName] CLOSE_P
    ;

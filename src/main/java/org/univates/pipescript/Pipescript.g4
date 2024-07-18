grammar Pipescript;

/*---------------- COMPILER INTERNALS ----------------*/

@header
{
    import java.util.Map;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.function.Function;
    import java.util.Optional;
    import java.util.ArrayList;
    import java.util.Random;
    import javax.sound.sampled.*;
    import java.io.File;
}

@members
{
    Map<String, List<Var>> memory = new LinkedHashMap<String, List<Var>>();
    Map<String, Map<String, Integer>> stackCounter = new LinkedHashMap<String, Map<String, Integer>>();
    List<CustomFunction> functions = new ArrayList();
    Map<String, String> gotos = new LinkedHashMap<String, String>();
    Integer counter = 1;
    Integer ifCounter = 1;

    final Function<Var, String> loadVar = (Var var) -> {
        switch (var.type) {
            case "int":
            case "bool":
            case "char":
                return "iload " + var.stackPos;
            case "double":
                return "dload " + var.stackPos;
            case "str":
                return "aload " + var.stackPos;
            default:
                return "iload " + var.stackPos;
        }
    };

    final Function<Var, String> storeVar = (Var var) -> {
        switch (var.type) {
            case "int":
            case "bool":
            case "char":
                return "istore " + var.stackPos;
            case "double":
                return "dstore " + var.stackPos;
            case "str":
                return "astore " + var.stackPos;
            default:
                return "istore " + var.stackPos;
        }
    };

    final Function<String, String> getTypeString = (String type) -> {
        return switch(type) {
            case "int":
                yield "I";
            case "bool":
                yield "B";
            case "char":
                yield "C";
            case "double":
                yield "F";
            case "str":
                yield "Ljava/lang/String;";
            default:
                yield "V";
        };
    };

    public static class CustomFunction {
        public String name;
        public List<String> receivedTypes;
        public String returnType;

        public CustomFunction (String name, List<String> receivedTypes, String returnType) {
            this.name = name;
            this.receivedTypes = receivedTypes;
            this.returnType = returnType;
        }
    }

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
RETURN        : '>>' ;
EQUAL         : 'is' ;
DIFFER        : 'not' ;
LESSER        : 'lt' ;
LESSER_EQUAL  : 'lte' ;
GREATER       : 'gt' ;
GREATER_EQUAL : 'gte' ;
FUNC          : 'fun' ;
MAIN          : 'main' ;
PRINT         : 'text' ;
INT_SCANNER   : 'textInInt';
STR_SCANNER   : 'textInStr';
IF            : 'if' ;
ELSE          : 'else' ;
WHILE         : 'while' ;
COMMA         : ',' ;
SEMICOLON     : ';' ;
INT_VAR       : 'int' ;
DOUBLE_VAR    : 'double' ;
STRING_VAR    : 'str' ;
CHAR_VAR      : 'char' ;
BOOL_VAR      : 'bool' ;
VOID_VAR      : 'void' ;
NULL_VAR      : 'null' ;
READ          : 'read';
GOTO          : '@';
DEF_GOTO      : 'def@';
WRITE         : 'write';
SOUND         : 'sound';
NUM           : [0-9]+;
COMMENT       : '#' .*? '\n' -> channel(HIDDEN);
BREAK         : 'break';
TRUE          : 'true';
RANDOM        : 'rand';
VAR           : [a-zA-Z_][a-zA-Z0-9_]*;
STRING        : '"' ( ~["\\] | '\\' . )* '"';
NL            : ('\r')? '\n' ;
WS            : [ \t\r]+ -> skip ; // skip spaces and tabs

/*---------------- PARSER RULES ----------------*/

program
    :
        {
            System.out.println(".source Output.j");
            System.out.println(".class  public Output");
            System.out.println(".super  java/lang/Object\n");
            System.out.println(".method public <init>()V");
            System.out.println("aload_0");
            System.out.println("invokenonvirtual java/lang/Object/<init>()V");
            System.out.println("return");
            System.out.println(".end method\n");
        }
        (NL)* (function (NL)*)*  main (NL)*
    ;

main
    :
        FUNC MAIN PIPE OPEN_C
            {
                if (!stackCounter.containsKey("main")) stackCounter.put("main", new LinkedHashMap<String, Integer>());

                System.out.println(".method public static main([Ljava/lang/String;)V\n");
            }
        (statement["main", null]) * CLOSE_C (NL)*
            {
                System.out.println("return");
                System.out.println(".limit stack 50");
                System.out.println(".limit locals 50");
                System.out.println(".end method");
            }
    ;

function
    :
    {
        List<String> types = new ArrayList();
        List<String> names = new ArrayList();
    }
        FUNC (name = VAR) PIPE
          (types+=(INT_VAR | BOOL_VAR | CHAR_VAR | DOUBLE_VAR | STRING_VAR )?
            vars+=VAR (COMMA types+=(INT_VAR | BOOL_VAR | CHAR_VAR | DOUBLE_VAR | STRING_VAR ) vars+=VAR)*
          )?
          PIPE (ret = INT_VAR | BOOL_VAR | CHAR_VAR | DOUBLE_VAR | STRING_VAR | VOID_VAR )
          OPEN_C
            {
                if (!stackCounter.containsKey($name.text)) stackCounter.put($name.text, new LinkedHashMap());

                final List<Var> receivedVars = new ArrayList();
                for (int i = 0; i < $types.size(); i++) {
                    final String type = $types.get(i).getText();
                    final String name = $vars.get(i).getText();

                    Map<String, Integer> stackTypes = stackCounter.get($name.text);
                    Integer count = stackTypes.get(type);
                    if (count == null) {
                        count = 0;
                    }
                    final Var var = new Var(name, type, count);
                    receivedVars.add(var);

                    stackTypes.put(type, ++count);
                    stackCounter.put($name.text, stackTypes);
                }
                if (memory.containsKey($name.text)) {
                    System.err.println("function being overwritten " + $name.text);
                }

                memory.put($name.text, receivedVars);
                functions.add(new CustomFunction($name.text, $types.stream().map(t -> t.getText()).toList(), $ret.text));

                String returnType = switch($ret.type) {
                    case INT_VAR:
                        yield "I";
                    case BOOL_VAR:
                        yield "i";
                    case CHAR_VAR:
                        yield "i";
                    case DOUBLE_VAR:
                        yield "F";
                    case STRING_VAR:
                        yield "Ljava/lang/String;";
                    default:
                        yield "V";
                };

                String receivedTypes = receivedVars.stream()
                    .map(v -> getTypeString.apply(v.type))
                    .reduce("", String::concat);

                System.out.println(".method public static "+ $name.text +"("+ receivedTypes +")"+ returnType +"\n");
            }
        (statement[$name.text, null]) *
        RETURN expression[$name.text] SEMICOLON (NL)*
        CLOSE_C (NL)*
            {
                switch($ret.type) {
                    case INT_VAR:
                    case BOOL_VAR:
                    case CHAR_VAR:
                        System.out.println("ireturn");
                        break;
                    case DOUBLE_VAR:
                        System.out.println("dreturn");
                        break;
                    case STRING_VAR:
                        System.out.println("areturn");
                        break;
                    default:
                        System.out.println("return");
                        break;
                };
                System.out.println(".limit stack 50");
                System.out.println(".limit locals 50");
                System.out.println(".end method");
            }
    ;

statement [String funcName, Integer tempWhile]
    :
        NL                                          |
        call_function[funcName, tempWhile]          |
        statement_if[funcName, tempWhile]           |
        statement_else[funcName, tempWhile]         |
        statement_while[funcName]                   |
        statement_while_true[funcName]              |
        break[tempWhile]                            |
        def_goto[funcName]                          |
        goto[funcName]                              |
        assignment[funcName, tempWhile]
    ;

function_playSound [String funcName]
    :
        SOUND PIPE STRING
        {
            String filePath = $STRING.text.replaceAll("^\"|\"$", "");
            emit("new java/io/File");
            emit("dup");
            emit("ldc \"" + filePath + "\"");
            emit("invokespecial java/io/File/<init>(Ljava/lang/String;)V");
            emit("invokestatic javax/sound/sampled/AudioSystem/getAudioInputStream(Ljava/io/File;)Ljavax/sound/sampled/AudioInputStream;");
            emit("astore_1");
            emit("invokestatic javax/sound/sampled/AudioSystem/getClip()Ljavax/sound/sampled/Clip;");
            emit("astore_2");
            emit("aload_2");
            emit("aload_1");
            emit("invokeinterface javax/sound/sampled/Clip/open(Ljavax/sound/sampled/AudioInputStream;)V 2");
            emit("aload_2");
            emit("invokeinterface javax/sound/sampled/Clip/start()V 1");

            emit("aload_2");
            emit("invokeinterface javax/sound/sampled/Clip/getMicrosecondLength()J 1");
            emit("ldc2_w 1000");
            emit("ldiv");
            emit("invokestatic java/lang/Thread/sleep(J)V");
        }
    ;


statement_if [String funcName, Integer tempWhile]
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

        OPEN_C NL (statement[funcName, tempWhile])* CLOSE_C NL
            { emit("NOT_IF_" + tempIf + ": "); }
    ;

statement_else [String funcName, Integer tempWhile]
    :
        { Integer tempIfElse = ifCounter++; }
        IF PIPE expression[funcName] op = ( EQUAL | DIFFER | LESSER | LESSER_EQUAL | GREATER | GREATER_EQUAL ) expression[funcName]
            { emit(($op.type == EQUAL)           ? "    if_icmpne NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == DIFFER)        ? "    if_icmpeq NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == LESSER)        ? "    if_icmpge NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == LESSER_EQUAL)  ? "    if_icmpgt NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == GREATER)       ? "    if_icmple NOT_IF_" + tempIfElse + " ; " :
                     ($op.type == GREATER_EQUAL) ? "    if_icmplt NOT_IF_" + tempIfElse + " ; " : ""); }

        OPEN_C NL (statement[funcName, tempWhile]) *
            { emit("goto END_IF_ELSE_" + tempIfElse + " ; "); }

        CLOSE_C ELSE OPEN_C NL
            { emit("NOT_IF_" + tempIfElse + ": "); }

        (statement[funcName, tempWhile]) * CLOSE_C NL
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

        OPEN_C NL (statement[funcName, tempWhile])*
            { emit("goto START_WHILE_" + tempWhile + " ; "); }

        CLOSE_C NL
            { emit("END_WHILE_" + tempWhile + ": "); }
    ;

statement_while_true [String funcName]
    :
        { Integer tempWhile = ifCounter++;
          emit("START_WHILE_" + tempWhile + ": ");
        }
        WHILE PIPE TRUE

        OPEN_C NL
        (statement[funcName, tempWhile])*
        (break[tempWhile])?
        (statement[funcName, tempWhile])*
            { emit("goto START_WHILE_" + tempWhile + " ; "); }

        CLOSE_C NL
            { emit("END_WHILE_" + tempWhile + ": "); }
    ;

break   [Integer tempWhile]
    :
        BREAK SEMICOLON
        { emit("goto END_WHILE_" + tempWhile + " ; "); }
    ;

function_printInteger [String funcName]
    :
        PRINT PIPE
            { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }

        (var = expression[funcName])
            {
                final String expressionResult = $var.text;

                if (expressionResult.matches("^[a-zA-Z]+$")) {
                    final List<Var> memoryVars = memory.get(funcName);

                    final Var var = memoryVars.stream().filter(v -> v.name.equals(expressionResult)).findFirst()
                        .orElse(null);
                    if (var == null) {
                        System.err.println("Unknown variable " + expressionResult + " in function call text");
                        throw new RuntimeException("Unknown variable " + expressionResult + " in function call text");
                    }

                    final String returnType = getTypeString.apply(var.type);

                    System.out.println("invokevirtual java/io/PrintStream/println("+ returnType +")V\n");
                } else {
                    System.out.println("invokevirtual java/io/PrintStream/println(I)V\n");
                }
            }
    ;

function_printString
    :
        PRINT PIPE
            { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }

        STRING { System.out.println("ldc " + $STRING.text); }
            { System.out.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"); }
    ;

function_printVar [String funcName]
    :
        PRINT PIPE
          { System.out.println("getstatic java/lang/System/out Ljava/io/PrintStream;"); }
        VAR
            {
                final String varName = $VAR.text;
                final List<Var> memoryVars = memory.get(funcName);

                final Var var = memoryVars.stream().filter(v -> v.name.equals(varName)).findFirst()
                    .orElse(null);
                if (var == null) {
                    System.err.println("Unknown variable " + varName + " in function call text");
                    throw new RuntimeException("Unknown variable " + varName + " in function call text");
                }

                System.out.println(loadVar.apply(var));
                System.out.println("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n");
            }
    ;

function_scanInteger [String funcName]
    :
        INT_SCANNER PIPE
        {
            System.out.println("new java/util/Scanner");
            System.out.println("dup");
            System.out.println("getstatic java/lang/System/in Ljava/io/InputStream;");
            System.out.println("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
            System.out.println("invokevirtual java/util/Scanner/nextInt()I");
        }
    ;

function_scanString [String funcName]
    :
        STR_SCANNER PIPE
        {
            System.out.println("new java/util/Scanner");
            System.out.println("dup");
            System.out.println("getstatic java/lang/System/in Ljava/io/InputStream;");
            System.out.println("invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V");
            System.out.println("invokevirtual java/util/Scanner/nextLine()Ljava/lang/String;");
        }
    ;

function_readFile [String funcName]
    :
        READ PIPE STRING
        {
            String fileName = $STRING.text.replaceAll("^\"|\"$", "");
            emit("new java/io/BufferedReader");
            emit("dup");
            emit("new java/io/FileReader");
            emit("dup");
            emit("ldc \"" + fileName + "\"");
            emit("invokespecial java/io/FileReader/<init>(Ljava/lang/String;)V");
            emit("invokespecial java/io/BufferedReader/<init>(Ljava/io/Reader;)V");
            emit("invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;");
        }
    ;

function_writeFile [String funcName]
    :   WRITE PIPE STRING
        {
            String fileName = $STRING.text.replaceAll("^\"|\"$", "");
            emit("new java/io/BufferedWriter");
            emit("dup");
            emit("new java/io/FileWriter");
            emit("dup");
            emit("ldc \"" + fileName + "\"");
            emit("invokespecial java/io/FileWriter/<init>(Ljava/lang/String;)V");
            emit("invokespecial java/io/BufferedWriter/<init>(Ljava/io/Writer;)V");
            emit("dup");
        }

     COMMA (fac = factor[funcName] | str = STRING)
        {
            if ($str.text != null) {
                String content = $str.text.replaceAll("^\"|\"$", "");
                emit("ldc \"" + content + "\"");
            }

            if ($fac.text == null) {
                emit("invokevirtual java/io/BufferedWriter/write(Ljava/lang/String;)V");
            } else {
                 Var var = memory.get(funcName)
                                 .stream()
                                 .filter(v -> v.name.equals($fac.text))
                                 .findFirst()
                                 .get();

                 if (var.type.equals("int")) {
                     emit("invokevirtual java/io/BufferedWriter/write(I)V");
                 } else {
                     emit("invokevirtual java/io/BufferedWriter/write(Ljava/lang/String;)V");
                 }
            }

            emit("invokevirtual java/io/BufferedWriter/close()V");
        }
    ;

function_randomNum [String funcName]
    :
        RANDOM PIPE (min = NUM) COMMA (max = NUM)
        {
            try {
                final int min = Integer.parseInt($min.text);
                final int max = Integer.parseInt($max.text);

                emit("new java/util/Random");
                emit("dup");
                emit("invokespecial java/util/Random/<init>()V");
                emit("ldc " + min);
                emit("ldc " + (max + 1));
                emit("invokevirtual java/util/Random.ints(II)Ljava/util/stream/IntStream;");
                emit("invokeinterface java/util/stream/IntStream/findFirst()Ljava/util/OptionalInt; 1");
                emit("invokevirtual java/util/OptionalInt/getAsInt()I");
            } catch (Exception e) {
               System.err.println("Inputs for function rand must be two integer values");
               throw new RuntimeException("Inputs for function rand must be two integer values");
            }
        }
    ;

function_customCall [String funcName]
    :
        (funcCall = VAR) PIPE ((factor[funcName] | expression[funcName] | (function_customCall[funcName] SEMICOLON))?
        (COMMA (factor[funcName] | expression[funcName]) | (function_customCall[funcName] SEMICOLON))*)?
        {

            final Optional<CustomFunction> optFun = functions.stream().filter(f -> f.name.equals($funcCall.text)).findFirst();
            if (!optFun.isPresent()) {
               System.err.println("Undefined function " + $funcCall.text);
               throw new RuntimeException("Undefined function " + $funcCall.text);
            }

            final CustomFunction fun = optFun.get();

            final String receivedTypes = fun.receivedTypes.stream()
                .map(v -> getTypeString.apply(v))
                .reduce("", String::concat);
            final String returnType = getTypeString.apply(fun.returnType);

            System.out.println("invokestatic Output/"+ fun.name +"("+ receivedTypes +")"+ returnType +"\n");
        }
    ;

goto [String funcName]
    :
        GOTO VAR SEMICOLON
        {
            final String gotoName = $VAR.text;
            final String nameDef = gotos.get(gotoName);
            if (nameDef == null || nameDef.isEmpty()) {
                System.err.println("Undefined Goto pointer " + gotoName);
                throw new RuntimeException("Undefined Goto pointer " + gotoName);
            }

            emit("goto " + nameDef + " ;");

        }
    ;

def_goto [String funcName]
    :
        DEF_GOTO VAR SEMICOLON
        {
            final String gotoName = $VAR.text;
            if (stackCounter.containsKey(gotoName)) {
                System.err.println("Goto name already used in function " + gotoName);
                throw new RuntimeException("Goto name already used in function " + gotoName);
            }
            if (memory.get(funcName).stream().anyMatch(v -> v.name.equals(gotoName))) {
                System.err.println("Goto name already used in variable " + gotoName);
                throw new RuntimeException("Goto name already used in variable " + gotoName);
            }

            if (gotos.get(gotoName) != null) {
                System.err.println("Goto name already used in another goto " + gotoName);
                throw new RuntimeException("Goto name already used in another goto " + gotoName);
            }

            final String nameDef = gotoName.toUpperCase() + "_DEF";
            gotos.put(gotoName, nameDef);
            emit(nameDef + ":");
        }
    ;

call_function [String funcName, Integer tempWhile]
    :
        (function_printInteger[funcName] |
        function_printString |
        function_printVar[funcName] |
        function_scanInteger[funcName] |
        function_scanString[funcName] |
        function_readFile[funcName] |
        function_writeFile[funcName] |
        function_playSound[funcName] |
        function_randomNum[funcName] |
        function_customCall[funcName])
        SEMICOLON
    ;

assignment [String funcName, Integer tempWhile]
    :
        (op = (INT_VAR | BOOL_VAR | CHAR_VAR | DOUBLE_VAR | STRING_VAR | VOID_VAR | NULL_VAR))? VAR
        ATTRIB ( exp = expression[funcName] | function_customCall[funcName] | function_scanInteger[funcName] | function_scanString[funcName] | function_readFile[funcName] | function_randomNum[funcName] |  STRING )
    	{
    	    List<Var> vars = memory.get(funcName);
            if (vars == null) {
                vars = new ArrayList<>();
            }
    	    boolean containsVar = vars.stream().anyMatch(var -> var.name.equals($VAR.text));
    	    if (!containsVar) {
                Map<String, Integer> stackTypes = stackCounter.get(funcName);
                Integer stackCount = stackTypes.get($op.text);
                if (stackCount == null) {
                    stackCount = 0;
                }
    	        Var newVar = new Var($VAR.text, $op.text, stackCount);
    	        stackTypes.put($op.text, ++stackCount);
    	        stackCounter.put(funcName, stackTypes);
                vars.add(newVar);
                memory.put(funcName, vars);
    	    }

    	    final Var currentVar = memory.get(funcName)
    	        .stream().filter(var -> var.name.equals($VAR.text)).findFirst().get();

            if ($op.type == 0) {
                System.out.println(storeVar.apply(currentVar));
            } else if ($STRING != null) {
                System.out.println("ldc " + $STRING.text);
                System.out.println("astore " + currentVar.stackPos);
            } else {
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
                    case STRING_VAR:
                        System.out.println("astore " + currentVar.stackPos);
                        break;
                    default:
                        System.err.println("undefined variable " + $VAR.text);
                }
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
            if (var == null) {
                System.err.println("undefined variable " + $VAR.text);
            } else {
                System.out.println(loadVar.apply(var));
            }
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
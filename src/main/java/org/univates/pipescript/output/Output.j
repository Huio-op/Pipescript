.source Output.j
.class  public Output
.super  java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static askNumber()I

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
istore 0
iload 0
ireturn
.limit stack 50
.limit locals 50
.end method
.method public static main([Ljava/lang/String;)V

ldc 0
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Tente acertar o numero sorteado"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Toda vez que voce erra o numero eh gerado novamente."
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

START_WHILE_1: 
new java/util/Random
dup
invokespecial java/util/Random/<init>()V
ldc 1
ldc 11
invokevirtual java/util/Random.ints(II)Ljava/util/stream/IntStream;
invokeinterface java/util/stream/IntStream/findFirst()Ljava/util/OptionalInt; 1
invokevirtual java/util/OptionalInt/getAsInt()I
istore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Digite um numero:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

invokestatic Output/askNumber()I

istore 2
iload 0
ldc 1
iadd
istore 0
iload 2
iload 1
    if_icmpne NOT_IF_2 ; 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Voce acertou!"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

goto END_WHILE_1 ; 
goto END_IF_ELSE_2 ; 
NOT_IF_2: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Voce errou, tente novamente"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

END_IF_ELSE_2: 
goto START_WHILE_1 ; 
END_WHILE_1: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Numero de tentativas:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V

return
.limit stack 50
.limit locals 50
.end method

.source Output.j
.class  public Output
.super  java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static sum(II)I

iload 0
iload 1
iadd
ireturn
.limit stack 50
.limit locals 50
.end method
.method public static mul(II)I

iload 0
iload 1
imul
ireturn
.limit stack 50
.limit locals 50
.end method
.method public static main([Ljava/lang/String;)V

new java/io/BufferedReader
dup
new java/io/FileReader
dup
ldc "file.txt"
invokespecial java/io/FileReader/<init>(Ljava/lang/String;)V
invokespecial java/io/BufferedReader/<init>(Ljava/io/Reader;)V
invokevirtual java/io/BufferedReader/readLine()Ljava/lang/String;
astore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 0
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Input a number:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
istore 0
iload 0
ldc 2
invokestatic Output/mul(II)I

ldc 5
invokestatic Output/sum(II)I

istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Your number doubled and added 5 is:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V

iload 0
ldc 15
    if_icmpge NOT_IF_1 ; 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Its lesser than 15"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

goto END_IF_ELSE_1 ; 
NOT_IF_1: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Its greater than 15"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

END_IF_ELSE_1: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Input a string:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/next()Ljava/lang/String;
astore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 1
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Input the number of loops:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
istore 1
ldc 0
istore 2
START_WHILE_2: 
iload 2
iload 1
    if_icmpge END_WHILE_2 ; 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Loop number: "
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

iload 2
ldc 1
iadd
istore 2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 2
invokevirtual java/io/PrintStream/println(I)V

goto START_WHILE_2 ; 
END_WHILE_2: 
return
.limit stack 50
.limit locals 50
.end method

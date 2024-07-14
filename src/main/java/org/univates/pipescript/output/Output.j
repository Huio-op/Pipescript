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
.method public static main([Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Input a number:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Adding one to the number"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

ldc 1
iload 0
invokestatic Output/sum(II)I

istore 0
iload 0
ldc 4
    if_icmpge NOT_IF_1 ; 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Its lesser than four"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

goto END_IF_ELSE_1 ; 
NOT_IF_1: 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Its greater than four"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

END_IF_ELSE_1: 
return
.limit stack 50
.limit locals 50
.end method

.source Output.j
.class  public Output
.super  java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static sum(II)I

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "test func"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

iload 0
iload 0
iadd
ireturn
.limit stack 50
.limit locals 50
.end method
.method public static main([Ljava/lang/String;)V

ldc 2
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "hello world"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

ldc 2
iload 0
invokestatic Output/sum(II)I

istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V

iload 0
ldc 4
    if_icmpge NOT_IF_1 ; 
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Its lesser than four"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

NOT_IF_1: 
return
.limit stack 50
.limit locals 50
.end method

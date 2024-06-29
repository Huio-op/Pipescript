.source Output.j
.class  public Output
.super  java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V

ldc 2
istore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "hello world"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

ldc 2
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

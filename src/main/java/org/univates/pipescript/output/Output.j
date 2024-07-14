.source Output.j
.class  public Output
.super  java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "Input a string:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/next()Ljava/lang/String;
astore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
aload 0
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 1
ldc 2
iadd
ldc 3
iadd
invokevirtual java/io/PrintStream/println(I)V

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V

return
.limit stack 50
.limit locals 50
.end method

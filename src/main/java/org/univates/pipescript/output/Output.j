.source Output.j
.class  public Output
.super  java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V

new java/util/Random
dup
invokespecial java/util/Random/<init>()V
ldc 1
ldc 11
invokevirtual java/util/Random.ints(II)Ljava/util/stream/IntStream;
invokeinterface java/util/stream/IntStream/findFirst()Ljava/util/OptionalInt; 1
invokevirtual java/util/OptionalInt/getAsInt()I
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc "O numero aleatorio e:"
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V

return
.limit stack 50
.limit locals 50
.end method

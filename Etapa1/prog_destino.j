.source prog_destino.java
.class public prog_destino
.super java/lang/Object
.method public <init>()V
.limit stack 1
.limit locals 1
aload_0
invokespecial java/lang/Object/<init>()V
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 4
.limit locals 100
ldc2_w 19.0
ldc2_w 4.0
dadd
ldc2_w 2.0
dadd
dstore 1
ldc2_w 38.0
dstore 3
dload 1
dload 3
dadd
dstore 5
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 5
invokevirtual java/io/PrintStream/println(D)V
return
.end method

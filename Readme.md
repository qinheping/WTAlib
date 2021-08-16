# Nay


## How to install Nay on linux 

1. Install antlr4 (4.9.2 for both java and python), z3 (4.8.11) and python2 (2.7.18).
2. Install java (16.0.1), cvc4-java-binding (https://github.com/CVC4/CVC4-archived/tree/64dcc865f8aae4fd1591bfec9ee117b360e9f9b3/examples). 

## How to run Nay-Horn

There are two steps to run Nay-Horn.
1. Produce CHC problem. Here is an example to produce the CHC problem for the max2 benchmark.
```
$ python src/main/python/NAY_Horn/spacer.py benchmarks/CLIA_Track_IF/fg_max2/grammar.sl benchmarks/CLIA_Track_IF/fg_max2/example1.txt
```
It takes two arguments: a grammar file and a example file; and it print the CHC problem into `tmp/horn_query.smt`.

2. Check the CHC probelm with z3.
```
$ z3 tmp/horn_query.smt
```
Result sat means UNREALIZABLE, while unsat means REALIZABLE.

## How to run Nay-SL

First, open the directory `src/main/java`. 

Second, compile `SLMain.java` into `SLMain.class` with the following command
```
javac -cp .:/usr/local/lib/antlr-4.9.2-complete.jar:../../../../CVC4-archived/build/src/bindings/java/CVC4.jar SLMain.java
```
Note the classpath should include both jar files for `antlr4` and `CVC4`.

Finally, you can run Nay-SL with three arguments 

1. `path` the folder of your SyGuS problem. Example: benchmarks/CLIA_Track_PLUS_Pos/mpg_guard1/
2. `num_e` a number indicating which example file you choose. Example: `num_e`=1 means that the file `example_1.txt` is chosen.
3. `num_i` a number indicating how many examples you want to use in the file. Example: `num_i`=1 means that you want to use the first example in the example file.
```
java -cp .:/usr/local/lib/antlr-4.9.2-complete.jar:../../../../CVC4-archived/build/src/bindings/java/CVC4.jar -ea -Djava.library.path=/usr/local/lib/ SLMain ../../../benchmarks/CLIA_Track_PLUS_Pos/mpg_guard1/ 1 1
```
Note that the path `/usr/local/lib/` should contain the file `libcvc4jni.so` if you successfully build CVC4 with java bindings.
SLMain will print the detailed result (in the same format as in the paper). The boolean flag at the end indicates whether the problem is unrealizable (false) or realizable (true).

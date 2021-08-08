# Nay


## How to install Nay on linux 

1. Install antlr4 (for both java and python), z3 and python2.
2. Install java, cvc4-java-binding. 

## How to run Nay-Horn

There are two steps to run Nay-Horn.
1. Produce CHC problem. Here is an example to produce the CHC problem for the max2 benchmark.
```
$ python src/main/python/NAY_horn/spacer.py benchmarks/CLIA_Track_IF/fg_max2/grammar.sl benchmarks/CLIA_Track_IF/fg_max2/example1.txt
```
It takes two arguments: a grammar file and a example file; and it print the CHC problem into `tmp/horn_query.smt`.

2. Check the CHC probelm with z3.
```
$ z3 tmp/horn_query.smt
```
The original synthesis problem with the given examples is unrealizable if the output of z3 is sat. 

## How to run Nay-SL

First, open the directory `src/main/java`. 

Second, compile `SLMain.java` into `SLMain.class` with the following command
```
javac -cp .:/usr/local/lib/antlr-4.9.2-complete.jar:../../../lib/CVC4-1.8.0.jar:../../..lib/com.microsoft.z3.jar SLMain.java
```
Note the classpath should include three jar files for `antlr4`, `z3`, and `CVC4`.

Finally, you can run Nay-SL with three arguments 

1. `path` the folder of your SyGuS problem. Example: benchmarks/CLIA_Track_PLUS_Pos/mpg_guard1/
2. `num_e` a number indicating which example file you choose. Example: `num_e`=1 means that the file `example_1.txt` is chosen.
3. `num_i` a number indicating how many examples you want to use in the file. Example: `num_i`=2 means that you want to use the first two examples in the example file.

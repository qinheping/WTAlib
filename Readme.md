# Nay


## How to install Nay on linux 

1. Install antlr4, z3 and python2.

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

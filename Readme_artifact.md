
Thank you for evaluating the software artifact of Nay. This README document will help you get started with the Nay software artifact.

Even though we have tried our best to make this artifact evaluation process as smooth as possible, we also would like to kindly ask you to anonymously reach us through easychair if you experience any technical difficulties. We will do our best to resolve them as speedily as possible.

### Started Guide:

This artifact includes a virtual machine disk (*pldi20artifact.ova*) file which can be run on VirtualBox software (https://www.virtualbox.org). 

Some of the benchmarks have high memory usage and they become memory-bounded unless the system has at least 4GB of RAM in a virtual machine. Therefore, we recommend that the testing machine has at least 8GB of RAM.
 
The VM automatically logs in and will never lock after inactivity or sleep, and nothing in this guide requires root permissions. The password for the root permission is *12345678*.
The original ubuntu image was downloaded from the ubuntu official website.

Once logged in, start the terminal by pressing (Ctrl+Alt+t). If the keyboard shortcut does not work for you, follow the instructions here (https://askubuntu.com/questions/124274/how-to-find-the-terminal-in-lubuntu).

In the terminal, execute the following commands (lines that start with `$`, omit the `$` while running). Lines starting with # are comments for your convenience, please don’t type them into the command line. 

$ cd PLDI2020_artifact
$ cd WTAlib

The dictionary WTAlib contains all we need for the artifact. 
There are three main results we introduced in the evaluation section of the paper: 1) evaluation of Nay_SL, 2) evaluation of Nay_Horn, and 3) the cost of computing semi-linear sets introduced in Section 8.2.
The running time of Nope shown in Table 1 can be found in https://arxiv.org/abs/1905.05800.

##### Evaluation of Nay_SL
Type in command line
$ bash run_success.sh

Bash files run_success.sh (~3 hours) are used to recreate Table 1 and Table 2 (supplemental material) in the paper except for columns Nay_Horn time and NOPE time. 
The aggregated result, detail result and error log can be found in result/result_xxxxxx.txt, result/result_detailxxxxxx.txt and error_log/log_xxxxxx.txt respectively where xxxxxx are the DayHourMinut of the starting time, for example xxxxxx=281108 when the script starting at 28th 11:08am . The format of the result and detailed result will be explained later.
The aggregated result is in the same format as Table 1. 

Note that in this script we only evaluate benchmarks on which Nay_SL can prove unrealizability for at least one run out of five. To run the full experiment, run the script run_full.sh (~30 hours) by typing

$ bash run_full.sh

There are two errors we made by accident in tables in the paper.
1) In Table 1 benchmark LimitedPlus ite1, the number of non-terminals and tranistion is wrong---should be 5 and 16.
2) The number of examples |E| in Table 1 should be the average number of examples, but we accidable put the number of example for one run for some benchmarks, for example, mpg_guard1, mpg_guard3 and mpg_ite2.

##### Evaluation of Nay_Horn
Type in command line
$ bash run_horn_success.sh

Bash files run_horn_success.sh (~30 minutes) are used to recreate the Nay_Horn time in Table 1 and Table 2 (supplemental material).
The result and error log can be found in result/result_horn_xxxxxx.txt and error_log/log_xxxxxx.txt respectively where xxxxxx are the DayHourMinut of the starting time, for example xxxxxx=281108 when the script starting at 28th 11:08am. 

Note that in this script we only evaluate benchmarks on which Nay_Horn can prove unrealizability for at least one run out of five. To run the full experiment, run the script run_full.sh (~30 hours) by typing

$ bash run_horn_full.sh

##### The Cost of Computing Semi-linear Sets

The plot in Figure 1 was produced with the running time of producing the result semi-linear set and the number of non-terminals. After running the full experiment, the second column (ignore & symbol) in the detailed result are the number of non-terminals and the 10th column are the running time of producing result semi-linear set. One can recreate Figure with datas in these two columns.

### Benchmarks

All benchmarks can be found in PLDI2020_artifact/benchmarks. Folders CLIA_Track_PLUS, CLIA_Track_IF, CLIA_Track_Const correspond to the three categories benchmarks introduced in Section 8. 

Each subfolder corresponds to one SyGuS with examples benchmarks where grammar.sl specifying the search space and exampleN.txt is the given input-output examples. For benchmarks with more than one example set given in the subfolder---the subfolder contain exampleN.txt for N>1---, random counterexamples were produced during the CEGIS loop so we sampled 5 different example sets and aggregate the result (see Section 7 for detail).

The original SyGuS benchmarks can be found in CLIA_track_XX/original_sygus folders where the specification are given as a predicate as in the standard SyGuS problem setting.

### Format of Result

In the aggregated result result/result_xxxxxx.txt, each row consists of benchmark name, number of non-terminal |N|, number of transition |Delta|, number of variables |V|, number of examples |E|, running time, and number of solved runs.
Recall that when random counterexamples were produced during the CEGIS loop, we will evaluate the benchmark for five runs with different random seeds. For benchmarks with more than one run, the number of examples and the running time are the average of all solved runs.

In the detail result result/result_detailxxxxxx.txt, each row consists of benchmarks name, number of non-terminal,, number of transition, number of examples, number of int-bool stages, average size of bv sets approximating Boolean non-terminals, size of the result semilinear set, average size of the period sets in the result semilinear set, running time of computing semilinear sets, running time of checking if the result semilinear set is disjoint from the specification, total running time, and boolean result true/false (realizable/unrealizable)

### Step by Step Instructions:

##### Run Nay_SL on SyGuS with examples problem
To run Nay_SL on a SyGuS with examples problem, you need to first put the grammar file *grammar.sl* and example file *example1.txt* in one folder, for example, look at the folder *benchmarks/CLIA_Track_IF/fg_max2*. Then type

$java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar XXX E 1

Where XXX is the name of the folder. The detailed result will be displayed in the terminal when Nay_SL returns. *false* at the end of result line means UNREALIZABLE while *true* means REALIZABLE. 

##### Run Nay_Horn on SyGuS with examples problem
To run Nay_Horn on a SyGuS with examples problem, first type

$python src/main/python/NAY_Horn/spacer.py XXX YYY

Where XXX is a grammar file and YYY is an example file. This command will produce a horn problem *tmp/horn_query.smt*. Then type 

$./z3 tmp/horn_query.smt 

To solve the Horn problem. Result *sat* means UNREALIZABLE while *unsat* means REALIZABLE.

##### Run Nay_SL on SyGuS problem
To run Nay_SL on a SyGuS problem, just type

$bash nay_sl.sh XXX

Where XXX is the SyGuS problem file.  For example, type

$bash nay_sl.sh benchmarks/CLIA_Track_IF/original_sygus/fg_max2.sl

The detailed result will be displayed in the terminal when Nay_SL returns. *false* at the end of result line means UNREALIZABLE while *true* means REALIZABLE. 


##### Run Nay_Horn on SyGuS problem
To run Nay_Horn on a SyGuS problem, just type

$bash nay_horn.sh XXX

Where XXX is the SyGuS problem file.  For example, type

$bash nay_horn.sh benchmarks/CLIA_Track_IF/original_sygus/fg_max2.sl

Result *sat* means UNREALIZABLE while *unsat* means REALIZABLE.

### Source code explaination:

The main component of Nay_SL are *src/main/java/SLMain.java* (main driver), *src/main/java/utilities/GrammarInterpretor.java* (produce equations from grammars), *src/main/java/utilities/IteFixedPointSolver.java* (solve term equations), and *src/main/java/utilities/Newton.java* (Newton’s method).
The main component of Nay_Horn are *src/main/python/parser/spacer.py* (encode SyGuS with problems to Horn problems).

The source code of the CEGIS loop are *src/main/python/CEGIS_Verifier.py* and *src/main/python/CEGIS_Verifier_horn.py*.

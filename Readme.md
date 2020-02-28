# Artifact for "Exact and Approximate Methods for Proving Unrealizability of Syntax-Guided Synthesis Problems"

Thank you for evaluating the software artifact of Nope. This README document will help you get started with the Nay software artifact.

Even though we have tried our best to make this artifact evaluation process as smooth as possible, we also would like to kindly ask you to  anonymously reach us through easychair if you experience any technical difficulties. We will do our best to resolve them as speedily as possible.

### Quick Started Guide:

This artifact includes a virtual machine disk (VMDK) file which can be run on VirtualBox software (https://www.virtualbox.org). 

Some of the benchmarks have high memory usage and they become memory-bounded unless the system has at least 4GB of RAM in virtual machine. Therefore, we recommend that the testing machine has at least 8GB of RAM.
 
The VM automatically logs in and will never lock after inactivity or sleep, and nothing in this guide requires root permissions. 
The original ubuntu image was downloaded from the ubuntu official website.

Once logged in, start the terminal by pressing (Ctrl+Alt+t). If the keyboard shortcut, does not work for you, follow the instructions here (https://askubuntu.com/questions/124274/how-to-find-the-terminal-in-lubuntu).

In the terminal, execute the following commands (lines that start with `$`, omit the `$` while running). Lines starting with # are comment for your convenience, please don’t type them into the command line. 


$ cd PLDI2020_artifact
$ cd WTAlib
$ ls
$ bash run_success.sh

Bash files run_success.sh (~3 hours) are used to recreate Table 1 and Table 2 (supplemental material) in the paper except for Nay_Horn time and NOPE time (which were evaluated in https://arxiv.org/abs/1905.05800). 
The result, detail and error log can be found in result/result_xxxxxx.txt, result/result_detailxxxxxx.txt and error_log/log_xxxxxx.txt respectively where xxxxxx are the DayHourMinut of the starting time, for example xxxxxx=281108 when the script starting at 28th 11:08am . The format of the result and detailed result will be explained later.
Note that in this script we only evaluate benchmarks on which Nay_SL can prove unrealizability for at least one run out of five. To run the full experiment, run the script run_full.sh (~30 hours) by typing

$ bash run_success

The plot in Figure 1 was produced with the runing time of producing the result semi-linear set and the number of non-terminals. After running the full experiemnt, the second column (ignore & symbol) in the detailed result are number of non-terminals and the 10th column are the running time of producing result semi-linear set.

### Benchmarks

All benchmarks can be found in PLDI2020_artifact/benchmarks. Folders CLIA_Track_PLUS, CLIA_Track_IF, CLIA_Track_Const correspond to the three categories benchmarks introduced in Section 8. 

Each subfolder corresponds to one SyGuS with examples benchmarks where grammar.sl specifying the search space and exampleN.txt is the given input-output examples. For benchmarks with more than one example set given in the subfolder---the subfolder contain exampleN.txt for N>1---, random counterexamples were produced during the CEGIS loop so we sampled 5 different example sets and aggreated the result (see Section 7 for detail).

The orginal benchmarks can be found in CLIA_track_XX/original_sygus folders where the sepcification are given as a predicate as in the standard SyGuS problem setting.

### Format of Result

In the aggreated result result/result_xxxxxx.txt, each row consists of bechmark name, number of non-terminal |N|, number of transition |Delta|, number of variables |V|, number of examples |E|, running time, and number of solved runs.
Recall that when random counterexamples were produced during the CEGIS loop, we will evluate the benchmark for five runs with different random seed. For benchamrks with more than one run, the number of example and the running time are the average of all solved runs.

In the detail result result/result_detailxxxxxx.txt, each row consists of benchamrks name, number of non-terminal,, number of transition, number of examples, number of int-bool stages, average size of bv sets aprroximating Boolean non-terminals, size of the result semi-linear set, average size of the period sets in the result semi-linear set, running time of computing semi-linear sets, running time of checking if the result semi-linear set is disjoint from the sepcification, total running time, and boolean result true/false (realizable/unrealizable)

### Step by Step Instructions:

To run Nay_Sl on a SyGuS with examples problem,
 file test.sl. All you need to do is
$python run.py test.sl

Then our tool will print the examples and candidate solutions found in each iteration. At last Nope will output unrealizable or a correct solution for the given sygus problems.
The running time can be checked after each iteartion.


### Source code explaination:

The main component of Nope is parser/SyGuSRewritter.py and parser/SyGuSToCVisitor.py which reduce a sygus file to a C file. There are also other parsers used to parse the output of ESolver or Z3 solver.


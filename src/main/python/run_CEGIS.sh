#! /bin/sh
FILES=../../../benchmarks/CLIA_Track_IF/original_sygus/*
output_file=./ESolver_time.txt
for f in $FILES
do
	fbase=${f##*/}
	fpref=${fbase%.*}
	echo "start" >> $output_file
	timeout 600 python CEGIS_Esolver.py $f >> $output_file
# >> result/$fpref.txt
done

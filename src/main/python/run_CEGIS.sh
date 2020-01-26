#! /bin/sh
FILES=../../../benchmarks/CLIA_Track_IF/*
out_path="../../../benchmarks/result/"
for f in $FILES
do
	echo "Processing $f file..." > $out_path$f
done
#! /bin/sh
FILES=../../../benchmarks/CLIA_Track_IF/*

for f in $FILES
do
	echo "Processing $f file..." > $out_path".result"
done
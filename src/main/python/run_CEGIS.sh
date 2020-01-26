#! /bin/sh
FILES=../../../benchmarks/CLIA_Track_IF/*

for f in $FILES
do
	fbase=${f##*/}
	fpref=${fbase%.*}
	echo "Processing $fpref file..." 
done
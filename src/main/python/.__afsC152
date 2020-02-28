#! /bin/sh
FILES=../../../benchmarks/CLIA_Track_IF/*

for f in $FILES
do
	fbase=${f##*/}
	fpref=${fbase%.*}
	timeout 300 python CEGIS_Verifier.py $f
done
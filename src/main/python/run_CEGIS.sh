#! /bin/sh
FILES=../../../benchmarks/CLIA_Track_IF/*

for f in $FILES
do
	fbase=${f##*/}
	fpref=${fbase%.*}
	timeout 600 python CEGIS_Verifier.py f
done
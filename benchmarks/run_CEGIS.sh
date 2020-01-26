#! /bin/sh
FILES=CLIA_Track_IF/*
out_path="result/"
for f in $FILES
do
	echo "Processing $f file..." > $out_path$f
done
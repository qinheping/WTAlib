#! /bin/sh
benchmark=(
#	mpg_plane1
#	mpg_plane2
#	mpg_plane3
	mpg_ite1
#	mpg_ite2
#	mpg_guard1
#	mpg_guard2
#	mpg_guard3
#	mpg_guard4
#	mpg_exampl1
#	array_sum_2_5
)
path="/u/q/h/qhu28/repositories/WTAlib/benchmarks/CLIA_Track_PLUS/"
out_path="/u/q/h/qhu28/repositories/WTAlib/benchmarks/CLIA_Track_PLUS/result_ite1.txt"
for s in "${benchmark[@]}"; do
	for ((i=1; i<6; i++)); do
		for ((e=1; e<5; e++)); do
			echo -n $s" & " >> $out_path
			timeout 300 java -ea -Djava.library.path=/u/q/h/qhu28/repositories/WTAlib/lib -jar WTAlib.jar $path$s $e $i >> $out_path
			echo >> $out_path
		done
		echo >> $out_path
	done 
done
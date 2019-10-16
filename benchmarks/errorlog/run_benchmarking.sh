#! /bin/sh
path="/u/q/h/qhu28/repositories/WTAlib/benchmarks/benchmarking/"
out_path="/u/q/h/qhu28/repositories/WTAlib/benchmarks/benchmarking/result_3.txt"
for ((d=1; i<6; i = i+1)); do
	for ((i=3; i<30; i = i+2)); do
		for ((v=1; v<11; v++)); do
			for ((e=1; e<20; e++)); do
				echo -n "benchmarking_"$i"_"$v"_"$e" "$i" "$v" "$e" " >> $out_path
				if timeout 600 java -ea -Djava.library.path=/u/q/h/qhu28/repositories/WTAlib/lib -jar WTAlib.jar $path"grammar_"$i"_"$v".sl" $e $d 1 >> $out_path; then
					echo $i"_"$v"_"$e
					echo >> $out_path
				else	
					echo >> $out_path
					break
				fi
			done
		done
	done
done 

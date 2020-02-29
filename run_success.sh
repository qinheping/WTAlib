#! /bin/sh
benchmark_plus_1=(
	mpg_guard4
	mpg_guard1
	mpg_guard2
	mpg_guard3
)
benchmark_plus_2=(
	mpg_plane1
)

benchmark_plus_3=(
	mpg_plane2
	mpg_plane3
	mpg_ite1
	mpg_ite2
	array_sum_2_5
)
benchmark_plus_4=(
	array_search_2
	array_search_3
)

currenttime=`date +"%d%H%M"`
echo "result result/result_$currenttime.txt"
echo "detail result/result_detail_$currenttime.txt"
echo "error log error_log/log_$currenttime.txt"
path="benchmarks/CLIA_Track_PLUS_Pos/"
out_detail="result/result_detail_$currenttime.txt"
out_error="error_log/log_$currenttime.txt"
out_path="result/result_$currenttime.txt"


echo "Category: limitedPlus" >> $out_detail
echo "Category: limitedPlus" >> $out_path

for s in "${benchmark_plus_1[@]}"; do
	echo "processing $s in $path"
	echo -n $s" & " >> $out_path
	count=0
	sumEx=0
	sumT=0.0
	for ((i=1; i<6; i++)); do
		for ((e=1; e<8; e++)); do
			echo -n $s" & run: $i & example: $e & " >> $out_detail
			echo "processing $s & run: $i & example: $e" >> $out_error
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i 2>>$out_error)
			echo -n $line >> $out_detail
			IFS='&'
			read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
			IFS=' '
			length=${#ADDR[@]}
			if [[ $length != '12' ]]; then
			echo -n "fail" >> $out_detail
			echo " " >> $out_detail
			break
			fi
			echo " " >> $out_detail

			
			read -ra N <<< "${ADDR[0]}"
			read -ra Delta <<< "${ADDR[1]}"
			read -ra V <<< "${ADDR[2]}"
			read -ra Ex <<< "${ADDR[3]}"
			read -ra T <<< "${ADDR[10]}"
			read -ra R <<< "${ADDR[11]}"
			if [ "${R:0:1}" = "f" ]; then
				count=$(($count + 1))
				sumT=$(echo print $T+$sumT | python2)
				sumEx=$(echo print $Ex+$sumEx | python2)
				break
			fi
		done

	done 
	avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2 2>>$out_error)
	avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2 2>>$out_error)
	echo " " >> $out_detail
	if [[ $count == '0' ]]; then
		echo  "fail" >> $out_path
		continue
	fi
	echo -n " & |N|: $N & |Delta|: $Delta & |V|: $V & avg example: $avgEx & avg time: " >> $out_path
	echo $avgT" & solved run: $count/5" >> $out_path
	
done
for s in "${benchmark_plus_2[@]}"; do
	echo -n $s" & " >> $out_path
	echo "processing $s in $path"
	count=0
	sumEx=0
	sumT=0.0
	for ((i=1; i<2; i++)); do
		for ((e=1; e<8; e++)); do
			echo -n $s" & run: $i & example: $e & " >> $out_detail
			echo "processing $s & run: $i & example: $e" >> $out_error
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i 2>>$out_error)
			echo -n $line >> $out_detail
			IFS='&'
			read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
			IFS=' '
			length=${#ADDR[@]}
			if [[ $length != '12' ]]; then
			echo -n "fail" >> $out_detail
			echo " " >> $out_detail
			break
			fi
			echo " " >> $out_detail

			
			read -ra N <<< "${ADDR[0]}"
			read -ra Delta <<< "${ADDR[1]}"
			read -ra V <<< "${ADDR[2]}"
			read -ra Ex <<< "${ADDR[3]}"
			read -ra T <<< "${ADDR[10]}"
			read -ra R <<< "${ADDR[11]}"
			if [ "${R:0:1}" = "f" ]; then
				count=$(($count + 1))
				sumT=$(echo print $T+$sumT | python2)
				sumEx=$(echo print $Ex+$sumEx | python2)
				break
			fi
		done
	done 
	avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2 2>>$out_error)
	avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2 2>>$out_error)
	echo " " >> $out_detail
	if [[ $count == '0' ]]; then
		echo  "fail" >> $out_path
		continue
	fi
	echo -n " & |N|: $N & |Delta|: $Delta & |V|: $V & avg example: $avgEx & avg time: " >> $out_path
	echo $avgT" & solved run: $count/1" >> $out_path
done

for s in "${benchmark_plus_3[@]}"; do
	echo -n $s" & " >> $out_path
	echo "processing $s in $path"
	count=0
	sumEx=0
	sumT=0.0
	for ((i=1; i<6; i++)); do
		for ((e=1; e<8; e++)); do
			echo -n $s" & run: $i & example: $e & " >> $out_detail
			echo "processing $s & run: $i & example: $e" >> $out_error
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i 2>>$out_error)
			echo -n $line >> $out_detail
			IFS='&'
			read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
			IFS=' '
			length=${#ADDR[@]}
			if [[ $length != '12' ]]; then
			echo -n "fail" >> $out_detail
			echo " " >> $out_detail
			break
			fi
			echo " " >> $out_detail

			
			read -ra N <<< "${ADDR[0]}"
			read -ra Delta <<< "${ADDR[1]}"
			read -ra V <<< "${ADDR[2]}"
			read -ra Ex <<< "${ADDR[3]}"
			read -ra T <<< "${ADDR[10]}"
			read -ra R <<< "${ADDR[11]}"
			if [ "${R:0:1}" = "f" ]; then
				count=$(($count + 1))
				sumT=$(echo print $T+$sumT | python2)
				sumEx=$(echo print $Ex+$sumEx | python2)
				break
			fi
		done

	done 
	avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2 2>>$out_error)
	avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2 2>>$out_error)
	echo " " >> $out_detail
	if [[ $count == '0' ]]; then
		echo  "fail" >> $out_path
		continue
	fi
	echo -n " & |N|: $N & |Delta|: $Delta & |V|: $V & avg example: $avgEx & avg time: " >> $out_path
	echo $avgT" & solved run: $count/5" >> $out_path
	
done
for s in "${benchmark_plus_4[@]}"; do
	echo -n $s" & " >> $out_path
	echo "processing $s in $path"
	count=0
	sumEx=0
	sumT=0.0
	for ((i=1; i<2; i++)); do
		for ((e=1; e<8; e++)); do
			echo -n $s" & run: $i & example: $e & " >> $out_detail
			echo "processing $s & run: $i & example: $e" >> $out_error
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i 2>>$out_error)
			echo -n $line >> $out_detail
			IFS='&'
			read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
			IFS=' '
			length=${#ADDR[@]}
			if [[ $length != '12' ]]; then
			echo -n "fail" >> $out_detail
			echo " " >> $out_detail
			break
			fi
			echo " " >> $out_detail

			
			read -ra N <<< "${ADDR[0]}"
			read -ra Delta <<< "${ADDR[1]}"
			read -ra V <<< "${ADDR[2]}"
			read -ra Ex <<< "${ADDR[3]}"
			read -ra T <<< "${ADDR[10]}"
			read -ra R <<< "${ADDR[11]}"
			if [ "${R:0:1}" = "f" ]; then
				count=$(($count + 1))
				sumT=$(echo print $T+$sumT | python2)
				sumEx=$(echo print $Ex+$sumEx | python2)
				break
			fi
		done

	done 
	avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2 2>>$out_error)
	avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2 2>>$out_error)
	echo " " >> $out_detail
	if [[ $count == '0' ]]; then
		echo  "fail" >> $out_path
		continue
	fi
	echo -n " & |N|: $N & |Delta|: $Delta & |V|: $V & avg example: $avgEx & avg time: " >> $out_path
	echo $avgT" & solved run: $count/1" >> $out_path
	
done


benchmark_if=(
fg_max2
fg_sum_2_5
fg_sum_2_15
fg_mpg_example1
fg_guard1
fg_guard2
fg_guard3
fg_guard4
)

path="benchmarks/CLIA_Track_IF/"

echo "Category: limitedIf" >> $out_detail
echo "Category: limitedIf" >> $out_path

for s in "${benchmark_if[@]}"; do
	echo "processing $s in $path"
	echo -n $s" & " >> $out_path
	count=0
	sumEx=0
	sumT=0.0
	for ((i=1; i<2; i++)); do
		for ((e=1; e<8; e++)); do
			echo -n $s" & run: $i & example: $e & " >> $out_detail
			echo "processing $s & run: $i & example: $e" >> $out_error
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i 2>>$out_error)
			echo -n $line >> $out_detail
			IFS='&'
			read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
			IFS=' '
			length=${#ADDR[@]}
			if [[ $length != '12' ]]; then
			echo -n "fail" >> $out_detail
			echo " " >> $out_detail
			break
			fi
			echo " " >> $out_detail

			
			read -ra N <<< "${ADDR[0]}"
			read -ra Delta <<< "${ADDR[1]}"
			read -ra V <<< "${ADDR[2]}"
			read -ra Ex <<< "${ADDR[3]}"
			read -ra T <<< "${ADDR[10]}"
			read -ra R <<< "${ADDR[11]}"
			if [ "${R:0:1}" = "f" ]; then
				count=$(($count + 1))
				sumT=$(echo print $T+$sumT | python2)
				sumEx=$(echo print $Ex+$sumEx | python2)
				break
			fi
		done

	done 
	avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2 2>>$out_error)
	avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2 2>>$out_error)
	echo " " >> $out_detail
	if [[ $count == '0' ]]; then
		echo  "fail" >> $out_path
		continue
	fi
	echo -n " & |N|: $N & |Delta|: $Delta & |V|: $V & example: $avgEx & time: " >> $out_path
	echo $avgT" & solved run: $count/1" >> $out_path
	
done


benchmark_const=(
example1
example2
example3
example4
example5
fg_search_2
fg_search_3
fg_search_4
fg_search_5
fg_search_6
fg_search_7
fg_search_8
fg_search_9
fg_search_10
fg_search_11
fg_search_12
fg_search_13
fg_search_14
fg_search_15
guard1
guard2
guard3
guard4
ite1
ite2
plane2
plane3
sum_2_5
sum_2_15
sum_3_5
sum_3_15
sum_4_5
sum_4_15
sum_5_5
sum_5_15
sum_6_5
sum_6_15
sum_7_5
sum_7_15
sum_8_5
sum_8_15
sum_9_5
sum_9_15
sum_10_5
sum_10_15
)

path="benchmarks/CLIA_Track_Const/"

echo "Category: limitedConst" >> $out_detail
echo "Category: limitedConst" >> $out_path

for s in "${benchmark_const[@]}"; do
	echo $s
	echo "processing $s in $path"
	echo -n $s" & " >> $out_path
	count=0
	sumEx=0
	sumT=0.0
	for ((i=1; i<2; i++)); do
		for ((e=1; e<8; e++)); do
			echo -n $s" & run: $i & example: $e & " >> $out_detail
			echo "processing $s & run: $i & example: $e" >> $out_error
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i 2>>$out_error)
			echo -n $line >> $out_detail
			IFS='&'
			read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
			IFS=' '
			length=${#ADDR[@]}
			if [[ $length != '12' ]]; then
			echo -n "fail" >> $out_detail
			echo " " >> $out_detail
			break
			fi
			echo " " >> $out_detail

			
			read -ra N <<< "${ADDR[0]}"
			read -ra Delta <<< "${ADDR[1]}"
			read -ra V <<< "${ADDR[2]}"
			read -ra Ex <<< "${ADDR[3]}"
			read -ra T <<< "${ADDR[10]}"
			read -ra R <<< "${ADDR[11]}"
			if [ "${R:0:1}" = "f" ]; then
				count=$(($count + 1))
				sumT=$(echo print $T+$sumT | python2)
				sumEx=$(echo print $Ex+$sumEx | python2)
				break
			fi
		done

	done 
	avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2 2>>$out_error)
	avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2 2>>$out_error)
	echo " " >> $out_detail
	if [[ $count == '0' ]]; then
		echo  "fail" >> $out_path
		continue
	fi
	echo -n " & |N|: $N & |Delta|: $Delta & |V|: $V & example: $avgEx & time: " >> $out_path
	echo $avgT" & solved run: $count/1" >> $out_path
	
done

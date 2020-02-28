#! /bin/sh
benchmark_plus_1=(
	mpg_guard1
	mpg_guard2
	mpg_guard3
	mpg_guard4
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

# <-- playground end
currenttime=`date +"%d%H%M"`
echo "result result/result_$currenttime.txt"
echo "detail result/result_detail_$currenttime.txt"
echo "error log error_log/log_$currenttime.txt"
path="benchmarks/CLIA_Track_PLUS_Pos/"
out_detail="result/result_detail_$currenttime.txt"
out_error="error_log/log_$currenttime.txt"
out_path="result/result_$currenttime.txt"

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
	echo -n "avg time: $avgT & avg example: " >> $out_path
	echo $avgEx >> $out_path
	
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
	echo -n "avg time: $avgT & avg example: " >> $out_path
	echo $avgEx >> $out_path
	
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
	echo -n "avg time: $avgT & avg example: " >> $out_path
	echo $avgEx >> $out_path
	
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
	echo -n "avg time: $avgT & avg example: " >> $out_path
	echo $avgEx >> $out_path
	
done


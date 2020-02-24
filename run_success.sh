#! /bin/sh
benchmark=(
	mpg_plane1
	#mpg_plane2
	#mpg_plane3
	mpg_ite1
	#mpg_ite2
	#mpg_guard1
	#mpg_guard2
	#mpg_guard3
	#mpg_guard4
	#mpg_exampl1
	#array_search_2
	#array_search_3
	#array_sum_2_5
)

# playground start -->
line="mpg_ite1 & 5 & 16 & 3 & 1 & 2 & 2.0 & 15 & 0.0 & 0.03 & 0.00 & 0.03 & f\\"
 
		count=0
		sumEx=0
		sumT=0.0
IFS='&' # hyphen (-) is set as delimiter
read -ra ADDR <<< "$line" # str is read into an array as tokens separated by IFS
IFS=' '
echo "length"
length=${#ADDR[@]}
echo $length
if [[ $length == '13' ]]; then
	echo 1
fi
echo "end"
read -ra N <<< "${ADDR[1]}"
echo "$N"
read -ra Delta <<< "${ADDR[2]}"
echo "$Delta"
read -ra V <<< "${ADDR[3]}"
echo "$V"
read -ra Ex <<< "${ADDR[4]}"
echo "$Ex"
read -ra T <<< "${ADDR[11]}"
echo "$T"
read -ra R <<< "${ADDR[12]}"
if [ "${R:0:1}" = "f" ]; then
	count=$(($count + 1))
	sumT=$(echo print $T+$sumT | python2)
	sumEx=$(echo print $Ex+$sumEx | python2)
fi


avgT=$(echo print\(\'%.2f\' % \($sumT/$count\)\) | python2)
avgEx=$(echo print\(\'%.2f\' % \($sumEx.0/$count\)\) | python2)
echo $avgT
echo $avgEx

#echo "${line:0:2}" # substring


# <-- playground end
currenttime=`date +"%d%H%M"`
echo $currenttime
path="benchmarks/CLIA_Track_PLUS_Pos/"
out_detail="result_detail_$currenttime.txt"
out_path="result_$currenttime.txt"
for s in "${benchmark[@]}"; do
	for ((i=1; i<6; i++)); do
		count=0
		sumEx=0
		sumT=0.0
		for ((e=1; e<8; e++)); do
			echo -n $s" & " >> $out_detail
			echo -n $s" & " >> $out_path
			line=$(timeout 600 java -ea -Djava.library.path=lib -jar benchmarks/WTAlib.jar $path$s $e $i)
			echo $line >> $out_detail
			echo >> $out_path
		done
		echo >> $out_path
	done 
done

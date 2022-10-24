s = 10

sum = 0
echo "enter numbers"

for((i=1; i<=10; i++))
  do
   read numbers
   if [ $(($numbers%2)) -eq 0 ] && [ $((numbers%8)) -ne 0 ] ;
     then sum=$(( $sum + $numbers ))
   fi
  done
  
echo $sum
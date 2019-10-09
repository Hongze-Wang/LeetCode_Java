# 195. Tenth Line

cat file.txt | sed -n '10p'

cat file.txt | sed '10!d'

cat file.txt | awk 'NR==10'
cat file.txt | awk 'NR==10{print}'
cat file.txt | awk '{if(NR==10) print}'
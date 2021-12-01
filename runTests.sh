#!/usr/bin/env bash
set -uo pipefail
[[ "0" == "true" ]] && set -x

echo "Running tests with Java:";
java -version

if [[ ! -d "output" ]]; then
  mkdir output
fi

java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 666 < ./test/00_easy_s666.txt > output/00_easy_s666_output.txt
diff -u test/00_easy_s666_output.txt output/00_easy_s666_output.txt > output/00_easy_s666_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 666 < ./test/01_easy_s666.txt > output/01_easy_s666_output.txt
diff -u test/01_easy_s666_output.txt output/01_easy_s666_output.txt > output/01_easy_s666_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 100 < ./test/02_easy_s100.txt > output/02_easy_s100_output.txt
diff -u test/02_easy_s100_output.txt output/02_easy_s100_output.txt > output/02_easy_s100_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars test 100 < ./test/03_test_s100.txt > output/03_test_s100_output.txt
diff -u test/03_test_s100_output.txt output/03_test_s100_output.txt > output/03_test_s100_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars hard 100 < ./test/04_hard_s100.txt > output/04_hard_s100_output.txt
diff -u test/04_hard_s100_output.txt output/04_hard_s100_output.txt > output/04_hard_s100_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 100 < ./test/05_easy_s100.txt > output/05_easy_s100_output.txt
diff -u test/05_easy_s100_output.txt output/05_easy_s100_output.txt > output/05_easy_s100_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 25 < ./test/06_easy_s25.txt > output/06_easy_s25_output.txt
diff -u test/06_easy_s25_output.txt output/06_easy_s25_output.txt > output/06_easy_s25_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/07_easy_s37.txt > output/07_easy_s37_output.txt
diff -u test/07_easy_s37_output.txt output/07_easy_s37_output.txt > output/07_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/08_easy_s37.txt > output/08_easy_s37_output.txt
diff -u test/08_easy_s37_output.txt output/08_easy_s37_output.txt > output/08_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/09_easy_s37.txt > output/09_easy_s37_output.txt
diff -u test/09_easy_s37_output.txt output/09_easy_s37_output.txt > output/09_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/10_easy_s37.txt > output/10_easy_s37_output.txt
diff -u test/10_easy_s37_output.txt output/10_easy_s37_output.txt > output/10_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/11_easy_s37.txt > output/11_easy_s37_output.txt
diff -u test/11_easy_s37_output.txt output/11_easy_s37_output.txt > output/11_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/12_easy_s37.txt > output/12_easy_s37_output.txt
diff -u test/12_easy_s37_output.txt output/12_easy_s37_output.txt > output/12_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/13_easy_s37.txt > output/13_easy_s37_output.txt
diff -u test/13_easy_s37_output.txt output/13_easy_s37_output.txt > output/13_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/14_easy_s37.txt > output/14_easy_s37_output.txt
diff -u test/14_easy_s37_output.txt output/14_easy_s37_output.txt > output/14_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/15_easy_s37.txt > output/15_easy_s37_output.txt
diff -u test/15_easy_s37_output.txt output/15_easy_s37_output.txt > output/15_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/16_easy_s37.txt > output/16_easy_s37_output.txt
diff -u test/16_easy_s37_output.txt output/16_easy_s37_output.txt > output/16_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/17_easy_s37.txt > output/17_easy_s37_output.txt
diff -u test/17_easy_s37_output.txt output/17_easy_s37_output.txt > output/17_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/18_easy_s37.txt > output/18_easy_s37_output.txt
diff -u test/18_easy_s37_output.txt output/18_easy_s37_output.txt > output/18_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/19_easy_s37.txt > output/19_easy_s37_output.txt
diff -u test/19_easy_s37_output.txt output/19_easy_s37_output.txt > output/19_easy_s37_diffs.txt
java -Dfile.encoding=UTF-8 -cp ./bin es.ucm.tp1.SuperCars easy 37 < ./test/20_easy_s37.txt > output/20_easy_s37_output.txt
diff -u test/20_easy_s37_output.txt output/20_easy_s37_output.txt > output/20_easy_s37_diffs.txt
# C
gcc -c -Wall -Werror -fpic hello.c
gcc -shared -o libhello.so hello.o
gcc -Wall -o main_hello.exe main_hello.c -L. -lhello
LD_LIBRARY_PATH=. ./main_hello.exe

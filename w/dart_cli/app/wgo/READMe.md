

# GO
go build -o libhello.so  -buildmode=c-shared  hello.go 
gcc -Wall -o main_hello main_hello.c -L. -lhello
LD_LIBRARY_PATH=. ./main_hello -L. -lhello

# C
gcc -c -Wall -Werror -fpic iello.c
gcc -shared -o libiello.so iello.o
gcc -Wall -o main_iello -liello
gcc -Wall -o main_iello main_iello.c -L. -liello
LD_LIBRARY_PATH=. ./main_iello 


objdump -s libiello.so


# GO
go build -o libhello.so  -buildmode=c-shared  hello.go 
gcc -Wall -o main_hello.exe main_hello.c -L. -lhello
LD_LIBRARY_PATH=. ./main_hello.exe -L. -lhello


objdump -s libiello.so
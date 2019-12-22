package main

import "C"
import "fmt"

//export PrintHello
func PrintHello() {
	fmt.Print("xx")
}

func main() {}

package main

import "C"
import "fmt"

//export PrintHello
func PrintHello() {
	fmt.Print("Hello,World")
}

func main() {}

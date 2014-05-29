package main

import "fmt"

func main() {
    a := []int{1, 2, 3, 4, 5}
    b := a[:1]
    b[0] = 5
    fmt.Printf("%d\n", a[0])
}
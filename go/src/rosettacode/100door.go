package main

import "fmt"

type Door struct {
    closed bool
}

func main() {
    var a [100]Door;
    for i := 0; i < len(a); i++ {
        a[i].closed = true;
    }

    for pass := 1; pass <= 100; pass++ {
        for pos := pass - 1; pos < len(a); pos += pass {
            if a[pos].closed {
                a[pos].closed = false
            } else {
                a[pos].closed = true
               }
        }
    }

    for i := 0; i < len(a); i++  {
        fmt.Printf("%d: %t\n", i + 1, a[i].closed)
    }
}
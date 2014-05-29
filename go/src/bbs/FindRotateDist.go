package main

import "fmt"

func findRotateDist(a []int) int {
    fmt.Println(a);

    if len(a) == 1 {
        return 0;
    }

    if len(a) == 2 {
        if a[0] <= a[1] {
            return 0;
        } else {
            return 1;
        }
    }

    mid := len(a) / 2;
    if a[mid] < a[len(a) - 1] {
        return findRotateDist(a[:mid]);
    } else {
        return mid + 1 + findRotateDist(a[mid+1:]);
    }
}

func main() {
    a := []int{6, 6, 6, 7, 9, 10, 14, 1, 2, 3, 4, 5, 6}
    fmt.Println(findRotateDist(a));
}


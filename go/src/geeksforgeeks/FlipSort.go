package main

import "fmt"

func flip(a []int) {
  for i := 0; i < len(a) / 2; i++ {
      t := a[i];
      a[i] = a[len(a) - i - 1];
      a[len(a) - i - 1] = t;
  }
}

func printa(a []int) {
  for i := 0; i < len(a); i++ {
      fmt.Printf("%d, ", a[i]);
  }
  fmt.Printf("\n");
}

func flip_sort(a []int) {
    printa(a);

    if len(a) == 1 {
        return
    }

    v := a[0];
    p := -1;
    for i := 1; i < len(a); i++ {
        if a[i] < v {
            p = i
            break;
        }
    }

    if p < 0 {
        flip_sort(a[1:])
    } else {
        flip(a[p:])
        flip(a)
        p = -1
        for i := 1; i < len(a); i++ {
            if a[i] > v {
                p = i
                break;
            }
        }

        if p < 0 {
            flip_sort(a[:len(a)-1])
        } else {
            flip(a[p:])
            flip_sort(a[:p])
            flip_sort(a[p+1:])
        }
    }
}

func main() {
  a := []int{5, 7, 1, 3, 4, 3, 2, 1};
  flip_sort(a[:]);
  printa(a);
}
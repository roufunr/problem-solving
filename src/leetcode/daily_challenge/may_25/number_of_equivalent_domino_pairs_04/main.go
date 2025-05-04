package main

import (
	"fmt"
	"strconv"
)

func getMax(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
func getMin(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
func sum(n int) int {
	return ((n - 1) * n) / 2
}
func numEquivDominoPairs(dominoes [][]int) int {
	pairCount := make(map[string]int)
	for idx := range len(dominoes) {
		item := dominoes[idx]
		key := strconv.Itoa(getMin(item[0], item[1])) + "_" + strconv.Itoa(getMax(item[0], item[1]))
		_, isExist := pairCount[key]
		if isExist == false {
			pairCount[key] = 1
		} else {
			pairCount[key] += 1
		}
	}
	ans := 0
	for _, value := range pairCount {
		if value == 1 {
			continue
		}
		ans += sum(value)
	}
	return ans
}

func main() {
	dominoes := [][]int{{1, 2}, {1, 2}, {1, 2}, {1, 2}, {2, 2}}
	fmt.Println(numEquivDominoPairs(dominoes))
}

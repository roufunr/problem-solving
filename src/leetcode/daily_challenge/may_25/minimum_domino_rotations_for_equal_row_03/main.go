package main

import (
	"fmt"
	"math"
)

func minimum(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

func maximum(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func minDominoRotations(tops []int, bottoms []int) int {
	m := make(map[int]int)
	mtop := make(map[int]int)
	mbottom := make(map[int]int)
	for idx := range 6 {
		m[idx+1] = 0
		mtop[idx+1] = 0
		mbottom[idx+1] = 0
	}
	for idx := range len(tops) {
		mtop[tops[idx]] += 1
		mbottom[bottoms[idx]] += 1
		if tops[idx] == bottoms[idx] {
			m[tops[idx]] += 1
			continue
		}
		m[tops[idx]] += 1
		m[bottoms[idx]] += 1
	}
	// fmt.Println(m, mtop, mbottom)
	minima := math.MaxInt
	for idx := range 6 {
		if m[idx+1] == len(tops) {
			topCount := mtop[idx+1]
			bottomCount := mbottom[idx+1]
			tempMin := len(tops) - maximum(topCount, bottomCount)
			minima = minimum(tempMin, minima)
		}
	}
	if minima == math.MaxInt {
		return -1
	}
	return minima
}

func main() {
	ans := minDominoRotations([]int{2, 1, 2, 4, 2, 2}, []int{5, 2, 6, 2, 3, 2})
	fmt.Println(ans)
}

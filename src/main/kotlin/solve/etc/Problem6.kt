package com.linecorp.lcp.config.solve.etc

class Problem6 {
    fun solution(arr: IntArray) {
        val idx = arr.binarySearch(2, 0, arr.size - 1)
        println("Solution: $idx")
        if (idx < 0) {
            println("not found")
        } else {
            println("found at $idx")
        }
    }
}

fun main() {
    val arr = intArrayOf(0, 3, 5, 6, 1, 2, 4)
    arr.sort()
    Problem6().solution(arr)
}

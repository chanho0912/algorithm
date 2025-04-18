package com.linecorp.lcp.config.solve.baekjoon

val arr = Array(13) { IntArray(13) }

fun solution() {
    val input = readln().toInt()
    val solved = factorial(input)
    println(solved)
}

fun factorial(n: Int): Int {
    if (n == 0 || n == 1) return 1
    if (arr[n][n - 1] > 0) return arr[n][n - 1]

    val result = n * factorial(n - 1)
    arr[n][n - 1] = result
    return result
}

fun main() {
    solution()
}

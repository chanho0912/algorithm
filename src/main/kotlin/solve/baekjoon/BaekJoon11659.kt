package com.linecorp.lcp.config.solve.baekjoon

class BaekJoon11659(input: Array<Int>) {
    private val arr = IntArray(100_000 + 1)

    init {
        arr[0] = 0
        for (i in 1..input.size) arr[i] = arr[i - 1] + input[i - 1]
    }

    // input = 5 4 3 2 1
    // arr = 5 9 12 14 15
    // arr = 0 5 9 12 14 15
    // 1 3 => arr[3] - arr[0]
    // 2 4 => arr[4] - arr[1]
    fun solve(from: Int, to: Int): Int = arr[to] - arr[from - 1]
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val input = readln().split(" ").map { it.toInt() }.toTypedArray()
    val solution = BaekJoon11659(input)
    repeat(m) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        val result = solution.solve(from, to)
        println(result)
    }
}

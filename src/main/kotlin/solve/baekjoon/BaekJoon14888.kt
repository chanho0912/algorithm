package com.linecorp.lcp.config.solve.baekjoon

/**
 * operatorCnt
 * 0 -> +
 * 1 -> -
 * 2 -> *
 * 3 -> /
 */
var n: Int = 0

data class Result(var max: Int = Int.MIN_VALUE, var min: Int = 0)

class BaekJoon14888 {

    fun solve(cursor: Int, operatorCnt: IntArray, input: IntArray, calc: Int, max: Int, min: Int): Result {
        if (cursor == n - 1) return Result(max = Math.max(calc, max), min = Math.min(calc, min))

        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE

        if (operatorCnt[0] > 0) {
            operatorCnt[0] -= 1
            val r = solve(cursor + 1, operatorCnt, input, calc + input[cursor + 1], max, min)
            operatorCnt[0] += 1
            max = r.max.coerceAtLeast(max)
            min = r.min.coerceAtMost(min)
        }

        if (operatorCnt[1] > 0) {
            operatorCnt[1] -= 1
            val r = solve(cursor + 1, operatorCnt, input, calc - input[cursor + 1], max, min)
            operatorCnt[1] += 1
            max = r.max.coerceAtLeast(max)
            min = r.min.coerceAtMost(min)
        }

        if (operatorCnt[2] > 0) {
            operatorCnt[2] -= 1
            val r = solve(cursor + 1, operatorCnt, input, calc * input[cursor + 1], max, min)
            operatorCnt[2] += 1
            max = r.max.coerceAtLeast(max)
            min = r.min.coerceAtMost(min)
        }

        if (operatorCnt[3] > 0) {
            operatorCnt[3] -= 1
            val r = solve(cursor + 1, operatorCnt, input, calc / input[cursor + 1], max, min)
            operatorCnt[3] += 1
            max = r.max.coerceAtLeast(max)
            min = r.min.coerceAtMost(min)
        }

        return Result(max = max, min = min)
    }
}

fun main() {

    n = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }.toIntArray()
    val operatorCnt = readln().split(" ").map { it.toInt() }.toIntArray()

    val result = BaekJoon14888().solve(0, operatorCnt, input, input[0], Int.MIN_VALUE, Int.MAX_VALUE)
    println("${result.max}\n${result.min}")
}

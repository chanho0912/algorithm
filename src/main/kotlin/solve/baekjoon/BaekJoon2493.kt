package com.linecorp.lcp.config.solve.baekjoon

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toTypedArray()

    val result = solve(n, arr)
    println(result.joinToString(" "))
}

data class Top(val index: Int, val height: Int)

fun solve(n: Int, input: Array<Int>): IntArray {
    val result = IntArray(n)
    val stack = Stack<Top>()

    stack.push(Top(0, input[0]))
    for (i in 1 until n) {

        while (stack.isNotEmpty() && stack.peek().height <= input[i]) stack.pop()

        if (stack.isEmpty()) {
            result[i] = 0
        } else {
            val previous = stack.peek()
            result[i] = previous.index + 1
        }

        stack.push(Top(i, input[i]))
    }

    return result
}

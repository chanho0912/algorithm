package com.linecorp.lcp.config.solve.baekjoon

import java.util.*

class BaekJoon1158 {
    fun solution() {
        val (n, k) = readln().split(" ").map { it.toInt() }
        val list = LinkedList<Int>()
        val result = LinkedList<Int>()

        for (i in 1..n) list.add(i)
        var nextIndex = k - 1

        while (list.size > 0) {
            if (nextIndex >= list.size)
                nextIndex = nextIndex % list.size

            result.add(list.removeAt(nextIndex))
            nextIndex += k - 1
        }

        print("<${result.joinToString(", ")}>")
    }
}

fun main() {
    BaekJoon1158().solution()
}

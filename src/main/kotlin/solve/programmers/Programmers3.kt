package com.linecorp.lcp.config.solve.programmers

import java.util.*

internal class Solution123 {
    fun solution(prices: IntArray): IntArray {
        val queue = LinkedList<Int>()
        for (p in prices) queue.offerLast(p)

        val answers = IntArray(prices.size)
        var index = 0
        while (queue.size > 0) {
            var count = 0
            val current = queue.poll()

            for (next in queue) {
                if (current > next) {
                    count += 1
                    break
                }
                count += 1
            }

            answers[index] = count
            index += 1
        }

        return answers
    }
}

fun main() {
    val res = Solution123().solution(intArrayOf(3, 1, 2, 1, 2))
    println(res.joinToString(prefix = "[", postfix = "]", separator = ","))
}

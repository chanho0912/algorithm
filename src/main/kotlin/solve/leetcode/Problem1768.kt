package com.linecorp.lcp.config.solve.leetcode

class Solution1768 {
    fun mergeAlternately(word1: String, word2: String): String {
        var p1 = 0
        var p2 = 0

        val sb = StringBuilder()
        while (p1 < word1.length && p2 < word2.length) {
            sb.append(word1[p1])
            sb.append(word2[p2])

            p1 += 1
            p2 += 1
        }

        while (p1 < word1.length) {
            sb.append(word1[p1])
            p1 += 1
        }

        while (p2 < word2.length) {
            sb.append(word2[p2])
            p2 += 1
        }

        return sb.toString()
    }
}

fun main() {
    val solution1768 = Solution1768()
    val word1 = "abcd"
    val word2 = "pq"
    val result = solution1768.mergeAlternately(word1, word2)
    println(result)
}

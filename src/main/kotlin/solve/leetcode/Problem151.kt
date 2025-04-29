package com.linecorp.lcp.config.solve.leetcode

class Solution151 {
    private val words = mutableListOf<String>()
    fun reverseWords(s: String): String {
        var word = StringBuilder()

        for (c in s) {
            if (c == ' ') {
                if (word.isNotEmpty()) {
                    words.add(word.toString())
                    word = StringBuilder()
                }
            } else {
                word.append(c)
            }
        }

        if (word.isNotEmpty()) words.add(word.toString())

        val result = StringBuilder()
        for (i in words.size - 1 downTo 0) {
            result.append(words[i])
            if (i != 0) result.append(" ")
        }

        return result.toString()
    }
}

fun main() {
    val solution151 = Solution151()
    val s = "  hello world!  "
    val result = solution151.reverseWords(s)
    println(result) // Output: "world! hello"
}

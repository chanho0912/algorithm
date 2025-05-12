package com.linecorp.lcp.config.solve.leetcode

import java.util.Stack

class Problem2390 {
    fun removeStars(s: String): String {

        val stack = Stack<Char>()
        for (c in s) {
            if (c == '*' && stack.isNotEmpty()) {
                stack.pop()
                continue
            }

            stack.push(c)
        }

        val result = StringBuilder()
        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }

        return result.reverse().toString()
    }
}

fun main(args: Array<String>) {

    Problem2390().removeStars("leet**cod*e").let(::println)
}

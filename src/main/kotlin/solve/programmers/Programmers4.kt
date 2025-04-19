package com.linecorp.lcp.config.solve.programmers

import java.util.*

class Solution12909 {
    fun solution(s: String): Boolean {
        val stack = Stack<Char>()

        for (i in 0..s.length - 1) {
            if (s[i] == '(') {
                stack.push(s[i])
                continue
            }

            if (stack.isEmpty()) return false

            stack.pop()
        }

        return stack.isEmpty()
    }
}

fun main() {
    println(Solution12909().solution("()"))
}

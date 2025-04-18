package com.linecorp.lcp.config.solve.baekjoon

fun isPalindrome(input: CharArray, left: Int, right: Int, erased: Boolean): Int {
    if (left >= right) {
        return if (erased) 1 else 0
    }

    if (input[left] == input[right]) {
        return isPalindrome(input, left + 1, right - 1, erased)
    }

    if (!erased) {
        val r1 = isPalindrome(input, left + 1, right, true)
        if (r1 <= 1) return r1
        val r2 = isPalindrome(input, left, right - 1, true)
        return r2
    }

    return 2
}

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val arr = readln().toCharArray()
        val result = isPalindrome(arr, 0, arr.size - 1, false)
        println(result)
    }
}

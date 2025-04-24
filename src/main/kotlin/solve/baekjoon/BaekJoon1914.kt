package com.linecorp.lcp.config.solve.baekjoon

fun move(n: Int, from: Int, via: Int, to: Int) {
    if (n == 1) {
        println("$from $to")
    } else {
        move(n - 1, from, to, via)
        println("$from $to")
        move(n - 1, via, from, to)
    }
}

fun plus(a: String, b: String): String {
    val maxLength = maxOf(a.length, b.length)
    val result = StringBuilder()
    var carry = 0

    for (i in 0 until maxLength) {
        val digitA = if (i < a.length) a[a.length - 1 - i] - '0' else 0
        val digitB = if (i < b.length) b[b.length - 1 - i] - '0' else 0
        val sum = digitA + digitB + carry
        result.append(sum % 10)
        carry = sum / 10
    }
    if (carry > 0) result.append(carry)
    return result.reverse().toString()
}

fun main() {
    val n = readln().toInt()
    val arr = Array(n + 1) { "0" }
    arr[1] = "1"
    arr[2] = "3"
    for (i in 3..n) arr[i] = plus(plus(arr[i - 1], arr[i - 1]), "1")
    println(arr[n])
    if (n <= 20) move(n, 1, 2, 3)
}

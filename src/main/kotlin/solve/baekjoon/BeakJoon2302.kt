package com.linecorp.lcp.config.solve.baekjoon

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val dp = IntArray(n + 1) { 1 }

    var lastVip = 0
    val needCalc = mutableListOf<Int>()

    repeat(m) {
        val vip = readln().toInt()
        needCalc.add(vip - lastVip - 1)
        lastVip = vip
    }

    needCalc.add(n - lastVip)

    for (i in 2.. n) dp[i] = dp[i - 1] + dp[i - 2]

    var result = 1
    for (i in needCalc) result *= dp[i]
    println(result)
}

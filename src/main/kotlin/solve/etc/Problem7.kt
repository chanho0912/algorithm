package com.linecorp.lcp.config.solve.etc

import java.util.*

fun solve(stock: Int, dates: IntArray, supplies: IntArray, k: Int): Int {
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first == b.first) {
            b.second - a.second
        } else {
            b.first - a.first
        }
    }

    for (i in dates.indices) pq.add(Pair(supplies[i], dates[i]))

    var result = 0
    var cur = stock

    while (cur < k && pq.isNotEmpty()) {
        val polled = pq.poll()!!
        if (polled.second > cur) continue
        cur += polled.first
        result += 1
    }

    return result
}

fun main() {

    println(solve(4, intArrayOf(4, 10, 15), intArrayOf(20, 5, 10), 30))
    println(solve(4, intArrayOf(4, 10, 15), intArrayOf(20, 5, 10), 30))
    println(solve(4, intArrayOf(4, 10, 15, 20), intArrayOf(20, 5, 10, 5), 40))
    println(solve(2, intArrayOf(1, 10), intArrayOf(10, 100, 20), 11))
}

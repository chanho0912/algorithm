package com.linecorp.lcp.config.solve.leetcode

class RecentCounter {
    private val queue = ArrayDeque<Int>()
    fun ping(t: Int): Int {
        while (queue.isNotEmpty() && queue.first() < t - 3000) queue.removeFirst()

        queue.addLast(t)
        return queue.size
    }
}

fun main() {
    val obj = RecentCounter()
    println(obj.ping(1))
    println(obj.ping(100))
    println(obj.ping(3001))
    println(obj.ping(3002))
}

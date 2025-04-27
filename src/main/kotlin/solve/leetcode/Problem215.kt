package com.linecorp.lcp.config.solve.leetcode

import java.util.PriorityQueue

class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        nums.forEach { pq.add(it) }

        var result = 0
        repeat(k) { result = pq.poll() }

        return result
    }
}

package com.linecorp.lcp.config.solve.leetcode

class Solution643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0L
        for (i in 0 until k) {
            sum += nums[i]
        }

        var maxSum = sum

        for (i in k until nums.size) {
            sum += nums[i] - nums[i - k]
            if (sum > maxSum) {
                maxSum = sum
            }
        }

        return maxSum.toDouble() / k
    }
}

fun main() {
    val solution = Solution643()
    val result = solution.findMaxAverage(intArrayOf(0, 1, 1, 3, 3), 4)
    println(result)
}

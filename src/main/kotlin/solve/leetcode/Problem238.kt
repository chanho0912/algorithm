package com.linecorp.lcp.config.solve.leetcode

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixProducts = IntArray(nums.size)
        val suffixProducts = IntArray(nums.size)

        for (i in nums.indices)
            prefixProducts[i] = if (i == 0) nums[i] else nums[i] * prefixProducts[i - 1]

        for (i in nums.size - 1 downTo 0)
            suffixProducts[i] = if (i == nums.size - 1) nums[i] else nums[i] * suffixProducts[i + 1]


        val result = IntArray(nums.size)
        for (i in nums.indices) {
            when (i) {
                0 -> result[i] = suffixProducts[i + 1]
                nums.size - 1 -> result[i] = prefixProducts[i - 1]
                else -> result[i] = prefixProducts[i - 1] * suffixProducts[i + 1]
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution238()
    println(solution.productExceptSelf(intArrayOf(-1,1,0,-3,3)).contentToString())
}

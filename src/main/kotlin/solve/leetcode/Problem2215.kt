package com.linecorp.lcp.config.solve.leetcode

class Solution2215 {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val nums1Set = nums1.toSet()
        val nums2Set = nums2.toSet()

        return listOf(
            (nums1Set - nums2Set).toList(),
            (nums2Set - nums1Set).toList()
        )
    }
}

fun main() {
    val solution = Solution2215()
    println(solution.findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6)))
    println(solution.findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2)))
}

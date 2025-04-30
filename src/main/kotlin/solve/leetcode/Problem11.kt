package com.linecorp.lcp.config.solve.leetcode

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            val width = right - left
            val minHeight = minOf(height[left], height[right])

            val area = width * minHeight
            maxArea = maxOf(area, maxArea)

            if (height[left] < height[right]) left++ else right--
        }

        return maxArea
    }
}

fun main() {
    println(Solution11().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

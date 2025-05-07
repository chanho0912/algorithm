package com.linecorp.lcp.config.solve.leetcode

class Problem1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean {

        val count = IntArray(2000 + 1)
        val freq = HashMap<Int, Int>()

        for (i in arr.indices)
            count[arr[i] + 1000] += 1

        for (i in count.indices) {
            if (count[i] > 0) {
                if (freq.containsKey(count[i])) {
                    return false
                } else {
                    freq[count[i]] = 1
                }
            }
        }

        return true
    }
}

fun main() {
//    Problem1207().uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)).let(::println)
//    Problem1207().uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)).let(::println)
    Problem1207().uniqueOccurrences(intArrayOf(1, 2)).let(::println)
}

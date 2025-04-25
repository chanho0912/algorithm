package com.linecorp.lcp.config.solve.leetcode

class Solution1071 {
    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    private fun check(str: String, commonDivisor: String): Boolean {
        var cursor = 0
        while (cursor + commonDivisor.length <= str.length) {
            if (str.length % commonDivisor.length != 0) return false
            if (str.substring(cursor, cursor + commonDivisor.length) != commonDivisor) return false

            cursor += commonDivisor.length
        }
        return true
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        var gcd = ""
        val gcdLength = gcd(str1.length, str2.length)
        val base = if (str1.length < str2.length) str1 else str2

        for (i in 1 .. gcdLength) {
            val commonDivisor = base.substring(0, i)

            if (!check(str1, commonDivisor)) continue
            if (!check(str2, commonDivisor)) continue

            if (commonDivisor.length > gcd.length) gcd = commonDivisor
        }

        return gcd
    }
}

fun main() {
    val solution1071 = Solution1071()
    val str1 = "ABABAB"
    val str2 = "ABA"
    val result = solution1071.gcdOfStrings(str1, str2)
    println(result) // Output: "AB"
}

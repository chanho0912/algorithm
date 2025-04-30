package com.linecorp.lcp.config.solve.leetcode

class Solution1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val arr1 = IntArray(26)
        val arr2 = IntArray(26)
        val wordSet = mutableSetOf<Char>()

        for (c in word1) {
            arr1[c - 'a'] += 1
            wordSet.add(c)
        }
        for (c in word2) {
            if (!wordSet.contains(c)) return false
            arr2[c - 'a'] += 1
        }

        for (i in 0..25)
            for (j in 0..25) {
                if (arr1[i] == arr2[j]) {
                    if (arr1[i] == 0) continue
                    arr1[i] = -1
                    arr2[j] = -1
                    break
                }
            }

        for (i in 0..25)
            if (arr1[i] > 0 || arr2[i] > 0) return false

        return true
    }
}

fun main() {
    println(Solution1657().closeStrings("abc", "bca")) // true
    println(Solution1657().closeStrings("a", "aa")) // false
    println(Solution1657().closeStrings("cabbba", "abbccc")) // true
    println(Solution1657().closeStrings("uau", "ssx")) // false

    // a 1 b 3 z 1 c 1 f 1
    // a 1 b 2 z 3 c 1
}

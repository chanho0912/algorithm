package com.linecorp.lcp.config.solve.baekjoon

class BaekJoon1439 {
    fun solution() {
        val input = readln().toCharArray()
        val n = input.size

        if (n <= 1) {
            println(0)
            return
        }

        var cnt = 0
        for (i in 1..input.size - 1) {
            if (input[i] != input[i - 1]) {
                cnt += 1
            }
        }

        if (cnt <= 1) {
            println(cnt)
            return
        }
        if (cnt % 2 == 0) {
            println(cnt / 2)
            return
        }

        println(cnt / 2 + 1)
    }
}

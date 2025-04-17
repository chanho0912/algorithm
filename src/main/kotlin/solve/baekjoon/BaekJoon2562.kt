package com.linecorp.lcp.config.solve.baekjoon

class BaekJoon2562 {
    fun solve() {
        val numbers = IntArray(9)
        var max = 0
        var index = 0
        repeat(numbers.size) {
            numbers[it] = readLine()!!.toInt()
            if (numbers[it] > max) {
                max = numbers[it]
                index = it + 1
            }
        }

        println(max)
        println(index)
    }
}

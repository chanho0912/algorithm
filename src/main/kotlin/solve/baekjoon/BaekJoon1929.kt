package com.linecorp.lcp.config.solve.baekjoon

class BaekJoon1929 {
    fun solution() {
        val input = readln().split(" ")

        val m = input[0].toInt()
        val n = input[1].toInt()

        val eratos = IntArray(n + 1) { 1 }
        eratos[0] = 0
        eratos[1] = 0
        val until = Math.sqrt(n.toDouble()).toInt() + 1

        for (i in 2..until)
            for (j in 2..n) {
                if (eratos[i] == 1) {
                    if (i * j <= n) eratos[i * j] = 0
                }
            }

        for (i in m..n) if (eratos[i] == 1) println(i)
    }
}

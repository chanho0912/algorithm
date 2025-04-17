package com.linecorp.lcp.config.solve.etc

import kotlin.math.max

class Problem1 {
    fun solution(array: IntArray): Int {

        val result = IntArray(array.size) { i -> array[i] }
        for (index in 1 until array.size)
            result[index] = max(result[index - 1] + array[index], result[index - 1] * array[index])

//        for (r in result) println(r)
        return result.last()
    }
}

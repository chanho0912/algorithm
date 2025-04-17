package com.linecorp.lcp.config.solve.programmers

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120812?language=kotlin
 */
class Programmers1 {
    fun solution(array: IntArray): Int {
        var maxCnt = 0
        var maxNumber = 0
        val result = IntArray(1000 + 1) { 0 }
        for (index in 0 until array.size) {
            result[array[index]]++

            if (maxCnt < result[array[index]]) {
                maxCnt = result[array[index]]
                maxNumber = array[index]
            }
        }

        for (index in 0 until array.size)
            if (result[array[index]] == maxCnt)
                if (array[index] != maxNumber)
                    return -1

        return maxNumber
    }
}

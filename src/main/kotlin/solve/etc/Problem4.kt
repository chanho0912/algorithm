package com.linecorp.lcp.config.solve.etc

class Problem4 {
    fun solution(input: String): String {
        if (input.length == 1) return "${input}1"

        var previous = input[0]
        var result = ""
        var cnt = 1
        for (index in 1..input.length - 1) {
            if (previous == input[index]) {
                cnt++
            }
            if (previous != input[index]) {
                result += "${previous}${cnt}/"
                cnt = 1
                previous = input[index]
            }
        }

        result += "${previous}${cnt}"
        return result
    }
}

package com.linecorp.lcp.config.solve.etc


/**
 * Q. 다음과 같이 영어로 되어 있는 문자열이 있을 때, 이 문자열에서 반복되지 않는 첫번째 문자를 반환하시오. 만약 그런 문자가 없다면 _ 를 반환하시오.
 * "abadabac" # 반복되지 않는 문자는 d, c 가 있지만 "첫번째" 문자니까 d를 반환해주면 됩니다!
 */
class Problem2 {

    fun solution(input: String): Char {
        val count = IntArray(128)
        for (c in input)
            count[c.code] += 1

        for (c in input) if (count[c.code] == 1) return c
        return '_'
    }
}

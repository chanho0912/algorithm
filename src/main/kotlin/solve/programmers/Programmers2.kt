package com.linecorp.lcp.config.solve.programmers

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * **DP에서는 항상 고유한 상태 (sum + index 조합 등)**를 기준으로 메모이제이션해야 합니다.
 * 지금 코드는 sum, next_sum만으로 중복 체크하고 있는데, pointer가 다르면 완전히 다른 경로임에도 중복으로 간주돼요.
 */
var visited = Array(2000 + 1) { IntArray(2000 + 1) { -1 } }

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        val answer = calculate(0, target, 0, numbers)
        return answer
    }
}

fun calculate(sum: Int, target: Int, pointer: Int, numbers: IntArray): Int {
    if (pointer == numbers.size)
        return if (sum == target) 1 else 0

    if (visited[pointer][sum + 1000] != -1) return visited[pointer][sum + 1000]

    val plus = calculate(sum + numbers[pointer], target, pointer + 1, numbers)
    val minus = calculate(sum - numbers[pointer], target, pointer + 1, numbers)

    visited[pointer][sum + 1000] = plus + minus
    return visited[pointer][sum + 1000]
}

fun main() {
    val numbers = intArrayOf(50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50)
    val solved = Solution().solution(numbers, 1000)
    println(solved)
}

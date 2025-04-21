package com.linecorp.lcp.config.solve.programmers

import java.util.*

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
class Solution42579 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val genreCnt = mutableMapOf<String, Int>()
        val genreSequentialMap = mutableMapOf<String, LinkedList<Pair<Int, Int>>>()
        for (i in genres.indices) {
            if (genreCnt.containsKey(genres[i])) {
                genreCnt[genres[i]] = genreCnt[genres[i]]!! + plays[i]
                genreSequentialMap[genres[i]]!!.add(i to plays[i])
            } else {
                genreCnt[genres[i]] = plays[i]
                genreSequentialMap[genres[i]] = LinkedList<Pair<Int, Int>>()
                genreSequentialMap[genres[i]]!!.add(i to plays[i])
            }
        }

        val answer = mutableListOf<Int>()
        val sorted = genreCnt.entries.sortedByDescending { it.value }

        for (g in sorted) {
            val list = genreSequentialMap[g.key]!!
            if (list.size == 1) {
                answer.add(list[0].first)
                continue
            }
            list.sortWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
            answer.add(list[0].first)
            answer.add(list[1].first)
        }

        return answer.toIntArray()
    }
}

fun main() {
    val result = Solution42579().solution(
        arrayOf("classic", "pop", "classic", "classic", "pop"),
        intArrayOf(500, 600, 150, 800, 2500)
    )
    println(result.joinToString(separator = ", "))
}

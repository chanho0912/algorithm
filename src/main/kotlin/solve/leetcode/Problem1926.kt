package com.linecorp.lcp.config.solve.leetcode

import java.util.*

class Solution1926 {
    private val visited = Array(100 + 1) { IntArray(100 + 1) { -1 } }
    private val directions = listOf(
        0 to 1,
        0 to -1,
        -1 to 0,
        1 to 0
    )

    private data class Pos(private val x: Int, private val y: Int, private val cnt: Int) {
        fun getPosition(): Pair<Int, Int> = Pair(x, y)
        fun getCount(): Int = cnt
    }

    private fun isEdge(m: Int, n: Int, pos: Pair<Int, Int>): Boolean {
        return pos.first == 0 || pos.first == m - 1 || pos.second == 0 || pos.second == n - 1
    }

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val m = maze.size
        val n = maze[0].size

        val queue = LinkedList<Pos>()
        val ent = Pos(entrance[0], entrance[1], 0)
        queue.offer(ent)
        visited[entrance[0]][entrance[1]] = 0

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val pos = cur.getPosition()
//            println("pos: $pos")
            val count = cur.getCount()
//            visited[pos.first][pos.second] = count

            if (isEdge(m, n, pos) && pos != entrance[0] to entrance[1] && maze[pos.first][pos.second] == '.') {
                return count
            }

            for (direction in directions) {
                val next = pos.first + direction.first to pos.second + direction.second

                if (next.first >= m || next.first < 0 || next.second >= n || next.second < 0) continue
                if (visited[next.first][next.second] != -1) continue
                if (maze[next.first][next.second] == '+') continue

                visited[next.first][next.second] = count + 1
                queue.offer(Pos(next.first, next.second, count + 1))
            }
        }

        return -1
    }
}

fun main() {
//    println(
//        Solution1926().nearestExit(
//            arrayOf(
//                charArrayOf('+', '+', '+'),
//                charArrayOf('.', '.', '.'),
//                charArrayOf('+', '+', '+')
//            ), intArrayOf(1, 0)
//        )
//    )

    println(
        Solution1926().nearestExit(
            arrayOf(
                charArrayOf('+', '+', '.', '+'),
                charArrayOf('.', '.', '.', '+'),
                charArrayOf('+', '+', '+', '.')
            ), intArrayOf(1, 2)
        )
    )
}

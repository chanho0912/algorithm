package com.linecorp.lcp.config.solve.leetcode

class Solution841 {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        dfs(0, rooms, visited)
        return visited.all { it }
    }

    private fun dfs(cur: Int, rooms: List<List<Int>>, visited: BooleanArray) {
        visited[cur] = true
        for (next in rooms[cur]) {
            if (!visited[next]) dfs(next, rooms, visited)
        }
    }
}

fun main() {
//    println(Solution841().canVisitAllRooms(listOf(listOf(2, 3), listOf(), listOf(2), listOf(1, 3))))
    println(Solution841().canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
}

package com.linecorp.lcp.config.solve.baekjoon

import java.util.*

var empty = LinkedList<Char>()

class BaekJoon1874 {

    // 4 3 1 5 2
    // 4 -> 1, 2, 3, 4 pop(4)
    // 3 -> 1, 2 pop(3)
    // 1 ->
    fun solve(n: Int, arr: IntArray): LinkedList<Char> {
        val stack = Stack<Int>()
        val result = LinkedList<Char>()
        var num = 1
        var cursor = 0
        for (i in arr.indices) {
            if (num > n) break
            val next = arr[i]

            while (stack.isEmpty() || stack.peek() < next) {
                stack.push(num++)
                result.add('+')
            }

            if (stack.peek() > next) {
                return empty
            }

            if (stack.peek() == next) {
                stack.pop()
                result.add('-')
            }

            cursor = i
        }

        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            if (pop == arr[cursor + 1]) {
                result.add('-')
                cursor += 1
            } else return empty
        }

        return result
    }
}

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = readln().toInt()
    }

    val result = BaekJoon1874().solve(n, arr)
    if (result.isEmpty()) print("NO")
    else for (r in result) println(r)
}

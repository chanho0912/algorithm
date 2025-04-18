package com.linecorp.lcp.config.solve.etc

class Problem5 {
    fun solution(
        list1: LinkedList<Int>,
        list2: LinkedList<Int>
    ): Int {

        var num1 = 0
        var num2 = 0

        var current: Node<Int>? = list1.head
        while (current != null) {
            num1 = num1 * 10 + current.data
            current = current.next
        }

        current = list2.head
        while (current != null) {
            num2 = num2 * 10 + current.data
            current = current.next
        }

        return num1 + num2
    }
}

fun main() {
    val list1 = LinkedList<Int>(6)
    list1.append(7)
    list1.append(8)

    val list2 = LinkedList<Int>(3)
    list2.append(5)
    list2.append(4)

    val solved = Problem5().solution(list1, list2)
    println(solved) // 1032
}

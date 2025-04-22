package com.linecorp.lcp.config.solve.etc

class MaxHeap {
    var items = mutableListOf<Int>().apply {
        add(-1)
    }

    fun insert(value: Int) {
        items.add(value)
        var idx = items.size - 1

        while (idx != 1) {
            val parent = idx / 2
            if (items[parent] < items[idx]) swap(parent, idx)
            idx = parent
        }
    }

    fun deleteMax(): Int {
        if (items.size == 1) return -1
        if (items.size == 2) return items.removeLast()

        val lastIdx = items.size - 1
        /**
         * swap root and last
         * max item will be placed in last index
         */
        swap(1, lastIdx)

        /**
         * get max item from last index and remove last
         */
        val max = items.removeLast()

        var current = 1
        while (true) {
            val leftC = if (items.size > current * 2) items[current * 2] else null
            val rightC = if (items.size > current * 2 + 1) items[current * 2 + 1] else null

            if (leftC == null) {
                break
            }

            if (rightC == null) {
                if (items[current] < leftC) {
                    swap(current, current * 2)
                    current = current * 2
                    continue
                }

                break
            }

            if (leftC < rightC && rightC > items[current]) {
                swap(current, current * 2 + 1)
                current = current * 2 + 1
                continue
            }

            if (leftC > rightC && leftC > items[current]) {
                swap(current, current * 2)
                current = current * 2
                continue
            }

            break
        }

        return max
    }

    private fun swap(parent: Int, idx: Int) {
        val tmp = items[parent]
        items[parent] = items[idx]
        items[idx] = tmp
    }

    fun printItems() {
        println(items.joinToString(separator = ", ", prefix = "[", postfix = "]"))
    }
}

fun main() {
    val heap = MaxHeap()
    heap.insert(8)
    heap.insert(6)
    heap.insert(7)
    heap.insert(2)
    heap.insert(5)
    heap.insert(4)
    heap.insert(3)
    val max = heap.deleteMax()
    println("max: $max")
    heap.printItems()
}

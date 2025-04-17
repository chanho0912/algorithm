package com.linecorp.lcp.config.solve.etc

class LinkedList<T>(data: T) {
    var head: Node<T> = Node(data)

    fun append(data: T) {
        val newNode = Node(data)
        if (head.next == null) {
            head.next = newNode
            return
        }

        var current = head
        while (current.next != null) current = current.next!!
        current.next = newNode
    }

    fun get(index: Int): Node<T>? {
        if (index <= 0) return head

        var current = head
        repeat(index) {
            current = current.next ?: return null
        }

        return current
    }

    // 1 3 5 8 9
    // 1 번째 자리에 4 삽입
    // 1 4 3 5 8 9
    fun addNode(index: Int, data: T) {
        val newNode = Node(data)
        if (index <= 0) {
            val currentHead = head

            head = newNode
            head.next = currentHead
            return
        }

        val previous = get(index - 1) ?: return
        val current = previous.next

        previous.next = newNode
        newNode.next = current
    }

    fun deleteNode(index: Int) {
        if (index <= 0) {
            head = head.next ?: return
            return
        }

        val previous = get(index - 1) ?: return
        previous.next = previous.next?.next
    }

    fun printList() {
        var current = head
        while (current.next != null) {
            print("${current.data} -> ")
            current = current.next!!
        }
        print("${current.data} -> null")
    }
}

class Node<T>(
    var data: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return "Node(data=$data, next=$next)"
    }
}

fun main() {
    val list = LinkedList(1)
    list.append(3)
    list.append(5)
    list.append(8)
    list.append(9)

    list.addNode(1, 4)
    list.addNode(0, 100)
    list.printList()
    println()

    list.deleteNode(100)
    list.printList()
    println()

    list.deleteNode(5)
    list.printList()
    println()

    list.deleteNode(5)
    list.printList()
    println()

    list.deleteNode(5)
    list.printList()
    println()
}

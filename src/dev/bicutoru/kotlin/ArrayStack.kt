package dev.bicutoru.kotlin

/**
 * A generic stack implementation using a fixed-size array.
 *
 * Operations:
 * - Push: O(1)
 * - Pop: O(1)
 * - Peek: O(1)
 * - isEmpty: O(1)
 * - size: O(1)
 *
 * @param <T> the type of elements stored in the stack
 * */
class ArrayStack<T>(private val capacity: Int) {

    private val elements: Array<T?> = arrayOfNulls(size = capacity)
    private var top: Int = -1

    /**
     * Checks if the stack contains no elements.
     *
     * Time Complexity: O(1) — constant time.
     *
     * @return true if the stack is empty, false otherwise
     * */
    fun isEmpty(): Boolean = top == -1

    /**
     *  Adds an element to the top of the stack.
     *
     *  Time Complexity: O(1) — constant insertion.
     *
     * @param value the element to be pushed onto the stack
     * @throws IllegalStateException if the stack is full
     * */
    fun push(value: T) {
        if (top == capacity - 1) throw IllegalStateException("Stack is full")

        elements[++top] = value
    }

    /**
     * Returns and removes the top element of the stack.
     *
     * Time Complexity: O(1) — constant time removal.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     * @throws IllegalStateException if the internal state is inconsistent (null element)
     * */
    fun pop(): T {
        if (isEmpty()) throw IllegalStateException("Stack is empty")

        val value = elements[top] ?: throw IllegalStateException("Unexpected null value")
        elements[top] = null
        top--
        return value
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * Time complexity: O(1) — constant read.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     * @throws IllegalStateException if the internal state is inconsistent (null element)
     * */
    fun peek(): T {
        if (isEmpty()) throw IllegalStateException("Stack is empty")

        return elements[top] ?: throw IllegalStateException("Unexpected null value")
    }

    /**
     * Returns the current number of elements in the stack.
     *
     * Time Complexity: O(1) — constant time.
     *
     * @return the number of elements in the stack
     * */
    fun size(): Int = top + 1
}
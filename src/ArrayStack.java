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
public class ArrayStack<T> {

    private T[] elements;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    /**
     * Checks if the stack contains no elements.
     *
     * Time Complexity: O(1) — constant time.
     *
     * @return true if the stack is empty, false otherwise
     * */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     *  Adds an element to the top of the stack.
     *
     *  Time Complexity: O(1) — constant insertion.
     *
     * @param value the element to be pushed onto the stack
     * @throws IllegalStateException if the stack is full
     * */
    public void push(T value) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack is full");
        }
        elements[++top] = value;
    }

    /**
     * Returns and removes the top element of the stack.
     *
     * Time Complexity: O(1) — constant time removal.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
    * */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = elements[top];
        elements[top] = null;
        top--;
        return value;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * Time complexity: O(1) — constant read.
     *
     * @return the element at the top of the stack
     * @throws IllegalStateException if the stack is empty
     * */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top];
    }

    /**
     * Returns the current number of elements in the stack.
     *
     * Time Complexity: O(1) — constant time.
     *
     * @return the number of elements in the stack
     * */
    public int size() {
        return top + 1;
    }

}

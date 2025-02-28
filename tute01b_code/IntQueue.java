package tute01b_code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class representing a bounded queue of integers.
 */
public class IntQueue {
    private Queue<Integer> queue;
    private int capacity;

    /**
     * @effects Constructs an IntQueue with a given capacity.
     * @param n The maximum number of elements the queue can hold.
     */
    public IntQueue(int n) {
        this.capacity = n;
        this.queue = new LinkedList<>();
    }

    /**
     * @effects Adds an integer to the front of the queue if space is available.
     * @param x The integer to add.
     * @throws IllegalStateException if the queue is full.
     */
    public void enq(int x) {
        if (queue.size() >= capacity) {
            throw new IllegalStateException("Queue is full");
        }
        queue.add(x);
    }

    /**
     * @effects Removes and returns the element from the end of the queue.
     * @return The integer removed from the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public int deq() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.poll();
    }

    /**
     * @effects
     * return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * @effects 
     * return true if the queue is full.
     */
    public boolean isFull() {
        return queue.size() >= capacity;
    }

    /**
     * @effects:
     *  Returns the size of the queue.
     */
    public int size() {
        return queue.size();
    }
}


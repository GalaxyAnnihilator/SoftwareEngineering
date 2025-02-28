package tute01b_code;

import java.util.HashSet;

/**
 * @overview: A class representing a set of even integers.
 * @attributes:
 *  set  HashSet<Integer>
 */
public class EvenIntSet {
    private HashSet<Integer> set;

    /**
     * @effects
     * Constructor initializes an empty set.
     */
    public EvenIntSet() {
        this.set = new HashSet<>();
    }

    /**
     * @effects Adds an even number to the set.
     * @param num - The number to add.
     * @return true if the number was added, false otherwise.
     */
    public boolean add(int num) {
        if (num % 2 == 0) {
            return set.add(num);
        }
        throw new IllegalArgumentException("Only even numbers are allowed.");
    }

    /**
     * @effects Removes a number from the set.
     * @param num - The number to remove.
     * @return true if the number was removed, false otherwise.
     */
    public boolean remove(int num) {
        return set.remove(num);
    }

    /**
     * @effects Checks if a number is in the set.
     * @param num The number to check.
     * @return true if the number is in the set, false otherwise.
     */
    public boolean contains(int num) {
        return set.contains(num);
    }

    /**
     * @effects Returns the size of the set.
     * @return The number of elements in the set.
     */
    public int size() {
        return set.size();
    }

    /**
     * @effects Returns a string representation of the set.
     * @return A string containing all even numbers in the set.
     */
    @Override
    public String toString() {
        return "EvenIntSet: " + set.toString();
    }
}


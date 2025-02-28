import java.util.HashMap;

/**
 * A class representing a map from strings to integers.
 */
public class StringIntMap {
    private HashMap<String, Integer> map;

    /**
     * Constructor initializes an empty map.
     */
    public StringIntMap() {
        this.map = new HashMap<>();
    }

    /**
     * @effects Adds a key-value pair to the map.
     * If the key already exists, it updates the value.
     * @param key The string key.
     * @param value The integer value.
     */
    public void put(String key, int value) {
        map.put(key, value);
    }

    /**
     * @effects Retrieves the value associated with the given key.
     * @param key The string key.
     * @return The associated integer value, or null if the key does not exist.
     */
    public Integer get(String key) {
        return map.get(key);
    }

    /**
     * @effects Removes a key-value pair from the map.
     * @param key The string key to remove.
     * @return The removed value, or null if the key was not present.
     */
    public Integer remove(String key) {
        return map.remove(key);
    }

    /**
     * @effects Checks if the map contains a given key.
     * @param key The string key.
     * @return true if the key exists, false otherwise.
     */
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    /**
     * @effects Returns the size of the map.
     * @return The number of key-value pairs in the map.
     */
    public int size() {
        return map.size();
    }

    /**
     * @effects Returns a string representation of the map.
     * @return A string containing all key-value pairs in the map.
     */
    @Override
    public String toString() {
        return "StringIntMap: " + map.toString();
    }
}

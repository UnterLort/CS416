import java.util.Objects;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <K> type of the key
 * @param <V> type of the value
 */
public class LinkedMap<K, V> implements Map<K, V> {

    private LinkedList<Entry<K, V>> entries;

    /**
     * 
     * Constructs an empty LinkedMap.
     */
    public LinkedMap() {
        entries = new LinkedList<>();
    }

    /**
     * 
     * @return number of entries in the map.
     */
    public LinkedList<Entry<K, V>> getList() {
        return entries;
    }

    /**
     * 
     * @param key   the key.
     * @param value the value.
     * @return the number of entries in the map.
     * 
     */
    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> existingEntry = getEntry(key);

        if (existingEntry != null) {
            V oldValue = existingEntry.getValue();
            existingEntry.setValue(value);
            return oldValue;
        } else {
            entries.add(newEntry);
            return null;
        }
    }

    /**
     * 
     * @param key   the key.
     * @param value the value.
     * @return the number of entries in the map.
     */
    public V putIfAbsent(K key, V value) {
        Entry<K, V> existingEntry = getEntry(key);

        if (existingEntry != null) {
            return existingEntry.getValue();
        } else {
            return put(key, value);
        }
    }

    /**
     * 
     * @return number of entries in the map.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Entry<K, V> entry : entries) {
            sb.append(entry.toString()).append(", ");
        }
        if (!entries.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 
     * Clear the list.
     */
    public void clear() {
        entries.clear();
    }

    /**
     * 
     * @param key the key to search for
     * @return the value associated with the key, or null if the key is not in the
     *         map.
     */
    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return entry != null ? entry.getValue() : null;
    }

    /**
     * 
     * @param key the key to search for in the map
     * @return true if the key is in the map
     */
    public boolean containsKey(K key) {
        return getEntry(key) != null;
    }

    /**
     * 
     * @return true if the map is empty
     */
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    /**
     * 
     * @param key the key to remove from the map
     * @return the value associated with the key, or null if the key is not in the
     *         map.
     */
    public V remove(K key) {
        Entry<K, V> entryToRemove = getEntry(key);
        if (entryToRemove != null) {
            entries.remove(entryToRemove);
            return entryToRemove.getValue();
        }
        return null;
    }

    /**
     * 
     * @return number of entries in the map.
     */
    public int size() {
        return entries.size();
    }

    /**
     * 
     * @param key The key to be searched for.
     * @return The entry with the given key.
     */
    private Entry<K, V> getEntry(K key) {
        for (Entry<K, V> entry : entries) {
            if (Objects.equals(key, entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    /**
     * 
     * The Entry class represents a single key-value pair.
     * 
     * @param <V> type of the value.
     * @param <K> type of the key.
     */
    public class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        /**
         * 
         * @param key   The key to be stored.
         * @param value The value to be stored.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * 
         * @return key stored in this entry.
         */
        public K getKey() {
            return key;
        }

        /**
         * 
         * @return value stored in this entry.
         */
        public V getValue() {
            return value;
        }

        /**
         * 
         * @param newValue to be stored.
         * @return old value.
         */
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        /**
         * 
         * @return string representation of the entry.
         */
        public String toString() {
            return "(" + key + ", " + value + ")";
        }

        /**
         * 
         * @param o object to compare to this entry.
         * @return true if this entry is equal to the specified object.
         */
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }
    }
}
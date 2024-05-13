/**
 * 
 * Binary Search Tree Map implementation.
 *
 * @author Kyle Stewart
 * @version 1
 * @param <K> type of keys stored in the map, must implement the
 *            {@link Comparable} interface.
 * @param <V> type of values stored in the map.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    /**
     * Inner class representing an entry in the map.
     *
     * @param <K> type of keys in entry.
     * @param <V> type of values in entry.
     */
    public class Entry<K extends Comparable<K>, V> implements Map.Entry<K, V>, Comparable<Entry<K, V>> {
        private K key;
        private V value;

        /**
         * Constructs a new entry with specified key and value.
         *
         * @param key   of entry.
         * @param value of entry.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * @return key of entry.
         */
        public K getKey() {
            return key;
        }

        /**
         * @return value of entry.
         */
        public V getValue() {
            return value;
        }

        /**
         * Set value of entry.
         *
         * @param value to set.
         */
        public void setValue(V value) {
            this.value = value;
        }

        /**
         * Return a string representation of entry.
         *
         * @return string representation of entry in the format "(key, value)".
         */
        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }

        /**
         * Compare entry key with specified key for order.
         *
         * @return negative integer, zero, or a positive integer as this key is less
         *         than,
         *         equal to, or greater than the specified key.
         */
        @Override
        public int compareTo(Entry<K, V> otherEntry) {
            return this.key.compareTo(otherEntry.getKey());
        }

        /**
         *
         * @param o object to compare.
         * @return true if objects are equal.
         */
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> e = (Entry<?, ?>) o;
            return key.equals(e.getKey()) && value.equals(e.getValue());
        }

        // hashCode() method can be overridden here if needed
    }

    private BST<Entry<K, V>> tree;

    /**
     * Construct an empty BSTMap.
     */
    public BSTMap() {
        tree = new BST<>();
    }

    /**
     * Retrieve binary search tree used by map.
     *
     * @return binary search tree used by map.
     */
    public BST<Entry<K, V>> getTree() {
        return tree;
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> oldEntry = tree.get(newEntry);
        if (oldEntry != null) {
            V oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
            return oldValue;
        } else {
            tree.add(newEntry);
            return null;
        }
    }

    @Override
    public V putIfAbsent(K key, V value) {
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> existingEntry = tree.get(newEntry);
        if (existingEntry == null) {
            tree.add(newEntry);
            return null;
        } else {
            return existingEntry.getValue();
        }
    }

    @Override
    public String toString() {
        return tree.toString();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = tree.get(new Entry<>(key, null));
        return entry != null ? entry.getValue() : null;
    }

    @Override
    public boolean containsKey(K key) {
        return tree.contains(new Entry<>(key, null));
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public V remove(K key) {
        // Attempt to remove entry from tree
        boolean removed = tree.remove(new Entry<>(key, null));
        // If removal was successful, return value of removed entry
        if (removed) {
            return get(key); // Return value using key
        } else {
            return null; // Return null if removal failed
        }
    }

    @Override
    public int size() {
        return tree.size();
    }
}
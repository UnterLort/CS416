/**
 * 
 * @author Kyle Stewart
 * @version 5
 */
public class SimpleHashTable {
    private String[] array;

    /**
     * 
     * Construct a SimpleHashTable with an array size of 10.
     */
    public SimpleHashTable() {
        array = new String[10];
    }

    /**
     * 
     * Adds a value to the hash table using the given key.
     * 
     * @param key   be used for hashing
     * @param value be stored in the hash table
     */
    public void put(int key, String value) {
        int index = hash(key, array.length, 2);
        array[index] = value;
    }

    /**
     * 
     * Retrieves the value from the hash table using the given key.
     * 
     * @param key be used for retrieval
     * @return the value associated with the given key, or null if not found
     */
    public String get(int key) {
        int index = hash(key, array.length, 2);
        return array[index] != null ? array[index] : "null";
    }

    /**
     * 
     * @return a string representation of the hash table
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(i).append(" ").append(array[i] != null ? array[i] : "null");
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * 
     * Calculates the hash value using the midsquare algorithm.
     * 
     * @param key  to be hashed
     * @param size of the hash table
     * @param r    of r for the midsquare algorithm
     * @return the calculated hash value
     */
    public static int hash(int key, int size, int r) {
        // Calculate square
        int square = key * key;
        // Extract r digits from the middle
        String squareStr = String.valueOf(square);
        int startIndex = Math.max((squareStr.length() - r) / 2, 0);
        int endIndex = Math.min(startIndex + r, squareStr.length());
        String midDigitsStr = squareStr.substring(startIndex, endIndex);
        int midDigits = Integer.parseInt(midDigitsStr);
        // Ensure hash value falls within the range of the array size
        return midDigits % size;
    }

    /**
     * 
     * A simple test case demonstrating the usage of the SimpleHashTable class.
     *
     * @param args Command-line argument.
     */
    public static void main(String[] args) {
        SimpleHashTable table = new SimpleHashTable();
        table.put(276, "Sleepy");
        table.put(42, "Doc");
        table.put(481, "Bashful");
        table.put(137, "Happy");
        table.put(369, "Grumpy");
        table.put(802, "Dopey");
        table.put(555, "Sneezy");
        table.put(134, "East");
        table.put(9, "North");
        table.put(724, "South");
        table.put(611, "West");

        // Test for get method
        System.out.println("Test for get method:");
        System.out.println("Key: 276, Value: " + table.get(276)); // Output: Sleepy
        System.out.println("Key: 42, Value: " + table.get(42)); // Output: Doc
        System.out.println("Key: 999, Value: " + table.get(999)); // Output: null

        // Test for toString method
        System.out.println("\nTest for toString method:");
        System.out.println(table.toString());
        
        // Test for hash method
        System.out.println("\nTest for hash method:");
        System.out.println("Hash for key 12: " + hash(12, 1000, 2)); // Expected: 44
    }
}
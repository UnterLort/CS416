import java.util.Scanner;

/**
 * 
 * A class to model a Simple Virtual machine Memory.
 * Memory Res.
 * 
 * @author Kyle Stewart
 * @version 4
 */
public class Memory {
    private int[] memory;

    /**
     * 
     * Default constructor that creates an array of integers to represent the VM
     * memory and initializes each memory cell to 0.
     */
    public Memory() {
        memory = new int[16];
        initializeMemory();
    }

    /**
     * 
     * @param s The Scanner object used to read values for memory initialization.
     */
    public Memory(Scanner s) {
        memory = new int[16];
        initializeMemory(s);
    }

    /**
     * 
     * @param address The address of the memory cell to read from.
     * @return The value stored at the specified address.
     * @throws IllegalStateException If the address is outside the valid range.
     */
    public int read(int address) throws IllegalStateException {
        if (address < 0 || address >= memory.length) {
            throw new IllegalStateException("Invalid memory address");
        }
        return memory[address];
    }

    /**
     * 
     * @param address The address of the memory cell to write to.
     * @param value   The value to be written.
     * @throws IllegalStateException If the address is outside the valid range.
     */
    public void write(int address, int value) throws IllegalStateException {
        if (address < 0 || address >= memory.length) {
            throw new IllegalStateException("Invalid memory address");
        }
        memory[address] = value;
    }

    /**
     * 
     * @return The String representation of Memory.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("address: |");
        for (int i = 0; i < memory.length; i++) {
            sb.append(String.format(" %2d |", i));
        }
        sb.append("\n");
        sb.append(" value:  |");
        for (int i = 0; i < memory.length; i++) {
            sb.append(String.format(" %2d |", memory[i]));
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * 
     * @return The internal array of integers representing the memory.
     */
    public int[] rawMemory() {
        return memory;
    }

    /**
     * 
     * Initializes the memory array by setting each memory cell to 0.
     */
    private void initializeMemory() {
        for (int i = 0; i < memory.length; i++) {
            memory[i] = 0;
        }
    }

    /**
     * 
     * @param s The Scanner object used to read the input values.
     * @throws IllegalStateException If there are insufficient input values in the
     *                               Scanner.
     */
    private void initializeMemory(Scanner s) {
        int count = 0;
        while (s.hasNextInt() && count < memory.length) {
            memory[count] = s.nextInt();
            count++;
        }
        if (count < memory.length) {
            throw new IllegalStateException("Insufficient input values");
        }
        if (s.hasNext()) {
            throw new IllegalStateException("Excess input values");
        }
    }


    /**
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15");
        Memory mem = new Memory(s);
        System.out.println(mem);
    }
}
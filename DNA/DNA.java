import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class DNA {

    /**
     *
     * @param fileName Name of the file containing DNA data.
     * @return Array of DNARecord objects.
     */
    public static DNARecord[] readData(String fileName) {
        DNARecord[] records = new DNARecord[20]; // Array to store DNA records
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); // Skip the header row
            int index = 0;
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                String name = data[0];
                int agatCount = Integer.parseInt(data[1]);
                int aatgCount = Integer.parseInt(data[2]);
                int tatcCount = Integer.parseInt(data[3]);
                Profile profile = new Profile(agatCount, aatgCount, tatcCount);
                records[index++] = new DNARecord(name, profile);
            }
            scanner.close();
            return records;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 
     * @param sequence One of the two sequences for comparison
     * @param match    Sequence The other one of the two sequences for comparison
     * @return Integer representing the number of matches between the two input
     *         sequences
     */
    public static int countMaximumConsecutiveMatches(String sequence, String match) {
        char[] seqChars = sequence.toCharArray();
        char[] matchChars = match.toCharArray();
        int maxMatches = 0;
        int matchCounter = 0;
        int offset = 0;
        int sequenceIndex = 0;
        while (sequenceIndex + offset < seqChars.length) {
            if (seqChars[sequenceIndex + offset] == matchChars[offset]) {
                if (offset == matchChars.length - 1) {
                    matchCounter++;
                    maxMatches = Math.max(maxMatches, matchCounter);
                    offset = 0;
                    sequenceIndex += matchChars.length;
                } else {
                    offset++;
                }
            } else {
                matchCounter = 0;
                sequenceIndex++;
                offset = 0;
            }
        }
        return maxMatches;
    }

    /**
     * 
     * @param fileName Name of file to read from
     * @return List of strings containing lines in the file
     */
    public static Profile readSequence(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String sequence = scanner.nextLine();
            int agatCount = countMaximumConsecutiveMatches(sequence, "AGAT");
            int aatgCount = countMaximumConsecutiveMatches(sequence, "AATG");
            int tatcCount = countMaximumConsecutiveMatches(sequence, "TATC");
            scanner.close();
            return new Profile(agatCount, aatgCount, tatcCount); // Constructing Profile with arguments
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String dataFileName = args[0];
        String sequenceFileName = args[1];
        DNARecord[] records = readData(dataFileName);
        Profile sequenceProfile = readSequence(sequenceFileName);
        boolean foundMatch = false;
        for (DNARecord record : records) {
            if (record != null && record.getProfile().equals(sequenceProfile)) {
                System.out.println("Matched " + record.getName() + ": " + record.getProfile());
                foundMatch = true;
                break;
            }
        }
        if (!foundMatch) {
            System.out.println("No match for " + sequenceProfile);
        }
    }
}
import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 *          The driver program for the 4bit virtual machine.
 *          Commandline options:
 *          -d specifies debug mode, which will print the state of the machine
 *          at each executiion step
 */
public class VM {

    /**
     * 
     * @param args the commandline arguement
     */
    public static void main(String[] args) {

        File progFile;
        CPU cpu;
        Memory memory;
        boolean debugMode = false;
        String usageString = "usage: java VM [-d] program";

        if (args.length != 1 && args.length != 2) {
            System.err.println(usageString);
            return;
        }

        if (args.length == 1) {
            progFile = new File(args[0]);
        } else {
            if (!args[0].equals("-d")) {
                System.err.println(usageString);
                return;
            }

            progFile = new File(args[1]);
            debugMode = true;
        }

        Scanner s;
        try {
            s = new Scanner(progFile);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        try {
            cpu = new CPU();
            memory = new Memory(s);

            cpu.run(memory, debugMode);

        } catch (Exception e) {
            System.out.println("FATAL ERROR: " + e);
        }
    }
}
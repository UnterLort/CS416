/**
 * 
 * A class to model a CPU in a simple Virtual Machine.
 * CPU Res.
 * 
 * @author Kyle Stewart
 * @version 4
 */
public class CPU {

    int ip;
    int is;
    int r0;
    int r1;

    /**
     * 
     * Default constructor.
     */
    public CPU() {
        ip = 0;
        is = 0;
        r0 = 0;
        r1 = 0;
    }

    /**
     * 
     * @param mem       memory
     * @param debugMode boolean
     * @throws IllegalStateException throw
     */
    public void run(Memory mem, boolean debugMode) throws IllegalStateException {
        int i = 0;
        while (true) {

            is = mem.read(ip);

            if (debugMode) {
                System.out.println("STEP " + i + ":");
                System.out.println(this);
                System.out.println(mem);
                System.out.println("----------");

            }
            i++;

            if (is == 0) {

                return;
            } else if (is == 1) {
                r0 = (r0 + r1) & 0xF;
                ip = (ip + 1) & 0xF;
            } else if (is == 2) {
                r0 = (r0 - r1) & 0xF;
                ip = (ip + 1) & 0xF;
            } else if (is == 3) {
                r0 = (r0 + 1) & 0xF;
                ip = (ip + 1) & 0xF;
            } else if (is == 4) {
                r1 = (r1 + 1) & 0xF;
                ip = (ip + 1) & 0xF;
            } else if (is == 5) {
                r0 = (r0 - 1) & 0xF;
                ip = (ip + 1) & 0xF;
            } else if (is == 6) {
                r1 = (r1 - 1) & 0xF;
                ip = (ip + 1) & 0xF;
            } else if (is == 7) {
                Beep.beep();
                ip = (ip + 1) & 0xF;
            } else if (is == 8) {
                System.out.println(mem.read((ip + 1) & 0xF));
                ip = (ip + 2) & 0xF;
            } else if (is == 9) {
                r0 = mem.read(mem.read((ip + 1) & 0xF));
                ip = (ip + 2) & 0xF;
            } else if (is == 10) {
                r1 = mem.read(mem.read((ip + 1) & 0xF));
                ip = (ip + 2) & 0xF;
            } else if (is == 11) {
                mem.write(mem.read((ip + 1) & 0xF), r0);
                ip = (ip + 2) & 0xF;
            } else if (is == 12) {

                mem.write(mem.read((ip + 1) & 0xF), r1);
                ip = (ip + 2) & 0xF;
            } else if (is == 13) {
                ip = mem.read((ip + 1) & 0xF);
            } else if (is == 14) {
                if (r0 == 0) {
                    ip = mem.read((ip + 1) & 0xF);
                } else {
                    ip = (ip + 2) & 0xF;
                }
            } else if (is == 15) {
                if (r0 != 0) {
                    ip = mem.read((ip + 1) & 0xF);
                } else {
                    ip = (ip + 2) & 0xF;
                }
            }
        }
    }

    /**
     * 
     * toString method.
     * 
     * @return String
     */
    public String toString() {
        return String.format("IP=%2d, IS=%2d, R0=%2d, R1=%2d", ip, is, r0, r1);
    }
}
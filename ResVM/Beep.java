import javax.sound.sampled.*;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 *          reference: https://stackoverflow.com/a/6700039
 */
public class Beep {
    private static float SAMPLE_RATE = 8000f;

    /**
     * 
     * Emits a beep sound with default frequency, duration, and volume.
     * 
     * @throws LineUnavailableException if a line cannot be opened because it is
     *                                  unavailable.
     */
    public static void beep() {
        try {
            tone(1000, 200, 1.0);
        } catch (LineUnavailableException e) {
            System.err.println("Beep unavailable");
        }
    }

    /**
     * 
     * Emits a tone with the specified frequency, duration, and volume.
     * 
     * @param hz    the frequency of the tone in Hz
     * @param msecs the duration of the tone in milliseconds
     * @param vol   the volume of the tone (0.0 to 1.0)
     * @throws LineUnavailableException if a line cannot be opened because it is
     *                                  unavailable.
     */
    private static void tone(int hz, int msecs, double vol)
            throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af = new AudioFormat(
                SAMPLE_RATE, // sampleRate
                8, // sampleSizeInBits
                1, // channels
                true, // signed
                false); // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i = 0; i < msecs * 8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
}
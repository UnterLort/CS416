/**
 * 
 * 
 * @author Kyle Stewart.
 * @version 3.
 */

public class Rock {
    private String name;
    private double numPounds;
    private double volume;

    /**
     *
     *
     * @param name the name of the rock.
     */
    public Rock(String name) {
        this.name = name;
    }

    /**
     *
     *
     * @return the name of the rock.
     */
    public String getName() {
        return name;
    }

    /**
     *
     *
     * @param name the name of the rock.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     *
     * @return the number of pounds of the rock.
     */
    public double getNumPounds() {
        return numPounds;
    }

    /**
     *
     *
     * @param numPounds the number of pounds of the rock.
     */
    public void setNumPounds(double numPounds) {
        this.numPounds = numPounds;
    }

    /**
     *
     *
     * @return the volume of the rock.
     */
    public double getVolume() {
        return volume;
    }

    /**
     *
     *
     * @param volume the volume of the rock.
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     *
     *
     * @return the density of the rock.
     */
    public int calculateDensity() {
        return (int) (numPounds / volume);
    }

    /**
     *
     *
     * @param amount the amount to increase the number of pounds by.
     */
    public void increasePounds(double amount) {
        numPounds += amount;
    }

    /**
     *
     *
     * @param amount the amount to decrease the number of pounds by.
     * @return the number of pounds of the rock after the decrease.
     */
    public double decreasePounds(double amount) {
        double nWeight = numPounds - amount;
        numPounds = nWeight;
        return nWeight;
    }

    @Override
    public String toString() {
        return "Rock " + name + " weighs " + String.format("%.3f", numPounds) + " pounds with a density of "
                + calculateDensity();
    }

    /**
     *
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        Rock r = new Rock("pet");
        r.setVolume(2.0);
        r.setNumPounds(10.0);
        System.out.println(r.calculateDensity());

        Rock r2 = new Rock("pet");
        r2.setNumPounds(10.0);
        r2.increasePounds(5.0);
        System.out.println(r2.getNumPounds());

        Rock r3 = new Rock("pet");
        r3.setNumPounds(10.0);
        System.out.println(r3.decreasePounds(5.0));

        Rock r4 = new Rock("pet");
        r4.setVolume(2.0);
        r4.setNumPounds(10.0);
        System.out.println(r4);
    }
}
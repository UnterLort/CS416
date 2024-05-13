/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Profile {
    private int agatCount;
    private int aatgCount;
    private int tatcCount;


    /**
     * 
     *  Constructs an empty profile.
     */
    public Profile() {
        this.agatCount = 0;
        this.aatgCount = 0;
        this.tatcCount = 0;
    }

    /**
     * @param agatCount Number of AGAT nucleotides in the profile.
     * @param aatgCount Number of AATG nucleotides in the profile.
     * @param tatcCount Number of TATC nucleotides in the profile.
     */
    public Profile(int agatCount, int aatgCount, int tatcCount) {
        this.agatCount = agatCount;
        this.aatgCount = aatgCount;
        this.tatcCount = tatcCount;
    }

    /**
     * @return Number of AGAT nucleotides in the profile.
     */
    public int getAgatCount() {
        return agatCount;
    }

    /**
     * @param agatCount New count for the AGAT nucleotide type.
     */
    public void setAgatCount(int agatCount) {
        this.agatCount = agatCount;
    }

    /**
     * @return Number of AATG nucleotides in the profile.
     */
    public int getAatgCount() {
        return aatgCount;
    }

    /**
     * 
     * @param aatgCount New count for the AATG nucleotide type.
     */
    public void setAatgCount(int aatgCount) {
        this.aatgCount = aatgCount;
    }

    /**
     * 
     * @return Total number of nucleotides (AGAT + AATG).
     */
    public int getTatcCount() {
        return tatcCount;
    }

    /**
     * 
     * @param tatcCount New value for the TATC count.
     */
    public void setTatcCount(int tatcCount) {
        this.tatcCount = tatcCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return agatCount == profile.agatCount && aatgCount == profile.aatgCount && tatcCount == profile.tatcCount;
    }

    @Override
    public String toString() {
        return "(AGAT = " + agatCount + ", AATG = " + aatgCount + ", TATC = " + tatcCount + ")";
    }
}
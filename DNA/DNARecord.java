/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class DNARecord {
    private String name;
    private Profile profile;

    /**
     * 
     * @param name    Name of DNA record (i.e., gene, chromosome).
     * @param profile Sequence profile for DNA record.
     */
    public DNARecord(String name, Profile profile) {
        this.name = name;
        if (profile == null) {
            this.profile = new Profile(); // Use default constructor
        } else {
            this.profile = profile;
        }
    }

    /**
     * 
     * @return Name of the DNA record.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return Sequence profile associated with the DNA record.
     */
    public Profile getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return name + ": " + profile;
    }
}
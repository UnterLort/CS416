/**
 * 
 * @author Kyle Stewart
 * @version 1
 */

public class Author {

    private String name;
    private String email;

    /**
     * 
     * 
     * This is the constructor for objects of class Author.
     */
    public Author() {
        name = "";
        email = "";
    }

    /**
     * 
     * 
     * @param name  the name of the author.
     * @param email the email address of the author.
     */
    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * 
     * 
     * @param name the new name for the author.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * 
     * @param email empty string if the email is not valid, otherwise the validated
     *              email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * 
     * @return the name of the author.
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * 
     * @return the email address of the author. Returns an empty string if no email
     *         has been set.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     * 
     * @return a copy of this object.
     */
    public String toString() {
        return this.name + " <" + this.email + ">";
    }

    /**
     * 
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        Author a = new Author();
        assert a.getName().equals("");
        assert a.getEmail().equals("");

        Author a1 = new Author("J. Doe", "jdoe@doewriter.com");
        assert a1.getName().equals("J. Doe");
        assert a1.getEmail().equals("jdoe@doewriter.com");

        a.setName("Jane");
        assert a.getName().equals("Jane");
        a.setEmail("jane@awesome.com");

        assert a.getEmail().equals("jane@awesome.com");
        assert a.toString().equals("Jane <jane@awesome.com>");
    }
}
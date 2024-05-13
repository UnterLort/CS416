/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class Course {

    private String subject;
    private int number;

    /**
     * 
     * @param subject of the course.
     * @param number  of the course.
     */
    public Course(String subject, int number) {
        this.subject = subject.length() > 4 ? subject.substring(0, 4).toUpperCase() : subject.toUpperCase();
        this.number = (number >= 400 && number <= 799) ? number : 401;
    }

    /**
     * 
     * @return the course subject and number.
     */
    public String toString() {
        return subject + " " + number;
    }

}
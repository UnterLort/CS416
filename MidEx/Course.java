/**
 * Course Midterm Exam.
 * 
 * @author Kyle Stewart
 * @version 1
 */

class Course {
    private String name;
    private int section;

    /**
     * 
     * @param name    name of course.
     * @param section section number of course.
     */
    Course(String name, int section) {
        this.name = name;
        this.section = section;
    }

    /**
     * 
     * @return name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return section number of course
     */
    public int getSection() {
        return section;
    }

    /**
     * 
     * @return String containing the course name and section number
     */
    @Override
    public String toString() {
        return name + " " + section;
    }

}
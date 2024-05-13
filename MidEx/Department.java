import java.util.ArrayList;

/**
 * Department Midterm Exam.
 * 
 * @author Kyle Stewart
 * @version 1
 */
class Department {
    private String name;
    private ArrayList<Course> courseListing;

    /**
     * 
     * @param name name of department.
     */
    Department(String name) {
        this.name = name;
        this.courseListing = new ArrayList<>();
    }

    /**
     * 
     * @param course course to add
     */
    public void add(Course course) {
        courseListing.add(course);
    }

    /**
     * 
     * @param course the course to remove
     */
    public void remove(Course course) {
        courseListing.remove(course);
    }

    /**
     * 
     * @return ArrayList of courses in the department
     */
    public ArrayList<Course> getListing() {
        return courseListing;
    }

    /**
     * 
     * @return String containing department name and course listing
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        for (Course course : courseListing) {
            sb.append(course.toString()).append("\n");
        }
        return sb.toString();
    }
}
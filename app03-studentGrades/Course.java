/**
 * The Course class represents a course in a student grades system.
 * It holds the course details a code number and title. 
 *
 * @author Yavor Yankov
 * @version 16/10/2020
 */
public class Course {
    // the title of this course
    private String title;
    // the code number of this course
    private String codeNumber;

    /**
     * Create a new course with title and code number
     * @param title
     * @param codeNumber
     */
    public Course(String title, String codeNumber)
    {
       this.title = title;
       this.codeNumber = codeNumber;
    }

    /**
     * Return the title of this course 
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     *  Return the code number of this course
     */
    public String getCodeNumber()
    {
        return this.codeNumber;        
    }
}

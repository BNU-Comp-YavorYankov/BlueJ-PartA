/**
 * The Course class represents a course in a student administration system.
 * It holds the course details a code number and title. 
 *
 * @author Yavor Yankov
 * @version 03/10/2020
 */
public class Course
{
    // the course`s code number
    private String codeNumber; 
    // the course`s title
    private String title;
    
    /**
     * Create a new course with a given code number and title
     */
    public Course(String codeNumber, String title)
    {
        this.codeNumber = codeNumber;
        this.title = title;
    }

    /**
     * Return the code number 
     **/
    public String getCodeNumber()
    {
        return this.codeNumber;
    }

    /**
     * Return the title 
     **/
    public String getTitle()
    {
        return this.title;
    }
}
import java.util.ArrayList;

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
    // enrolled students for this course
    private ArrayList<Student> enrolledStudents;
    
    /**
     * Create a new course with title and code number
     */
    public Course(String title, String codeNumber)
    {
       this.title = title;
       this.codeNumber = codeNumber;
       this.enrolledStudents = new ArrayList<Student>();
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

    /**
     * Enroll this student for new course
     */
    public void enrollStudent(Student newStudent)
    {
        if(isAlreadyEnrolled(newStudent)){
            System.out.println("This student has already enrolled for " + this.title + " course!");
        }
        else{
            this.enrolledStudents.add(newStudent);
            System.out.println(newStudent.getName() + " has been enrolled for " + this.title + " course.");
        }
    }

    /**
     * Check is the new student already enrolled for this courses
     */
    private boolean isAlreadyEnrolled(Student newStudent) {
        // iterate all enrolled students of this course
        for (Student student : this.enrolledStudents) {

            // if the new student details match with the current student destails return true 
            if(student.getName() == newStudent.getName() &&
                student.getStudentID() == newStudent.getStudentID()){
                    return true;
                }
        }
        return false;
    }

    /**
     * Return text representation of this course details
     */
    @Override
    public String toString(){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(this.codeNumber + ", " + this.title + " course\n");

        if(this.enrolledStudents.size() > 0){
            sBuilder.append("Enrolled students:\n");
            for (Student student : this.enrolledStudents) {
                sBuilder.append("Id: "+ student.getStudentID() + " " + student.getName() + "\n");
            }
        }
        else
        {
            sBuilder.append("There is no any enrolled students yet.\n");
        }
        return sBuilder.toString();
    }
}

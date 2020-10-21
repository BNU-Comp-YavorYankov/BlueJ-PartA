import java.util.*;

/**
 * The Student class represents a student in a student administration system. It
 * holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 * 
 *          Modified by Yavor Yankov
 * @version 16/10/2020
 * 
 */
public class Student {
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;
    // enrolled course of this student
    private Course course;

    /**
     * Create a new student with a given name and ID number.
     * 
     * @param fullName
     * @param studentId
     */
    public Student(String fullName, String studentID) {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    /**
     * Return the full name of this student.
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName) {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID() {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints) {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Return the enrolled course of this student
     */
    public Course getCourse() {
        if (isEnrolled()) {
            return this.course;
        }
        return null;
    }

    /**
     * Return the login name of this student. The login name is a combination of the
     * first four characters of the student's name and the first three characters of
     * the student's ID number.
     */
    public String getLoginName() {
        return name.substring(0, 4) + id.substring(0, 3);
    }

    /**
     * Enroll this student for given a course
     * 
     * @param newCourse for which this student will be enrolled
     */
    public void enrollCourse(Course newCourse) {
        if (this.course != null) {
            System.out.print("This student is already enrolled for a course - ");
            this.course.print();
        } else {
            this.course = newCourse;
            System.out.print(this.name + " has been enrolled successfuly for ");
            this.course.print();
        }
    }

    /**
     * Complete a module from enrolled course as provide module mark
     * 
     * @param mark
     * @param moduleCode
     */
    public void completeModule(int mark, String moduleCode) {
        if (mark > 100 || mark < 0) {
            System.out.println("The mark cannot be less than zero or more than 100!");
        } else {
            // Check is this student enrolled for a course
            if (isEnrolled()) {

                // the module which want to be completed
                var completedModule = getModuleByModuleCode(moduleCode);

                if (completedModule == null) {
                    System.out.println("The module with code " + moduleCode + " cannot be found!");
                } else {
                    if (mark > 39) {
                        completedModule.setMark(mark);

                        this.credits += 15;

                        this.course.updateModule(completedModule);
                    } else {
                        System.out.println("You could not pass this module" + "(" + completedModule.getModuleCode()
                                + ")" + completedModule.getTitile() + "!");
                    }
                }
            }
        }
    }

    /**
     * Return the module which has same module code with this from the parameter
     * 
     * @param moduleCode
     */
    private Module getModuleByModuleCode(String moduleCode) {
        Module result = null;

        // iterate all modules of the enrolled course
        for (Module module : this.course.getModules()) {
            /*
             * if the module code match with this of the current module set to result the
             * current module
             */
            if (module.getModuleCode() == moduleCode) {
                result = module;
            }
        }

        return result;
    }

    /**
     * Is this student enrolled for a course
     */
    private boolean isEnrolled() {
        if (this.course == null) {
            System.out.println("This student is not enrolled for any courses!");
            return false;
        }
        return true;
    }

    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print() {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);
        if (this.course != null) {
            this.course.print();
        }
    }
}

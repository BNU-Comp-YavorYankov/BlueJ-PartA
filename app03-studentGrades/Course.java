import java.util.ArrayList;

/**
 * The Course class represents a course in a student grades system. It holds the
 * course details a code number and title.
 *
 * @author Yavor Yankov
 * @version 16/10/2020
 */
public class Course {
    // the title of this course
    private String title;
    // the code number of this course
    private String codeNumber;
    // the modules of this course
    private ArrayList<Module> modules;
    // the grade of this course
    private Character grade;

    /**
     * Create a new course with title and code number
     */
    public Course(String title, String codeNumber) {
        this.title = title;
        this.codeNumber = codeNumber;
        this.modules = new ArrayList<Module>();
    }

    /**
     * Return the title of this course
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Return the code number of this course
     */
    public String getCodeNumber() {
        return this.codeNumber;
    }

    /**
     * Return collection with all modules of this course
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /**
     * Return the grade of this course 
     * if all 4 modules are completed
     */
    public Character getGrade()
    {
        return this.grade;
    }

    /**
     * Add new module to this course
     */
    public void addModule(Module newModule) {
        if (this.modules.size() > 3) {
            System.out.println("Courses can have up to 4 modules!");
        } else if (isModuleExist(newModule)) {
            System.out.println("The module is already added!");
        }
        else{
            this.modules.add(newModule);
            System.out.println("The module "+newModule.getTitile()+" was added successfuly.");
        }
    }

    /**
     * Update module as completed 
     */
    public void updateModule(Module updatedModule){
        var moduleIndex = this.modules.indexOf(updatedModule);
        this.modules.set(moduleIndex, updatedModule);

        updatedModule.print();

        if(isCourseCompleted())
        {
            setGrade();
        }
    }

    private void setGrade() {

        if(this.modules.size() < 3){
            System.out.println("A final grade can be calculated for a course consisting of 4 completed modules.");
        }
        else{
            var averageMark = 0;
            for (Module module : modules) {
                averageMark += module.getMark(); 
            }
            averageMark /= 4;

            if(averageMark >= 0 && averageMark <= 39)
            {
                this.grade = 'F';
            }
            else if(averageMark >= 40 && averageMark <= 49)
            {
                this.grade = 'D';
            }
            else if(averageMark >= 50 && averageMark <= 59)
            {
                this.grade = 'C';
            }
            else if(averageMark >= 60 && averageMark <= 69)
            {
                this.grade = 'B';
            }
            else if(averageMark >= 70 && averageMark <= 100)
            {
                this.grade = 'A';
            }
            System.out.println("The final grade of this course is " + this.grade);
        }
    }

    private boolean isCourseCompleted() {
        for (Module module : modules) {
            if(module.getMark() == null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks wheter the given module already exists in the course`s modules
     */
    private boolean isModuleExist(Module newModule) {
        for (Module module : this.modules) {
            if (module.getTitile() == newModule.getTitile() && 
                module.getModuleCode() == newModule.getModuleCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print course details
     */
    public void print() {
        System.out.println(this.codeNumber + ", " + this.title);
        if(this.modules.size() > 0)
        {
            System.out.println("Modules: ");
            for (Module module : modules) {
                module.print();
            }
        }
        if(this.grade != null){
            System.out.println("The final grade is " + this.grade);
        }
    }
}

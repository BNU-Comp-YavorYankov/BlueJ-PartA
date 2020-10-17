import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

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
    }
}

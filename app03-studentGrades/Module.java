/**
 * The Module class represents a module in a student grades system. It holds the
 * module details a module code , mark and title.
 *
 * @author Yavor Yankov
 * @version 16/10/2020
 */
public class Module {
    // the title of this module
    private String title;
    // the code of this module
    private String code;
    // the mark of this module in percantage
    private int mark;
    // is completed this module
    private boolean isCompleted;

    /**
     * Create a new module with title, module code and mark
     * 
     * @param title
     * @param code  of the module
     */
    public Module(String title, String code) {
        this.title = title;
        this.code = code;
        this.isCompleted = false;
    }

    /**
     * Return the title of this module
     */
    public String getTitile() {
        return this.title;
    }

    /**
     * Return the module code of this module
     */
    public String getModuleCode() {
        return this.code;
    }

    /**
     * Return the mark in percantage of this module int data type cannot be set to
     * null but its class Integer can be!
     */
    public Integer getMark() {
        if (this.isCompleted) {
            return this.mark;
        }
        return null;
    }

    /**
     * Set a percantage mark of this module Whenever is set a mark of this module
     * this means that the module is completed
     * 
     * @param mark
     */
    public void setMark(int mark) {
        this.isCompleted = true;
        this.mark = mark;
    }

    /**
     * Print this module details
     */
    public void print() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("(" + this.code + ")" + this.title + " - ");

        if (!this.isCompleted) {
            sBuilder.append(" not completed\n");
        } else {
            sBuilder.append(this.mark + "%\n");
        }

        System.out.println(sBuilder);
    }
}

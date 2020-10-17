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

        System.out.println("Cannot be provided a grade because this module is not completed yet.");
        return null;
    }

    /**
     * Set a percantage mark of this module
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
            sBuilder.append(" is have not completed yet\n");
        } else {
            sBuilder.append(" awarded with " + this.mark + "%\n");
        }

        System.out.println(sBuilder);
    }
}

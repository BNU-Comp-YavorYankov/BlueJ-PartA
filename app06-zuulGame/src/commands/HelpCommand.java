package commands;

import java.util.Set;

/**
 * The command prints out all possible commands.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class HelpCommand implements Command
{
    // All known commands
    private Set<String> commands;

    /**
     * The constructor which recieve the commands from
     * command invoker class and assign them to the field commands.
     * 
     * @param commands all known commands
     */
    public HelpCommand(Set<String> commands) 
    {
        this.commands = commands;
    }

    /**
     * Execute this command as prints out all known commands.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        // Creates a new string with all commands and specified delimiter
        System.out.println(String.join(" ", this.commands));
    }
}

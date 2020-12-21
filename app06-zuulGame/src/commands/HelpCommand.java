package commands;

import java.util.ArrayList;

/**
 * The command prints out all possible commands.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class HelpCommand implements Command
{
    // All known commands
    private ArrayList<String> commands;

    /**
     * The constructor which recieve the commands from
     * command invoker class and assign them to the field commands.
     * 
     * @param commands all known commands
     */
    public HelpCommand(ArrayList<String> commands) 
    {
        this.commands = commands;
    }

    /**
     * Execute this command as prints out all known commands.
     * The method is overridden from Command interface.
     */
    @Override
    public void execute() {
        
    }
}

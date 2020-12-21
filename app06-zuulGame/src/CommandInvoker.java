import java.util.HashMap;
import java.util.Set;
import commands.*;

/**
 * CommandInvoker checks user input against the known commands, 
 * and if the input is not one of the known commands, 
 * it prints out an error message.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class CommandInvoker 
{
    /**
     * All commands which can be executed 
     * @key Keeps the name of the command
     * @value Keeps the command class
     */
    private final HashMap<String,Command> commands;

    /**
     * The constructor of this command invoker class
     * which initialize the commands collection and 
     * adds the known commands into the collection.
     */
    public CommandInvoker() 
    {
        this.commands = new HashMap<String, Command>();
  
        seedAvailableCommands();
    }

    /**
     * Execute the command based on the user input.
     * It gets the command from the commands collection,
     * if command exists it will be executed,
     * if no it prints out an error message.
     * @param userInput The user input which will execute a command.
     */
    public void execute(String userInput) 
    {
        Command command = this.commands.get(userInput.toLowerCase());

        if(command == null)
        {
            System.out.println("I don't know what you mean...");
        }
        else
        {
            command.execute();
        }
    }

    /**
     * Add all available commands in the commands collection
     */
    private void seedAvailableCommands() 
    {
        this.commands.put("help", new HelpCommand(getCommandsNames()));
        this.commands.put("quit", new QuitCommand());
    }

    /**
     * It gets only the keys from the commands collection
     * and return them in Set collection
     * 
     * @return Keys of this commands collection
     */
    private Set<String> getCommandsNames()
    {
        return this.commands.keySet();
    }
}
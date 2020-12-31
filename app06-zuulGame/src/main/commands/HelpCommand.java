package main.commands;

import java.util.Collection;
import main.Game;

/**
 * The command prints out all possible commands.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class HelpCommand implements Command
{
    private Collection<Command> commands; // all known commands
    private Game game;                // game instance

    /**
     * The constructor which recieve the commands from
     * command invoker class and assign them to the field commands.
     * 
     * @param commands all known commands
     */
    public HelpCommand(Collection<Command> commands, Game game) 
    {
        this.commands = commands;
        this.game = game;
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
        for (Command command : commands) 
        {
            System.out.println(command);
        }

        System.out.println("\n\r" + this.game.getCurrentLocation().getLongDescription());
    }

    /**
     * @return description of this command
     */
    @Override
    public String toString()
    {
        return "help - print out all commands and current location";
    }
}

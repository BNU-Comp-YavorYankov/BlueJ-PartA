package main.commands;

import main.utilities.InputReader;

/**
 * The command exits current program by terminating running Java virtual
 * machine.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class QuitCommand implements Command 
{    
    private InputReader reader; // user input source

    /**
     * The constructor of this command which initialize InputReader
     */
    public QuitCommand() 
    {
        this.reader = new InputReader();
    }

    /**
     * Execute this command as prints out message and invoke System.exit method that
     * terminating running Java virtual machine.
     */
    @Override
    public void execute() 
    {
        System.out.print("Are you sure you want to quit the game? Y/N");
        
        String input = this.reader.getString().toLowerCase();
        
        while (true) 
        {
            if (input.equals("yes") || input.equals("y")) 
            {
                System.out.println("Thank you for playing.  Good bye.");

                System.exit(0);
            } 
            else if (input.equals("no") || input.equals("n")) 
            {
                return;
            }
        }
    }

    /**
     * @return description of this command
     */
    @Override
    public String toString()
    {
        return "quit - quit the game";
    }
}
package main.commands;

import main.Game;
import main.models.Player;
import main.utilities.InputReader;

/**
 * This command adds a new player into the game.
 * 
 * The way it works is - The constructor recieves the current game instance and
 * initialize the InputReader. The execution of the command recieves players name.
 * If the user provided name meets the constraint 
 * the new player is created and added into the game.
 * If not, the user must provide different name while the name meet the constraint.
 * 
 * @author Yavor Yankov
 * @version 22/12/2020
 */
public class AddPlayerCommand implements Command
{
    private InputReader reader; // input source
    private Game game;          // game instance

    /**
     * The constructor of this command
     */
    public AddPlayerCommand(Game game) 
    {
        this.reader = new InputReader();
        this.game = game;
    }

    /**
     * Executes this command as asks user for its username
     * and create new player with the provided name
     */
	@Override
    public void execute() 
    {
        System.out.println("Hey stranger, before you start, I need to know your name...");
        
        String name = this.reader.getString();
        
        if(name.length() < 3)
        {
            while (name.length() < 3) 
            {
                try 
                {
                    this.game.setPlayer(new Player(name));
                }
                catch (IllegalArgumentException e) 
                {
                    System.out.println(e.getMessage());
                    name = this.reader.getString();
                }
            }
        }
        else
        {
            this.game.setPlayer(new Player(name));
        }
        System.out.println("Great " + name + ", let`s your journey begin now...");
        System.out.println();
    }    
}

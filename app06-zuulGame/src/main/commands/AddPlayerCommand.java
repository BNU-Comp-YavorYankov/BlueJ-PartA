package main.commands;

import main.Game;
import main.models.Player;
import main.utilities.InputReader;

/**
 * This command adds a new player into the game.
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
        System.out.println("Great " + name + ", let`s your journey begin now...");
        System.out.println();
    }    
}

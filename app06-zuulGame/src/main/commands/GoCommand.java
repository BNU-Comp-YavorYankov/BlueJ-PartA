package main.commands;

import main.*;
import main.models.Room;

/**
 * The command execution change the room where player is.
 * 
 * The way it works is: The constructor set the direction.
 * Then execute method checks is the direction filed null or empty,
 * if so it prints out an error message,
 * if not it
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class GoCommand implements Command
{
    private String direction;   // where the player tries to go
    private Game game;          // the game instance  
    /**
     * The constructor of this command which initialize InputReader
     */
    public GoCommand(Game game) 
    {
        this.game = game;
    }

    /**
     * Sets the direction where the player tries to go
     * 
     * @param direction where the player tries to go
     */
    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    /**
     * Executes this command as check the is the direction field empty or null
     */
    @Override
    public void execute() 
    {
        if(this.direction == null || 
            this.direction.equals("") || 
            !isDirection())
        {
            System.out.println("Go where?");
            return;
        }

        // Try to leave current room.
        Room nextRoom = this.game
            .getCurrentRoom()
            .getExit(this.direction);

        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
        }
        else
        {
            this.game.setCurrentRoom(nextRoom);
            
            System.out.println(this.game
                .getCurrentRoom()
                .getLongDescription());
        }
    }

    private boolean isDirection() 
    {
        if(this.direction.equals("east") || 
            this.direction.equals("west") ||
            this.direction.equals("north") ||
            this.direction.equals("south"))
        {
            return true;
        }
        return false;
    }
}

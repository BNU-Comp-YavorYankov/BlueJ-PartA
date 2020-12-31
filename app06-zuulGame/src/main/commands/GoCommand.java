package main.commands;

import main.*;
import main.models.Location;

/**
 * The command execution change the room where player is.
 * 
 * The way it works is - The constructor recieves the current game instance.
 * Command invoker invokes the setDirection method as set the direction
 * where the player tries to go.
 * Then execute method checks is the direction filed null, empty or valid direction,
 * if so it prints out an error message.
 * If not it changes the players current location 
 * if the direction is headed to exit of the current room.
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class GoCommand implements Command
{
    private String direction;   // where the player tries to go
    private Game game;          // the game instance  
    
    /**
     * The constructor of this command
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
     * Executes this command as check is the direction field 
     * empty, null or valid direction and 
     * change new location of the player.
     * Also every time when the location is changed 
     * the player`s energy decrease with 5.
     */
    @Override
    public void execute() 
    {
        if(this.direction == null || 
            this.direction.isEmpty() || 
            !isDirectionValid())
        {
            System.out.println("Go where?");
            return;
        }

        // Try to leave current room.
        Location nextLocation = this.game
            .getCurrentLocation()
            .getExit(this.direction);

        if (nextLocation == null) 
        {
            System.out.println("There is no door!");
        }
        else
        {
            this.game.setCurrentLocation(nextLocation);
            
            System.out.println(this.game
                .getCurrentLocation()
                .getLongDescription());
            
            this.game.getPlayer().decreaseEnergy(5);
        }
    }

    /**
     * @return is the direction valid
     */
    private boolean isDirectionValid() 
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

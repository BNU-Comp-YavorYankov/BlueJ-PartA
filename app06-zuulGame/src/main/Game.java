package main;

import java.util.HashMap;
import main.models.*;
import main.items.Item;
import main.items.ItemsGenerator;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * This main class creates and initialises all the others: it creates the map,
 * creates the command invoker and starts the game.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * @author Yavor Yankov
 * @version 21/12/2020
 */
public class Game 
{
    private Location currentLocation; // the location where the player is
    private Player player;            // the player of this game
    private Map map;                  // the map of this game
    
    /**
     * Create the game and initialise its external map
     * and current location.
     */
    public Game() 
    {
        this.map = new Map();
        this.currentLocation = this.map.getOutside();
        new ItemsGenerator(this.map.getLocations());
    }

    /**
     * @return the map of this game
     */
    public Map getMap()
    {
        return this.map;
    }

    /**
     * @return current location
     */
    public Location getCurrentLocation()
    {
        return this.currentLocation;
    }

    /**
     * Set new location where the player will be.
     *  
     * @param nextLocation the new location where the player will go
     */
    public void setCurrentLocation(Location nextLocation)
    {
        this.currentLocation = nextLocation;
    }

    /**
     * @return the player of this game
     */
    public Player getPlayer() 
    {
        return this.player;    
    }

    /**
     * Sets the player of this game
     * 
     * @param player of this game
     */
    public void setPlayer(Player player) 
    {
        this.player = player;
    }

    /**
     * Print out the opening message for the player.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
    }

    /**
     * Print out the current location long description
     */
    public void printCurrentLocationLongDescription() 
    {
        System.out.println(this.currentLocation.getLongDescription());
	}
}

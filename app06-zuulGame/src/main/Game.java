package main;

import main.models.Player;
import main.models.Location;

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
    private Player player;    // the player of this game

    /**
     * Create the game and initialise its external map.
     */
    public Game() 
    {
        createRooms();
        //this.map = new Map();
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
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        this.currentLocation = outside;  // start game outside
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

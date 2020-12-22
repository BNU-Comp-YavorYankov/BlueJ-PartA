package main.models;

import java.util.HashMap;

/**
 * Class Location - a location in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Location" represents one location in the scenery of the game.  It is 
 * connected to other locations via exits.  For each existing exit, the location 
 * stores a reference to the neighboring location.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Location 
{
    private String description;
    private HashMap<String, Location> exits; // stores exits of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param description The room's description.
     */
    public Location(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Return a string describing the location's exits, for example
     * "Exits: north west".
     * The way it works is - create new string from 
     * all keys from the exits collection.
     * 
     * @return Details of the location's exits.
     */
    private String getPossibleExits()
    {
        /**
         * String.join creates new string from the 
         * exits` keys collection with predefined delimiter.
         */
         return "Exits: " + String.join(" ", this.exits.keySet()); 
    }

    /**
     * Return the location that is reached if we go from this location in direction
     * "direction". If there is no location in that direction, return null.
     * 
     * @param direction The exit's direction.
     * @return The location in the given direction.
     */
    public Location getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Define an exit from this location.
     * 
     * @param direction The direction of the exit.
     * @param neighbor  The location to which the exit leads.
     */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * (the one that was defined in the constructor).
     * 
     * @return The short description of the location
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the location in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * 
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n\r" + getPossibleExits();
    }

}


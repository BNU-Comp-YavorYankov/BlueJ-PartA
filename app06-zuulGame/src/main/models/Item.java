package main.models;

/**
 * Class Item - an item in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * An "Item" represents one item in the scenery of the game. 
 * It keeps information about the item`s points and its description.
 * 
 * The Item class encapsulates the values of points and description.
 * Once the item is created its values cannot be changed. 
 * This class only export data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Item 
{
    private int points;         // points of this item
    private String description; // description of this item
    
    /**
     * The constructor intialize new item as recieve its
     * points and description
     * 
     * @param points of this item
     * @param description of this item
     */
    public Item(int points, String description)
    {
        this.points = points;
        this.description = description;
    }

    /**
     * @return the points of this item
     */
    public int getPoints() 
    {
        return points;
    }

    /**
     * @return the description of this item
     */
    public String getDescription() 
    {
        return description;
    }
}

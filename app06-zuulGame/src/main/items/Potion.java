package main.items;

/**
 * The potion class implements the Item interface.
 * It set health and energy points and description of this potion.
 * 
 * The health and energy points are same value.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Potion implements Item
{
    private int points;         // health and energy points of this potion
    private String description; // description of this potion

    /**
     * The constructor intialize new potion as it recieves its
     * health and energy points and description
     * 
     * @param points of this potion
     * @param description of this potion
     */
    public Potion(int points, String description)
    {
        this.points = points;
        this.description = description;
    }

    /**
     * @return health and energy points of this potion
     */
    @Override
    public int getPoints() 
    {
        return this.points;
    }

    /**
     * @return description of this potion
     */
    @Override
    public String getDescription() 
    {
        return this.description;
    }
}
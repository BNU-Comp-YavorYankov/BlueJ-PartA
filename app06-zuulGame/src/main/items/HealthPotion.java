package main.items;

/**
 * The HealthPotion class implements the Item interface.
 * It set health points and description of this potion.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class HealthPotion implements Item
{
    private int points;         // health points of this potion
    private String description; // description of this potion

    /**
     * The constructor intialize new potion as it recieves its
     * health points and description
     * 
     * @param points of this potion
     * @param description of this potion
     */
    public HealthPotion(int points, String description)
    {
        this.points = points;
        this.description = description;
    }

    /**
     * @return health points of this potion
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
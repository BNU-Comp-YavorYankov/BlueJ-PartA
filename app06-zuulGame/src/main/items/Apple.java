package main.items;

/**
 * The Apple class implements the Item interface.
 * It set health(HP) points and description of this apple.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Apple implements Item
{
    private String name;        // name of this apple
    private int points;         // health points of this apple
    private String description; // description of this apple

    /**
     * The constructor intialize new apple as it recieves its
     * health points and description
     * 
     * @param name of this apple
     * @param points of this apple
     * @param description of this apple
     */
    public Apple(String name, int points, String description)
    {
        this.name = name;
        this.points = points;
        this.description = description;
    }

    /**
     * @return the name of this apple
     */
    @Override
    public String getName() 
    {
        return this.name;
    }

    /**
     * @return health points of this apple
     */
    @Override
    public int getPoints() 
    {
        return this.points;
    }

    /**
     * @return description of this apple
     */
    @Override
    public String getDescription() 
    {
        return this.description;
    }
}
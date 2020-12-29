package main.items;

/**
 * The Shield class implements the Item interface.
 * It set shield points and description of this shield.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * If this item is equiped, it will extend the health levels
 * depending on the health points.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Shield implements Item 
{
    private String name;        // name of this shield
    private int points;         // shield points of this shield
    private String description; // description of this shield

    /**
     * The constructor intialize new shield as it recieves its
     * shield points and description.
     * 
     * @param name of this shield
     * @param points of this shield
     * @param description of this shield
     */
    public Shield(String name, int points, String description)
    {
        this.name = name;
        this.points = points;
        this.description = description;
    }

    /**
     * @return the name of this shield
     */
    @Override
    public String getName() 
    {
        return this.name;
    }

    /**
     * @return the shield points of this shield
     */
    @Override
    public int getPoints() 
    {
        return this.points;
    }

    /**
     * @return the description of this shield
     */
    @Override
    public String getDescription() 
    {
        return this.description;
    }
}

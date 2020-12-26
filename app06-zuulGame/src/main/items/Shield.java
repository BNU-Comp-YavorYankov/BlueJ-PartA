package main.items;

/**
 * The Shield class implements the Item interface.
 * It set attack points and description of this shield.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Shield implements Item 
{
    private int points;         // shield points of this shield
    private String description; // description of this shield

    /**
     * @return the shield points of this shield
     */
    @Override
    public int getPoints() 
    {
        return 0;
    }

    /**
     * @return the description of this shield
     */
    @Override
    public String getDescription() 
    {
        return null;
    }
    
}

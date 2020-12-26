package main.items;

/**
 * The Dagger class implements the Item interface.
 * It set attack points and description of this dagger.
 * 
 * This class is a child class of the parent class 'Item'.
 * It only can export its data.
 * 
 * @author Yavor Yankov
 * @version 26/12/2020
 */
public class Dagger implements Item
{
    private int points;         // attack points of this dagger
    private String description; // description of this dagger

    /**
     * The constructor intialize new dagger as it recieves its
     * attack points and description
     * 
     * @param points of this dagger
     * @param description of this dagger
     */
    public Dagger(int points, String description)
    {
        this.points = points;
        this.description = description;
    }

    /**
     * @return attack points of this dagger
     */
    @Override
    public int getPoints() 
    {
        return this.points;
    }

    /**
     * @return description of this dagger
     */
    @Override
    public String getDescription() 
    {
        return this.description;
    }
}

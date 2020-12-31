package main.models;

/**
 * Class Map - a map in an adventure game.
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * A "Map" represents a map in the game.
 * It keeps information about all locations in the "World of Zuul".
 *
 * @author Yavor Yankov
 * @version 28/12/2020
 */
public class Map 
{
    // Constant for pub location
    private static final Location PUB = new Location("in the campus pub");
    // Constant for outside location
    private static final Location OUTSIDE = new Location("outside the main entrance of the university");
    // Constant for theater location
    private static final Location THEATER = new Location("in a lecture theater");
    // Constant for lab location
    private static final Location LAB = new Location("in a computing lab");
    // Constant for office location
    private static final Location OFFICE = new Location("in the computing admin office");
    // Constant for warehouse location
    private static final Location WAREHOUSE = new Location("in the pub`s warehouse");
    
    /**
     * The constructor of this map which links locations` exits together.
     */
    public Map() 
    {
        setLocationsExits();
    }
   
    /**
     * @return pub location
     */
    public Location getPub() 
    {
        return PUB;
    }
    
    /**
     * @return outside location
     */
    public Location getOutside() 
    {
        return OUTSIDE;
    }

    /**
     * @return theater location
     */
    public Location getTheater() 
    {
        return THEATER;
    }

    /**
     * @return lab location
     */
    public Location getLab() 
    {
        return LAB;
    }

    /**
     * @return office location
     */
    public Location getOffice() 
    {
        return OFFICE;
    }

    /**
     * @return pub`s warehouse location
     */
    public Location getWarehouse() 
    {
        return WAREHOUSE;
    }

    /**
     * @return all locations on the map
     */
    public Location[] getLocations()
    {
        return new Location[] {OUTSIDE, PUB, THEATER, LAB, OFFICE, WAREHOUSE}; 
    }

    /**
     * Visualize this map as return its location as a string.
     */
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(" +-------------------------------------------------+\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" | |   PUB   | <---> | OUTSIDE | <---> | THEATER | |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" |     /|\\              /|\\                       |\n\r");
        stringBuilder.append(" |      |                 |                        |\n\r");
        stringBuilder.append(" |     \\|/              \\|/                       |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" | |WAREHOUSE|       |   LAB   | <---> | OFFICE  | |\n\r");
        stringBuilder.append(" | +---------+       +---------+       +---------+ |\n\r");
        stringBuilder.append(" +-------------------------------------------------+\n\r\n\r");

        return stringBuilder.toString();
    }

    /**
     * Link locations` exits together.
     */
    private void setLocationsExits() 
    {
        PUB.setExit("east", OUTSIDE);
        PUB.setExit("south", WAREHOUSE);
        
        OUTSIDE.setExit("east", THEATER);
        OUTSIDE.setExit("south", LAB);
        OUTSIDE.setExit("west", PUB);

        THEATER.setExit("west", OUTSIDE);

        LAB.setExit("north", OUTSIDE);
        LAB.setExit("east", OFFICE);

        OFFICE.setExit("west", LAB);

        WAREHOUSE.setExit("north", PUB);
    }
}